<template>
  <div>
    <v-container fluid fill-height>
      <v-card>
        <v-card-title>Faculdade Estácio de Sá</v-card-title>
        <v-card-subtitle>Projeto Final de Desenvolvimento Full Stack</v-card-subtitle>
        <v-card-text>João Luiz Silva Tavares - 202208681182</v-card-text>
      </v-card>
    </v-container>

    <v-container class="d-flex justify-center text-center">
      <v-card>
        <v-img d-block :width="650" aspect-ratio="16/9" cover src="../public/img/stacio.webp">
        </v-img>
        <btn color="#448AFF" @btnAcao=iniciar :text=text></btn>
      </v-card>
    </v-container>

  </div>
</template>

<script>
import btn from "../componets/btns/btn.vue"

export default {
  components: {
    btn
  },
  data() {
    return {
      text: "Entrar no Sistema",
    };
  },
  methods: {

    iniciar(text) {
      this.$router.push('/login');
    }
  }


};
</script>

<style scoped></style>
