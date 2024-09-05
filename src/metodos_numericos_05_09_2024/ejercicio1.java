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
public class ejercicio1 {
    public static double f(double x) {
        return 25 * Math.pow(x, 3) - 6 * Math.pow(x, 2) + 7 * x - 88;
    }

    public static double fPrime(double x) {
        return 75 * Math.pow(x, 2) - 12 * x + 7;
    }

    public static double fDoublePrime(double x) {
        return 150 * x - 12;
    }

    public static double fTriplePrime(double x) {
        return 150;
    }
    public static double taylorExpansion(double x, double x0, int order) {
        double f_x0 = f(x0);
        double f_prime_x0 = fPrime(x0);
        double f_double_prime_x0 = fDoublePrime(x0);
        double f_triple_prime_x0 = fTriplePrime(x0);

        switch (order) {
            case 0:
                return f_x0;
            case 1:
                return f_x0 + f_prime_x0 * (x - x0);
            case 2:
                return f_x0 + f_prime_x0 * (x - x0) +
                       (f_double_prime_x0 / 2) * Math.pow((x - x0), 2);
            case 3:
                return f_x0 + f_prime_x0 * (x - x0) +
                       (f_double_prime_x0 / 2) * Math.pow((x - x0), 2) +
                       (f_triple_prime_x0 / 6) * Math.pow((x - x0), 3);
            default:
                throw new IllegalArgumentException("Order must be 0, 1, 2, or 3");
        }
    }

    public static void main(String[] args) {
        double x0 = 1;
        double x = 3;
        double fExact = f(x);
        System.out.println("CRISTIAN GONZALO MAMANI ESPINOZA ---- 12827829");
        System.out.printf("%-12s %-15s %-15s %-15s%n", "Orden", "Aprox", "V Verdadero", "Error Relativo");
        
        for (int order = 0; order <= 3; order++) {
            double fTaylor = taylorExpansion(x, x0, order);
            double errorRelativePercentual = Math.abs(fExact - fTaylor) / Math.abs(fExact) * 100;
            System.out.printf("%-12d %-15.6f %-15.6f %-15.6f%n", order, fTaylor, fExact, errorRelativePercentual);
        }
    }
}
