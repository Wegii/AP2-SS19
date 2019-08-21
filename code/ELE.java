import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ELE {

    public static double[] qs = new double[82];
    public static double[] rad = new double[82];
    public static int counter = 0;

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        double[] t_steig_own = {-27.3, -11.7, -11.6, -21.9, -17.8, -15, -21.8, -14, -11.1, -59.7, -23.7, -16.4, -16.2, -32.4, -25.3, -13.9, -13.7, -25.9, -8.1, -18.7};
        double[] t_sink_own = {8.7, 9.3, 9.7, 13.6, 9.9, 11.6, 8.4, 11, 8.2, 13.6, 10.9, 9.4, 10, 9.9, 7.3, 11.3, 10.2, 11.9, 5.3, 7.9};
        double[] U_own = {204, 221, 221, 188, 83, 176, 54, 97, 128, 208, 320, 331, 298, 367, 186, 220, 217, 59, 373, 477};
        checkSize(t_steig_own, false);
        checkSize(t_sink_own, false);
        checkSize(U_own, false);

        double distance_own =  0.0018;
        double eta_luft_own =  0.0000171;
        double p_luft_own = 1.125712615d;   // dichte = Luftdruck/(Gaskonstante für trockene Luft * Temperatur in Kelvin)
        double p_ol_own = 871d;             // Already given
        double p_delta = p_ol_own - p_luft_own;

        //computeCunningham(t_steig_own, t_sink_own, U_own, distance_own, null, eta_luft_own, p_delta, false);
        //computeUncorrected(t_steig_own, t_sink_own, U_own, distance_own, null, eta_luft_own, p_delta, false);
        computeCorrection(t_steig_own, t_sink_own, U_own, distance_own, null, eta_luft_own, p_delta, false);
        counter = 20;
        System.out.println("\n\n");


        double[] t_steig_t1 = {-31.05, -30.05, -16.1, -19, -25.9, -22.5, -24.6, -19.9, -23.1, -9.8, -21, -13, -30.4, -33.9, -11, -15.4, -22.3, -25.3, -24.4, -28};
        double[] t_sink_t1 = {18.3, 9.39, 9.48, 12, 11.34, 6.1, 10.4, 9.81, 11.2, 4.6, 9.6, 6, 10.6, 11.5, 6.2, 7.89, 10.8, 10.4, 10.7, 11.7};
        double[] U_t1 = {199, 210, 256, 290, 324, 348, 381, 400, 350, 322, 365, 365, 391, 358, 384, 315, 366, 421, 374, 312};
        checkSize(t_steig_t1, false);
        checkSize(t_sink_t1, false);
        checkSize(U_t1, false);

        double distance_t1 = 0.0022d;
        double eta_luft_t1 = 0.0000171;
        double p_luft_t1 = 1.123697784;
        double p_ol_t1 = 871d;              // Already given
        p_delta = p_ol_t1 - p_luft_t1;

        //computeCunningham(t_steig_t1, t_sink_t1, U_t1, distance_t1, null, eta_luft_t1, p_delta, false);
        //computeUncorrected(t_steig_t1, t_sink_t1, U_t1, distance_t1, null, eta_luft_t1, p_delta, false);
        computeCorrection(t_steig_t1, t_sink_t1, U_t1, distance_t1, null, eta_luft_t1, p_delta, false);
        counter = 40;
        System.out.println("\n\n");



        double[] t_steig_t2 = {-17.5, -13.6, -18.43, -28.8, -10.5, -4.4, -6.8, -8.3, -6.8, -7.4, -9.9, -3.9, -14, -6.9, -11.9, -8.4, -6.1, -9.9, -11.3, -9.4};
        double[] t_sink_t2 = {8.6, 6.7, 3.9, 5.4, 7.1, 3.6, 3.8, 4.9, 4.9, 5.5, 4.3, 6.1, 5.65, 4.8, 4.8, 4.9, 3.7, 4.2, 6.9, 5.2};
        double[] U_t2 = {167, 167, 499, 499, 497, 498, 497, 497, 435, 435, 433, 432, 432, 431, 431, 432, 263, 263, 263, 263};
        checkSize(t_steig_t2, false);
        checkSize(t_sink_t2, false);
        checkSize(U_t2, false);

        double distance_t2 = 0.0019d;
        double eta_luft_t2 = 0.0000171;
        double p_luft_t2 = 1.125215013;
        double p_ol_t2 = 871d;              // Already given
        p_delta = p_ol_t2 - p_luft_t2;

        //computeCunningham(t_steig_t2, t_sink_t2, U_t2, distance_t2, null, eta_luft_t2, p_delta, false);
        //computeUncorrected(t_steig_t2, t_sink_t2, U_t2, distance_t2, null, eta_luft_t2, p_delta, false);
        counter = 60;
        System.out.println("\n\n");



        double[] t_steig_t3 = {-41.79, -56, -79.80, -49.80, -25.82, -47.40, -41.50, -35.80, -32.20, -31, -23.54, -21.51, -21.49, -18.53, -31.20, -22.20, -21.50, -19.9, -59.9, -20.52, -12.50, -31.02};
        double[] t_sink_t3 = {18.27, 24.70, 24.20, 22.80, 16.92, 22.40, 22.80, 21.10, 21.60, 20.40, 12.32, 11.59, 11.40, 11.29, 14.90, 13.60, 13.50, 13, 11.60, 8.10, 9.40, 6.09};
        double[] U_t3 = {269, 271, 292, 300, 269, 298, 295, 298, 292, 299, 100, 175, 180, 123, 399, 307, 308, 298, 305, 106, 313, 400};
        double[] distance_t3 = {0.0015d, 0.0021d, 0.0021d, 0.002d, 0.0015d, 0.002d, 0.0021d, 0.002d, 0.0021d, 0.002d, 0.0015d, 0.0015d, 0.0015d, 0.0015d, 0.002d, 0.002d, 0.002d, 0.002d, 0.0021d, 0.0015d, 0.0021d, 0.0015d};
        checkSize(t_steig_t3, true);
        checkSize(t_sink_t3, true);
        checkSize(U_t3, true);
        checkSize(distance_t3, true);

        double eta_luft_t3 = 0.0000171;
        double p_luft_t3 = 1.125712615d;    // Taken from own
        double p_ol_t3 = 871d;              // Already given
        p_delta = p_ol_t3 - p_luft_t3;

        //computeCunningham(t_steig_t3, t_sink_t3, U_t3, 0, distance_t3, eta_luft_t3, p_delta, true);
        //computeUncorrected(t_steig_t3, t_sink_t3, U_t3, 0, distance_t3, eta_luft_t3, p_delta, true);
        computeCorrection(t_steig_t3, t_sink_t3, U_t3, 0, distance_t3, eta_luft_t3, p_delta, true);
        System.out.println("\n\n");


        // Perform analysis on data
        //analysis();
    }

    @SuppressWarnings("Duplicates")
    public static void computeCunningham (double[] t_steig, double[] t_sink, double[] U, double distance, double[] distances, double eta_luft, double p_delta, boolean customPosition) {
        /* Compute velocities */
        double[] v_steig = new double[80];
        double[] v_sink = new double[80];

        if (!customPosition) {
            for (int i = 0; i < t_steig.length; i++) {
                v_steig[i] = 0.5 * distance / t_steig[i];
                v_sink[i] = 0.5 * distance / t_sink[i];
            }
        } else {
            for (int i = 0; i < t_steig.length; i++) {
                v_steig[i] = 0.5 * distances[i] / t_steig[i];
                v_sink[i] = 0.5 * distances[i] / t_sink[i];
            }
        }

        /* Compute r0 */
        double[] r0 = new double[80];
        double g = 9.81d; // Already given

        for (int i = 0; i < t_steig.length; i++) {
            r0[i] = (3d/2d) * (Math.sqrt((eta_luft*(v_steig[i] + v_sink[i])) / (p_delta * g)));
        }

        /* Compute eta_korr */
        double[] eta_korr = new double[80];
        double A = 1.257d; // Already given
        double lambda = 7.2*Math.pow(10, -8); // Already given

        for (int i = 0; i < t_steig.length; i++) {
            eta_korr[i] = eta_luft / (1 + A*(lambda / r0[i]));
        }

        /* Compute r_korr */
        double[] r_korr = new double[80];

        for (int i = 0; i < t_steig.length; i++) {
            // r_korr[i] = Math.sqrt(Math.pow(r0[i], 2) + (0.25d)*(Math.pow(A, 2)*Math.pow(lambda, 2))) - (0.5d)*A*lambda;
            r_korr[i] = (3d/2d) * Math.sqrt((eta_korr[i]*(v_steig[i] + v_sink[i])) / (p_delta * g));
            rad[i + counter] = r_korr[i] / (Math.pow(10, -7));
        }

        /* Compute q */
        double pi = 3.1415d;
        double[] q = new double[80];
        double d = 0.006d;

        for (int i = 0; i < t_steig.length; i++) {
            //q[i] = (1/U[i]) * 3*pi*d * eta_korr[i] * r_korr[i] * (v_steig[i] - v_sink[i]);
            q[i] = (3*pi*d/U[i]) * eta_korr[i] * r_korr[i] * (v_steig[i] - v_sink[i]);
            qs[i + counter] = (-1) * (q[i] / (1.602176*Math.pow(10, -19)));
            //qs[i + counter] = (-1) * (q[i] / Math.pow(10, -19));
        }

    }

    @SuppressWarnings("Duplicates")
    private static void computeUncorrected (double[] t_steig, double[] t_sink, double[] U, double distance, double[] distances, double eta_luft, double p_delta, boolean customPosition) {
        /* Compute velocities */
        double[] v_steig = new double[80];
        double[] v_sink = new double[80];

        if (!customPosition) {
            for (int i = 0; i < t_steig.length; i++) {
                v_steig[i] = 0.5 * distance / t_steig[i];
                v_sink[i] = 0.5 * distance / t_sink[i];
            }
        } else {
            for (int i = 0; i < t_steig.length; i++) {
                v_steig[i] = distances[i] / t_steig[i];
                v_sink[i] = distances[i] / t_sink[i];
            }
        }

        /* Compute r0 */
        double[] r0 = new double[80];
        double g = 9.81d; // Already given

        for (int i = 0; i < t_steig.length; i++) {
            r0[i] = (3d/2d) * Math.sqrt((eta_luft*(v_steig[i] + v_sink[i])) / (p_delta * g));
            rad[i + counter] = r0[i] / (Math.pow(10, -7));
        }

        /* Compute q */
        double pi = 3.1415d;
        double[] q = new double[80];
        double d = 0.006d;

        for (int i = 0; i < t_steig.length; i++) {
            q[i] = (3*pi*d/U[i]) * eta_luft * r0[i] * (v_steig[i] - v_sink[i]);
            //qs[i + counter] = (-1)*(q[i] / (1.602176*Math.pow(10, -19)));
            qs[i + counter] = (-1) * (q[i] / Math.pow(10, -19));
        }
    }

    @SuppressWarnings("Duplicates")
    private static void computeCorrection(double[] t_steig, double[] t_sink, double[] U, double distance, double[] distances, double eta_luft, double p_delta, boolean customPosition) {
        /* Compute velocities */
        double[] v_steig = new double[80];
        double[] v_sink = new double[80];

        if (!customPosition) {
            for (int i = 0; i < t_steig.length; i++) {
                v_steig[i] = -0.5 * distance / t_steig[i];
                v_sink[i] = 0.5 * distance / t_sink[i];
            }
        } else {
            for (int i = 0; i < t_steig.length; i++) {
                v_steig[i] = (-1)*distances[i] / t_steig[i];
                v_sink[i] = distances[i] / t_sink[i];
            }
        }


        double d = 0.006d;
        int n = t_steig.length;
        double s1 = 0.0018, s2 = s1;

        // Compute delta_d
        //double delta_d = (0.1 / Math.sqrt(n)) * Math.sqrt((1d / (n*(n-1))) * (n * Math.pow(d, 2) - Math.pow(d, 2)));
        double delta_d = 5 * Math.pow(10, -5);

        // Compute delta_U
        double delta_U = (0.1 / Math.sqrt(n)) * Math.sqrt((1d / (n*(n-1))) * sum(U));
        delta_U = 1;

        // Compute delta_s1
        double delta_s1;
        if (customPosition)
            delta_s1 = (0.1 / Math.sqrt(n)) * Math.sqrt((1d / (n*(n-1))) * sum(distances));
        else
            delta_s1 = (0.1 / Math.sqrt(n)) * Math.sqrt((1d / (n*(n-1))) * (n * Math.pow(d, 2) - Math.pow(distance, 2)));
        delta_s1 = 5 * Math.pow(10, -5);

        // Compute delta_s2
        double delta_s2 = delta_s1;

        // Compute delta_t1
        double delta_t1 = (0.1 / Math.sqrt(n)) * Math.sqrt((1d / (n*(n-1))) * sum(t_steig));
        delta_t1 = 0.5;

        // Compute delta_t2
        double delta_t2 = (0.1 / Math.sqrt(n)) * Math.sqrt((1d / (n*(n-1))) * sum(t_sink));
        delta_t2 = 0.5;

        double pi = 3.1415d;
        double g = 9.81d;
        double dg;

        for (int i = 0; i < n; i++) {

            dg = Math.abs(delta_d * ((9 * pi) / 2) * (1/U[i]) * Math.sqrt((Math.pow(eta_luft, 3) * (v_steig[i] + v_sink[i])) / (p_delta*g))*(v_steig[i] - v_sink[i]));
            dg += Math.abs(delta_U * ((9 * pi) / 2) * (1/Math.pow(U[i], 2)) * Math.sqrt((Math.pow(eta_luft, 3) * (v_steig[i] + v_sink[i])) / (p_delta*g))*(v_steig[i] - v_sink[i]));

            dg += Math.abs(delta_s1 * (0.5d*9*pi)*(d/U[i])*Math.sqrt((Math.pow(eta_luft, 3)/(p_delta*g))) * ((s2*t_steig[i] + 3*t_sink[i]*s1) / (2*t_sink[i]*Math.pow(t_steig[i], 2) * Math.sqrt((s2/t_sink[i]) + (s1 / t_steig[i])))));
            dg += Math.abs(delta_s2 * (0.5d*9*pi)*(d/U[i])*Math.sqrt((Math.pow(eta_luft, 3)/(p_delta*g))) * ((-s1*t_sink[i] - 3*t_steig[i]*s2) / (2*t_steig[i]*Math.pow(t_sink[i], 2) * Math.sqrt((s1/t_steig[i]) + (s2 / t_sink[i])))));

            dg += Math.abs(delta_t1 * (0.5d*9*pi)*(d/U[i])*Math.sqrt((Math.pow(eta_luft, 3)/(p_delta*g))) * ((s1*(s2*t_steig[i] + 3*t_sink[i]*s1)) / (2*t_sink[i]*Math.pow(t_steig[i], 3) * Math.sqrt((s2/t_sink[i]) + (s1 / t_steig[i])))));
            dg += Math.abs(delta_t2 * (0.5d*9*pi)*(d/U[i])*Math.sqrt(Math.pow(eta_luft, 3)/(p_delta*g)) * ((s2 * (s1*t_sink[i] + 3*t_steig[i]*s2)) / (2*t_steig[i]*Math.pow(t_sink[i], 3) * Math.sqrt((s1/t_steig[i]) + (s2 / t_sink[i])))));
            System.out.println(dg / Math.pow(10, -19));
        }

    }

    private static double sum(double[] values) {
        double val = 0, interim = 0;

        for (int i = 0; i < values.length; i++)
            val += Math.pow(values[i], 2);

        for (int i = 0; i < values.length; i++)
            interim += values[i];

        return (values.length * val) - Math.pow(interim, 2);
    }

    private static void analysis () {
        // Print charge and radius
        //printGeneral();

        // Print number of occurrences
        //printOccurrences();
    }

    private static void printGeneral() {
        for (int i = 0; i < 82; i++) System.out.println(qs[i]);

        System.out.println("\n");

        for (int i = 0; i < 82; i++) System.out.println(rad[i]);
    }

    private static void printOccurrences() {
        Arrays.sort(qs);

        int[] hfg = new int[300];
        for (int i = 0; i < 80; i++){
            hfg[(int)(10*qs[i])] = hfg[(int)(10*qs[i])] + 1;
            System.out.println(qs[i] + " becomes " + (int)(10*qs[i]));
        }
        for (int i = 0; i < 300; i++) System.out.println(hfg[i]);
    }

    private static void checkSize(double[] arr, boolean more) {
        if (more)
            assertEquals(22, arr.length);
        else
            assertEquals(20, arr.length);
    }

}
