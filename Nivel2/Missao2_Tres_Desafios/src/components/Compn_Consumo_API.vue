<template class="container-fluid">
  <div :id="Var_id_div_principla" :class="Var_stilo2" class="container-fluid  " >
      <header>
        <div :class="Var_div_principal">{{ Var_titulo }}</div>
      </header>
     
      <div class="row container-fluid">
        <div  class="col"> <input type="text"  class=" form-control border border-1 border-secondary" placeholder="Insira a URL aqui!!" v-model="Var_url"></div>
        <div class="col-xl-1  "> <button @click="Var_processar" class="btn btn-outline-secondary float-start" type="button" >Processar...</button></div>
        
      </div>  
      <div class="text-start px-3 ">API Padão: <span class="text-danger">{{Var_API_padrao}}</span></div>
      <p class="text-start px-3">Copie e Cole a API padrão e aperte Processar</p>
       
      <div class=" border border-red"/> 

      <br>

      <div class="row container-fluid">
       
        <div id="Var_imagem" class="col   ">
          <h1 class=" text-primary ">{{Var_texto_imagem}}</h1>
          <img :class="Var_StiloImagem" :src="Var_imagem" alt="Avatar do usuário">
        </div>   

        <div class="col ">          
          <div class="row">
            <h1 class=" text-primary ">{{Var_texto_informacoes}}</h1>
            <div class="col-sm-3 border text-start text-primary">Id:</div>
            <div class="col border text-start">{{Var_id_API}}</div>
          </div>
          <div class="row">
            <div class="col-sm-3 border text-start text-primary ">Nome:</div>
            <div class="col border text-start">{{Var_nome_API}}</div>
          </div>
          <div class="row">
            <div class="col-sm-3 border text-start text-primary">Sobrenome:</div>
            <div class="col border text-start"> {{Var_sobrenome_API}}</div>
          </div>
          <div class="row">
            <div class="col-sm-3 border text-start text-primary ">Email:</div>
            <div class="col border text-start">{{ Var_email_API }}</div>
          </div>

          <br>

          <div class="pt-3">
          <span class="col-4 text-primary text-start  px-5 ">{{ Var_text_quantidade }}</span>
          <span class="col-4 text-start text-primary  text-start px-5">{{ Var_qtdCard_inicial }}</span> 
        </div>

        <br>

          <div class="row pt-4">
            <div class="col   "><button @click="Var_Anterior" class="btn btn-outline-secondary float-center" type="button" >Anterior</button></div>
            <div class="col  "><button @click="Var_Proximo" class="btn btn-outline-secondary float-center" type="button" >Proximo</button></div>
          </div>
        </div>        
      </div>   
      
      
     <footer>

      </footer>

    </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';


@Options({
  components: {
    
  },
  data() {
    return {

      Var_id_div_principla:"id_div_principla",
      Var_stilo2:"stilo2",
      Var_div_principal:"fontes",
      Var_titulo:"Sistema de Consumo de API",
      Var_imagem:"https://image.shutterstock.com/image-photo/african-girl-caucasian-friends-studying-260nw-1413307274.jpg",
      Var_texto_imagem:"IMAGEM",
      Var_texto_informacoes:"INFORMAÇÕES",
      Var_visivel:false,
      Var_API_padrao:"https://reqres.in/api/users?per_page=12",
      Var_url:"https://reqres.in/api/users?per_page=12",
      Var_erro_URL:"Informe uma API válida",
      Var_StiloImagem:"img",
      Var_id_API:"",
      Var_nome_API:"",
      Var_sobrenome_API:"",
      Var_email_API:"",
      Var_text_quantidade:"Sua API possui Cards!!",
      Var_text_Quant:"Escolha a Quantidade de card's para gerar o Site:",
      Var_qtdCard:"",
      Var_qtdCard_inicial:"",
      Var_input_Qantidade:"",
      Var_index:"0",
           
        };
  },
  methods:{
    async Var_processar(){
          this.Var_visivel=true
       
          console.log(this.Var_index)
            try {
                const resposta = await fetch(this.Var_url);
                const objetoAPI = await resposta.json();
                this.Var_qtdCard_inicial=objetoAPI.data.length
                
                this.Var_imagem = objetoAPI.data[this.Var_index].avatar 
                this.Var_id_API = objetoAPI.data[this.Var_index].id
                this.Var_nome_API = objetoAPI.data[this.Var_index].first_name  
                this.Var_sobrenome_API = objetoAPI.data[this.Var_index].last_name   
                this.Var_email_API = objetoAPI.data[this.Var_index].email 
            } catch (error) {
               alert(error);
            }
      },
      
      Var_abrir_site(){
        console.log('abrir site');
        },

      async Var_Proximo(){
        console.log("Proximo")
          if (this.Var_index > this.Var_index){
          this.Var_index = this.Var_index+1;
        }
        try {   
                const resposta = await fetch(this.Var_url);
                const objetoAPI = await resposta.json();
                this.Var_qtdCard++;
                if (this.Var_qtdCard < objetoAPI.data.length){
                this.Var_imagem = objetoAPI.data[this.Var_qtdCard].avatar 
                this.Var_id_API = objetoAPI.data[this.Var_qtdCard].id
                this.Var_nome_API = objetoAPI.data[this.Var_qtdCard].first_name  
                this.Var_sobrenome_API = objetoAPI.data[this.Var_qtdCard].last_name   
                this.Var_email_API = objetoAPI.data[this.Var_qtdCard].email
                }else{
                  alert("Chegou o Final da Lista")
                }
              } catch (error) {
                console.log("erro")
  }

      },

      async Var_Anterior(){
        console.log("Anterior")
         if (this.Var_index > this.Var_index){
          this.Var_index = this.Var_index+1;
        }
        try {   
                const resposta = await fetch(this.Var_url);
                const objetoAPI = await resposta.json();
                this.Var_qtdCard--;
                if (this.Var_qtdCard > -1){
                console.log(this.Var_qtdCard);
                this.Var_imagem = objetoAPI.data[this.Var_qtdCard].avatar 
                this.Var_id_API = objetoAPI.data[this.Var_qtdCard].id
                this.Var_nome_API = objetoAPI.data[this.Var_qtdCard].first_name  
                this.Var_sobrenome_API = objetoAPI.data[this.Var_qtdCard].last_name   
                this.Var_email_API = objetoAPI.data[this.Var_qtdCard].email
              }else{
                  alert("Chegou o Final da Lista")
                }
                
              } catch (error) {
                console.log("erro")
            }
      }
   
  }

})
export default class App extends Vue {
  Var_id_div_principla:undefined;
  Var_stilo2:undefined;
  Var_div_principal: unknown;
  Var_titulo: string | undefined;
  var_processar:undefined;
  Var_imagem:undefined;
  Var_texto_imagem:string | undefined;
  Var_texto_informacoes:string | undefined;
  Var_visivel:boolean | undefined;
  Var_abrir_site:undefined;
  Var_url:string|undefined;
  VarConsumirAPI:undefined;
  Var_erro_URL:string|undefined;
  Var_StiloImagem: undefined;
  Var_id_API:string|undefined;
  Var_nome_API:string|undefined;
  Var_sobrenome_API:string|undefined;
  Var_email_API: string|undefined;
  Var_API_padrao:string|undefined;
  Var_qtdCard:string|undefined;
  Var_text_Quant:string|undefined;
  Var_text_quantidade:string|undefined;
  Var_input_Qantidade:undefined;
  Var_Anterior:undefined;
  Var_Proximo:undefined;
  Var_index:number| undefined;
  Var_qtdCard_inicial:string|undefined;
      
}
</script>

<style >

#id_div_principla{

  border: 1px solid red;
  display:inline-block; 
  padding: 10px;
}

.img{
  height: 80%;
  width: 80%;
}

.stilo1{
  font-size: 20px;
  color: blue;
  background-color:azure ;
  box-shadow: 2px 2px 2px #888888;
}

.stilo2{
  font-size: 20px;
  color:black;
  background-color:azure ;
  box-shadow: 2px 2px 2px #888888;
  }

.divMain{
  display: flex;
  height: 100%;
  width: 100%;
  border: 2px solid blue;
  padding: 20px;
  }

main{
  display: flex; 
  justify-content: center; 
  align-items: center;
}

.inputs{
  border: 2px solid blue;
  font-family: Arial, Helvetica, sans-serif;
  font-style: normal;
  width: 100%;
  padding: 4px;
  margin-left: 6px;
  height: 20px;
  }

  .div_principal{
  border: 3px;
  border-color: blue;
  font-family: Arial, Helvetica, sans-serif;
  font-style: normal;
  }

  .label{
   color:   blue;
   }

  .botao{
  border: 2px solid blue;
  font-family: Arial, Helvetica, sans-serif;
  font-style: normal;
  width: 100%;
  padding: 4px;
  margin-left: 6px;
  height: 30px;    
  }

  .btn{
    color: blue;
  }

  .btn:hover{
    color: red;
    background-color: yellow;
  }

</style>