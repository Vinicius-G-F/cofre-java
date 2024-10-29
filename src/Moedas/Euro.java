package Moedas;

public class Euro extends Moeda {
    public Euro(double valor){
        this.valor = valor;
        this.tipoMoeda = EnumMoeda.Euro;
    }

    @Override
    public InfoMoeda info() {
        InfoMoeda infoMoeda = new InfoMoeda(this.valor, this.tipoMoeda);
        return infoMoeda;
    }

    @Override
    public double converter(EnumMoeda tipoDeMoeda) {
        switch (tipoDeMoeda){
            case Real:
                return this.valor * 6.17;
            case Euro:
                return this.valor;
            case Dolar:
                return this.valor * 1.08;
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
