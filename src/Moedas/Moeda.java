package Moedas;

public abstract class Moeda {
    protected double valor;
    protected EnumMoeda tipoMoeda;
    public abstract InfoMoeda info();
    public abstract double converter(EnumMoeda tipoDeMoeda);
    public abstract void Depositar(double valor);
    public abstract void Sacar(double valor);
}
