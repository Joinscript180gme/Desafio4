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
public class ejercicio3 {
    
    public static void main(String[] args) {
        // Valores conocidos
        System.out.println("CRISTIAN GONZALO MAMANI ESPINOZA ---- 12827829");
        double B = 20.0; // ancho (m)
        double H = 0.3;  // profundidad (m)
        double n = 0.03; // coeficiente de rugosidad
        double S = 0.0003; // pendiente

        // Rango de errores
        double nMin = 0.027; // mínimo coeficiente de rugosidad
        double nMax = 0.033; // máximo coeficiente de rugosidad
        double SMin = 0.00027; // mínimo pendiente
        double SMax = 0.00033; // máximo pendiente

        // Calcular el flujo usando los valores centrales
        double Q = calculateFlow(B, H, n, S);
        System.out.println("Flujo calculado: " + Q + " m³/s");

        // Calcular el cambio en el flujo debido a la rugosidad
        double deltaN = (nMax - nMin) / 2;
        double deltaQ_n = calculateErrorFlowDeltaN(B, H, n, S, deltaN);
        System.out.println("Cambio en el flujo debido a la rugosidad: " + deltaQ_n + " m³/s");

        // Calcular el cambio en el flujo debido a la pendiente
        double deltaS = (SMax - SMin) / 2;
        double deltaQ_S = calculateErrorFlowDeltaS(B, H, n, S, deltaS);
        System.out.println("Cambio en el flujo debido a la pendiente: " + deltaQ_S + " m³/s");
    }
    public static double calculateFlow(double B, double H, double n, double S) {
        return (1 / n) * Math.pow((B * H / S), 2.0 / 3.0);
    }
    public static double calculateErrorFlowDeltaN(double B, double H, double n, double S, double deltaN) {
        double Q = calculateFlow(B, H, n, S);
        double partialDerivative = -Math.pow((B * H / S), 2.0 / 3.0) / (n * n);
        return Math.abs(partialDerivative) * deltaN;
    }
    public static double calculateErrorFlowDeltaS(double B, double H, double n, double S, double deltaS) {
        double Q = calculateFlow(B, H, n, S);
        double partialDerivative = (2.0 / 3.0) * (Q / S);
        return Math.abs(partialDerivative) * deltaS;
    }
}
