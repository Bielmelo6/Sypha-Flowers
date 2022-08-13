package Repositorio;

import Floricultura.Flor;

import java.io.IOException;
import java.util.ArrayList;

public class ListaFlores {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FlorRepositorio repoFlor = new FlorRepositorio();
        repoFlor.FlorRepositorio = new ArrayList<>();

        Flor rosa = new Flor("Rosa","Vermelho",3.5);
        Flor girassol = new Flor("Girassol","Amarelo",5);
        Flor margarida = new Flor("Margarida", "Branco", 4.50);
        Flor orquidea = new Flor("Orquidea", "Roxo", 4);
        Flor tulipa = new Flor("Tulipa", "Laranja", 3);
        repoFlor.addFlor(rosa);
        repoFlor.addFlor(girassol);
        repoFlor.addFlor(margarida);
        repoFlor.addFlor(orquidea);
        repoFlor.addFlor(tulipa);

        String caminho = "./ArquivoRepositorio/repositorio.flor";
        repoFlor.salvarRepositorio(caminho);
        repoFlor = FlorRepositorio.carregarRepositorio(caminho);
    }
}
