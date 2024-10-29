package Moedas;

import Moedas.InfoMoeda;
import Moedas.Moeda;

public class Real extends Moeda {

    public Real(double valor){
        this.valor = valor;
        this.tipoMoeda = EnumMoeda.Real;
    }

    @Override
    public InfoMoeda info() {
        InfoMoeda infoMoeda = new InfoMoeda(this.valor, this.tipoMoeda);
        return infoMoeda;
    }

    @Override
    public double converter(EnumMoeda tipoDeMoeda) {
        switch (tipoDeMoeda){
            case Euro:
                return this.valor / 6.17;
            case Real:
                return this.valor;
            case Dolar:
                return this.valor / 5.71;
            default:
                return this.valor;
        }
    }

    @Override
    public void Depositar(double valor) {
        if (valor <= 0) return;
        this.valor += valor;
    }
    @Override
    public void Sacar(double valor) {
        if (valor <= 0) return;
        this.valor -= valor;
    }
}
