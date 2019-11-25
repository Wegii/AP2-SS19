public class BRZ {

    private static double[] half;

    /**
     * Calculate different properties
     * @param args CLI-args
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        // Tiefpass
        //
        double[] Ua = {2.3, 2.32, 2.3, 2.26, 1.74, 1.24, 0.544, 0.340, 0.238, 0.148, 0.0576};
        //
        double[] Ue = {2.32, 2.32, 2.3, 2.3, 1.94, 1.66, 1.38, 1.34, 1.31, 1.29, 1.3};
        // Frequencies given in kHz
        double[] f = {0.031001, 0.10433, 0.21195, 2.1398, 11.231, 20.534, 54.090, 87.799, 126.303, 203.747, 507.212};
        //
        double[] delta_t = {0, 0, 0, 14, 8, 7, 3.6, 2.3, 1.6, 1.12, 0.4};

        // Serienschwingkreis
        //
        double[] Uas = {0.244, 0.408, 0.656, 1.32, 1.44, 0.88, 0.64, 0.36, 0.216, 0.128, 0.320};
        //
        double[] Ues = {2.32, 2.26, 2.24, 2.1, 2.06, 2.2, 2.24, 2.24, 2.28, 2.28, 2.28};
        // Frequencies given in kHz
        double[] fs = {70.456, 83.102, 91.831, 102.04, 106.38, 116.52, 123.3, 139.832, 165.653, 211.267, 77.565};
        //
        double[] delta_ts = {-3.4, -2.6, -2, -0.8, -0.2, 1.48, 1.7, 1.7, 1.4, 1.1, 3.3};

        // durchlass(Ua, Ue);
        // simplePrint(f);
        // verschiebung(f, delta_t);

        durchlass(Uas, Ues);
        simplePrint(fs);
        verschiebung(fs, delta_ts);

        // Theoriekurve
        computeError(300, 3, 560*Math.pow(10,-12), 112*Math.pow(10,-12), 0.0047, 0.0001175, 98.100, 10.15);
        // Durchlasskurve
        computeError(424.06, 3.18, 4.664*Math.pow(10,-7),0.0544*Math.pow(10,-7), 4.854, 0.0559, 105.75, 13.9);

        // Phasenverschiebungskurve
        computeError(1.456, 6.354, 1.0821*Math.pow(10,-4),4.728*Math.pow(10,-4), 0.02067, 0.0899, 106.42, 11.21);
    }

    private static void computeError(double r, double delta_r, double c, double delta_c, double l, double delta_l, double fres, double bf) {
        double delta_fg, delta_bf, delta_q;

        delta_fg = Math.sqrt(Math.pow(delta_r, 2)*Math.pow(1/(2*Math.PI*c*Math.pow(r, 2)),2)
                     //+ Math.pow(delta_c, 2)*Math.pow(1/(2*Math.PI * r * Math.pow(c, 2)),2)
                    );


        // delta_bf
        delta_bf = Math.sqrt(Math.pow(delta_r, 2)*Math.pow(1/(2*Math.PI*l),2) + Math.pow(delta_l, 2)*Math.pow(r/(2*Math.PI*Math.pow(l, 2)),2));

        // delta_q
        delta_q = Math.sqrt(Math.pow(delta_fg, 2)*Math.pow(1/(bf), 2) + Math.pow(delta_bf, 2) * Math.pow(fres/Math.pow(bf,2), 2));

        System.out.println(delta_fg);
        System.out.println(delta_bf);
        System.out.println(delta_q);

        System.out.println();
    }

    /**
     *
     *
     * @param Ua
     * @param Ue
     */
    private static void durchlass(double[] Ua, double[] Ue) {
        for (int i = 0; i < Ue.length; i++) {
            System.out.println(Ua[i] / Ue[i]);
        }
        System.out.println();
    }

    /**
     *
     *
     * @param freq
     * @param delta_t
     */
    private static void verschiebung(double[] freq, double[] delta_t) {
        for (int i = 0; i < freq.length; i++) {
            System.out.println(2 * Math.PI * 1000 * freq[i] * delta_t[i] * Math.pow(10, -6));
        }
        System.out.println();
    }

    /**
     *
     *
     * @param val
     */
    private static void simplePrint(double[] val) {
        for (double element: val) {
            System.out.println(element);
        }
        System.out.println();
    }

}
