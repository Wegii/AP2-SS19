public class BRZ {

    private static double[] half;

    /**
     * Calculate different properties
     * @param args CLI-args
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        double[][] U_p = {
                {868, 876, 874}, {844, 847, 844}, {807, 805, 801}, {766, 760, 756}, {698, 691, 686}, {658, 652, 647},
                {603, 597, 593}, {483, 479, 478}, {367, 363, 363}, {315, 313, 314}
        };

        double[][] I_p = {
                {8, 9, 9}, {18, 18, 18}, {40, 40, 39}, {75, 74, 74}, {145, 143, 142}, {188, 186, 185},
                {253, 251, 249}, {400, 396, 397}, {547, 542, 545}, {612, 608, 612}

        };

        double[][] U_s = {
                {1.526, 1.552, 1.552}, {1.413, 1.429, 1.433}, {1.241, 1.262, 1.271}, {1.074, 1.093, 1.1}, {0.807, 0.835, 0.806},
                {0.683, 0.692, 0.688}, {0.55, 0.552, 0.553}, {0.383, 0.381, 0.381}, {0.255, 0.255, 0.255}, {0.207, 0.207, 0.208}
        };
        double[][] I_s = {
                {15, 15, 15}, {30, 30, 30}, {62, 62, 63}, {105, 107, 108}, {169, 174, 168}, {196, 199, 198}, {232, 234, 234},
                {321, 319, 319}, {389, 389, 391}, {414, 416, 417}
        };

        //double[] I_p_median = {8.66, 18, 39.66, 74.33, 143.33, 186.33, 251, 397.66, 544.66, 610.66};
        double[] I_p_median = {4.33, 18, 19.83, 37.165, 71.665, 93.165, 125.5, 198.8, 272.33, 305.33};
        double[] U_p_median = {872.66, 845.0, 804.33, 760.66, 691.66, 652.33, 597.66, 480.0, 364.33, 314.0};

        double[] I_s_median = {15, 30, 62.33, 106.66, 170.33, 197.66, 233.33, 319.6, 389.66, 415.66};
        //double[] U_s_median = {1543.3, 1425, 1258, 1089, 816, 687.6, 551.6, 381.6, 255, 207.33};
        double[] U_s_median = {771.6666666666669, 712.5, 629.0, 544.5, 408.0, 343.83333333333326, 275.83333333333337, 190.83333333333331, 127.5, 103.66666666666667};

        // Parallel
        //calculateMedian(U_p, false);
        //calculateMedian(I_p, false);
        //halfValues(half, true);

        // Series
        //calculateMedian(U_s, false);
        //halfValues(half, true);
        //calculateMedian(I_s, false);
        System.out.println("parallel");
        durchtritt(U_p_median, I_p_median, false);
        System.out.println("reihe");
        durchtritt(U_s_median, I_s_median, true);
    }

    /**
     *
     *
     * @param val
     */
    private static void calculateMedian(double[][] val, boolean print) {
        double median = 0;
        half = new double[val.length];

        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val[i].length; j++)
                median += val[i][j];

            if (print)
                System.out.println(median / val[0].length);

            half[i] = median / val[0].length;
            median = 0;
        }
    }

    /**
     *
     *
     * @param val
     */
    private static void halfValues (double[] val, boolean print) {
        for (double element : val) {
            if (print)
                System.out.println((element / 2));
        }
    }

    /**
     *
     *
     * @param u
     * @param i
     * @param series
     */
    private static void durchtritt (double[] u, double[] i, boolean series) {
        double eta_durch, r, u0 = 1230;

        // For series
        if (series) {
             r = 1.61;
        } else {
            // For parallel
            r = 1.61;
        }

        for (int j = 0; j < u.length; j++) {
            eta_durch = u0 - (r * i[j]) - u[j];
            System.out.println(eta_durch);
        }

        System.out.println();
    }


}
