package desafios;

public class Carro {
    private String modelo;
    private int ano;
    private String cor;

    public Carro(String modelo,int ano, String cor){
        this.modelo=modelo;
        this.ano=ano;
        this.cor=cor;
    }

    public String fichaTecnica(String modelo, int ano, String cor){
        return """
                Ficha Tecnica
                Modelo: %s
                Ano: %d
                Cor: %s
                """.formatted(modelo,ano,cor);
    }

    public int idadeCarro(int ano){
        return 2024 - ano;
    }
}
