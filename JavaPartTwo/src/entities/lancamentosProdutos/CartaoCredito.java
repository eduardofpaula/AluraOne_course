package entities.lancamentosProdutos;

public class CartaoCredito {
    private double limite;

    public CartaoCredito() {
    }

    public CartaoCredito(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
