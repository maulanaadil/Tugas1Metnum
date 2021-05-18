package pertemuan7;

public class MetodeSecant {
    public static void main(String[] args) {
        int i = 0;
        int k = 1;
        double galat = 0.0001;
        double x0 = 1.3;
        double x1 = 2;
        double x2;
        double selisih;
        double fx = fungsiX(x0);
        double fx1 = fungsiX(x1);

        System.out.format("%20s |%20s |%20s |\n", "iterasi", "Xn", "F(Xn)");
        System.out.format("%20s |%20s |%20s |\n", i, String.format("%.8f", x0), String.format("%.8f", fx));
        System.out.format("%20s |%20s |%20s |\n", k, String.format("%.8f", x1), String.format("%.8f", fx1));

        try {
            do {
                k++;
                x2 = x1 - ((fungsiX(x1) * (x1 - x0)) / (fungsiX(x1) - fungsiX(x0)));
                double fx2 = fungsiX(x2);
                selisih = Math.abs(x2 - x1);
                System.out.format("%20s |%20s |%20s |\n", k, x2, String.format("%.8f", fx2));
                x0 = x1;
                x1 = x2;
            } while (selisih > galat);
            System.out.println("Akar Hampiran : " + String.format("%.8f", x2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static double fungsiX(double x) {
        return (Math.pow(x, 3)) + 5 * (Math.pow(x, 2)) - (10 * x) - 4;
    }
}
