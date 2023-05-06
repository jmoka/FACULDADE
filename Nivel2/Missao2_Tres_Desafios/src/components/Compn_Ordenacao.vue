<template>
  <div class="msg">
    {{ message }}
  </div>
  
 <!-- renderização da pagina -->
 <div id="containerPrincipal"></div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';

@Options({

  props: {}, 

  data() {
    return {
      message: 'João Luiz Silva Tavares',

      
      };
  },

  methods: {
    btnTeste() {
      /* eslint-disable prefer-const */
/* eslint-disable @typescript-eslint/no-explicit-any */
/* eslint-disable @typescript-eslint/no-unused-vars */

  const container = document.createElement('div');
  container.id = 'containerPrincipal';

//==================================================================
//RESULTADO ( ARRAY)
let saida: number[] = [];
let saidastring = saida.map(num=>num.toString())
let saidaElemento=document.createElement("div");
let saidaElementoListaOriginal=document.createElement("div");
let saidaElementoListaResultado=document.createElement("div");
let textSaidaRotulo=document.createElement("h4");
let textSaidarResultado=document.createElement("h4");
let textSaidaexplicacao=document.createElement("h4");
let textEntrada=document.createElement("h4");
let rotuloEntrada=document.createElement("h4");
rotuloEntrada.innerHTML = "Lista Original: "

// Inserindo Elemento na div saida elemento
saidaElemento.appendChild(saidaElementoListaOriginal);
saidaElementoListaOriginal.appendChild(rotuloEntrada);
saidaElementoListaOriginal.appendChild(textEntrada);
saidaElemento.appendChild(saidaElementoListaResultado);
saidaElementoListaResultado.appendChild(textSaidaRotulo);
saidaElementoListaResultado.appendChild(textSaidarResultado);
saidaElemento.appendChild(textSaidaexplicacao);

//ATRIBUTOS
saidaElemento.id="saidaElemento";
saidaElementoListaOriginal.id="saidaElementoListaOriginal"
textEntrada.id="textEntrada"
textSaidaRotulo.id="textSaidaRotulo"
saidaElementoListaResultado.id="saidaElementoListaResultado"
textSaidarResultado.id="textSaidarResultado"

// CABEÇALHO
let cabecalho = document.createElement("div");

let textoCabecalho = document.createElement("h4");
textoCabecalho.classList.add("mergem")
textoCabecalho.innerHTML = "Missão Prática | Nível 2 | Mundo 2";
cabecalho.appendChild(textoCabecalho);

//==========================================================================

// ELEMENTO1
let elemento1: HTMLElement = document.createElement("div");
let textoElemento1: HTMLElement = document.createElement("h4");
let inputElemento1: HTMLInputElement = document.createElement("input");
let btnAdicionar: HTMLButtonElement = document.createElement("button");
let btnOrdenar: HTMLButtonElement = document.createElement("button");
let btnEmbaralhar: HTMLButtonElement = document.createElement("button");
let btnLimpar: HTMLButtonElement = document.createElement("button");
textoElemento1.classList.add("mergem");
inputElemento1.classList.add("input");
inputElemento1.classList.add("mergem");
btnAdicionar.classList.add("btn");
btnOrdenar.classList.add("btn");
btnEmbaralhar.classList.add("btn");
btnLimpar.classList.add("btn");

//CABEÇALHO
cabecalho=document.createElement("div");
textoCabecalho=document.createElement("h4");
textoCabecalho.innerHTML="Missão Prática | Nível 2 | Mundo 2";
cabecalho.appendChild(textoCabecalho);

//==========================================================================

//Incluindo os Itens na DIV (elemento1)
elemento1.appendChild(textoElemento1);
elemento1.appendChild(inputElemento1);
elemento1.appendChild(btnAdicionar);
elemento1.appendChild(btnOrdenar);
elemento1.appendChild(btnEmbaralhar);
elemento1.appendChild(btnLimpar);

// Adiciona o texto no botão e na Label Rotulo
btnAdicionar.innerHTML = "Incluir";
btnOrdenar.innerHTML="Ordenar";
btnEmbaralhar.innerHTML="Embaralhar";
btnLimpar.innerHTML="Limpar"
textoElemento1.innerHTML = `1 - Esse trabalho tem o objetivo de inserir um valor no campo informado e incluir em uma ARRAY.<br/>
2 - Enseguida escolher um dos métodos de ordenamento disponivel nos "Rádios" abaixo.<br/> 
3 - Após ter escolhido clique em Ordenar, para Verificar o resultado.<br/> 
4 - Tem a opção de Embaralher e de Limpar`;
inputElemento1.placeholder="Digite o número aqui e aperte o  <ENTER>  ou o botão  <INCLUIR>  bem ao lado ===>"
inputElemento1.id="inputElemento1"

//! FUNÇÕES 

//Função ADICIONAR ELEMENTO na Array    
const adicionarElemento = () => {   
    const valorInserido= Number(inputElemento1.value);
    console.log(typeof valorInserido);

    if ( valorInserido !== Number(inputElemento1.value) || inputElemento1.value === "" ){
        alert("Insira mais de um Número no campo abaixo");
        inputElemento1.value="";
        inputElemento1.focus();
    } else {
        saida.push(valorInserido);
        
        textEntrada.innerHTML = saida.toString();
        inputElemento1.value="";
        inputElemento1.focus();     
    }
}

//Função ORDENAR UMA ARRAY  compareFunction na Array 
const compareFunction = (saida: number[]) => {
    return saida.sort((a, b) => a - b);
  };
  
  //Função ORDENAR UMA ARRAY  Bubble-Sort na Array 
  const bubbleSort = (array: number[]) => {
    let valorTrocado;
    do {
      valorTrocado = false;
      for (let i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
          const temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          valorTrocado = true;
        }
      }
    } while (valorTrocado);
    return array;
  };

  //Função ORDENAR UMA ARRAY-   selectionSort na Array 
const selectionSort = (array: number[]) => {
    for (let i = 0; i < array.length - 1; i++) {
      let minIndex = i;
      for (let j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex !== i) {
        const temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
      }
    }
    return array;
  }


//Função ORDENAR UMA ARRAY-   quickSort na Array 
const quickSort = (array: number[], p: number, r: number) => {
    if (p < r) {
      const q = partition(array, p, r);
      quickSort(array, p, q - 1);
      quickSort(array, q + 1, r);
    }
    return array;
  }
  
  const partition = (array: number[], p: number, r: number) => {
    const pivot = array[r];
    let i = p - 1;
    for (let j = p; j <= r - 1; j++) {
      if (array[j] < pivot) {
        i++;
        const temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    const temp = array[i + 1];
    array[i + 1] = array[r];
    array[r] = temp;
    return i + 1;
  }

  //Função EMBARALHA UMA ARRAY-   shuffle na Array 
const shuffle = (array: any[]) => {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      const temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
    return array;
  };
  
  //! BOTÕES
  //CLICK DOS BOTÕES
  
  // * BOTÃO ADICIONAR
  btnAdicionar.addEventListener("click", () => {
    adicionarElemento();
  });
  
  // ADICIONAR ELEMENTO USANDO O ENTER NO INPUT
  inputElemento1.addEventListener("keyup", function (event) {
    if (event.keyCode === 13) {
      adicionarElemento();
    }
  });
  
  //  BOTÃO LIMPAR
  btnLimpar.addEventListener("click", () => {
    if (saida.length==0 && saida.length < 1) {
      alert("Lista já se encontra vazia");
      inputElemento1.focus();
    } else {
      textSaidaRotulo.innerHTML = "";
      textSaidarResultado.innerHTML = "";
      textSaidaexplicacao.innerHTML = "";
      textEntrada.innerHTML = "";
      botaoRadio1.checked = false;
      botaoRadio2.checked = false;
      botaoRadio3.checked = false;
      botaoRadio4.checked = false;
      botaoRadio5.checked = false;
      saida.splice(0, saida.length);
      btnOrdenar.className = "removendoClasse"
    
    }
  });

  // * BOTÃO EMBARALHAR
btnEmbaralhar.addEventListener("click", () => {
    if (saida.length !== 0 && saida.length < 2) {
      alert("Lista vazia ou com somente um Número (Inclua mais de um número na lista)");
      inputElemento1.focus();
    } else {
      textSaidaRotulo.innerHTML = "Resultado: ";
      const resultado = shuffle(saida);
      const resultadoString = resultado.toString();
      textSaidarResultado.innerHTML = resultadoString;
      textSaidaexplicacao.innerHTML = `<span class= "textTestaque">FEITO O EMBARALHAMENTO</span><br/><br/>
  
      `;
    }
  });

  // * BOTÃO ORDENAR

btnOrdenar.addEventListener("click",()=>{ 

    if(botaoRadio1.checked === true && saida.length > 1){
        const saidaText = saida;
        const resultadoSaidaText = saidaText.toString();
        textSaidarResultado.innerHTML = resultadoSaidaText;
       

        const saidaTextSort = saida.sort();
        const resultadosaidaTextSort= saidaTextSort.toString();
        textSaidarResultado.innerHTML = resultadosaidaTextSort;
        textSaidaRotulo.innerHTML = "Resultado: ";
        textSaidaexplicacao.innerHTML = `<span class="textTestaque">FUNÇÃO SORT NATIVA DO JS, ORDENA EM ORDEM ALFABÉTICA</span> (É usada para classificar os elementos de um array 
        em ordem crescente ou decrescente,<br/> com base em um critério específico, caso não seja especificado, ordena em ordem 
        alfabética)<br/><br/>SINTAX:<br/><br/> array.sort()`;
        
        
    }else if(botaoRadio2.checked === true && saida.length > 1){

        const saidaText1 = saida;
        const resultadoSaidaText1 = saidaText1.toString();
        textSaidarResultado.innerHTML = resultadoSaidaText1;
        

        const saidaTextCompareFunction = compareFunction(saida);
        const resultadosaidaCompareFunction= saidaTextCompareFunction.toString();
        textSaidarResultado.innerHTML = resultadosaidaCompareFunction;
        textSaidaRotulo.innerHTML = "Resultado: ";
        textSaidaexplicacao.innerHTML = `<span class="textTestaque">COMPARE FUNCTION</span>  ordena uma array numericamente, A função "compareFunction" é uma função que deve receber dois parâmetros (a e b) e retornar um valor negativo se a deve ser 
        classificado antes de b, um valor positivo se b deve ser classificado antes de a, e 0 se a e b são considerados iguais em termos de ordenação.
        <br/> <br/>SINTAX:<br/><br/>  
        
        const compareFunction = (saida: number[]) => {<br/>  
            return saida.sort((a, b) => a - b);<br/>  
          }<br/>  `;

    }else if(botaoRadio3.checked === true && saida.length > 1){
        const saidaText2 = saida;
        const resultadoSaidaText2 = saidaText2.toString();
        textSaidarResultado.innerHTML = resultadoSaidaText2;
       

        const saidabubbleSort = bubbleSort(saida);
        const resultadoSaidaSaidabubbleSort = saidabubbleSort.toString();
        textSaidarResultado.innerHTML = resultadoSaidaSaidabubbleSort;
        textSaidaRotulo.innerHTML = "Resultado: ";
        textSaidaexplicacao.innerHTML = `<span class="textTestaque">O BUBBLE SORT</span>  é um algoritmo de ordenação simples que percorre uma lista de elementos várias vezes, 
        comparando elementos adjacentes e trocando-os se estiverem na ordem errada. Esse processo continua até que a lista esteja completamente ordenada.
        <br/> <br/>SINTAX:<br/><br/> 
        
        const bubbleSort = (array: number[]) => {<br/> 
            let valorTrocado;<br/> 
            do {<br/> 
              valorTrocado = false;<br/> 
              for (let i = 0; i < array.length - 1; i++) {<br/> 
                if (array[i] > array[i + 1]) {<br/> 
                  const temp = array[i];<br/> 
                  array[i] = array[i + 1];<br/> 
                  array[i + 1] = temp;<br/> 
                  valorTrocado = true;<br/> 
                }<br/> 
              }<br/> 
            } while (valorTrocado);<br/> 
            return array;<br/> 
          }<br/> 
          `;
    
}else if (botaoRadio4.checked == true && saida.length>1){
    const saidaText3 = saida;
    const resultadoSaidaText3 = saidaText3.toString();
    textSaidarResultado.innerHTML = resultadoSaidaText3;
    

    const saidaBubbleSort = quickSort(saida, 0, saida.length - 1);
    const resultadoSaidaSaidaBubbleSort = saidaBubbleSort.toString();
     textSaidarResultado.innerHTML = resultadoSaidaSaidaBubbleSort;
     textSaidaRotulo.innerHTML="Resultado: ";
     textSaidaexplicacao.innerHTML=`Uma função <span class="textTestaque">QUICK SORT</span>  é um algoritmo de ordenação que segue o paradigma 
        "dividir para conquistar". Essa função divide a matriz em duas partes, uma com elementos menores que um pivô 
        escolhido e outra com elementos maiores que o pivô. Em seguida, a função é chamada recursivamente em cada parte 
        até que a matriz esteja completamente ordenada.<br/><br/> 
        A função partition seleciona o pivô como o último elemento da matriz. O laço for percorre a matriz da posição 
        inicial p até a posição final r-1, comparando cada elemento com o pivô e trocando os elementos, se necessário, 
        para colocá-los em posições corretas. No final do laço, o pivô é trocado com o elemento imediatamente após o último 
        elemento menor do que o pivô encontrado.
        <br/> <br/>SINTAX:<br/><br/> 

        const quickSort = (array, p, r) => {<br/> 
            if (p < r) {<br/> 
              const q = partition(array, p, r);<br/> 
              quickSort(array, p, q - 1);<br/> 
              quickSort(array, q + 1, r);<br/> 
            }<br/> 
            return array;<br/> 
          }<br/> <br/> 
          
          const partition = (array, p, r) => {<br/> 
            const pivot = array[r];<br/> 
            let i = p - 1;<br/> 
            for (let j = p; j <= r - 1; j++) {<br/> 
              if (array[j] < pivot) {<br/> 
                i++;<br/> 
                const temp = array[i];<br/> 
                array[i] = array[j];<br/> 
                array[j] = temp;<br/> 
              }<br/> 
            }<br/> 
            const temp = array[i + 1];<br/> 
            array[i + 1] = array[r];<br/> 
            array[r] = temp;<br/> 
            return i + 1;<br/> 
          }<br/>`;
}else if(botaoRadio5.checked == true && saida.length>1){
    const saidaText4 = saida;
    const resultadoSaidaText4 = saidaText4.toString();
    textSaidarResultado.innerHTML = resultadoSaidaText4;
    

    const saidabubbleSort = selectionSort(saida);
        const resultadoSaidaSaidabubbleSort = saidabubbleSort.toString();
        textSaidarResultado.innerHTML = resultadoSaidaSaidabubbleSort;
        textSaidaRotulo.innerHTML="Resultado: ";
    textSaidaexplicacao.innerHTML=`<span class="textTestaque">O SELECTION SORT</span>  é um algoritmo de ordenação simples e de fácil implementação. 
        Ele funciona da seguinte maneira:<br/> <br/> 

        Percorre todo o vetor a ser ordenado, buscando o menor elemento;<br/> 
        Troca o menor elemento encontrado com o primeiro elemento do vetor;<br/> 
        Repete o processo acima, mas agora ignorando o primeiro elemento do vetor já ordenado;<br/> 
        Continua repetindo os passos 1, 2 e 3 até que todo o vetor esteja ordenado.<br/> 
        Dessa forma, o Selection Sort sempre seleciona o menor elemento do vetor e o coloca na posição correta, 
        até que todo o vetor esteja ordenado.<br/><br/>
        
        const selectionSort = (array) => {<br/>
            for (let i = 0; i < array.length - 1; i++) {<br/>
              let minIndex = i;<br/>
              for (let j = i + 1; j < array.length; j++) {<br/>
                if (array[j] < array[minIndex]) {<br/>
                  minIndex = j;<br/>
                }<br/>
              }<br/>
              if (minIndex !== i) {<br/>
                const temp = array[i];<br/>
                array[i] = array[minIndex];<br/>
                array[minIndex] = temp;<br/>
              }<br/>
            }<br/>
            return array;<br/>
          }<br/>
        `      
    }else if(botaoRadio1.checked !== true  || botaoRadio2.checked !== true  || botaoRadio3.checked !== true  || botaoRadio4.checked !== true ){
        alert(`Opss... Algo de Errado !!
        1 - Verifique se você inseriu mais de um número na lista; 
        2 - Escolha uma das Opções, caso não esteja selecionada;`);
    }else{
        alert("Selecione uma Opção abaixo!!" )
       
    }
});


//==========================================================================

// DIV's RADIOS  
const elementoRadio=document.createElement("div");
const divRadio1=document.createElement("div");
const divRadio2=document.createElement("div");
const divRadio3=document.createElement("div");
const divRadio4=document.createElement("div");
const divRadio5=document.createElement("div");
elementoRadio.appendChild(divRadio1);
elementoRadio.appendChild(divRadio2);
elementoRadio.appendChild(divRadio3);
elementoRadio.appendChild(divRadio4);
elementoRadio.appendChild(divRadio5);

//CLASSE DAS DIV'S
divRadio1.classList.add("divRadio");
divRadio2.classList.add("divRadio");
divRadio3.classList.add("divRadio");
divRadio4.classList.add("divRadio");
divRadio5.classList.add("divRadio");

// RADIO 1
const botaoRadio1=document.createElement("input");
const labelBotaoRadio1=document.createElement("label");
botaoRadio1.setAttribute("type", "radio");
divRadio1.appendChild(botaoRadio1);
divRadio1.appendChild(labelBotaoRadio1);
labelBotaoRadio1.textContent="Sort";

// CHECKER RADIO1
botaoRadio1.addEventListener("click",()=>{
    botaoRadio2.checked = false;
    botaoRadio3.checked = false;
    botaoRadio4.checked = false;
    botaoRadio5.checked = false;
})

// RADIO 2
const botaoRadio2=document.createElement("input");
const labelBotaoRadio2=document.createElement("label");
botaoRadio2.type = "radio";
divRadio2.appendChild(botaoRadio2)
divRadio2.appendChild(labelBotaoRadio2)
labelBotaoRadio2.textContent="Compare_Function"

// CHECKER RADIO2
botaoRadio2.addEventListener("click",()=>{
    botaoRadio4.checked = false;
    botaoRadio3.checked = false;
    botaoRadio1.checked = false;
    botaoRadio5.checked = false;
})

// RADIO 3
const botaoRadio3=document.createElement("input");
const labelBotaoRadio3=document.createElement("label");
botaoRadio3.type = "radio";
divRadio3.appendChild(botaoRadio3)
divRadio3.appendChild(labelBotaoRadio3)
labelBotaoRadio3.textContent="Bubble_Sort"

// CHECKER RADIO3
botaoRadio3.addEventListener("click",()=>{
    botaoRadio1.checked = false;
    botaoRadio2.checked = false;
    botaoRadio4.checked = false;
    botaoRadio5.checked = false;
})

// RADIO 4
const botaoRadio4=document.createElement("input");
const labelBotaoRadio4=document.createElement("label");
botaoRadio4.type = "radio";
divRadio4.appendChild(botaoRadio4)
divRadio4.appendChild(labelBotaoRadio4)
labelBotaoRadio4.textContent="Quick_Sort"

// CHECKER RADIO3
botaoRadio4.addEventListener("click",()=>{
    botaoRadio1.checked = false;
    botaoRadio2.checked = false;
    botaoRadio3.checked = false;
    botaoRadio5.checked = false;
})

// RADIO 5
const botaoRadio5=document.createElement("input");
const labelBotaoRadio5=document.createElement("label");
botaoRadio5.type = "radio";
divRadio5.appendChild(botaoRadio5)
divRadio5.appendChild(labelBotaoRadio5)
labelBotaoRadio5.textContent="Selection_Sort"

// CHECKER RADIO3
botaoRadio5.addEventListener("click",()=>{
    botaoRadio1.checked = false;
    botaoRadio2.checked = false;
    botaoRadio3.checked = false;
    botaoRadio4.checked = false;
})

// CSS CLASS RADIOS
labelBotaoRadio1.classList.add("labelradio");
botaoRadio1.classList.add("radios");
labelBotaoRadio2.classList.add("labelradio");
botaoRadio2.classList.add("radios");
labelBotaoRadio3.classList.add("labelradio");
botaoRadio3.classList.add("radios");
labelBotaoRadio4.classList.add("labelradio");
botaoRadio4.classList.add("radios");
labelBotaoRadio5.classList.add("labelradio");
botaoRadio5.classList.add("radios");


botaoRadio1.addEventListener("click",()=>{
  if(botaoRadio1.checked==true){
    btnOrdenar.className = "mudaCorTesxtoOrdenar"}
});
botaoRadio2.addEventListener("click",()=>{
  if(botaoRadio2.checked==true){
    btnOrdenar.className = "mudaCorTesxtoOrdenar"}
});
botaoRadio3.addEventListener("click",()=>{
  if(botaoRadio3.checked==true){
    btnOrdenar.className = "mudaCorTesxtoOrdenar"}
});

botaoRadio4.addEventListener("click",()=>{
  if(botaoRadio4.checked==true){
    btnOrdenar.className = "mudaCorTesxtoOrdenar"}
});
botaoRadio5.addEventListener("click",()=>{
  if(botaoRadio5.checked==true){
    btnOrdenar.className = "mudaCorTesxtoOrdenar"}
});

 container.appendChild(cabecalho)
 container.appendChild(elemento1)
 container.appendChild(elementoRadio)
 container.appendChild(saidaElemento)

const sistOrdenar = document.getElementById('containerPrincipal');
      sistOrdenar?.replaceWith(container);
      
function mergeSort(saida: number[]): string {
    throw new Error("Function not implemented.");
}
    },
  },
  
mounted(){
  this.btnTeste();
}
})
export default class Compn_Ordenacao1 extends Vue {
message: any;
}
</script>

<style>

.mudaCorTesxtoOrdenar{
  color: red;
  height: 50px;
  border-radius: 10px;
  background-color:yellow;
}

.msg{
  color: blue;
  margin: 6px;
  padding: 5px;
  
}

.msg:hover{
  background-color: yellow;
  color: red;
}

.radios {
  width: 25px;
  height: 25px;
}

  .labelradio{
    color:blue;
    font-size:25px;
    margin: 3px;
    margin-right: 30px;
    padding-right: 30px;
  }

  .mergem{
  margin: 6px 1px;
 
}

.input{
 width: 50%;
 height: 50px;
 border-radius: 10px;
 border-color: blue;
}

.btn{
  border-color: blueviolet;
 height: 50px;
 color: blue;
 border-radius: 10px;
}

.btn:hover{
  
  background-color: yellow;
  color: red;}

.divRadio{
 text-align: start;
 padding-left: 20%;
}

</style>


