<template>
  <div>
    <h3>Comments</h3>
    <textarea v-model="commentContent" placeholder="Enter comment"></textarea>
    <button @click="addComment">Add Comment</button>
  </div>
</template>

<script>
export default {
  props: ['postId'],
  data() {
    return {
      commentContent: ''
    };
  },
  methods: {
    addComment() {
      this.$emit('add-comment', { postId: this.postId, content: this.commentContent });
      this.commentContent = '';
    }
  }
};
</script>

<style>
/* CSS樣式可以在這裡添加 */
</style>