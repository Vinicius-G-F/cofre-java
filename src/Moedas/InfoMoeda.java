package Moedas;

public class InfoMoeda  {
    double valor = 0;
    EnumMoeda tipoMoeda;

    public InfoMoeda(double valor, EnumMoeda tipoMoeda){
        this.valor = valor;
        this.tipoMoeda = tipoMoeda;
    }

    public double GetValor(){
        return valor;
    }

    public EnumMoeda GetTipoMoeda(){
        return tipoMoeda;
    }
}
