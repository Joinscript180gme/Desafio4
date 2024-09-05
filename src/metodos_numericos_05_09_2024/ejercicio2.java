/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_numericos_05_09_2024;

/**
 *
 * @author hp
 */
public class ejercicio2 {
    public static double ln(double x) {
        return Math.log(x);
    }

    public static double lnPrime(double x) {
        return 1 / x;
    }

    public static double lnDoublePrime(double x) {
        return -1 / (x * x);
    }

    public static double lnTriplePrime(double x) {
        return 2 / (x * x * x);
    }

    public static double lnQuadruplePrime(double x) {
        return -6 / (x * x * x * x);
    }
    public static double taylorExpansion(double x, double x0, int order) {
        double ln_x0 = ln(x0);
        double ln_prime_x0 = lnPrime(x0);
        double ln_double_prime_x0 = lnDoublePrime(x0);
        double ln_triple_prime_x0 = lnTriplePrime(x0);
        double ln_quadruple_prime_x0 = lnQuadruplePrime(x0);

        switch (order) {
            case 0:
                return ln_x0;
            case 1:
                return ln_x0 + ln_prime_x0 * (x - x0);
            case 2:
                return ln_x0 + ln_prime_x0 * (x - x0) +
                       (ln_double_prime_x0 / 2) * Math.pow((x - x0), 2);
            case 3:
                return ln_x0 + ln_prime_x0 * (x - x0) +
                       (ln_double_prime_x0 / 2) * Math.pow((x - x0), 2) +
                       (ln_triple_prime_x0 / 6) * Math.pow((x - x0), 3);
            case 4:
                return ln_x0 + ln_prime_x0 * (x - x0) +
                       (ln_double_prime_x0 / 2) * Math.pow((x - x0), 2) +
                       (ln_triple_prime_x0 / 6) * Math.pow((x - x0), 3) +
                       (ln_quadruple_prime_x0 / 24) * Math.pow((x - x0), 4);
            default:
                throw new IllegalArgumentException("Order must be between 0 and 4");
        }
    }

    public static void main(String[] args) {
        double x0 = 1;
        double x = 2.5;
        double lnExact = ln(x);
        System.out.println("CRISTIAN GONZALO MAMANI ESPINOZA ---- 12827829");
        System.out.printf("%-12s %-15s %-15s %-15s%n", "Orden", "Aprox", "V Verdadero", "Error Relativo");

        for (int order = 0; order <= 4; order++) {
            double lnTaylor = taylorExpansion(x, x0, order);
            double errorRelativePercentual = Math.abs(lnExact - lnTaylor) / Math.abs(lnExact) * 100;
            System.out.printf("%-12d %-15.6f %-15.6f %-15.6f%n", order, lnTaylor, lnExact, errorRelativePercentual);
        }
    }
}
