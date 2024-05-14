<template>
  <div>
    <h2>New Post</h2>
    <textarea v-model="postContent" placeholder="Enter post content"></textarea>
    <button @click="addPost">Post</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      postContent: ''
    };
  },
  methods: {
    addPost() {
      this.$emit('add-post', this.postContent);
      this.postContent = '';
    }
  }
};
</script>

<style>
/* CSS樣式可以在這裡添加 */
</style>
