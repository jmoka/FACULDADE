<template>
    <div class="ordenando">   
      <h1>Sistema de Ordenação Numérica</h1>
        <Compn_Ordenacao/>
   
    </div>
   
    <div>
    <router-view :key="$route.fullPath" />
  </div>
  </template>


<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import Compn_Ordenacao from '@/components/Compn_Ordenacao.vue'; // @ is an alias to /src



@Options({
  components: {
    Compn_Ordenacao,
   

    
  },
})
export default class OrdenacaoView extends Vue {}

</script>

