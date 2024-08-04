<template>
  <div>
    <h2>已有帳號請登入</h2>
    <form @submit.prevent="login">
      <label for="username">帳號:</label>
      <input type="text" id="username" v-model="username" maxlength="10" placeholder="帳號為您的手機號碼" required>
      <label for="password">密碼:</label>
      <input type="password" id="password" v-model="password" required>
      <button type="submit">登入</button>
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
        const response = await axios.post('http://localhost:8090/login', {
          username: this.username,
          password: this.password
        });

        if (response.status === 200) {
          // 登入成功，設定登入消息
          this.$router.push({ path: '/SocialMedia', query: { userId: response.data.userId, userName: response.data.userName } });
          this.loginMessage = '登入成功';
          // 触发登录成功事件
          this.$emit('loginSuccess');
        }
      } catch (error) {
        console.error(error);
        if (error.response) {
          // 根據後端返回的狀態碼顯示具體的錯誤訊息
          if (error.response.status === 404) {
            this.loginMessage = "帳號不存在";
          } else if (error.response.status === 401) {
            this.loginMessage = "密碼錯誤";
          } else {
            this.loginMessage = "登入失敗，請稍後再試";
          }
        } else {
          this.loginMessage = "登入失敗，請檢查網絡連接或稍後再試";
        }
      }
    }
  }
}
</script>
