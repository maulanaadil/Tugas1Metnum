package pertemuan7;

public class Main {

    public static void main(String[] args) {
        double a = 1.3;
        double b = 2;
        double galat = 0.0001;

        Metode metode = new Metode();

        System.out.println("Soal no 1.");
        metode.bagiDua(a, b, galat);
        System.out.println();

        System.out.println("Soal no 2.");
        metode.regulaFalsi(a, b, galat);
        System.out.println();

        System.out.println("Soal no 3.");
        metode.newRaphson(a, galat);
        System.out.println();

        System.out.println("Soal no 4.");
        metode.secant(a, b, galat);
        System.out.println();

    }

    public static class Metode {
        public static double bagiDua(double a, double b, double galat) {
            double c;
            double nilaiLebarSelangBaru;

            String lebarSelangBaru = "";
            boolean nilaiGalat = false;
            int i = 1;

            c = (a + b) / 2;
            double fa = fungsiX(a);
            double fc = fungsiX(c);
            double faxfc = fa * fc;


            if (faxfc < 0) {
                lebarSelangBaru = "[a,c]";
                nilaiLebarSelangBaru = Math.abs(c-b);
            } else {
                lebarSelangBaru = "[c,b]";
                nilaiLebarSelangBaru = Math.abs(c-b);

            }

            System.out.println("Nilai Fungsi(a) * Fungsi(c) : " + faxfc);
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s | |%12s |\n", "Iterasi", "a", "b", "c", "f(a)", "f(c)", "Selang Baru", "|a - b|", " |a - b| < galat");
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s | |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fc), lebarSelangBaru, String.format("%.8f", nilaiLebarSelangBaru), nilaiGalat);

            if (faxfc < 0) {
                b = c;
            } else {
                a = c;
            }

            try {
                do {
                    i++;
                    if (faxfc < 0 ) {
                        b = c;
                    } else {
                        a = c;
                    }
                    c = (a + b) / 2;
                    if (b==c) {
                        nilaiLebarSelangBaru = Math.abs(a - b);
                    } else {
                        nilaiLebarSelangBaru = Math.abs(c - b);
                    }
                    fa = fungsiX(a);
                    fc = fungsiX(c);
                    faxfc = fa * fc;


                    if(faxfc<0){
                        lebarSelangBaru = "[a,c]";
                    }else{
                        lebarSelangBaru = "[c,b]";
                    }

                    if (nilaiLebarSelangBaru < galat) {
                        nilaiGalat = true;
                    }

                    System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s | |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fc), lebarSelangBaru, String.format("%.8f", nilaiLebarSelangBaru), nilaiGalat);
                } while (nilaiLebarSelangBaru > galat);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
            System.out.println("Akar Hampiran : " + String.format("%.8f", c));
            System.out.println("f(x) : " + String.format("%.8f", fc));
            return c;
        }

        public double regulaFalsi(double a, double b, double galat) {
            double fa = fungsiX(a);
            double fb = fungsiX(b);
            int i = 1;
            String selangBaru;
            boolean nilaiGalat = false;
            boolean fcNol = false;
            boolean fcNilaiGalat = false;
            double bilangan1 = fb * (b - a);
            double bilangan2 = fb - fa;
            double bilangan3 = bilangan1 / bilangan2;
            double bilangan4 = b - bilangan3;
            double c = bilangan4;
            double lebarSelangBaru = Math.abs(a - b);
            double fc = fungsiX(c);
            double faxfc = fa * fc;


            if (faxfc < 0) {
                selangBaru = "[a,c]";
            } else {
                selangBaru = "[c,b]";
            }
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", "iterasi", "a", "b", "c", "f(a)", "f(b)", "f(c)", "selang baru", "|a - b|", " |f(c) < galat|", "f(c) = 0");
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fb), String.format("%.8f", fc), selangBaru, String.format("%.8f", lebarSelangBaru), nilaiGalat, fcNilaiGalat, fcNol);

            if (faxfc < 0) {
                b = c;
            } else {
                a = c;
            }

            try {
                do {
                    i++;
                    fa = fungsiX(a);
                    fb = fungsiX(b);

                    bilangan1 = fb * (b - a);
                    bilangan2 = fb - fa;
                    bilangan3 = bilangan1 / bilangan2;
                    bilangan4 = b - bilangan3;
                    c = bilangan4;
                    lebarSelangBaru = Math.abs(a - b);

                    fc = fungsiX(c);

                    faxfc = fa * fc;
                    if (faxfc < 0 && i != -1) {
                        selangBaru = "[a,c]";
                        b = c;
                    } else {
                        selangBaru = "[c,b]";
                        a = c;
                    }

                    if (lebarSelangBaru < galat) {
                        nilaiGalat = true;
                        break;
                    } else if (fc == 0) {
                        fcNilaiGalat = true;
                        break;
                    } else if (Math.abs(fc) < galat) {
                        fcNilaiGalat = true;
                        break;
                    }

                    System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fb), String.format("%.8f", fc), selangBaru, String.format("%.8f", lebarSelangBaru), nilaiGalat, fcNilaiGalat, fcNol);

                } while (lebarSelangBaru > galat || fc == 0 || Math.abs(fc) > galat);
                System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fb), String.format("%.8f", fc), selangBaru, String.format("%.8f", lebarSelangBaru), nilaiGalat, fcNilaiGalat, fcNol);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
            System.out.println("Akar hampiran   : " + String.format("%.8f", c));
            System.out.println("Dengan F(x)     : " + String.format("%.8f", fc));
            return c;
        }

        public double newRaphson(double x0, double galat) {
            double xSebelum = x0 + 1;
            double selisih = xSebelum - x0;
            int i = 0;

            System.out.format("%12s |%12s |%12s |%12s |\n", "iterasi", "xn", "f(xn)", "turunanF(xn)");
            System.out.format("%12s |%12s |%12s |%12s |\n", i,String.format("%.8f", x0) , String.format("%.8f", fungsiX(x0)), String.format("%.8f", tFungsiX(x0)));

            while (Math.abs(selisih) > galat) {
                i++;
                xSebelum = x0;
                x0 = xSebelum - (fungsiX(x0) / tFungsiX(x0));
                selisih = xSebelum - x0;

                System.out.format("%12s |%12s |%12s |%12s |\n", i,String.format("%.8f", x0) , String.format("%.8f", fungsiX(x0)), String.format("%.8f", tFungsiX(x0)));
            }

            System.out.println("Akar Persamaan : " + String.format("%.8f", x0));
            return x0;
        }

        public double secant(double x0, double x1, double galat) {
            int i = 0;
            int k = 1;
            double x2 = 0;
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
            return x2;
        }


        public double tFungsiX(double x) {
            return (3 * Math.pow(x, 2)) + (10 * x) - 10;
        }

        public static double fungsiX(double x) {
            return (Math.pow(x, 3)) + 5 * (Math.pow(x, 2)) - (10 * x) - 4;
        }
    }
}
