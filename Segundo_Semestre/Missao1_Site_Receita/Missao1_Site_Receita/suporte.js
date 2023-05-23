
const nomeInput  = document.getElementById("nome")

nomeInput.addEventListener("input", function() {
    const nome = nomeInput.value;
    console.log("O valor do campo nome é: " + nome);
  });

  const btn  = document.getElementById("enviar")

btn.addEventListener("click", function() {
    alert(" Muito obrigado pela sua mensegem, entraremos em contato com você " + nome.value+ " em breve!!")
  
  });




