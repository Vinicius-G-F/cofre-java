package Moedas;

public class Euro extends Moeda {
    // inicializando o enum que diferencia as moedas e o valor disponível da moeda conforme é passado
    // ao instanciar a classe
    public Euro(double valor){
        this.valor = valor;
        this.tipoMoeda = EnumMoeda.Euro;
    }

    // método que retorna um objeto com as principais informações da moeda
    @Override
    public InfoMoeda info() {
        InfoMoeda infoMoeda = new InfoMoeda(this.valor, this.tipoMoeda);
        return infoMoeda;
    }

    // método que faz a conversão das moedas referentes ao valores de mercado dela em 28/10/2024, logo
    // em seguida ele faz o retorno do valor de acordo com o tipo de moeda pedido
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

    // adiciona o valor disponivel da moeda, caso o valor passado seja negativo o método não faz nada
    @Override
    public void Depositar(double valor) {
        if (valor <= 0) return;
        this.valor += valor;
    }

    // remove o valor disponivel da moeda, caso o valor passado seja negativo o método não faz nada
    @Override
    public void Sacar(double valor) {
        if (valor <= 0) return;
        this.valor -= valor;
    }
}
