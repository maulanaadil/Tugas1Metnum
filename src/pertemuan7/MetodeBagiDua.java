
package pertemuan7;

public class MetodeBagiDua {
    public static void main(String[] args) {
        double a = 1.3;
        double b = 2;
        double c = (a + b) /2;
        double nilaiLebarSelangBaru = Math.abs(a-b);
        double galat = 0.0001;
        String lebarSelangBaru;
        boolean nilaiGalat = false;
        int i = 1;

        double fa = fungsiX(a);
        double fc = fungsiX(c);
        double faxfc = fa * fc;
        System.out.println("Nilai Fungsi(a) * Fungsi(c) : " + faxfc);
        System.out.println("i | a | b | c | fa | fc | nilaiLebarSelangBaru | nilaiGalat | selang baru");

        if (faxfc < 0) {
            lebarSelangBaru = "[a,c]";
            b = c;
        } else {
            lebarSelangBaru = "[c,b]";
            a = c;
        }
        System.out.println(i + " | " + String.format("%.8f", a) + " | " + String.format("%.8f", b) + " | " + String.format("%.8f", c) + " | " + String.format("%.8f", fa) + " | " + String.format("%.8f", fc)  + " | " + String.format("%.8f", nilaiLebarSelangBaru) + " | " + false +" | "+ lebarSelangBaru);

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
                c = (a+b)/2;
                nilaiLebarSelangBaru = Math.abs(a-b);

                if (nilaiLebarSelangBaru < galat) {
                    nilaiGalat = true;
                    lebarSelangBaru = "";
                }

                System.out.println();
                System.out.println("Nilai Fungsi(a) * Fungsi(c) : " + faxfc);
                System.out.println(i + " | " + String.format("%.8f", a) + " | " + String.format("%.8f", b) + " | " + String.format("%.8f", c) + " | " + String.format("%.8f", fa) + " | " + String.format("%.8f", fc)  + " | " + String.format("%.8f", nilaiLebarSelangBaru) + " | " + nilaiGalat  +" | "+ lebarSelangBaru);
            } while (nilaiLebarSelangBaru > galat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Akar Hampiran : " + String.format("%.8ff", c));
        System.out.println("f(x) : " + String.format("%.8f", fc));

    }
    public static double fungsiX(double x) {
        return (Math.pow(x, 3)) + 5 * (Math.pow(x, 2)) - (10 * x) - 4;
    }
}   
