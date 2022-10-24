package processador_de_boletos.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static Map<String, Boleto> boletos = new HashMap<>();
    private static List<Fatura> faturas = new ArrayList<Fatura>();
    
    public static void main(String[] args) {
        
        System.out.println("\n### Bem vindo(a) ao Processador de Boletos ###\n");

        main: while (true) {
            String menu = menu();
            menu: switch (menu) {
                
                case "1":
                System.out.println("\n## Registrar nova Fatura ##\n");
                novaFatura();
                break menu;
                
                case "2":
                System.out.println("\n## Ver Faturas Registradas ##\n");
                verFaturas();
                break menu;
                
                case "3":
                System.out.println("\n## Registrar novo Boleto ##\n");
                novoBoleto();
                break menu;
                
                case "4":
                System.out.println("\n## Ver Boletos Registrados ##\n");
                verBoletos();
                break menu;
                
                case "5":
                System.out.println("\n## Adicionar Pagamentos ##\n");
                adicionarPagamentos();
                break menu;
                
                case "6":
                System.out.println("\n### Obrigado por usar o Processador de Boletos ###\n");
                break main;
                
                default:
                System.out.println("\n## Digite uma opção válida! ##\n");
                break menu;
            }
        }
    }

    private static String menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nEscolha uma das opções a seguir:");
        System.out.println(
            "\n1) Registrar nova Fatura"+
            "\n2) Ver Faturas"+
            "\n3) Registrar novo Boleto"+
            "\n4) Ver Boletos"+
            "\n5) Adicionar Pagamentos a uma Fatura"+
            "\n6) Sair");

        String menu = input.nextLine();

        return menu;
    }

    private static void novoBoleto() {
        Scanner input = new Scanner(System.in);

        System.out.println(
            "\nPara cadastrar um novo Boleto, informe: "+
            "\n1) O Código;"+
            "\n2) A Data; e"+
            "\n3) O Valor pago."+
            "\n# Não utilize caracteres especiais (ex: @, $, !) #\n"+
            "\nPressione Enter para seguir\n");
        input.nextLine();

        System.out.println("\n# Informe os seguintes dados #\n");

        System.out.println("\nCódigo (ex: 1234)");
        String codigo = input.nextLine().trim();

        System.out.println("\nData (ex: 22-12-2019)");
        String data = input.nextLine().trim();

        System.out.println("\nValor pago (ex: 139.90)");
        String valor_pago = input.nextLine().trim();

        if (!Util.verificaString(codigo)) {
            aviso("\n# Código informado inválido");
            return;
        }

        if (!Util.verificaData(data)) {
            aviso("\n# Data informada inválida");
            return;
        }

        if (!Util.isDouble(valor_pago)) {
            aviso("Valor informado inválido");
            return;
        }

        Boleto boleto = new Boleto(codigo, data, Double.parseDouble(valor_pago));
        if (!boletos.containsKey(boleto.getCodigo())) {
            boletos.put(boleto.getCodigo(), boleto);
        } else {
            aviso("Código de boleto já Registrado!");
        }

    }

    private static void verBoletos() {

        if (!boletos.isEmpty()) {
            for (Boleto boleto : boletos.values()) {
                System.out.println("\n" + boleto.toString());
            }
        } else {
            aviso("Ainda não há Boletos Registrados!");
        }
    }

    private static void novaFatura() {
        Scanner input = new Scanner(System.in);

        System.out.println(
            "\nPara cadastrar uma nova Fatura, informe: "+
            "\n1) A Data;"+
            "\n2) O Valor Total; e"+
            "\n3) O Nome do Cliente." +
            "\n# Não utilize caracteres especiais (ex: @, $, !) #\n"+
            "\nPressione Enter para seguir\n");
        input.nextLine();

        System.out.println("\n# Informe os seguintes dados #\n");

        System.out.println("\nData (ex: 23-11-2020)");
        String data = input.nextLine().trim();

        System.out.println("\nValor Total (ex: 1039.90)");
        String valor_total = input.nextLine().trim();

        System.out.println("\nNome do Cliente (ex: Gabriel)");
        String nome_cliente = input.nextLine();

        if (!Util.verificaData(data)) {
            aviso("Data informada inválida");
            return;
        }

        if (!Util.isDouble(valor_total)) {
            System.out.println("Valor informado inválido!");
            return;
        }
        
        if (!Util.verificaString(nome_cliente)) {
            aviso("Nome informado inválido!");
            return;
        }

        Fatura fatura = new Fatura (data, Double.parseDouble(valor_total), nome_cliente);
        faturas.add(fatura);
    }

    private static void verFaturas() {
        if (!faturas.isEmpty()) {
            for (Fatura fatura: faturas) {
                System.out.println("\n" + fatura.toString());
            }
        } else {
            aviso("Ainda não há Faturas Registradas!");
        }
    }

    private static void adicionarPagamentos() {
        if (faturas.isEmpty()) {
            aviso("Ainda não há Faturas Registradas!");
            return;
        }

        if (boletos.isEmpty()) {
            aviso("Ainda não há Boletos Registrados!");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.println("\nEscolha uma Fatura para resgitrar o pagamento:\n");

        int contador = 0;

        for (Fatura fatura : faturas) {
            if (fatura.getStatus().equals("PENDENTE")) {
                System.out.println(contador + ") " + fatura.toString());
                contador++;
            }
        }
        
        int index = 0;
        try {
            index = input.nextInt();
        } catch (Exception e) {
            aviso("Valor inválido!");
            return;
        }
        
        Fatura fatura = faturas.get(index);

        if (fatura.getStatus().equals("PAGA")) {
            return;
        }

        addPagamento: while (true) {
            System.out.println("\nEscolha o código de um Boleto para adicionar à Fatura " + index + ":\n");

            for (Boleto boleto : boletos.values()) {
                if (!fatura.getPagamentos().contains(boleto.getCodigo())) {
                    System.out.println(boleto.toString());
                }
            }

            input = new Scanner(System.in);
            String codigo = input.nextLine();

            if (!boletos.containsKey(codigo)) {
                aviso("Código inválido!");
                break addPagamento;
            } else {

                Boleto boleto = boletos.get(codigo);
                Pagamento pagamento = new Pagamento(boleto.getValor_pago(), boleto.getData(), "BOLETO");

                ArrayList<Pagamento> pagamentos = fatura.getPagamentos();
                pagamentos.add(pagamento);

                fatura.setPagamentos(pagamentos);

                Double valor_pago = 0.0;
                for (Pagamento pag: pagamentos) {
                    valor_pago += pag.getValor_pago();
                }

                if (valor_pago >= fatura.getValor_total()) {
                    fatura.setStatus("PAGA");
                    aviso("Fatura paga!");
                    break addPagamento;
                } else {
                    aviso("Pagamento adicionado!");
                    System.out.print("\nDeseja adicionar mais pagamentos? (s/n) ");

                    input = new Scanner(System.in);
                    String continuar = input.nextLine();

                    if (!continuar.trim().toLowerCase().equals("s")) {
                        break addPagamento;
                    }
                }
            }
        }
        
    }

    private static void aviso(String aviso) {
        System.out.println("\n# " + aviso.toUpperCase() + " #\n");
    }
}
