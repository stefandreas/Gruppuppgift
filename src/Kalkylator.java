import java.util.Scanner;

public class Kalkylator {

    public static void main(String[] args) {
        printMenu();
    }

    /* Deltagare: Stefan Johansson och Emily Arnelid
    Vi gör en string array och initierar den med 6 olika strängar.
    printMenu använder en for-loop för att skriva ut en meny med 5 val + 1 uppmaning. Vi har en while-loop som använder
    scan-objektet för att se om vi har input från användaren. If satsen kollar om det är ett heltal och om det är det,
    så switchar vi på det värdet. Om värdet är utanför så körs default. Om inte ett heltal anges så körs else, där vi
    nollställer scan-objektet och återvänder till while-loopen.
    */
    public static void printMenu() {
        Scanner scan = new Scanner(System.in);
        String[] meny = {"1. Roten ur", "2. Procent", "3. Phytagoras sats", "4. Cirkelns area", "5. Avsluta",
                "Gör ett val från menyn genom att skriva en siffra mellan 1 och 5 : "};

        for (int i = 0; i < 6; i++) {
            if(i<5) {
                System.out.println(meny[i]);
            }else
                System.out.print(meny[i]);
        }
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        double sqof = sqrtof();
                        System.out.println("Roten ur är: " + sqof);
                        System.out.println();
                        printMenu();
                        break;
                    case 2:
                        double svar = procent();
                        System.out.println("Andelen av värdet är: " + svar);
                        System.out.println();
                        printMenu();
                        break;
                    case 3:
                        System.out.println("Du kommer att få ange två stycken katedrar");
                        double pyth = pythagoras();
                        System.out.println("Hypotenusan är: " + pyth);
                        System.out.println();
                        printMenu();
                        break;
                    case 4:
                        System.out.println("Ange cirkelns diameter");
                        double area = circleA();
                        System.out.println("Cirkelns area är: "+ area);
                        System.out.println();
                        printMenu();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.print("Du måste ange ett nummer från menyn, försök igen : ");
                }
            }else {
                scan.nextLine();
                System.out.print("Du måste ange ett heltal, försök igen : ");
            }
        }
    }

    /* Vi ber användaren om ett heltal mellan min och max, metoden tar emot två parametrar som begränsar storleken på
    talet. Vi använder en while loop som loopar tills vi fått ett korrekt värde.
    Vi använder en boolean för att stoppa loopen när vi har ett godkänt värde. Sedan returnerar vi heltalet. */
    public static int getVal(int min, int max) {
        int heltal = 0;
        int retval = 0;
        System.out.print("Ange ett heltal mellan " + min + " och " + max + " : ");
        Scanner scan2 = new Scanner(System.in);
        boolean vimpel = true;
        while (vimpel) {
            if (scan2.hasNextInt()) {
                heltal = scan2.nextInt();
                if (heltal >= min && heltal <= max) {
                    retval = heltal;
                    vimpel = false;
                } else {
                    scan2.nextLine();
                    System.out.print("Det var inte ett heltal mellan " + min + " och " + max + " , försök igen : " );
                }
            } else {
                scan2.nextLine();
                System.out.print("Det var inte ett heltal, försök igen : ");
            }
        }
        return retval;
    }
    /*Vi ber användaren om ett flyttal mellan min och max, metoden tar emot två parametrar som begränsar storleken på
    * talet. Vi Kontrollerar att det är ett flyttal. Sedan returnera vi flyttalet. Vi använder en while loop som loopar
    * tills vi fått ett korrekt värde. Vi använder en boolean för att stoppa loopen när vi har ett godkänt värde.*/
    public static double getVal(double min, double max){
        double flyttal = 0;
        double returnValue = 0;
        System.out.print("Ange ett flyttal mellan " + min + " och " + max + " : ");
        Scanner scan5 = new Scanner(System.in);
        boolean flagga = true;
        while (flagga) {
            if (scan5.hasNextDouble()){
                flyttal = scan5.nextDouble();
                if (flyttal >= min && flyttal <= max){
                    returnValue = flyttal;
                    flagga = false;
                } else {
                    scan5.nextLine();
                    System.out.print("Det var inte inom gränserna, försök igen : ");
                }
            } else {
                scan5.nextLine();
                System.out.print("Det här var inte ett flyttal, försök igen : ");
            }
        }
        return returnValue;
        }

    /*Vi anropar getVal med min och max och castar svaret till en double variabel som vi skickar in som argument till
    Math.sqrt och returnerar värdet  */
    public static double sqrtof() {
        int min = 0;
        int max = 1000;
        int number = getVal(min, max);
        double num = (double) number;
        double squar = Math.sqrt(num);
        return squar;
    }
    /*Vi kom på efter att vi gjort metoden att vi inte hade behövt göra en specialanpassad metod för procent.
    * double getVal finns högre upp
    * Vi skapade en array så att vi kunde stoppa in två värden i den för att returnera till procentmetoden
    * Så den här metoden är lite onödig men vi lät den vara kvar som ett exempel på när man inte har läst i
    * uppgiften ordentligt. */
    public static double[] getVal(double minPro, double maxPro, double minVal, double maxVal) {
        double heltal = 0;
        double[] arrayReturn = new double[2];

        System.out.print("Ange ett procenttal mellan 0 till 100 : ");
        Scanner scan3 = new Scanner(System.in);
        Boolean flag = true;
        Boolean flag2 = true;
        while (flag) {
            if (scan3.hasNextDouble()) {
                heltal = scan3.nextDouble();
                if (heltal >= minPro && heltal <= maxPro) {
                    arrayReturn[0] = heltal;
                    flag = false;
                } else {
                    scan3.nextLine();
                    System.out.print("Det var inte ett procenttal mellan 0 och 100, försök igen :");
                }
            } else {
                scan3.nextLine();
                System.out.print("Det var inte ett procenttal mellan 0 och 100, försök igen :");
            }
        }
        while (flag2) {
            System.out.print("Ange ett värde mellan 1 och 50 : ");
            Scanner scan4 = new Scanner(System.in);
            if (scan4.hasNextDouble()) {
                heltal = scan4.nextDouble();
                if (heltal >= minVal && heltal <= maxVal) {
                    arrayReturn[1] = heltal;
                    flag2 = false;
                }else {
                    scan4.nextLine();
                    System.out.print("Det var inte ett tal mellan 1 och 50, försök igen :");
                }
            } else {
                scan4.nextLine();
                System.out.print("Det var inte ett tal mellan 1 och 50, försök igen :");
            }
        }
                return arrayReturn;
        }
    /*Vi anropar vår special double array getVal metod som returnerar en array med de värden vi vill ha. Vi räknar om
    procent till decimaltal och räknar ut andelen som vi sedan returnerar.*/
    public static double procent(){
        double minPro = 0;
        double maxPro = 100;
        double minVal = 1;
        double maxVal = 50;
        double[] procentTal = getVal(minPro,maxPro,minVal,maxVal);
        double procent = 0;
        double value = 0;
        procent = procentTal[0];
        value = procentTal[1];
        final double decimal = 100;
        double andel = procent/decimal * value;
        return andel;
    }
    /*Vi anropar double getVal som returnerar två stycken katedrar. Som vi använder i vårat anrop Math.hypot. Sedan
    returneras hypotenusan.*/
    public static double pythagoras(){
        double min = 1;
        double max = 1000;
        double kateder1 = 0;
        double kateder2 = 0;
        kateder1 = getVal(min, max);
        System.out.println("Kateder nummer 2 ");
        kateder2 = getVal(min, max);
        double hypotenusa = Math.hypot(kateder1, kateder2);
        return hypotenusa;
    }
    /* Anropar double getVal och frågar om en diameter. Sedan dividerar vi diametern med 2 för att få fram radien,
    sedan gör vi bara uträkningen för area och returnerar värdet.  */
    public static double circleA(){
        double diameter = 0;
        diameter = getVal(1, 1000);
        double radie = diameter/2;
        double area = Math.PI * radie * radie;
        return area;
    }
}



