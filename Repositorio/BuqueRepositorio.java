package Repositorio;

import Floricultura.Buque;
import java.io.*;
import java.util.ArrayList;

public class BuqueRepositorio implements Serializable {

    int id;
    public ArrayList<Buque> BuqueRepositorio;

    public BuqueRepositorio(){
        this.BuqueRepositorio = null;
    }

    public void addBuque(Buque b){
        b.setId(this.id);
        BuqueRepositorio.add(b);
        id++;
    }

    public Buque encontrarBuque(int id){
        for (Buque x : BuqueRepositorio){
            if (id == x.getId())
                return x;
        }
        System.out.println("Não encontramos esse buque no pedido.");
        return null;
    }

    public void removeBuque(int i){
        if(encontrarBuque(i) != null)
            BuqueRepositorio.remove(encontrarBuque(i));
    }

    public void printBuque(){
        for (Buque x: BuqueRepositorio) {
            System.out.println(x + " | Preço total do buquê: R$" + x.calcPreco() + "0)");
        }
    }

    public double precoTotalB(){
        double total = 0;
        for (Buque x:BuqueRepositorio) {
            total += x.calcPreco();
        }
        return total;
    }

    public int quantidadeB(){
        int qtdTotal = 0;
        for (Buque x: BuqueRepositorio) {
            qtdTotal += x.getQtdFlor();
        }
        return qtdTotal;
    }

    public void salvarRepositorio(String caminhoArquivo) throws IOException {
        // https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012
        FileOutputStream fout = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
    }

    public static BuqueRepositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
        // https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012
        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
        BuqueRepositorio resp = (BuqueRepositorio) ois.readObject();
        ois.close();
        return resp;
    }

}
