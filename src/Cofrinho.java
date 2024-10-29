import Moedas.EnumMoeda;
import Moedas.Moeda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cofrinho {
    List<Moeda> moedas;

    public Cofrinho() {
        this.moedas = new ArrayList<>();
    }

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

    private boolean contemMoeda(Moeda moeda){
        return moedas.stream().anyMatch(moedaNoCofre->{
            return moedaNoCofre.info().GetTipoMoeda() == moeda.info().GetTipoMoeda();
        });
    }
}
