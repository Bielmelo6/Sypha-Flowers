package Floricultura;

import Metodo.*;

import java.io.Serializable;

public class Flor implements Serializable, CalcPreco {

    private String flor;
    private String cor;
    private double precoFlor;

    public Flor(String flor, String cor, double preco){
        this.flor = flor;
        this.cor = cor;
        this.precoFlor = preco;
    }

    public String getFlor() {
        return flor;
    }

    public void setFlor(String flor) {
        this.flor = flor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setPrecoFlor(double precoFlor) {
        this.precoFlor = precoFlor;
    }

    public double getPrecoFlor() {
        return precoFlor;
    }

    public double calcPreco(){
        return getPrecoFlor();
    }

    @Override
    public String toString() {
        return
                "Flor: " + flor +
                " | Cor: " + cor +
                " | Preço da unidade da flor : R$" + precoFlor + "0"
                ;
    }
}
