import java.util.Scanner;

public class Kalkylator {
    public static Boolean flagga = true;

    public static void main(String[] args) {
        printMenu();
    }

    /* printMenu skriver ut en meny med 5 val + 1 uppmaning. Användaren uppmanas att skriva in ett heltal mellan 1 0ch 5. Sen
     * switchar vi på det heltalet */
    public static void printMenu() {
        Scanner scan = new Scanner(System.in);
        String[] meny = {"1. Roten ur", "2. Procent", "3. Phytagoras sats", "4. Cirkelns area", "5. Avsluta",
                "Gör ett val från menyn genom att skriva en siffra mellan 1 och 5"};

        for (int i = 0; i < 6; i++) {
            System.out.println(meny[i]);
        }
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {

                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        double sqof = sqrtof();
                        System.out.println("Roten ur är: " + sqof);
                        printMenu();
                        break;
                    case 2:
                        double svar = procent();
                        System.out.println("Andelen av värdet är "+svar);
                        printMenu();
                        break;
                    case 3:
                        System.out.println("Pythagoras sats");
                        break;
                    case 4:
                        System.out.println("Cirkelns area");
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Gör ett val!");
                }
            }
        }
    }

    /* Vi ber användaren om ett heltal mellan 0-1000 och metoden tar emot två parametrar som begränsar storlrkrn på talet.
     Vi kontrollerar att det är ett heltal. Sedan returnerar vi heltalet. */
    public static int getVal(int min, int max) {
        int heltal = 0;
        int retval = 0;
        System.out.println("Ange ett heltal mellan " + min + " och " + max);
        Scanner scan2 = new Scanner(System.in);
        if (scan2.hasNextInt()) {
            heltal = scan2.nextInt();
            if (heltal >= min && heltal <= max) {
                retval = heltal;
            }
        } else {
            scan2.nextLine();
            System.out.println("Det var inte ett heltal mellan 0-1000, försök igen");
            getVal(min, max);
        }
        return retval;
    }

    /*  */
    public static double sqrtof() {
        int min = 0;
        int max = 1000;
        int number = getVal(min, max);
        double num = (double) number;
        double squar = Math.sqrt(num);
        return squar;
    }

    public static double getVal(double min, double max) {
        double heltal = 0;
        double retval = 0;

        if (flagga) {
            System.out.print("Ange ett procenttal mellan 0 till 100 : ");
            Scanner scan3 = new Scanner(System.in);
            if (scan3.hasNextDouble()) {
                heltal = scan3.nextDouble();
                if (heltal >= min && heltal <= max) {
                    retval = heltal;
                    flagga = false;
                }
            } else {
                scan3.nextLine();
                System.out.println("Det var inte ett procenttal mellan 0 och 100!");
                //getVal(min, max);
            }
        }
        if(!flagga){
            System.out.print("Ange ett värde mellan 1 och 50 : ");
            Scanner scan3 = new Scanner(System.in);
            if (scan3.hasNextDouble()) {
                heltal = scan3.nextDouble();
                if (heltal >= min && heltal <= max) {
                    retval = heltal;
                    flagga = true;
                }
            } else {
                scan3.nextLine();
                System.out.println("Det var inte ett tal mellan 1 och 50, försök igen ");
                //getVal(min, max);
            }
        }
            return retval;
    }
    public static double procent(){
        double min = 0;
        double max = 100;
        double minVal = 1;
        double maxVal = 50;
        double procentTal = getVal(min,max);
        double value = getVal(minVal,maxVal);
        final double decimal = 100;
        double andel = procentTal/decimal * value;
        return andel;
    }
}



