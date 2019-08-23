public class VAK {

    /**
     * Calculate different properties
     * @param args CLI-args
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        double[] I = {
                5.7, 8, 10.9, 12.3, 14, 15.2, 16.8, 19.3, 20.9, 22.3, 23.4, 24.4, 25.2, 26, 26.7, 27.3, 28.4,
                29.4, 30.5, 31.2, 37.8, 42.6, 46.3, 50.1, 53.1, 55.2, 57.1, 59, 61.5, 67.6, 68.1, 81.7, 84.7,
                86.3, 87.1, 88.1, 88.4,88.7, 88.8, 89.1, 89.3, 89.6, 90, 90.3
            };
        double[] p = {
                0.005, 0.03, 0.078, 0.11, 0.15, 0.19, 0.24, 0.34, 0.4, 0.48, 0.54, 0.6, 0.65, 0.7, 0.74, 0.78,
                0.84, 0.9, 0.97, 1, 1.3, 1.9, 2.4, 3, 3.5, 3.9, 4.5, 5.1, 5.8, 9.2, 11.9, 30.6, 49.2, 76.2, 100.1,
                201.3, 301.5, 403.2, 501.3, 602.2, 702.8, 806.9, 906.9, 964.2
            };
        double[] I_31 = {86.1, 83.3, 72.6, 51, 30.6, 13.6, 10.8, 9.8, 9.3, 9, 8.8};
        double[] I_32 = {87.7, 88.2, 86.7, 85.1, 76.5, 69.5, 63.4, 48.2, 40, 34, 31.4, 27.5, 24.8, 22.6, 21, 20.3};
        double[] I_33 = {88, 87.9, 85.4, 80.2, 72.8, 63.2, 55.6, 45.4, 39.1, 31.5, 28.4, 25.8, 23.3, 20.7, 18.8, 17.4, 16.3, 14.8, 13.8};
        double res = 50;

        // Calculate all values
        calculatePower(I, res);

        // Calculate pressure for three configurations
        calculatePressure(I_31);
        calculatePressure(I_32);
        calculatePressure(I_33);

        // Calibration values
        calculatePressure(I);
        calculatePressureError(I, p);
    }

    /**
     * Calculate the power of the Pirani gauge. Note: Unit of Power in [mW]
     *
     * @param I Different currents per pressure
     * @param res Used resistor
     */
    private static void calculatePower(double[] I, double res) {
        for (double element : I)
            System.out.println((0.25 * res * Math.pow(element / 1000, 2)) * 1000);
    }

    /**
     * Calculate the pressure given a current. Note: Unit of current in [mA], of pressure [mbar]
     * Uses the function y = Amin + (Amax - Amin) / (1 + (x0/x)^h), whereas the formula below simply calculates x(y)
     * given the before mentioned equation.
     *
     * @param I Array of currents for which the pressure should be calculated
     */
    @SuppressWarnings("Duplicates")
    private static void calculatePressure(double[] I) {
        double Amin = 5.7, Amax = 90.3, x0 = 2.66842, h = 0.84205;

        for (double element : I)
            System.out.println(element + " " + x0 * Math.pow(((-Amax + Amin)/(Amin - element)) - 1, -1/h));

        System.out.println();
    }

    /**
     * Calculate error of pressure given by the function with respect to the pressure given by the reference manometer
     *
     * @param I Array of currents
     * @param p Array of reference pressure
     */
    @SuppressWarnings("Duplicates")
    private static void calculatePressureError(double[] I, double[] p) {
        double Amin = 5.7, Amax = 90.3, x0 = 2.66842, h = 0.84205;

        for (int i = 0; i < I.length; i++)
            System.out.println(I[i] + " " + Math.abs((x0 * Math.pow(((-Amax + Amin)/(Amin - I[i])) - 1, -1/h)) - p[i]));

        System.out.println();
    }

}
