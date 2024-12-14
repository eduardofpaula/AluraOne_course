package desafiosPOO;

import java.util.ArrayList;

public class ContaBancaria4 {
    private int numeroConta;
    private double saldo;

    public ContaBancaria4(int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static void main(String[] args) {
        ArrayList<ContaBancaria4> listaContas = new ArrayList<>();
        ContaBancaria4 conta1 = new ContaBancaria4(1, 100433);
        ContaBancaria4 conta2 = new ContaBancaria4(2, 2004534);
        ContaBancaria4 conta3 = new ContaBancaria4(3, 30034534);
        ContaBancaria4 conta4 = new ContaBancaria4(4, 543534200);
        ContaBancaria4 conta5 = new ContaBancaria4(5, 25345300);

        listaContas.add(conta1);
        listaContas.add(conta2);
        listaContas.add(conta3);
        listaContas.add(conta4);
        listaContas.add(conta5);

        ContaBancaria4 contaMaiorValor = new ContaBancaria4(0, 0);
        for (ContaBancaria4 item : listaContas) {
            if (item.getSaldo() > contaMaiorValor.getSaldo()) {
                contaMaiorValor.setSaldo(item.getSaldo());
                contaMaiorValor.setNumeroConta(item.getNumeroConta());
            }
        }

        System.out.println("Conta com maior valor: " + contaMaiorValor.getNumeroConta() + "\n" + "Saldo da maior conta: " + contaMaiorValor.getSaldo());
    }
}
