package desafiosPOO;

public class Musica {
    String titulo;
    String artista;
    int anoLancamento;
    double avaliacao;
    int numAvaliacaos;

    public Musica(String titulo,String artista, int anoLancamento, double avaliacao, int numAvaliacaos){
        this.titulo=titulo;
        this.artista=artista;
        this.anoLancamento=anoLancamento;
        this.avaliacao=avaliacao;
        this.numAvaliacaos=numAvaliacaos;
    }

    public String fichaTecnica(String titulo, String artista, int anoLancamento){
        return "Ficha Tecnica\n" +
                "Titulo: " + titulo +
                "Artista: " + artista +
                "Ano de Lançamento: " + anoLancamento;
    }

    public double calcular(int numAvaliacaos,double avaliacao){
        return avaliacao / numAvaliacaos;
    }

    public String avaliarMusica(double avaliacao){
        String resultadoAvaliacao = "";
        if(avaliacao <= 2 ){
            return resultadoAvaliacao = "Ruim";
        } else if (avaliacao >= 3 && avaliacao <= 4) {
            return resultadoAvaliacao = "Otimo";
        } else if (avaliacao >= 5) {
            return resultadoAvaliacao = "Excelente";
        }
        return resultadoAvaliacao;
    }
}
