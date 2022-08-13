package Floricultura;

import java.io.Serializable;
import Exception.QtdFlorException;
import Metodo.*;

public class Buque extends Flor implements Serializable, CalcPreco, VeriQtdFlor {

    private int id;
    private int qtdFlor;
    private boolean ornamento;

    public Buque(String flor, String cor,  double precoFlor, int qtdFlor, boolean ornamento){
        super(flor, cor, precoFlor);
        this.qtdFlor = qtdFlor;
        this.ornamento = ornamento;
    }

    public void setOrnamento(boolean ornamento) {
        this.ornamento = ornamento;
    }

    public void setQtdFlor(int qtdFlor) {
        this.qtdFlor = qtdFlor;
    }

    public int getQtdFlor() {
        return qtdFlor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isOrnamento() {
        return ornamento;
    }

    @Override
    public double calcPreco() {
        int aumento = 0;
        if(ornamento){
            aumento = 10;
        }
        return super.calcPreco()*getQtdFlor() + aumento;
    }

    @Override
    public String toString() {
        return  "ID " + id + ": Buquê(" +
                "Flor: " + getFlor() +
                " | Cor: " + getCor() +
                " | Preço da unidade da flor: R$" + getPrecoFlor() + "0" +
                " | Quantidade de flores: " + qtdFlor +
                " | Ornamento: " + ornamento
                ;
    }

    public void veriQtdFlor() throws QtdFlorException{
        if(getQtdFlor() < 2)
            throw new QtdFlorException();
    }

}


