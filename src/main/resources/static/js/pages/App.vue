<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>Spring Boot Rest</v-toolbar-title>
      <v-spacer></v-spacer>
      <span v-if="profile">{{profile.name}}</span>
      <v-btn v-if="profile" icon href="/logout">
        <v-icon class="material-icons">exit_to_app</v-icon>
      </v-btn>
    </v-app-bar>
    <v-main style="padding: 90px 0px 0px;">
      <v-container v-if="!profile">
        Необходимо авторизоваться через
        <a href="/login">Google</a>
      </v-container>
      <v-container v-if="profile">
        <messages-list :messages="messages" />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import MessagesList from "../components/messages/MessagesList.vue";
import {addHandler} from 'util/ws';
import {getIndex} from 'util/collections';

export default {
  components: {
    MessagesList
  },
  data() {
    return {
      messages: frontendData.messages,
      profile: frontendData.profile
    }
  },
  created() {
    addHandler(data => {
      let index = getIndex(this.messages, data.id)
      if (index > -1) {
        this.messages.splice(index, 1, data)
      } else {
        this.messages.push(data)
      }
    })
  }
}
</script>

<style>
</style>
