alert("Boas vindas ao jogo do numero secreto!!");
let numeroMax = parseInt(prompt("Qual o limite para descobrir o numero maior ?"))
let numeroSecreto = parseInt(Math.random() * `${numeroMax}` + 1);
console.log(numeroSecreto);
let chute = 0;
let tentativas = 1;

while (chute != numeroSecreto) {
  chute = prompt(`Escolha um numero entre 1 e ${numeroMax}`);
  if (chute == numeroSecreto) {
    break;
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

// operador ternario
let palavraTentativa = tentativas > 1 ? 'tentativas' : 'tentativa';
alert(
  `Parabéns!! Você acertou o numero secreto ${numeroSecreto} com ${tentativas} ${palavraTentativa}!!`);


// if(tentativas > 1){
//   alert(
//     `Parabéns!! Você acertou o numero secreto ${numeroSecreto} com ${tentativas} tentativas!!`
//   );
// }else{
//   alert(
//     `Parabéns!! Você acertou o numero secreto ${numeroSecreto} com ${tentativas} tentativa!!`
//   );
// }


