<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="username" maxlength="10" placeholder="帳號為您的手機號碼" required>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password" required>
      <button type="submit">Login</button>
    </form>
    <!-- 顯示登入結果消息 -->
    <div v-if="loginMessage">{{ loginMessage }}</div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
      loginMessage: '' // 用於顯示登入結果消息
    }
  },
  methods: {
    async login() {
      try {
        const response = await axios.post('http://localhost:8787/login', {
          username: this.username,
          password: this.password
        });

        console.log(response.data);
        if (response.status === 200) {
          // 登入成功，設定登入消息
          this.$router.push({ path: '/SocialMedia', query: { userId: response.data.userId } })
          this.loginMessage = 'Login successful';
          // 触发登录成功事件
          this.$emit('loginSuccess');
        } else {
          this.loginMessage = 'Login failed';
        }
      } catch (error) {
        console.error(error);
        // 登入失敗，設定登入消息
        this.loginMessage = 'Login failed';
      }
    }
  }
}
</script>