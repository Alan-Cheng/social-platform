<template>
  <div>
    <h2>Login</h2>
    <input type="text" v-model="phoneNumber" placeholder="Enter phone number">
    <button @click="login">Login</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      phoneNumber: ''
    };
  },
  methods: {
    login() {
      this.$emit('login');
    }
  }
};
</script>

<style>
/* CSS樣式可以在這裡添加 */
</style>
