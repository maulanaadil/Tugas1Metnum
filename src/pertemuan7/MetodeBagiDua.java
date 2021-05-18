
package pertemuan7;

public class MetodeBagiDua {

    public static void main(String[] args) {
        metodeBagiDua(1.3, 2, 0.0001);
    }


    /*
    fungsi untuk menentukan akar persamaan dari method fungsiX
    menggunakan metode bagi dua
     */
    public static String metodeBagiDua(double a, double b, double galat) {
        double c = (a + b) / 2;
        double nilaiLebarSelangBaru = Math.abs(a - b);

        String lebarSelangBaru;
        boolean nilaiGalat = false;
        int i = 1;

        double fa = fungsiX(a);
        double fc = fungsiX(c);
        double faxfc = fa * fc;
        System.out.println("Nilai Fungsi(a) * Fungsi(c) : " + faxfc);
        System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s | |%12s |\n", "Iterasi", "a", "b", "c", "f(a)", "f(c)", "Selang Baru", "|a - b|", " |a - b| < galat");

        if (faxfc < 0) {
            lebarSelangBaru = "[a,c]";
            b = c;
        } else {
            lebarSelangBaru = "[c,b]";
            a = c;
        }
        System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s | |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fc), lebarSelangBaru, String.format("%.8f", nilaiLebarSelangBaru), nilaiGalat);
        try {
            do {
                i++;
                fa = fungsiX(a);
                fc = fungsiX(c);
                faxfc = fa * fc;

                if (faxfc < 0) {
                    lebarSelangBaru = "[a,c]";
                    b = c;
                } else {
                    lebarSelangBaru = "[c,b]";
                    a = c;
                }
                c = (a + b) / 2;
                nilaiLebarSelangBaru = Math.abs(a - b);

                if (nilaiLebarSelangBaru < galat) {
                    nilaiGalat = true;
                    lebarSelangBaru = "";
                }

                System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s | |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fc), lebarSelangBaru, String.format("%.8f", nilaiLebarSelangBaru), nilaiGalat);
            } while (nilaiLebarSelangBaru > galat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Akar Hampiran : " + String.format("%.8f", c));
        System.out.println("f(x) : " + String.format("%.8f", fc));
        return lebarSelangBaru;
    }

    /*
    fungsiX merupakan persamaan dari
    x^3 + 5x^2 - 10x - 4 = 0
     */
    public static double fungsiX(double x) {
        return (Math.pow(x, 3)) + 5 * (Math.pow(x, 2)) - (10 * x) - 4;
    }
}   
