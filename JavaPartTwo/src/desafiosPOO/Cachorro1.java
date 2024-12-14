package desafiosPOO;

public class Cachorro1 extends Animal1 {
    @Override
    public void emitirSom(){
        System.out.println("AU AU");
    }

    public void abanarRabo(){
        System.out.println("O cachorro está abanando o rabo");
    }

    public static void main(String[] args) {
        // Criando um objeto da classe Cachorro
        Cachorro cachorro = new Cachorro();

        // Chamando métodos da classe Cachorro
        cachorro.emitirSom();
        cachorro.abanarRabo();

        // Verificando se o objeto é uma instância de Animal antes do casting
        if (cachorro instanceof Animal) {
            // Fazendo o casting para a classe Animal
            Animal animal = (Animal) cachorro;

            // Chamando o método disponível na classe Animal
            animal.emitirSom();
        } else {
            System.out.println("O objeto não é uma instância de Animal");
        }

        // Observe que o método abanarRabo() não está disponível na referência de Animal
        // animal.abanarRabo(); // Isso geraria um erro de compilação
    }
}
