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
            // Menginisialisasikan variabel yang akan dipakai
            double c, nilaiLebarSelangBaru, fa, fc, faxfc;
            String lebarSelangBaru = "";
            boolean nilaiGalat = false;
            int i = 1;

            // menghitung nilai c
            c = (a + b) / 2;

            // menghitung fa dengan memasukan persamaan method fungsiX dengan parameter nilai a
            fa = fungsiX(a);

            // menghitung fc dengan memasukan persamaan method fungsiX dengan parameter nilai c
            fc = fungsiX(c);

            // menghitung fa * fc serta menginisialisasikan nilai tersebut menjadi variabel faxfc
            faxfc = fa * fc;

            // mengkondisikan apabila nilai faXfc kurang dari 0
            if (faxfc < 0) {
                lebarSelangBaru = "[a,c]";
                nilaiLebarSelangBaru = Math.abs(c - b);
            } else {
                lebarSelangBaru = "[c,b]";
                nilaiLebarSelangBaru = Math.abs(c - b);

            }

            // mencetak nilai variabel yang sudah terisi nilai kedalam program
            System.out.println("Nilai Fungsi(a) * Fungsi(c) : " + faxfc);
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%18s |\n", "Iterasi", "a", "b", "c", "f(a)", "f(c)", "Selang Baru", "|a - b|", " |a - b| < galat");
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%18s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fc), lebarSelangBaru, String.format("%.8f", nilaiLebarSelangBaru), nilaiGalat);

            /*
            mengkondisikan apabila nilai faXfc kurang dari 0 maka nilai b diganti dengan nilai c
            apabila tidak maka nilai a diganti dengan nilai c
             */
            if (faxfc < 0) {
                b = c;
            } else {
                a = c;
            }

            try {
                // Proses menglooping iterasi
                do {
                    i++;
                    /*
                    mengkondisikan apabila nilai faXfc kurang dari 0 maka nilai b diganti dengan nilai c
                    apabila tidak maka nilai a diganti dengan nilai c
                    */
                    if (faxfc < 0) {
                        b = c;
                    } else {
                        a = c;
                    }

                    // menghitung nilai c dengan rumus yang sudah tertera dimodul
                    c = (a + b) / 2;

                    /*
                    mengkondisikan apabila nilai b sama dengan nilai c maka nilai lebar selang baru = a - b
                    dan apabila tidak maka nilai lebar selang baru = c - b
                    *Math Abs merupakan method dari java agar mengembalikan nilai absolut.
                     */
                    if (b == c) {
                        nilaiLebarSelangBaru = Math.abs(a - b);
                    } else {
                        nilaiLebarSelangBaru = Math.abs(c - b);
                    }

                    // menghitung fa dengan memasukan persamaan method fungsiX dengan parameter nilai a
                    fa = fungsiX(a);

                    // menghitung fc dengan memasukan persamaan method fungsiX dengan parameter nilai c
                    fc = fungsiX(c);

                    // menghitung fa * fc serta menginisialisasikan nilai tersebut menjadi variabel faxfc
                    faxfc = fa * fc;

                    /*
                    mengkondisikan apabila nilai faXfc kurang dari 0 maka nilai b diganti dengan nilai c
                    apabila tidak maka nilai a diganti dengan nilai c
                     */
                    if (faxfc < 0) {
                        lebarSelangBaru = "[a,c]";
                    } else {
                        lebarSelangBaru = "[c,b]";
                    }

                    /*
                    Mengkondisikan apabila nilaiLebarSelangBaru kurang dari nilai galat maka
                    variabel nilaiGalat akan menjadi true
                    apabila tidak variabel nilaiGalat akan menjadi false
                     */
                    if (nilaiLebarSelangBaru < galat) {
                        nilaiGalat = true;
                    } else {
                        nilaiGalat = false;
                    }

                    // mencetak nilai variabel yang sudah terisi nilai kedalam program
                    System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%18s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fc), lebarSelangBaru, String.format("%.8f", nilaiLebarSelangBaru), nilaiGalat);

                    // Mengkonidiskan apabila nilaiLebarSelangBaru lebih dari galat maka looping dihentikan
                } while (nilaiLebarSelangBaru > galat);
            } catch (Exception e) {
                // Menangkap Exception Error dari program java
                System.out.println(e.getMessage());
            }

            // Mencetak nilai variabel yang sudah terisi nilai kedalam program
            System.out.println();
            System.out.println("Akar Hampiran : " + String.format("%.8f", c));
            System.out.println("f(x) : " + String.format("%.8f", fc));
            return c;
        }

        public static double regulaFalsi(double a, double b, double galat) {
            // Menginisialisasikan variabel yang akan dipakai
            double fa, fb, bilangan1,bilangan2,bilangan3,bilangan4, c, nilaiLebarSelangBaru, fc,faxfc;
            int i = 1;
            boolean nilaiGalat = false;
            boolean fcNol = false;
            boolean fcNilaiGalat = false;
            String selangBaru = "";

            // menghitung fa dengan memasukan persamaan method fungsiX dengan parameter nilai a
            fa = fungsiX(a);

            // menghitung fb dengan memasukan persamaan method fungsiX dengan parameter nilai b
            fb = fungsiX(b);

            // Menghitung nilai C dengan cara memisahkan operasi operasi didalam rumus menghitung nilai c
            bilangan1 = fb * (b - a);
            bilangan2 = fb - fa;
            bilangan3 = bilangan1 / bilangan2;
            bilangan4 = b - bilangan3;
            c = bilangan4;

            // Menghitung nilaiLebarSelangBaru
            nilaiLebarSelangBaru = Math.abs(a - b);

            // menghitung fb dengan memasukan persamaan method fungsiX dengan parameter nilai b
            fc = fungsiX(c);

            // menghitung fa * fc serta menginisialisasikan nilai tersebut menjadi variabel faxfc
            faxfc = fa * fc;


            /*
              mengkondisikan apabila nilai faXfc kurang dari 0 maka nilai b diganti dengan nilai c
              apabila tidak maka nilai a diganti dengan nilai c
            */
            if (faxfc < 0) {
                selangBaru = "[a,c]";
            } else {
                selangBaru = "[c,b]";
            }

            // mencetak nilai variabel yang sudah terisi nilai kedalam program
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", "iterasi", "a", "b", "c", "f(a)", "f(b)", "f(c)", "selang baru", "|a - b|", " |f(c) < galat|", "f(c) = 0");
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fb), String.format("%.8f", fc), selangBaru, String.format("%.8f", nilaiLebarSelangBaru), fcNilaiGalat, fcNol);

            /*
               mengkondisikan apabila nilai faXfc kurang dari 0 maka nilai b diganti dengan nilai c
               apabila tidak maka nilai a diganti dengan nilai c
            */
            if (faxfc < 0) {
                b = c;
            } else {
                a = c;
            }

            try {
                // Proses menglooping iterasi
                do {
                    i++;
                    // menghitung fa dengan memasukan persamaan method fungsiX dengan parameter nilai a
                    fa = fungsiX(a);
                    // menghitung fb dengan memasukan persamaan method fungsiX dengan parameter nilai b
                    fb = fungsiX(b);

                    // Menghitung nilai C dengan cara memisahkan operasi operasi didalam rumus menghitung nilai c
                    bilangan1 = fb * (b - a);
                    bilangan2 = fb - fa;
                    bilangan3 = bilangan1 / bilangan2;
                    bilangan4 = b - bilangan3;
                    c = bilangan4;

                    // Menghitung nilaiLebarSelangBaru
                    nilaiLebarSelangBaru = Math.abs(a - b);

                    // menghitung fb dengan memasukan persamaan method fungsiX dengan parameter nilai b
                    fc = fungsiX(c);

                    // menghitung fa * fc serta menginisialisasikan nilai tersebut menjadi variabel faxfc
                    faxfc = fa * fc;

                    /*
                      mengkondisikan apabila nilai faXfc kurang dari 0 dan nilai i bukan -1 maka nilai b diganti dengan nilai c
                      apabila tidak maka nilai a diganti dengan nilai c
                    */
                    if (faxfc < 0 && i != -1) {
                        selangBaru = "[a,c]";
                        b = c;
                    } else {
                        selangBaru = "[c,b]";
                        a = c;
                    }

                    /*
                        Mengkondisikan nilaiLebarSelangBaru kurang dari nilai galat maka nilaiGalat berubah menjadi true
                        lalu hentikan looping
                     */
                    if (nilaiLebarSelangBaru < galat) {
                        nilaiGalat = true;
                        break;
                    }
                    /*
                        Mengkondisikan fc sama dengan 0 maka variabel fcNilaiGalat berubah menjadi true
                        lalu hentikan looping
                     */
                    else if (fc == 0) {
                        fcNilaiGalat = true;
                        break;
                    }
                    /*
                        Mengkondisikan fc sama kurang dari nilai galat maka variabel fcNilaiGalat berubah menjadi true
                        lalu hentikan looping
                        *Math Abs merupakan method dari java agar mengembalikan nilai absolut.
                     */
                    else if (Math.abs(fc) < galat) {
                        fcNilaiGalat = true;
                        break;
                    }

                    // mencetak nilai variabel yang sudah terisi nilai kedalam program
                    System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fb), String.format("%.8f", fc), selangBaru, String.format("%.8f", nilaiLebarSelangBaru), fcNilaiGalat, fcNol);

                    /*
                    menkondisikan apabila nilaiLebarSelangBaru lebih dari galat atau
                    nilai fc sama dengan 0 atau
                    nilai fc lebih dari galat
                    maka looping dihentikan
                     */
                } while (nilaiLebarSelangBaru > galat || fc == 0 || Math.abs(fc) > galat);
                // mencetak nilai variabel yang sudah terisi nilai kedalam program
                System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a), String.format("%.8f", b), String.format("%.8f", c), String.format("%.8f", fa), String.format("%.8f", fb), String.format("%.8f", fc), selangBaru, String.format("%.8f", nilaiLebarSelangBaru), fcNilaiGalat, fcNol = true);
            } catch (Exception e) {
                // Menangkap Exception Error dari program java
                System.out.println(e.getMessage());
            }

            // Mencetak nilai variabel yang sudah terisi nilai kedalam program
            System.out.println();
            System.out.println("Akar hampiran   : " + String.format("%.8f", c));
            System.out.println("Dengan F(x)     : " + String.format("%.8f", fc));
            return c;
        }

        public static double newRaphson(double x0, double galat) {

            double xSebelum = x0 + 1;
            double selisih = xSebelum - x0;
            boolean xnKondisiTrueFalse = false;
            int i = 1;

            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |\n", "iterasi", "xn", "f(xn)", "turunanF(xn)", "|Xn - Xn - 1|", "|Xn - Xn - 1| < galat");
            System.out.format("%12s |%12s |%12s |%12s |%12s |%22s |\n", i, String.format("%.8f", x0), String.format("%.8f", fungsiX(x0)), String.format("%.8f", tFungsiX(x0)), "", xnKondisiTrueFalse);

            while (Math.abs(selisih) > galat) {
                i++;
                xSebelum = x0;
                x0 = xSebelum - (fungsiX(x0) / tFungsiX(x0));
                selisih = Math.abs(xSebelum - x0);

                if (selisih < galat) {
                    xnKondisiTrueFalse = true;
                } else {
                    xnKondisiTrueFalse = false;
                }

                System.out.format("%12s |%12s |%12s |%12s |%12s |%22s |\n", i, String.format("%.8f", x0), String.format("%.8f", fungsiX(x0)), String.format("%.8f", tFungsiX(x0)), String.format("%.8f", selisih), xnKondisiTrueFalse);
            }

            System.out.println("Akar Persamaan : " + String.format("%.8f", x0));
            return x0;
        }

        public static double secant(double x0, double x1, double galat) {
            int i = 0;
            int k = 1;
            boolean cekKondisiXn = false;
            double x2 = 0;
            double selisih;
            double fx = fungsiX(x0);
            double fx1 = fungsiX(x1);

            selisih = Math.abs(x1 - x0);
            if (selisih < galat) {
                cekKondisiXn = true;
            } else {
                cekKondisiXn = false;
            }
            System.out.format("%20s |%20s |%20s |%20s |%20s |\n", "iterasi", "Xn", "F(Xn)", "|Xn - Xn - 1|", "|Xn - Xn - 1| < galat");
            System.out.format("%20s |%20s |%20s |%20s |%20s |\n", i, String.format("%.8f", x0), String.format("%.8f", fx), "", "");
            System.out.format("%20s |%20s |%20s |%20s |%20s |\n", k, String.format("%.8f", x1), String.format("%.8f", fx1), String.format("%.8f", selisih), cekKondisiXn);

            try {
                do {
                    k++;
                    x2 = x1 - ((fungsiX(x1) * (x1 - x0)) / (fungsiX(x1) - fungsiX(x0)));
                    double fx2 = fungsiX(x2);
                    selisih = Math.abs(x2 - x1);
                    if (selisih < galat) {
                        cekKondisiXn = true;
                    } else {
                        cekKondisiXn = false;
                    }
                    System.out.format("%20s |%20s |%20s |%20s |%20s |\n", k, String.format("%.8f", x2), String.format("%.8f", fx2), String.format("%.8f", selisih), cekKondisiXn);
                    x0 = x1;
                    x1 = x2;
                } while (selisih > galat);
                System.out.println("Akar Hampiran : " + String.format("%.8f", x2));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return x2;
        }


        public static double tFungsiX(double x) {
            return (3 * Math.pow(x, 2)) + (10 * x) - 10;
        }

        public static double fungsiX(double x) {
            return (Math.pow(x, 3)) + 5 * (Math.pow(x, 2)) - (10 * x) - 4;
        }
    }
}
