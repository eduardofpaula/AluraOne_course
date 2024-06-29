// let titulo = document.querySelector('h1');
// titulo.innerHTML = 'Hora do Desafio';

// let paragrafo = document.querySelector('p');
// paragrafo.innerHTML = 'Escolha um numero entre 1 e 10';
let tentativas = 1;
let numSecreto = numeroAleatorio();
console.log(numSecreto);

function exibirTextoTela(tag, texto) {
  let campo = document.querySelector(tag);
  campo.innerHTML = texto;
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

function alertaJs() {
  alert("Eu amo JS");
}

function cidade() {
  let cidade = prompt("Digite um nome de cidade: ");
  alert(`Estive em ${cidade} e lembrei de você.`);
}

function soma() {
  let valor1 = parseInt(prompt("Digite o primeiro numero a ser somado: "));
  let valor2 = parseInt(prompt("Digite o segundo numero a ser somado: "));
  let soma = valor1 + valor2;
  alert(`O resultado da soma foi ${soma}`);
}

function numeroAleatorio() {
  return parseInt(Math.random() * 10 + 1);
}

function helloWorld() {
  console.log("Ola Mundo");
}

function nome(nome) {
  console.log(`Olá, ${nome}!!`);
}

function dobro(num) {
  return num * 2;
}

function media(num1, num2, num3) {
  return (num1 + num2 + num3) / 3;
}

function maior(num1, num2) {
  if (num1 > num2) {
    return num1;
  } else {
    return num2;
  }
}

function multi(num1) {
  return num1 * num1;
}

function imc(alt, peso) {
  let imc = peso / (alt * alt);

  if (imc < 16.9) {
    return console.log("muito abaixo do peso");
  } else if (imc >= 17 && imc <= 18.4) {
    return console.log("abaixo do peso");
  } else if (imc >= 18.5 && imc <= 24.9) {
    return console.log("peso normal");
  } else if(imc >= 25 && imc <= 29.9){
    return console.log("acima do peso")
  } else {
    return console.log("Obesidade grau I")
  }
}
