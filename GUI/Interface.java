package GUI;

import Floricultura.*;
import Repositorio.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import Exception.*;
import Usuario.*;

public class Interface {


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);

        String caminhoFlor = "./ArquivoRepositorio/repositorio.flor";
        FlorRepositorio repoFlor = FlorRepositorio.carregarRepositorio(caminhoFlor);
        FlorRepositorio florCliente = new FlorRepositorio();
        florCliente.FlorRepositorio = new ArrayList<>();


        BuqueRepositorio buqueCliente = new BuqueRepositorio();
        buqueCliente.BuqueRepositorio = new ArrayList<>();

        VasoRepositorio vasoCliente = new VasoRepositorio();
        vasoCliente.VasoRepositorio = new ArrayList<>();

        boolean condition = true;
        int acao;

        System.out.println("Bem vindo(a) a SyphaFlowers!");
        System.out.println("Para realizar o cadastro digite seu nome:");
        String nome = scanString.nextLine();
        System.out.println("Digite sua idade:");
        int idade = scanInt.nextInt();
        System.out.println("Digite sua função:(Cliente ou Funcionário)");
        String funcao = scanString.nextLine();

        Cliente novoCliente = new Cliente(nome, idade, funcao);
        Funcionario funcionario = new Funcionario(nome, idade, funcao);

        novoCliente.func();
        funcionario.func();

        while (condition) {

            System.out.println("""
                    
                    1 - Adicionar uma unidade de flor no pedido.
                    2 - Adicionar um buquê.
                    3 - Adicionar um vaso.
                    4 - Remover algum item do pedido.
                    5 - Visualizar o pedido e o valor de cada item.
                    6 - Visualizar o valor total do pedido.
                    7 - Finalizar.
                    Digite o número da ação que você quer realizar:
                    """);

            acao = scanInt.nextInt();

            switch (acao) {
                case 1 -> {
                    repoFlor.printFlor();
                    System.out.println("\nDigite o nome da flor:");
                    String nomeFlor = scanString.nextLine();
                    Flor cliente = repoFlor.encontrarFlor(nomeFlor);
                    if (cliente != null) {
                        florCliente.addFlor(cliente);
                        System.out.println("Flor adicionada!");
                    } else {
                        System.out.println("Nenhuma flor foi adicionada");
                    }
                }
                case 2 -> {
                    repoFlor.printFlor();
                    int i = 0;
                    System.out.println("\nDigite o nome da flor:");
                    String nomeBuque = scanString.nextLine();
                    Flor clienteB = repoFlor.encontrarFlor(nomeBuque);
                    System.out.println("Quantas flores serão?");
                    int qtd = scanInt.nextInt();
                    System.out.println("Você quer ornamentos no seu buquê?(Aumentará o valor em R$10,00)");
                    Scanner scanResp = new Scanner(System.in);
                    String resp = scanResp.nextLine();
                    boolean ornamento = Objects.equals(resp, "Sim") || Objects.equals(resp, "sim");
                    Buque objBuque = new Buque(clienteB.getFlor(), clienteB.getCor(), clienteB.getPrecoFlor(), qtd, ornamento);
                    try {
                        objBuque.veriQtdFlor();
                    } catch (QtdFlorException x) {
                        System.out.println(x.getMessage());
                        i = 1;
                    }
                    buqueCliente.addBuque(objBuque);
                    if (i == 1) {
                        buqueCliente.BuqueRepositorio.remove(objBuque);
                        System.out.println("O buquê não pôde ser adicionado");
                    } else
                        System.out.println("Buquê adicionado!");
                }
                case 3 -> {
                    repoFlor.printFlor();
                    int j = 0;
                    System.out.println("\nDigite o nome da flor:");
                    String nomeVaso = scanString.nextLine();
                    Flor clienteV = repoFlor.encontrarFlor(nomeVaso);
                    System.out.println("Quantas flores serão?");
                    int qtdV = scanInt.nextInt();
                    System.out.println("Você quer ornamentos no seu vaso?(Aumentará o valor em R$10,00)");
                    String respV = scanString.nextLine();
                    boolean ornamentoV = Objects.equals(respV, "Sim") || Objects.equals(respV, "sim");
                    System.out.println("Qual o tamanho que você quer seu vaso? (Grande, Médio ou Pequeno)");
                    String tamVaso = scanString.nextLine();
                    Vaso objVaso = new Vaso(clienteV.getFlor(), clienteV.getCor(), clienteV.getPrecoFlor(), qtdV, ornamentoV, tamVaso);
                    try {
                        objVaso.veriQtdFlor();
                    } catch (QtdFlorException x) {
                        System.out.println(x.getMessage());
                        j = 1;
                    }
                    try {
                        objVaso.veriTamVaso();
                    } catch (TamVasoException x) {
                        System.out.println(x.getMessage());
                        j = 2;
                    }
                    vasoCliente.addVaso(objVaso);
                    if (j == 1 || j == 2) {
                        vasoCliente.VasoRepositorio.remove(objVaso);
                        System.out.println("O vaso não pôde ser adicionado");
                    } else {
                        System.out.println("Vaso adicionado!");
                    }
                }
                case 4 -> {
                    System.out.println("""
                            Qual item você deseja remover:
                            1 - Flor.
                            2 - Buquê.
                            3 - Vaso.
                            """);
                    int itemRemovido = scanInt.nextInt();
                    if (Objects.equals(1, itemRemovido)) {
                        florCliente.printFlor();
                        System.out.println("Digite o ID de qual flor você deseja remover:");
                        florCliente.removeFlor(scanInt.nextInt());
                        System.out.println("Item removido!");
                    } else if (Objects.equals(2, itemRemovido)) {
                        buqueCliente.printBuque();
                        System.out.println("Digite o ID de qual buquê você deseja remover:");
                        buqueCliente.removeBuque(scanInt.nextInt());
                        System.out.println("Item removido!");
                    } else if (Objects.equals(3, itemRemovido)) {
                        vasoCliente.printVaso();
                        System.out.println("Digite o ID do vaso que você deseja remover:");
                        vasoCliente.removeVaso(scanInt.nextInt());
                        System.out.println("Item removido!");
                    }
                }
                case 5 -> {
                    if (florCliente.FlorRepositorio.size() == 0 && buqueCliente.BuqueRepositorio.size() == 0 && vasoCliente.VasoRepositorio.size() == 0) {
                        System.out.println("Não há nenhum item no seu pedido!");
                        break;
                    }
                    System.out.println("Pedido de " + novoCliente.getNome() + ":");
                    florCliente.printFlor();
                    buqueCliente.printBuque();
                    vasoCliente.printVaso();
                }
                case 6 -> {
                    int qtdTotal = florCliente.quantidadeF() + buqueCliente.quantidadeB() + vasoCliente.quantidadeV();
                    if (qtdTotal >= 20) {
                        System.out.println("Parabéns! Como seu pedido teve mais de 20 flores no total, você recebeu um desconto de 20% em sua compra!");
                        double totalPedido = florCliente.precoTotalF() + buqueCliente.precoTotalB() + vasoCliente.precoTotalV();
                        System.out.println("O pedido de " + novoCliente.getNome() + " foi no valor de R$: " + (totalPedido * 0.80) + "0");
                    } else {
                        double totalPedido = florCliente.precoTotalF() + buqueCliente.precoTotalB() + vasoCliente.precoTotalV();
                        System.out.println("O pedido de " + novoCliente.getNome() + " foi no valor de R$: " + totalPedido + "0");
                    }
                }
                case 7 -> {
                    System.out.println("Obrigado por comprar na Sypha Flowers. Volte sempre, " + novoCliente.getNome() + " :)");
                    condition = false;
                }
            }
        }
    }
}
