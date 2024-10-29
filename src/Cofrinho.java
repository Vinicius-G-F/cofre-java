import Moedas.EnumMoeda;
import Moedas.Moeda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cofrinho {
    // criando a lista de moedas a partir da classe pai "Moeda" mas que vai ser preenchido por classes
    // euro, real e dolar
    List<Moeda> moedas;

    // inicializando lista no constructor
    public Cofrinho() {
        this.moedas = new ArrayList<>();
    }

    // método público para adição da moeda ao cofre, primeiro ele checa se a moeda ja foi adicionada, caso
    // a moeda ja tenha sido adicionada então o valor da moeda é incrementado ao que já esta presente na
    // lista, caso contrário apenas adiciona a instacia da moeda na lista
    public void AdicionarMoeda(Moeda moeda){
        if(this.contemMoeda(moeda)){
            moedas.forEach((moedaNoCofre)->{
                if (moedaNoCofre.info().GetTipoMoeda() == moeda.info().GetTipoMoeda()){
                    moedaNoCofre.Depositar(moeda.info().GetValor());
                }
            });
        } else {
            moedas.add(moeda);
        }
    }

    // método de remoção de moeda, ele verifica se a moeda existe na lista "moedas" se não existe ele solta
    // uma mensagem de erro, caso a moeda exista ele também precisa verifica dentro do map se o valor de
    // remoção é maior do que o que tem disponível no cofre, se o valor de remoção for maior então ele dá
    // uma mensagem de erro e impede a remoção retornando a moeda de volta a lista sem nenhuma alteração
    // caso contrário o método "sacar" da moeda é chamado para reduzir a quantidade disponivel da moeda.
    // Caso a moeda seja zerada o filter verifica se o valor dela é maior que zero para então decidir
    // se ela deve permanecer na lista
    public void RemoverMoeda(Moeda moeda){
        if (this.contemMoeda(moeda)) {
            moedas = moedas.stream().map((moedaNoCofre ->{
                if (moedaNoCofre.info().GetTipoMoeda() == moeda.info().GetTipoMoeda()){
                    if (moedaNoCofre.info().GetValor() < moeda.info().GetValor()){
                        System.out.printf("Você esta tentando retirar do cofre um valor maior que o disponível dentro do cofre. \n\n");
                        return moedaNoCofre;
                    }
                    moedaNoCofre.Sacar(moeda.info().GetValor());
                    return moedaNoCofre;
                } else {
                    return moedaNoCofre;
                }
            }))
                    .filter(moedaNoCofre -> moedaNoCofre.info().GetValor() > 0)
                    .collect(Collectors.toList());
        } else {
            System.out.printf("moeda ainda não foi adicionada ao cofre \n\n");
        }
    }

    // método foreach é chamado para printar todos os itens da lista "moedas", mas antes existe uma
    // verificação se existem moedas dentro da lista para avisar ao usuario sobre a ausencia de moedas
    public void ListarMoedas(){
        if(moedas.stream().count() <= 0){
            System.out.printf("Nada foi adicionado aqui ainda. =/\n");
        } else {
            moedas.forEach((moeda)->{
                System.out.printf("%s = %.2f%n", moeda.info().GetTipoMoeda().toString(), moeda.info().GetValor());
            });
        }

        System.out.printf("\n\n");
    }


    // aqui a mesma verificação de ausencia de moedas é feita para então prosseguir com o print do valor
    // total, aparentemente o método mais facil de fazer a soma é convertendo a lista moedas em uma lista
    // de double com os valores em reais e então somando cada item dessa nova lista para ter o total em
    // reais, podendo assim imprimir o valor para o usuário
    public void ValorTotalEmReais(){
        if(moedas.stream().count() <= 0){
            System.out.printf("Nada foi adicionado aqui ainda. =/\n");
        } else {
            double valorTotal = moedas.stream().mapToDouble(moedaNoCofre ->{
                return moedaNoCofre.converter(EnumMoeda.Real);
            }).sum();

            System.out.printf("O valor total em reais dentro do cofre é de R$ %.2f%n", valorTotal);
        }

        System.out.printf("\n\n");
    }

    // um método simples que eu criei para me ajudar a saber se o tipo da moeda que o usuário quer adicionar
    // ou remover já esta presente na lista, retornando um valor booleano referente a comparação do valor
    // do enumMoeda presente nas moedas da lista com o que está pra ser verificado
    private boolean contemMoeda(Moeda moeda){
        return moedas.stream().anyMatch(moedaNoCofre->{
            return moedaNoCofre.info().GetTipoMoeda() == moeda.info().GetTipoMoeda();
        });
    }
}
