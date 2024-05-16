<template>
  <div id="app">
    <LogIn v-if="!isAuthenticated" @loginSuccess="handleLoginSuccess"/>
    <RegisterUser v-if="!isAuthenticated"/>
    <SocialMedia v-if="isAuthenticated"/>
  </div>
</template>

<script>
import LogIn from './components/LogIn.vue';
import RegisterUser from './components/RegisterUser.vue';
import SocialMedia from './components/SocialMedia.vue';

export default {
  name: 'App',
  components: {
    LogIn,
    RegisterUser,
    SocialMedia
  },
  data() {
    return {
      isAuthenticated: false 
    }
  },
  methods: {
    handleLoginSuccess() {
      this.isAuthenticated = true; 
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
