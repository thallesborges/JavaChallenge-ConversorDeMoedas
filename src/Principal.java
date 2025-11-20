import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println("🪙 Seja muito bem-vindo(a) ao Conversor de Moedas 💱");
        Thread.sleep(2000);

        while (true) {
            List<Moeda> moedas = new ArrayList<>();
            moedas.add(new Moeda("Dólar Americano", "USD"));
            moedas.add(new Moeda("Euro", "EUR"));
            moedas.add(new Moeda("Libra Esterlina", "GBP"));
            moedas.add(new Moeda("Iene Japonês", "JPY"));
            moedas.add(new Moeda("Peso Argentino", "ARS"));
            moedas.add(new Moeda("Peso Chileno", "CLP"));
            moedas.add(new Moeda("Dólar Canadense", "CAD"));
            moedas.add(new Moeda("Renminbi Chinês", "CNY"));
            moedas.add(new Moeda("Real Brasileiro", "BRL"));
            moedas.sort((m1, m2) -> m1.getNome().compareTo(m2.getNome()));

            InterfaceMenu ui = new InterfaceMenu();

            int indexMoedaBase = ui.menuMoedaBase(moedas, scanner);
            Moeda moedaBase = moedas.get(indexMoedaBase);
            moedas.remove(moedaBase);

            Thread.sleep(1000);
            int indexMoedaConverter = ui.operacaoEscolhida(moedaBase, moedas, scanner);
            if (indexMoedaConverter == -1) {
                Thread.sleep(500);
                System.out.println("↩️ Você optou por alterar a moeda, estamos voltando ao menu anterior.");
                Thread.sleep(2000);
                continue;
            }

            Moeda moedaConverter = moedas.get(indexMoedaConverter);
            System.out.println("✳️ Converter de " + moedaBase + " para " + moedaConverter);

            double valor;
            while (true) {
                System.out.print("💸 Insira o valor que deseja converter: ");
                try {
                    valor = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    if (valor <= 0) {
                        System.out.println("⁉️ Valor inválido! Insira um valor maior que 0.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Entrada inválida! Insira um valor numérico positivo.");
                }
            }

            ConsultaConversao consultaConversao = new ConsultaConversao();
            BuscaValorConversao conversao = consultaConversao.valorConversao(moedaBase, moedaConverter, valor);
            System.out.println("🪙 O valor de " + df.format(valor) + " ["+ moedaBase.getCodigo() + "] equivale a " + df.format(conversao.conversion_result()) + " [" + moedaConverter.getCodigo() + "] em " + moedaConverter.getNome());
            Thread.sleep(5000);

            int opcao;
            while (true) {
                System.out.println("↩️ Deseja fazer outra conversão?");
                System.out.println("1. Sim");
                System.out.println("2. Não");
                System.out.print("💠 Opção: ");
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    if (opcao < 0 || opcao > 2) {
                        System.out.println("❌ Opção inválida! Por favor, insira 1 para 'Sim' ou 2 para 'Não'.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Entrada inválida! Por favor, insira 1 para 'Sim' ou 2 para 'Não'.");
                }
            }

            if (opcao == 1) {
                continue;
            }

            System.out.println("❇️ Encerrando...");
            Thread.sleep(500);
            System.out.println("👋🏻 Obrigado por utilizar nosso sistema, volte sempre!");
            break;
        }
    }
}
