<template>
  <div>
    <h2>Social Media Page</h2>
    <div>
      <h3>Create a Post</h3>
      <form @submit.prevent="createPost">
        <textarea v-model="newPostContent" placeholder="What's on your mind?" required></textarea>
        <button type="submit">Post</button>
      </form>
    </div>
    <div>
      <h3>Posts</h3>
      <div v-for="post in posts" :key="post.postId" class="post">
        <p>{{ post.content }}</p>
        <p>Posted by: {{ post.userName }}</p>
        <p>Posted at: {{ post.createdAt }}</p>
        <!-- 獨立的 comment 输入框 -->
        <form @submit.prevent="addComment(post)">
          <input type="text" v-model="post.newCommentContent" placeholder="Add a comment" required>
          <button type="submit">Comment</button>
        </form>
        <!-- 顯示该 post 的 comments -->
        <div v-for="comment in post.comments" :key="comment.commentId" class="comment">
          <p>{{ comment.content }}</p>
          <p>Commented by: {{ comment.userName }}</p>
          <p>Commented at: {{ comment.createdAt }}</p>
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
      userId: null,
    };
  },
  created() {
    this.fetchPosts();
    // 从本地存储中获取 userId
    this.userId = this.$route.query.userId;
  },
  methods: {
    createPost() {
      const newPost = {
        content: this.newPostContent,
        userId: this.userId, // 使用当前用户的 userId
        comments: [],
        createdAt: new Date().toISOString().slice(0, 19).replace('T', ' ')
      };
      axios.post('http://localhost:8787/api/posts', newPost)
        .then(() => {
          this.fetchPosts(); // 提交帖子后重新获取帖子列表
          this.newPostContent = '';
        })
        .catch(error => {
          console.error('Error creating post:', error);
        });
    },
    addComment(post) {
        const newComment = {
          content: post.newCommentContent,
          userId: this.userId, // 使用当前用户的 userId
          createdAt: new Date().toISOString().slice(0, 19).replace('T', ' '),
          postId: post.postId
        };
        axios.post(`http://localhost:8787/api/posts/${post.postId}/comments`, newComment)
          .then(() => {
            this.fetchPosts(); // 提交评论后重新获取帖子列表
            post.newCommentContent = ''; // 清空评论输入框
          })
          .catch(error => {
            console.error('Error adding comment:', error);
          });
    },
    fetchPosts() {
      axios.get('http://localhost:8787/api/posts')
        .then(response => {
          this.posts = response.data.reverse(); // 反转顺序
          // 为每个 post 添加一个新评论的属性
          this.posts.forEach(post => {
            post.newCommentContent = ''; // 为每个帖子添加评论输入框内容属性
          });
        })
        .catch(error => {
          console.error('Error fetching posts:', error);
        });
    }
  }
};
</script>

<style scoped>
.post {
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
}
.comment {
  margin-left: 20px;
  border-top: 1px solid #eee;
  padding-top: 5px;
}
</style>
