package pertemuan7;

public class MetodeRegulasiFalsi {
    public static void main(String[] args) {
        double a = 1.3;
        double b = 2;

        double galat = 0.0001;
        double fa = fungsiX(a);
        double fb = fungsiX(b);
        int i = 1;
        
        String selangBaru;

        boolean nilaiGalat = false;
        boolean fcNol = false;
        boolean fcNilaiGalat = false;

        double bilangan1 = fb * (b-a);
        double bilangan2 = fb - fa;
        double bilangan3 =  bilangan1/bilangan2;
        double bilangan4 = b - bilangan3;
        double c = bilangan4;
        double lebarSelangBaru = Math.abs(a-b);
        
        
        double fc = fungsiX(c);
        
        double faxfc = fa * fc;


        if (faxfc < 0) {
            selangBaru = "[a,c]";
        } else {
            selangBaru = "[c,b]";
        }

        System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", "iterasi", "a","b","c","f(a)","f(b)","f(c)","selang baru", "|a - b|", " |f(c) < galat|", "f(c) = 0");
//        System.out.println("Iterasi |   a   |   b   |   c   |     f(a)    |     f(b)    |   f(c)   |   selangBaru  |   selangBaru|a-b|   |   |a-b| < galat   |   |f(c) < galat|   |   f(c) = 0   |");
//        System.out.println(i + "    | " + String.format("%.8f", a) + " | " + String.format("%.8f", b) + " | " + String.format("%.8f", c) + " | " + String.format("%.8f", fa) + " | " + String.format("%.8f", fb) + " | " + String.format("%.8f", fc) + " | " + selangBaru + " | " + String.format("%.8f", lebarSelangBaru) + " | " + " | " + false + " | " + false + " | " + false + "|" );
        System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a),String.format("%.8f", b),String.format("%.8f", c),String.format("%.8f", fa),String.format("%.8f", fb),String.format("%.8f", fc),selangBaru, String.format("%.8f", lebarSelangBaru), nilaiGalat, fcNilaiGalat, fcNol);

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

                bilangan1 = fb * (b-a);
                bilangan2 = fb - fa;
                bilangan3 =  bilangan1/bilangan2;
                bilangan4 = b - bilangan3;
                c = bilangan4;
                lebarSelangBaru = Math.abs(a-b);

               fc = fungsiX(c);

               faxfc = fa * fc;
                if (faxfc < 0  && i != -1) {
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

                System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a),String.format("%.8f", b),String.format("%.8f", c),String.format("%.8f", fa),String.format("%.8f", fb),String.format("%.8f", fc),selangBaru, String.format("%.8f", lebarSelangBaru), nilaiGalat, fcNilaiGalat, fcNol);

            } while(lebarSelangBaru > galat || fc == 0 || Math.abs(fc) > galat);
            System.out.format("%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |%12s |\n", i, String.format("%.8f", a),String.format("%.8f", b),String.format("%.8f", c),String.format("%.8f", fa),String.format("%.8f", fb),String.format("%.8f", fc),selangBaru, String.format("%.8f", lebarSelangBaru), nilaiGalat, fcNilaiGalat, fcNol);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Akar hampiran   : " + String.format("%.8f", c));
        System.out.println("Dengan F(x)     : " + String.format("%.8f", fc));
    }

    public static double fungsiX(double x) {
        return (Math.pow(x, 3)) + 5 * (Math.pow(x, 2)) - (10 * x) - 4;
    }
}

