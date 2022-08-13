package Floricultura;

import java.io.Serializable;
import java.util.Objects;
import Exception.*;
import Metodo.*;

public class Vaso extends Buque implements Serializable, CalcPreco, VeriQtdFlor, VeriTamVaso {

    String tamanhoVaso;
    double precoVaso;

    public Vaso(String flower, String color, double precoFlor, int qtdFlower, boolean ornament, String tamanhoVaso){
        super(flower, color, precoFlor, qtdFlower, ornament);
        this.tamanhoVaso = tamanhoVaso;
        priceVaso();
    }

    public void setTamanhoVaso(String tamanhoVaso) {
        this.tamanhoVaso = tamanhoVaso;
    }

    public String getTamanhoVaso() {
        return tamanhoVaso;
    }

    public double getPrecoVaso() {
        return precoVaso;
    }

    public void setPrecoVaso(double precoVaso) {
        this.precoVaso = precoVaso;
    }

    public void priceVaso(){
        if(Objects.equals(tamanhoVaso, "Grande"))
            setPrecoVaso(20);
        else if(Objects.equals(tamanhoVaso, "Médio"))
            setPrecoVaso(15);
        else if(Objects.equals(tamanhoVaso, "Pequeno"))
            setPrecoVaso(10);
    }

    @Override
    public double calcPreco() {
        return super.calcPreco() + getPrecoVaso();
    }

    @Override
    public String toString() {
        return  "ID " + getId() + ": Vaso(" +
                "Flor: " + getFlor() +
                " | Cor: " + getCor() +
                " | Preço da unidade da flor: R$" + getPrecoFlor() + "0" +
                " | Quantidade de flores: " + getQtdFlor() +
                " | Ornamento: " + isOrnamento() +
                " | Tamanho do vaso: " + tamanhoVaso +
                " | Preço do Vaso: R$" + precoVaso + "0"
                ;
    }

    @Override
    public void veriQtdFlor() throws QtdFlorException {
        super.veriQtdFlor();
    }

    @Override
    public void veriTamVaso() throws TamVasoException {
        if(!Objects.equals(getTamanhoVaso(), "Grande") && !Objects.equals(getTamanhoVaso(), "Médio") && !Objects.equals(getTamanhoVaso(), "Pequeno"))
            throw new TamVasoException();
    }
}
