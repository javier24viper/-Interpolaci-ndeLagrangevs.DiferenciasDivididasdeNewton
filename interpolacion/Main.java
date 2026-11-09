package interpolacion;

public class Main {
    public static void main(String[] args) {
        // Nodos de prueba
        double[] x = {1.0, 2.0, 4.0, 5.0};
        double[] y = {2.0, 1.0, 5.0, 10.0};
        double xEval = 3.0;

        System.out.println("=== PRUEBA DE INTERPOLACIÓN ===");
        System.out.println("Punto a evaluar (xEval): " + xEval + "\n");

        // Evaluacion Lagrange
        double resLagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);
        System.out.printf("--- MÉTODO DE LAGRANGE ---\n");
        System.out.printf("Resultado P(%.1f) = %.6f\n\n", xEval, resLagrange);

        // Evaluacion Newton
        double[][] tablaNewton = DiferenciasDivididasNewton.calcularTablaDiferencias(x, y);
        System.out.println("--- MÉTODO DE DIFERENCIAS DIVIDIDAS DE NEWTON ---");
        DiferenciasDivididasNewton.imprimirTabla(x, tablaNewton);
        double resNewton = DiferenciasDivididasNewton.evaluarNewton(x, tablaNewton, xEval);
        System.out.printf("\nResultado P(%.1f) = %.6f\n\n", xEval, resNewton);

        // Comparacion
        System.out.printf("Diferencia entre métodos: %e\n", Math.abs(resLagrange - resNewton));
    }
}