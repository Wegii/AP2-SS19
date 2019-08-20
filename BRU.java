public class Computations {

    public static double[] qs = new double[82];
    public static double[] rad = new double[82];
    public static double[] error = new double[82];
    public static int counter = 0;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        double[] U = {1, 2, 3, 4, 5, 6};
        double[] val = {4, 3, 3, 3, 3, 3};
        double[][] r = {{10, 30, 100, 200}, {10, 30, 200}, {10, 30, 200}, {10, 30, 200}, {10, 30, 200}, {10, 30, 200}};
        double[][] a =  {{8.24, 5.57, 1.7, 0.6}, {8.69, 6.7, 1}, {8.9, 7.3, 1.43}, {9.01, 7.31, 1.79}, {9.1, 7.51, 2.07}, {9.17, 7.66, 2.29}};

        //calcuateValues(U, val, r, a);
        calculateError(U, val, r, a);
    }

    @SuppressWarnings("Duplicates")
    private static void calcuateValues (double[] U, double[] val, double[][] r, double[][] a) {
        double r1, i1, p1;

        for (int i = 0; i < U.length; i++) {
            //System.out.println("\n\n\n");
            //System.out.println("Voltage: " + U[i]);

            for (int j = 0; j < val[i]; j++) {
                r1 = getR(r[i][j], a[i][j]);
                i1 = getI(U[i], r1);
                p1 = getP(U[i], i1);

                printText(r1, i1, p1);
            }
            System.out.println("\n\n");
        }
    }

    @SuppressWarnings("Duplicates")
    private static void calculateError (double[] U, double[] val, double[][] r, double[][] a) {
        double r1, i1, p1;
        double delta_u = 0.1, delta_a = 0.05, delta_r2, delta_r1;
        double delta_i, delta_p;

        for (int i = 0; i < U.length; i++) {
            for (int j = 0; j < val[i]; j++) {
                r1 = getR(r[i][j], a[i][j]);
                i1 = getI(U[i], r1);
                p1 = getP(U[i], i1);

                delta_r2 = r[i][j] / 100;
                delta_r1 = Math.abs(delta_r2 * (a[i][j] / (10 - a[i][j]))) + Math.abs(delta_a * 10 * r[i][j] / Math.pow(10 - a[i][j], 2));

                delta_i = Math.abs(delta_u / (r1 + r[i][j])) + Math.abs(delta_r1 * U[i] / Math.pow((r1 + r[i][j]), 2)) + Math.abs(delta_r1 * U[i] / Math.pow((r1 + r[i][j]), 2));
                delta_p = Math.abs(delta_i * 2 * i1 * r1) + Math.abs(delta_r1*Math.pow(i1, 2));

                //System.out.println(delta_i * 1000);
                System.out.println(delta_p * 1000);
            }
            System.out.println();
        }
    }

    private static double getP (double u, double i) {
        return u*i;
    }

    private static double getI(double u, double r) {
        return u / r;
    }

    private static double getR(double r, double a) {
        return r * (a / (10 - a));
    }

    private static void printText(double r, double i, double p) {
        System.out.println(r + " " + i + " " + p);
    }


}
