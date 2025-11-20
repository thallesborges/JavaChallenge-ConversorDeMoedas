import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🪙 Seja bem-vindo(a) ao Conversor de Moedas 💱");
        Thread.sleep(1000);

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

            ui.limparTela();
            int indexMoedaConverter = ui.operacaoEscolhida(moedaBase, moedas, scanner);
            if (indexMoedaConverter == -1) {
                Thread.sleep(500);
                System.out.println("↩️ Você optou por alterar a moeda base, estamos voltando ao menu anterior.");
                Thread.sleep(3000);
                ui.limparTela();
                continue;
            }

            Moeda moedaConverter = moedas.get(indexMoedaConverter);
            System.out.println("💱 Converter de " + moedaBase + " para " + moedaConverter);
            break;
        }
    }
}
