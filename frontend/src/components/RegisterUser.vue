<template>
  <div>
    <h2>未申請帳號請註冊</h2>
    <form @submit.prevent="register">
      <label for="username">手機號碼:</label>
      <input type="text" id="username" v-model="username" placeholder="申請新帳號限定為手機號碼" maxlength="10" @input="limitInputLength" required>
      <label for="password">密碼:</label>
      <input type="password" id="password" v-model="password" required>
      <label for="name">您的暱稱:</label>
      <input type="text" id="name" v-model="name" required>
      <button type="submit">註冊</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
      rigidterMessage: '',
    }
  },
  methods: {
    limitInputLength(event) {
      if (event.target.value.length > 10) {
        event.target.value = event.target.value.slice(0, 10);
      }
      this.username = event.target.value;
    },
    async register() {
      // 檢查電話號碼是否為十個數字
      if (!/^\d{10}$/.test(this.username)) {
        alert('請輸入手機號碼作為帳號');
        return;
      }

      try {
        const response = await axios.post('http://localhost:8090/api/register', {
          userPhone: this.username, // 確保這裡是 userPhone
          password: this.password,
          userName: this.name
        });

        if (response.status === 200) {
          window.alert('註冊成功，請以您的手機號碼與密碼登入');
        }
      } catch (error) {
        if (error.response.status === 409) {
          window.alert('此手機號碼已被註冊，請使用其他手機號碼');
          return;
        }
        console.error('註冊失敗', error);
        window.alert('遇到連線問題，請檢查連線並稍後再試');
      }
    }
  }
}
</script>