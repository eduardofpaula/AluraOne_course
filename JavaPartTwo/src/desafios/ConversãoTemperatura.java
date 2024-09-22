package desafios;

public class ConversãoTemperatura {
    public static void main(String[] args) {
        double temperatura = 35.2;
        String mensagemA = String.format("A TEMPERATURA EM CELSIUS É %f" , temperatura);
        System.out.println(mensagemA);
        double faren = (temperatura * 1.8) + 32;
        int farenheit = (int) faren;
        System.out.println("A TEMPERATURA EM FARENHEIT É " + farenheit);
    }
}
