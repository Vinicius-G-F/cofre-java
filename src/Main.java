import Moedas.Dolar;
import Moedas.EnumMoeda;
import Moedas.Euro;
import Moedas.Real;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // chamando o scanner que vai pegar as entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // instanciando o cofrinho sem nada ainda dentro
        Cofrinho cofre = new Cofrinho();

        // iniciando o loop para pegar as entradas do usuário
        while(true){
            // esse método imprime na tela o menu principal
            mostrarMenuPrincipal();

            // aqui eu declarei uma variavel de controle para ver qual opção o usuario escolheu,
            // poderia ser um enum mas eu fique com preguiça. '-'
            int opcaoSelecionada = -1;

            // tratamento de possíveis exceptions caso o usuario digita um texto ao invés de numero, esse
            // tratamento vai se repetir mais algumas vezes '-'
            try {
                opcaoSelecionada = scanner.nextInt();
            } catch (Exception e) {
                System.out.printf("valor invalido\n\n");
                scanner.nextLine();
                continue;
            }

            // opção 1 é a de adicionar moeda
            if (opcaoSelecionada == 1){
                try {
                    // mais alguns prints pra mostrar as opções do usuário
                    mostrarMenuMoeda();
                    int opcaoSelecionadaMoeda = scanner.nextInt();
                    System.out.printf("Digite o Valor:\n");
                    double valorParaAdicao = scanner.nextDouble();

                    // uma vez coletado os dados digitados esse método vai adicionar a moeda ao cofre
                    adicionarMoeda(opcaoSelecionadaMoeda, valorParaAdicao, cofre);
                } catch (Exception e) {
                    System.out.printf("valor invalido\n\n");
                    scanner.nextLine();
                }

                continue;
                // opção 2 de remover
            } else if (opcaoSelecionada == 2) {
                try {
                    // mais alguns prints pra mostrar as opções do usuário
                    mostrarMenuMoeda();
                    int opcaoSelecionadaMoeda = scanner.nextInt();
                    System.out.printf("Digite o Valor:\n");
                    double valorParaAdicao = scanner.nextDouble();
                    // uma vez coletado os dados digitados esse método vai remover a moeda do cofre
                    removerMoeda(opcaoSelecionadaMoeda, valorParaAdicao, cofre);
                } catch (Exception e) {
                    System.out.printf("valor invalido\n\n");
                    scanner.nextLine();
                }

                continue;
                //opção 3 para listagem e método da classe cofre sendo chamado, os prints são feitos dentro
                // da classe cofre mesmo
            } else if (opcaoSelecionada == 3) {
                cofre.ListarMoedas();
                continue;
                //opção 4 para mostrar valot total e método da classe cofre sendo chamado, o print é
                // feito dentro da classe cofre mesmo
            } else if (opcaoSelecionada == 4) {
                cofre.ValorTotalEmReais();
                continue;
                // opção 4 para encerrar
            } else if (opcaoSelecionada == 0) {
                break;
            }
            // imprimindo valor invalido caso nenhum dos if encontre uma opção valida
            System.out.printf("valor invalido\n\n");
        }

        // fechando o scanner
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
        // instanciando a moeda selecionada e adicionando a classe cofre junto com o valor da moeda
        // para insersão
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
        // imprimindo valor invalido caso nenhum dos if encontre uma opção valida
        System.out.printf("valor invalido\n\n");
    }
    private static void removerMoeda(int opcao, double valor, Cofrinho cofre){
        // instanciando a moeda selecionada e removendo da classe cofre junto com o valor da moeda
        // para remoção
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
        // imprimindo valor invalido caso nenhum dos if encontre uma opção valida
        System.out.printf("valor invalido\n\n");
    }
}