<template>
    <div class="divApiPrincipal">   
      <Compn_Consumo_API/>
    </div>
   
    <div>
  
  </div>
  </template>


<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import Compn_Consumo_API from '@/components/Compn_Consumo_API.vue'; // @ is an alias to /src



@Options({
  components: {
    Compn_Consumo_API,
   
  },
})
export default class OrdenacaoView extends Vue {}

</script>

