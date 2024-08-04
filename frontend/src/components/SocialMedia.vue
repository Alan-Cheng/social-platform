<template>
  <div>
    <h1>社媒頁面</h1>
    <div>
      <h2><strong>{{ this.$route.query.userName }}你好！</strong><br>新增你的貼文：</h2>
      <form @submit.prevent="createPost" class="postForm">
        <textarea v-model="newPostContent" placeholder="你在想什麼?" required class="postTextArea"></textarea>
        <button type="submit" class="postButton">發文</button>
      </form>
    </div>

    <div>
      <h2>所有貼文</h2>
      <div v-for="post in posts" :key="post.postId" class="post">
        <div class="post-content">
          <p>{{ post.content }}</p>
          <p><strong>{{ post.userName }}</strong> 建立於: {{ post.createdAt }}</p>
          <button v-if="post.userId == this.$route.query.userId" @click="deletePost(post.postId)" class="deleteButton">刪除您的貼文與留言</button>
          <form @submit.prevent="addComment(post)">
            <input type="text" v-model="post.newCommentContent" placeholder="輸入留言" required>
            <button type="submit" class="commentButton">新增留言</button>
          </form>
          <div v-for="comment in post.comments" :key="comment.commentId" class="comment">
            <div class="comment-content">
              <p>{{ comment.content }}</p>
              <p><strong>{{ comment.userName }}</strong> 回覆於: {{ comment.createdAt }}</p>
              <button v-if="comment.userId == this.$route.query.userId" @click="deleteComment(post.postId, comment.commentId)" class="deleteButton">刪除您的留言</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      newPostContent: '',
      posts: [],
      userId: this.$route.query.userId,
      userName: this.$route.query.userName,
    };
  },
  created() {
    this.fetchPosts();
    this.userId = this.$route.query.userId;
  },
  methods: {
    createPost() {
      const newPost = {
        content: this.newPostContent,
        userId: this.$route.query.userId,
        comments: [],
        createdAt: new Date().toISOString().slice(0, 19).replace('T', ' ')
      };
      axios.post('http://localhost:8090/api/posts', newPost)
        .then(() => {
          this.fetchPosts();
          this.newPostContent = '';
        })
        .catch(error => {
          console.error('Error creating post:', error);
        });
    },
    addComment(post) {
      const newComment = {
        content: post.newCommentContent,
        userId: this.$route.query.userId,
        createdAt: new Date().toISOString().slice(0, 19).replace('T', ' '),
        postId: post.postId
      };
      axios.post(`http://localhost:8090/api/posts/${post.postId}/comments`, newComment)
        .then(() => {
          this.fetchPosts();
          post.newCommentContent = '';
        })
        .catch(error => {
          console.error('Error adding comment:', error);
        });
    },
    deletePost(postId) {
      axios.delete(`http://localhost:8090/api/posts/${postId}`)
        .then(() => {
          this.fetchPosts();
        })
        .catch(error => {
          console.error('Error deleting post:', error);
        });
    },
    deleteComment(postId, commentId) {
      axios.delete(`http://localhost:8090/api/posts/${postId}/comments/${commentId}`)
        .then(() => {
          this.fetchPosts();
        })
        .catch(error => {
          console.error('Error deleting comment:', error);
        });
    },
    fetchPosts() {
      axios.get('http://localhost:8090/api/posts')
        .then(response => {
          this.posts = response.data.reverse();
          this.posts.forEach(post => {
            post.newCommentContent = '';
          });
        })
        .catch(error => {
          console.error('Error fetching posts:', error);
        });
    }
  }
};
</script>

<style>
body {
  background-color: rgba(203, 232, 241, 0.3); /* 淺藍色且透明度高 */
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif; /* 設置字體 */
}
</style>

<style scoped>
/* Post 的樣式 */
.post {
  width: 80%; /* 使 post 寬度佔螢幕寬度的 80% */
  margin: 0 auto; /* 使 post 在螢幕上居中 */
  border: 2px solid #003366;
  border-radius: 10px;
  padding: 20px;
  margin-bottom: 15px;
  background-color: #f9f9f9;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

/* 相鄰 Post 背景顏色不同 */
.post:nth-child(even) {
  background-color: #e9ecef; /* 比如淡灰色 */
}

.post:nth-child(odd) {
  background-color: #f9f9f9; /* 原本的背景顏色 */
}

/* 其他樣式保持不變 */
.post p {
  margin: 0;
  padding: 5px 0;
  color: #333;
}

.comment {
  margin-left: 20px;
  border-top: 1px solid #ddd;
  padding-top: 10px;
  margin-top: 10px;
  padding-left: 10px;
  background-color: #f2f2f2;
  border-left: 3px solid #007bff;
  position: relative;
}

.comment-content, .post-content {
  position: relative;
}

.comment p {
  margin: 0;
  padding: 3px 0;
  color: #555;
}

form {
  margin-top: 10px;
}

.postButton, .commentButton, .deleteButton {
  border-radius: 5px;
  cursor: pointer;
}

.postButton {
  background-color: #2ba33d;
  color: white;
  border: none;
  padding: 8px 15px;
}

.commentButton {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 5px 10px;
}

.deleteButton {
  position: absolute;
  top: 10px;
  right: 10px;
  background-color: #dc3545;
  color: white;
  border: none;
  padding: 5px 10px;
}

.postButton:hover {
  background-color: #2a923d;
}

.commentButton:hover {
  background-color: #0056b3;
}

.deleteButton:hover {
  background-color: #c82333;
}

textarea, input[type="text"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-top: 5px;
  box-sizing: border-box;
}

</style>
