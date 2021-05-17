package pertemuan7;

public class MetodeNewRaphson {

    public static void main(String[] args) {
        int i = 0;
        double x0 = 1.3;
        double galat = 0.0001;
        double xSebelum = x0 + 1;
        double selisih = xSebelum - x0;

        System.out.println("iterasi | xn  | f(xn) | turunanf(xn)");
        System.out.println(i + " | " + String.format("%.8f", x0) + " | " + String.format("%.8f", fungsiX(x0)) + " | " + String.format("%.8f", tFungsiX(x0)));


        while (Math.abs(selisih) > galat) {
            i++;
            xSebelum = x0;
            x0 = xSebelum - (fungsiX(x0) / tFungsiX(x0));
            selisih = xSebelum - x0;

            System.out.println(i + " | " + String.format("%.8f", x0) + " | " + String.format("%.8f", fungsiX(x0)) + " | " + String.format("%.8f", tFungsiX(x0)));
        }

        System.out.println("Akar Persamaan : " + String.format("%.8f", x0));
    }

    public static double tFungsiX(double x) {
        return (3 * Math.pow(x, 2)) + (10 * x) - 10;
    }

    public static double fungsiX(double x) {
        return (Math.pow(x, 3)) + 5 * (Math.pow(x, 2)) - (10 * x) - 4;
    }
}
