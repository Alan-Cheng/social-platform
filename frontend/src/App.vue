<template>
  <div id="app">
    <login v-if="!loggedIn" @login="login" />
    <register v-if="!loggedIn" @register="register" />
    <post v-if="loggedIn" @add-post="addPost" />
    <div v-if="loggedIn">
      <h2>All Posts</h2>
      <div v-for="post in posts" :key="post.id">
        <p>{{ post.content }}</p>
        <comment-section :postId="post.id" @add-comment="addComment" />
      </div>
    </div>
  </div>
</template>

<script>
import Login from './components/LoginCom.vue';
import Register from './components/RegisterCom.vue';
import Post from './components/PostCom.vue';
import CommentSection from './components/CommentCom.vue'; 

export default {
  name: 'App',
  components: {
    Login,
    Register,
    Post,
    CommentSection
  },
  data() {
    return {
      loggedIn: false,
      posts: []
    };
  },
  methods: {
    login() {
      // 登入邏輯
      this.loggedIn = true;
    },
    register() {
      // 註冊邏輯
      this.loggedIn = true;
    },
    addPost(content) {
      // 新增發文邏輯
      this.posts.push({ id: this.posts.length + 1, content: content });
    },
    addComment({ postId, content }) {
      // 新增留言邏輯
      const post = this.posts.find(post => post.id === postId);
      if (post) {
        if (!post.comments) {
          post.comments = [];
        }
        post.comments.push({ id: post.comments.length + 1, content: content });
      }
    }
  }
};
</script>

<style>
/* CSS樣式可以在這裡添加 */
</style>
