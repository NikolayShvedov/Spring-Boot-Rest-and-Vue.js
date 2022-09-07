<template>
  <v-layout row>
    <v-text-field style="padding-top: 5px;"
        label="New message"
        placeholder="Write something"
        v-model="text"
    />
    <v-btn @click="save">
      Save
    </v-btn>
  </v-layout>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  props: ['messageAttribute'],
  data() {
    return {
      text: '',
      id: ''
    }
  },
  watch: {
    messageAttribute(newVal, oldVal) {
      this.text = newVal.text
      this.id = newVal.id
    }
  },
  methods: {
    ...mapActions(['addMessageAction', 'updateMessageAction']),
    save() {
      const message = {
        id: this.id,
        text: this.text
      }
      if (this.id) {
        this.updateMessageAction(message)
      } else {
        this.addMessageAction(message)
      }
      this.text = ''
      this.id = ''
    }
  }
}
</script>

<style>
</style>
