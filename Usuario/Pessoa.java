package Usuario;

public abstract class Pessoa {
    String nome;
    int idade;
    String funcao;

    public abstract void func();

    public String getNome() {
        return nome;
    }
}
