<template>  
<div id="principal" class="container-fluid ">
    <div id="container_carde" class="border bg-primary  row">
      <div class="col-md-4 h-300" v-for="receita in receitas" :key="receita.id">
        <div class="card">
          <img :src="receita.img" class="card-img-top" />
          <div class="card-body">
            <h1 class="card-title">{{ receita.titulo }}</h1>
            <h4 class="text-danger">{{preparo1}}</h4>            
            <p class="card-text">{{ receita.preparo }}</p>
            <h4 class="text-danger">{{ingradientes}}</h4>   
            <p class="card-text">{{ receita.ingredientes.join(', ') }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>
  
<script lang="ts">

import { Options, Vue } from 'vue-class-component';

@Options({
  data() {
    return {
      preparo1:"Preparo",
      ingradientes:"Ingredientes",

      receitas: [
      {
    id: 1,
    titulo: "Bolo de Chocolate",
    img: "https://cdn.panelinha.com.br/receita/1566396045135-6635_trat.jpg",
    preparo: "Em uma tigela, misture farinha de trigo, açúcar, chocolate em pó, fermento em pó, leite, ovos e óleo. Despeje a massa em uma forma untada e asse em forno preaquecido a 180°C por aproximadamente 40 minutos. Espere esfriar, desenforme e decore a gosto.",
    ingredientes: ["2 xícaras de farinha de trigo", "2 xícaras de açúcar", "1 xícara de chocolate em pó", "1 colher de sopa de fermento em pó", "1 xícara de leite", "3 ovos", "1/2 xícara de óleo"]
  },
  {
    id: 2,
    titulo: "Risoto de Funghi",
    img: "https://cdn.panelinha.com.br/receita/1565898071671-risoto.jpg",
    preparo: "Em uma panela, refogue cebola e alho em azeite. Acrescente arroz arbóreo e mexa por alguns minutos. Adicione vinho branco e deixe evaporar. Aos poucos, adicione caldo de legumes quente, mexendo sempre, até o arroz ficar al dente. Acrescente funghi secchi hidratado e picado, queijo parmesão ralado e manteiga. Misture bem e sirva quente.",
    ingredientes: ["1 cebola picada", "2 dentes de alho picados", "azeite de oliva", "2 xícaras de arroz arbóreo", "1/2 xícara de vinho branco", "1 litro de caldo de legumes", "50g de funghi secchi", "100g de queijo parmesão ralado", "2 colheres de sopa de manteiga"]
  },
  {
    id: 3,
    titulo: "Salmão Grelhado",
    img: "https://cdn.panelinha.com.br/receita/1649367694236-gravlax-de-salma%CC%83o-com-beterraba.jpg",
    preparo: "Tempere os filés de salmão com sal, pimenta, suco de limão e ervas a gosto. Aqueça uma frigideira com um fio de azeite e grelhe os filés de ambos os lados até ficarem dourados. Sirva acompanhado de legumes cozidos e arroz branco.",
    ingredientes: ["4 filés de salmão", "sal e pimenta a gosto", "suco de 1 limão", "ervas (como dill, salsa ou alecrim) a gosto", "azeite de oliva"]
  },
  {
id: 4,
titulo: "Macarrão à Carbonara",
img: "https://cdn.panelinha.com.br/receita/1565893815418-carbonara.jpg",
preparo: "Cozinhe o macarrão em água salgada de acordo com as instruções da embalagem. Enquanto isso, em uma frigideira, frite o bacon em um pouco de azeite até ficar crocante. Em uma tigela separada, bata os ovos com queijo parmesão ralado. Escorra o macarrão cozido e adicione-o à frigideira com o bacon. Desligue o fogo e adicione a mistura de ovos e queijo, mexendo rapidamente para que o calor do macarrão cozinhe os ovos. Tempere com sal e pimenta a gosto e sirva imediatamente.",
ingredientes: ["250g de macarrão (espaguete, fettuccine, ou outra massa longa)", "200g de bacon em cubos", "2 ovos", "100g de queijo parmesão ralado", "azeite de oliva", "sal e pimenta a gosto"]
},
{
id: 5,
titulo: "Frango Assado com Batatas",
img: "https://cdn.panelinha.com.br/receita/1480384800000-Marinada-para-peito-de-frango-assado.jpg",
preparo: "Tempere o frango com sal, pimenta, alho em pó e ervas a gosto. Em uma assadeira, coloque o frango e as batatas descascadas e cortadas em pedaços. Regue com azeite de oliva e leve ao forno preaquecido a 200°C por aproximadamente 1 hora, ou até que o frango esteja dourado e as batatas estejam macias. Sirva quente acompanhado de legumes cozidos ou salada.",
ingredientes: ["1 frango inteiro", "batatas descascadas e cortadas em pedaços", "sal e pimenta a gosto", "alho em pó a gosto", "ervas (como alecrim, tomilho ou orégano) a gosto", "azeite de oliva"]
},
{
id: 6,
titulo: "Lasanha de Carne",
img: "https://cdn.panelinha.com.br/receita/1630688719235-lasanha_1.jpg",
preparo: "Em uma panela, refogue a carne moída com cebola e alho em azeite. Tempere com sal, pimenta e temperos de sua preferência. Adicione molho de tomate e deixe cozinhar por alguns minutos. Em um refratário, alterne camadas de molho de carne, massa de lasanha pré-cozida e queijo mussarela ralado. Repita as camadas até finalizar com queijo mussarela na última camada. Leve ao forno preaquecido a 180°C por cerca de 30 minutos, ou até a lasanha estar dourada e borbulhante. Deixe descansar por alguns minutos antes de servir.",
ingredientes: ["500g de carne moída", "1 cebola picada", "2 dentes de alho picados", "azeite de oliva", "sal e pimenta a gosto", "temperos de sua preferência (como orégano, manjericão,salsa, ou cominho)", "500ml de molho de tomate", "massa de lasanha pré-cozida", "300g de queijo mussarela ralado"]
},
{
id: 7,
titulo: "Tacos Mexicanos",
img: "https://t1.gstatic.com/licensed-image?q=tbn:ANd9GcQPir0f1BHnKzF0oJ40_GjHM6Z0xD5ZfMcrB96lulVvf2dwYa8w3-Scmt3AZMVg5bXT",
preparo: "Em uma frigideira, aqueça um fio de óleo e refogue cebola e pimentão picados até ficarem macios. Adicione carne moída e cozinhe até dourar. Tempere com cominho, páprica, sal e pimenta a gosto. Em outra frigideira, aqueça as tortilhas de milho por alguns segundos de cada lado. Monte os tacos com a carne refogada, queijo ralado, guacamole, salsa e outros acompanhamentos de sua preferência, como alface e tomate picados. Sirva quente.",
ingredientes: ["500g de carne moída", "1 cebola picada", "1 pimentão picado", "óleo vegetal", "cominho em pó a gosto", "páprica a gosto", "sal e pimenta a gosto", "tortilhas de milho", "queijo ralado", "guacamole", "salsa", "acompanhamentos opcionais: alface picada, tomate picado"]
},
{
id: 8,
titulo: "Ratatouille",
img: "https://cdn.panelinha.com.br/receita/1362106800000-Ratatouille-de-frigideira.jpg",
preparo: "Corte berinjela, abobrinha, pimentão, cebola e tomate em rodelas. Em uma assadeira, intercale as fatias dos legumes em pé, formando um padrão. Regue com azeite de oliva, tempere com sal, pimenta e ervas de sua preferência, como tomilho e alecrim. Cubra com papel alumínio e leve ao forno preaquecido a 180°C por aproximadamente 1 hora. Retire o papel alumínio e deixe assar por mais 20 minutos, ou até que os legumes estejam macios. Sirva quente como acompanhamento ou como prato principal.",
ingredientes: ["1 berinjela", "1 abobrinha", "1 pimentão", "1 cebola", "2 tomates", "azeite de oliva", "sal e pimenta a gosto", "ervas (como tomilho e alecrim) a gosto"]
},
{
id: 9,
titulo: "Salada Caprese",
img: "https://cdn.panelinha.com.br/receita/lr/1662408049820-CP_17.08_alta-3_blog.jpg",
preparo: "Corte tomates e queijo mussarela em fatias. Em um prato, intercale as fatias de tomate com as de queijo. Adicione folhas de manjericão fresco. Regue com azeite de oliva, tempere com sal e pimenta a gosto. Finalize com um fio de vinagre balsâmico. Sirva como entrada ou acompanhamento.",
ingredientes: ["tomates", "queijo mussarela", "folhas de manjericão fresco", "azeite de oliva", "sal e pimenta a gosto", "vinagre balsâmico"]
},

      ],
    };
  },

 })
export default class App extends Vue {
  
  receitas: any;
  
}
</script>

<style>


.card{
 padding: 10px ;
 margin: 10px;
 height: 95%;
}

</style>
