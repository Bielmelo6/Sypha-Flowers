package Usuario;

import java.util.Objects;

public class Funcionario extends Pessoa{

    public Funcionario(String nome, int idade, String funcao){
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
    }

    @Override
    public void func() {
        if(Objects.equals(funcao,"Funcionario") || Objects.equals(funcao,"Funcionário") || Objects.equals(funcao,"funcionario") || Objects.equals(funcao,"funcionário"))
            System.out.println("Bem vindo(a), " + getNome() + "!\nEspero que consiga ajudar nosso cliente, conto com você :)");
    }
}
