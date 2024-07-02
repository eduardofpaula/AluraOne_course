let numerosSorteados = [];
let numeroLimite = 10;
let tentativas = 1;
let numSecreto = numeroAleatorio();
console.log(numSecreto);

function exibirTextoTela(tag, texto) {
  let campo = document.querySelector(tag);
  campo.innerHTML = texto;
  responsiveVoice.speak(texto, "Brazilian Portuguese Female", { rate: 1.2 });
}

mensagemInicial();

function mensagemInicial() {
  exibirTextoTela("h1", "Jogo do Numero Secreto");
  exibirTextoTela("p", "Escolha um numero entre 1 e 10");
}
function verificarNumero() {
  let chute = document.querySelector("input").value;
  console.log(chute == numSecreto);

  if (chute == numSecreto) {
    exibirTextoTela("h1", "Acertou!!");
    let palavraTentativa = tentativas > 1 ? "tentativas" : "tentativa";
    let mensagemTentativa = `Você descobriu o numero secreto com ${tentativas} ${palavraTentativa}!!`;
    exibirTextoTela("p", mensagemTentativa);
    document.getElementById("reiniciar").removeAttribute("disabled");
  } else {
    if (chute > numSecreto) {
      exibirTextoTela("p", "O chute é maior que o numero secreto!!");
    } else {
      exibirTextoTela("p", "O chute é menor que o numero secreto!!");
    }
    tentativas++;
    limparCampo();
  }
}

function novoJogo() {
  numSecreto = numeroAleatorio();
  limparCampo();
  tentativas = 1;
  mensagemInicial();
  document.getElementById("reiniciar").setAttribute("disabled", true);
}

function limparCampo() {
  chute = document.querySelector("input");
  chute.value = "";
}

function numeroAleatorio() {
    let numeroEscolhido = parseInt(Math.random() * numeroLimite + 1);
    let quantidadeElementosLista = numerosSorteados.length;
  
    if (quantidadeElementosLista == numeroLimite) {
      numerosSorteados = [];
    }
    // verificando se o mesmo numero já foi sorteado
    if (numerosSorteados.includes(numeroEscolhido)) {
      // recursão para chamar um novo numero aleatorio
      return numeroAleatorio();
    } else {
      numerosSorteados.push(numeroEscolhido);
      console.log(numerosSorteados);
      return numeroEscolhido;
    }
  }