package desafiosPOO;

public class ContaBancaria3 {
    private double saldo;

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public double consultarSaldop() {
        return this.saldo;
    }
}
