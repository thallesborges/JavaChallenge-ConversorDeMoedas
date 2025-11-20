import java.util.List;
import java.util.Scanner;

public class InterfaceMenu {

    public int menuMoedaBase(List<Moeda> moedas, Scanner scanner) throws InterruptedException {
        System.out.println("=== Converter de: ");
        Thread.sleep(500);

        for (int i = 0; i < moedas.size(); i++) {
            System.out.println((i + 1) + ". " + moedas.get(i).getNome());
            Thread.sleep(500);
        }

        int index;
        while (true) {
            System.out.print("💠 Insira uma das opções: ");
            try {
                index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index < 0 || index >= moedas.size()) {
                    System.out.println("❌ Opção inválida! Por favor, escolha entre 1 e " + moedas.size() + ".");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Por favor, digite um número inteiro positivo entre 1 e " + moedas.size() + ".");
            }
        }
        return index;
    }

    public int operacaoEscolhida(Moeda moedaBase, List<Moeda> moedas, Scanner scanner) throws InterruptedException {
        System.out.println("=== Converter de " + moedaBase.getNome() + " para:");
        Thread.sleep(500);

        int i;
        for (i = 0; i < moedas.size(); i++) {
            System.out.println((i+1) + ". " + moedas.get(i));
            Thread.sleep(500);
        }
        System.out.println("----------------");
        System.out.println((i+1) + ". Alterar moeda");

        int index;
        while (true) {
            System.out.print("💠 Insira uma das opções: ");
            try {
                index = Integer.parseInt(scanner.nextLine()) - 1;
                if (index < 0 || index > i) {
                    System.out.println("❌ Opção inválida! Por favor, insira um valor numérico entre 1 e " + (i + 1) + ".");
                    continue;
                }

                if (index == i) {
                    return -1;
                }

                return index;

            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Por favor, insira um valor inteiro positivo entre 1 e " + (i + 1) + ".");
            }
        }
    }
}
