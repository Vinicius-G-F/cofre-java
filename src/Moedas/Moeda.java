package Moedas;

// classe estática que será herdada pelas classes moedas, a partir dessa classe as moedas poderão ser
// adicionadas a lista de moedas no "cofrinho", é possivel manter uma padronização consistente através
// dela pois as classes que herdam dessa classe precisam implementar todos os métodos aqui definidos.
public abstract class Moeda {
    protected double valor;
    protected EnumMoeda tipoMoeda;
    public abstract InfoMoeda info();
    public abstract double converter(EnumMoeda tipoDeMoeda);
    public abstract void Depositar(double valor);
    public abstract void Sacar(double valor);
}
