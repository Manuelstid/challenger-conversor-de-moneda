import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        String menu = """
                   Escriba el numero de la opcion de cambio deseada:
                   1. COP-Peso colombiano ==> USD-Dollar
                   2. USD-Dollar ==> COP-Peso colombiano
                   3. BRL-Real Brasileño ==> USD-Dollar
                   4. USD-Dollar ==> BRL-Real Brasileño
                   5. ARS Peso Argentino ==> USD-Dollar
                   6. USD-Dollar ==> ARS Peso Argentino
                   7. Salir
                   """;

        while (!exit) {
            System.out.println(menu);
            int choice = scanner.nextInt();


            switch (choice) {
                case 1 -> performConversion("COP", "USD", scanner);
                case 2 -> performConversion("USD", "COP", scanner);
                case 3 -> performConversion("BRL", "USD", scanner);
                case 4 -> performConversion("USD", "BRL", scanner);
                case 5 -> performConversion("ARS", "USD", scanner);
                case 6 -> performConversion("USD", "ARS", scanner);
                case 7 -> exit = true;
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    private static void performConversion(String baseCurrency, String targetCurrency, Scanner scanner) {
        System.out.printf("Ingrese la cantidad en %s que desea convertir a %s:%n", baseCurrency, targetCurrency);
        double amount = scanner.nextDouble();
        CurrencyConverter converter = new CurrencyConverter(baseCurrency);
        double convertedAmount = converter.convert(targetCurrency, amount);
        System.out.printf("%.2f %s equivale a %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
    }
}
