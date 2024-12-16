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
  } else if (imc >= 25 && imc <= 29.9) {
    return console.log("acima do peso");
  } else {
    return console.log("Obesidade grau I");
  }
}

function fact(n) {
  let resultado = 1;
  let i = n;
  while (i > 1) {
    resultado *= i;
    i--;
  }
  return resultado;
}

function conversor(n) {
  const dolar = 4.8;
  return console.log(`Valor convertido para dolar ${n * dolar}`);
}

function retangulo(base, alt) {
  let perimetro = 2 * (base + alt);

  return console.log(
    `Area da sala: ${base * alt}\nPerimetro da sala: ${perimetro}`
  );
}

function circulo(raio) {
  const pi = 3.14;
  let area = pi * Math.pow(raio, 2);
  return console.log(`Area do Circulo: ${area}`);
}

function tabuada(n) {
  for (let i = 0; i <= 10; i++) {
    let resultado = n * i;
    console.log(`${n} X ${i}: ${resultado}`);
  }
}

let listaGenerica = [];
let linguagensProgramacao = ["JavaScript", "C", "C++", "Kotlin", "Python"];
linguagensProgramacao.push("Java", "Ruby", "Golang");
console.log(linguagensProgramacao);
console.log(linguagensProgramacao[0]);
console.log(linguagensProgramacao[2]);
console.log(linguagensProgramacao[7]);
