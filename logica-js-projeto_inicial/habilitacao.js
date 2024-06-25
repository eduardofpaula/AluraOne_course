alert("Boas vindas ao nosso site!");
let nome = "Lua";
let idade = 25;
let numeroDeVendas = 50;
let saldoDisponivel = 1000;
let mensagemDeErro = "Erro! Preencha todos os campos";
alert(mensagemDeErro);

nome = prompt("Qual o nome do Usuario?");
idade = prompt("Digite sua idade")

if(idade > 18){
    alert("Pode tirar habilitação!!")
}else{
    alert("Não pode tirar habilitação!!")
}
