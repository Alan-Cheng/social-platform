<template>
  <div>
    <h2>Register</h2>
    <input type="text" v-model="phoneNumber" placeholder="Enter phone number">
    <input type="password" v-model="password" placeholder="Enter password">
    <button @click="register">Register</button>
    <div v-if="showSuccessMessage">{{ successMessage }}</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      phoneNumber: '',
      password: '',
      showSuccessMessage: false,
      successMessage: ''
    };
  },
  methods: {
    register() {
      // 檢查是否為電話號碼
      if (!this.isValidPhoneNumber(this.phoneNumber)) {
        alert('請輸入有效的電話號碼');
        return;
      }

      // 檢查是否輸入密碼
      if (!this.password) {
        alert('請輸入密碼');
        return;
      }

      // 模擬註冊成功
      // 實際情況下，這裡應該是向後端發送註冊請求
      // 然後根據後端的回應來顯示註冊成功或失敗的消息
      this.showSuccessMessage = true;
      this.successMessage = '註冊成功';
      // 停留在APP畫面
      setTimeout(() => {
        this.showSuccessMessage = false;
        this.successMessage = '';
      }, 3000);
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
