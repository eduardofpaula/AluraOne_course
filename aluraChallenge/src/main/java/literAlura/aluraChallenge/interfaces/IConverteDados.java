package literAlura.aluraChallenge.interfaces;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
