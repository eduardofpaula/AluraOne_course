alert("Boas vindas ao jogo do numero secreto!!");
let numeroSecreto = 5;
let chute = 0;
let tentativas = 1;

chute = prompt("Digite qual o numero secreto!");

while (chute != numeroSecreto) {
  chute = prompt(`Digite o numero secreto:`);
  if (chute == numeroSecreto) {
    alert("Você acertou o numero secreto, parabéns!!");
  } else {
    if (chute < numeroSecreto) {
      chute = alert(
        `O numero digitado é menor que o numero secreto, tentativa de numero ${tentativas}`
      );
    } else {
      chute = alert(
        `O numero digitado é maior que o numero secreto, tentativa de numero ${tentativas}`
      );
    }
  }
  tentativas++;
}

alert("Você acertou o numero secreto, parabéns!!");
