<template>
  <div>
    <h2>Login</h2>
    <input type="text" v-model="phoneNumber" placeholder="Enter phone number">
    <input type="password" v-model="password" placeholder="Enter password">
    <button @click="login">Login</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      phoneNumber: '',
      password: ''
    };
  },
  methods: {
    login() {
      // 檢查是否為有效的電話號碼
      if (!this.isValidPhoneNumber(this.phoneNumber)) {
        alert('請輸入有效的電話號碼');
        return;
      }

      // 檢查是否輸入密碼
      if (!this.password) {
        alert('請輸入密碼');
        return;
      }

      // 登入邏輯
      this.$emit('login', { phoneNumber: this.phoneNumber, password: this.password });
    },
    isValidPhoneNumber(phoneNumber) {
      // 這裡可以根據你的需求添加更多的電話號碼驗證邏輯
      // 現在的範例只檢查是否為10位數字
      return /^\d{10}$/.test(phoneNumber);
    }
  }
};
</script>

<style>
/* CSS樣式可以在這裡添加 */
</style>
