package processador_de_boletos.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private List boletos = new ArrayList<Boleto>();
    private List faturas = new ArrayList<Fatura>();
    
    public static void main(String[] args) {
        
        System.out.println("\n## Bem vindo(a) ao Processador de Boletos ##\n");

        main: while (true) {
            String menu = menu();
            switch (menu) {
                case "1":
                    System.out.println("Caso 1");
                    break;
                case "2":
                    System.out.println("Caso 2");
                    break;
                case "3":
                    System.out.println("Caso 3");
                    break;
                case "4":
                    System.out.println("Caso 4");
                    break;
                case "5":
                    System.out.println("Caso 5");
                    break;
                case "6":
                    System.out.println("\n## Obrigado por usar o Processador de Boletos ##\n");
                    break main;
                default:
                    System.out.println("\n## Digite uma opção válida! ##\n");
                    break;
            }
        }
    }

    private static String menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha uma das opções a seguir:");
        System.out.println(
            "\n1) Registrar novo Boleto"+
            "\n2) Ver Boletos"+
            "\n3) Registrar nova Fatura"+
            "\n4) Ver Faturas"+
            "\n5) Adicionar Pagamentos a uma Fatura"+
            "\n6) Sair");

        String menu = input.nextLine();
        return menu;
    }

    private static void novoBoleto() {
        //todo
    }

    private static void verBoletos() {
        //todo
    }

    private static void novaFatura() {
        //todo
    }

    private static void verFaturas() {
        //todo
    }

    private static void adicionarPagamentos() {
        //todo
    }
}
