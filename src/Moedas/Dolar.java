package Moedas;

public class Dolar extends Moeda{
    public Dolar(double valor){
        this.valor = valor;
        this.tipoMoeda = EnumMoeda.Dolar;
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
                return this.valor * 0.92;
            case Dolar:
                return this.valor;
            case Real:
                return this.valor * 5.71;
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
