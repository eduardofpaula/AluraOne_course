console.log("Bem Vindo!!");

let nome = "Olá Eduardo!!";

alert(nome);

let linguaguem = prompt("Qual linguagem de programação você mais gosta?");
console.log(linguaguem);

let valor1 = 300;
let valor2 = 600;
let resultadoAdi = valor1 + valor2;
console.log(`A soma de ${valor1} e ${valor2} é igual a ${resultadoAdi}.`);

let resultadoSub = valor1 - valor2;
console.log(
  `A diferença entre ${valor1} e ${valor2} é igual a ${resultadoSub}.`
);

let idade = prompt("Digite sua idade: ");
if (idade >= 18) {
  console.log("Maior de idade, está liberado!!");
} else {
  console.log("Menor de idade, volte!!");
}

let numero = prompt("Digite um numero: ");
if (numero > 0) {
  console.log("Numero positivo!!");
} else if (numero < 0) {
  console.log("Numero negativo!!");
} else {
  console.log("Numero igual a zero!!");
}

let contagem = 1;
while (contagem <= 10) {
  console.log(contagem);
  contagem++;
}

let nota = 3;
if (nota >= 7) {
  console.log("Aprovado");
} else {
  console.log("Reprovado");
}

let numAleatorio = parseInt(Math.random());
console.log(numAleatorio);

let numAleatorio1 = parseInt(Math.random() * 10 + 1);
console.log(numAleatorio1);

let numAleatorio2 = parseInt(Math.random() * 1000 + 1);
console.log(numAleatorio2);
