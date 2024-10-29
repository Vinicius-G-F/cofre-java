import Moedas.Dolar;
import Moedas.EnumMoeda;
import Moedas.Euro;
import Moedas.Real;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofre = new Cofrinho();
        while(true){
            mostrarMenuPrincipal();
            int opcaoSelecionada = -1;
            try {
                opcaoSelecionada = scanner.nextInt();
            } catch (Exception e) {
                System.out.printf("valor invalido\n\n");
                scanner.nextLine();
                continue;
            }

            if (opcaoSelecionada == 1){
                try {
                    mostrarMenuMoeda();
                    int opcaoSelecionadaMoeda = scanner.nextInt();
                    System.out.printf("Digite o Valor:\n");
                    double valorParaAdicao = scanner.nextDouble();
                    adicionarMoeda(opcaoSelecionadaMoeda, valorParaAdicao, cofre);
                } catch (Exception e) {
                    System.out.printf("valor invalido\n\n");
                    scanner.nextLine();
                }

                continue;
            } else if (opcaoSelecionada == 2) {
                try {
                    mostrarMenuMoeda();
                    int opcaoSelecionadaMoeda = scanner.nextInt();
                    System.out.printf("Digite o Valor:\n");
                    double valorParaAdicao = scanner.nextDouble();
                    removerMoeda(opcaoSelecionadaMoeda, valorParaAdicao, cofre);
                } catch (Exception e) {
                    System.out.printf("valor invalido\n\n");
                    scanner.nextLine();
                }

                continue;
            } else if (opcaoSelecionada == 3) {
                cofre.ListarMoedas();
                continue;
            } else if (opcaoSelecionada == 4) {
                cofre.ValorTotalEmReais();
                continue;
            } else if (opcaoSelecionada == 0) {
                break;
            }
            System.out.printf("valor invalido\n\n");
        }

        scanner.close();
    }



    private static void mostrarMenuPrincipal(){
        System.out.printf(
                "COFRINHO\n" +
                "1-Depositar\n" +
                "2-Sacar\n" +
                "3-Listar Moedas\n" +
                "4-Calcular total em reais\n" +
                "0-Encerrar\n");
    }
    private static void mostrarMenuMoeda(){
        System.out.printf(
                "Ecolha a moeda:\n" +
                "1-Real\n" +
                "2-Dolar\n" +
                "3-Euro\n");
    }
    private static void adicionarMoeda(int opcao, double valor, Cofrinho cofre){
        if (opcao == 1){
            Real real = new Real(valor);
            cofre.AdicionarMoeda(real);
            return;
        } else if (opcao == 2) {
            Dolar dolar = new Dolar(valor);
            cofre.AdicionarMoeda(dolar);
            return;
        } else if (opcao == 3) {
            Euro euro = new Euro(valor);
            cofre.AdicionarMoeda(euro);
            return;
        }

        System.out.printf("valor invalido\n\n");
    }
    private static void removerMoeda(int opcao, double valor, Cofrinho cofre){
        if (opcao == 1){
            Real real = new Real(valor);
            cofre.RemoverMoeda(real);
            return;
        } else if (opcao == 2) {
            Dolar dolar = new Dolar(valor);
            cofre.RemoverMoeda(dolar);
            return;
        } else if (opcao == 3) {
            Euro euro = new Euro(valor);
            cofre.RemoverMoeda(euro);
            return;
        }

        System.out.printf("valor invalido\n\n");
    }
}