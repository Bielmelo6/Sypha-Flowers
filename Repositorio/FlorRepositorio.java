package Repositorio;

import Floricultura.Flor;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


public class FlorRepositorio implements Serializable {


    public ArrayList<Flor> FlorRepositorio;

    public FlorRepositorio (){
        this.FlorRepositorio = null;
    }

    public void addFlor(Flor f){
        FlorRepositorio.add(f);
    }

    public Flor encontrarFlor(String nome){
        for (Flor x : FlorRepositorio){
            if (Objects.equals(x.getFlor(), nome))
                return x;
        }
        System.out.println("Não temos essa flor na nossa loja!");
        return null;
    }

    public void printFlor(){
        int id = 0;
        for (Flor x:FlorRepositorio) {
            System.out.println("ID " + id + ": " + x);
            id++;
        }
    }

    public void removeFlor(int i){
        FlorRepositorio.remove(i);
    }

    public double precoTotalF(){
        double total = 0;
        for (Flor x:FlorRepositorio) {
            total += x.calcPreco();
        }
        return total;
    }

    public int quantidadeF() {
        int i = 0;
        for (Flor x: FlorRepositorio) {
            i++;
        }
        return i;
    }

    public void salvarRepositorio(String caminhoArquivo) throws IOException {
        FileOutputStream fout = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
    }

    public static FlorRepositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
        FlorRepositorio resp = (FlorRepositorio) ois.readObject();
        ois.close();
        return resp;
    }

}
