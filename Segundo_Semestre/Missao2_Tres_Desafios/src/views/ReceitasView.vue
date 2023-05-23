<template>
    <div class="receitas">   
      <h1>Site de Receitas</h1>
        <Compn_Receitas/>   
    </div>  
  
</template>


<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import Compn_Receitas from '@/components/Compn_Receitas.vue'; 



@Options({
  components: {
    Compn_Receitas,
     
  },
})
export default class ReceitasView extends Vue {}

</script>