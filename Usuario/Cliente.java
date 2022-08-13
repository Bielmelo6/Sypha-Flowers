package Usuario;

import java.util.Objects;

public class Cliente extends Pessoa{

    public Cliente(String nome, int idade, String funcao){
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
    }

    @Override
    public void func() {
        if(Objects.equals(funcao,"Cliente") || Objects.equals(funcao,"cliente"))
            System.out.println("Bem vindo(a), " + getNome() + "!\nEstamos muito felizes em lhe atender, espero que goste dos nossos serviços :)");
    }

}
