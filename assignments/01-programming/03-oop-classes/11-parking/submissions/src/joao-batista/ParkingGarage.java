import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double taxa;

        if (hours <= 3.0) {
            taxa = 2.00;
        } else {
            double horasExtras = hours - 3.0;
            int horasExtrasArredondadas = (int) Math.ceil(horasExtras);
            taxa = 2.00 + (horasExtrasArredondadas * 0.50);
        }

        if (taxa > 10.00) {
            taxa = 10.00;
        }

        return taxa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalArrecadado = 0.0;
        int numeroCliente = 1;

        while (true) {
            System.out.print(
                    "Digite o número de horas estacionadas para o cliente (ou -1 para sair): "
            );
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            double taxa = calculateCharges(horas);

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n",
                    numeroCliente, taxa);

            totalArrecadado += taxa;
            numeroCliente++;

            System.out.println();
        }

        System.out.printf("%nTotal arrecadado ontem: $%.2f%n", totalArrecadado);

        scanner.close();
    }
}