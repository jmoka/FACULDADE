<template>
  <div class="home">
    <img alt="Vue logo" src="https://sismf.museudofutebol.org.br/anexos/imagem/688304/w:420/h:420/c:1">
    <capa msg="Missão Prática | Nível 2 | Mundo 2"/>
    <h2>João Luiz Silva Tavares</h2>
    <h4>Matrícula: 202208681182</h4>
  </div>
  <div>
    
  </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import capa from '@/components/capa.vue'; // @ is an alias to /src

@Options({
  components: {
    capa,
  },
})
export default class CapaView extends Vue {}
</script>
