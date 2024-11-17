<!-- app.vue -->
<template>
  <div>
    <NuxtPage /> <!-- A página será renderizada aqui -->
  </div>
</template>


<script>
import { mapActions } from 'vuex'
import Conteudo from './componentes/Conteudo'

export default {
  name: 'App',
  components: { Conteudo },
  methods: mapActions(['setUsuario']),
  mounted() {
    // Limpar o localStorage quando a página for carregada
    localStorage.removeItem('token');
    this.setUsuario(null)
  }
}
</script>