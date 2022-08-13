package Repositorio;

import Floricultura.Buque;
import Floricultura.Vaso;
import java.io.*;
import java.util.ArrayList;

public class VasoRepositorio implements Serializable {

    int id;
    public ArrayList<Vaso> VasoRepositorio;

    public VasoRepositorio() {
        this.VasoRepositorio = null;
    }

    public void addVaso(Vaso v) {
        v.setId(this.id);
        VasoRepositorio.add(v);
        id++;
    }

    public Buque encontrarVaso(int id) {
        for (Vaso x : VasoRepositorio) {
            if (id == x.getId())
                return x;
        }
        System.out.println("Não encontramos esse vaso no pedido.");
        return null;
    }

    public void removeVaso(int i) {
        if (encontrarVaso(i) != null)
            VasoRepositorio.remove(encontrarVaso(i));
    }

    public void printVaso() {
        for (Vaso x : VasoRepositorio) {
            System.out.println(x + " | Preço final do Vaso: R$" + x.calcPreco() + "0)");
        }
    }

    public double precoTotalV() {
        double total = 0;
        for (Vaso x : VasoRepositorio) {
            total += x.calcPreco();
        }
        return total;
    }

    public int quantidadeV() {
        int qtdTotal = 0;
        for (Vaso x : VasoRepositorio) {
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

    public static VasoRepositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
        // https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012
        FileInputStream fin = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fin);
        VasoRepositorio resp = (VasoRepositorio) ois.readObject();
        ois.close();
        return resp;
    }

}
