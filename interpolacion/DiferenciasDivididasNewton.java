package interpolacion;

public class DiferenciasDivididasNewton {

    public static double[][] calcularTablaDiferencias(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];

        // Copiar y en la primera columna
        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }

        // Calcular diferencias divididas
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return tabla;
    }

    public static double evaluarNewton(double[] x, double[][] tabla, double xEval) {
        int n = x.length;
        double resultado = tabla[0][0];
        double producto = 1.0;

        for (int i = 1; i < n; i++) {
            producto *= (xEval - x[i - 1]);
            resultado += tabla[0][i] * producto;
        }
        return resultado;
    }

    public static void imprimirTabla(double[] x, double[][] tabla) {
        int n = x.length;
        System.out.println("Tabla / Matriz de Diferencias Divididas:");
        for (int i = 0; i < n; i++) {
            System.out.printf("i=%d | x=%5.1f | ", i, x[i]);
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%8.4f | ", tabla[i][j]);
            }
            System.out.println();
        }
    }
}