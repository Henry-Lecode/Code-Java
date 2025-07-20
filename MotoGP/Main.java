import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static List<MotoGp> mg = new ArrayList<>();
    public static List<RacerWithSpeed> eveluate = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void greet(){
        System.out.println("_-^-_-^-_-^-_-^-_-^-_-^-_-^-_-^-_-^-_-^-_\n");
        System.out.println("\t\tWELCOME TO MOTOR GP\n" +
                           "\t\t  🏆CHAMPION 2025🏆");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dinhDang = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        Date d = cal.getTime();
        String s = dinhDang.format(d);
        System.out.println(s);
    }

    public static void addRacer(){
        System.out.println("\nInput amount of racer.");
        int a = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < a; i++){
            System.out.println("\nInput racer #" + (i + 1) + ".");
            System.out.println("Input your brand.");
            String b = sc.nextLine();
            System.out.println("Input name of racer.");
            String n = sc.nextLine();
            System.out.println("Input No of racer.");
            int no = Integer.parseInt(sc.nextLine());
            switch (b) {
                case "Ducati":
                    mg.add(new Ducati(b, n, no));
                    break;
                case "Yamaha":
                    mg.add(new Yamaha(b, n, no));
                    break;
                case "Honda":
                    mg.add(new Honda(b, n, no));
                    break;
                case "Aprilia":
                    mg.add(new Aprilia(b, n, no));
                    break;
                default:
                    System.out.println("The brand is wrong.");
                    break;
            }
        }
    }

    public static void showResultFormationLap(){
        System.out.println("\n<<<<<-----Formation lap----->>>>>");
        System.out.println("|Brand     |Racer     |No   |Speed   |");
        for(MotoGp m : mg){
            m.showResultFormationLap();
        }
    }

    public static void sortSpeedOpeningLap(){
        for(MotoGp m : mg){
            eveluate.add(new RacerWithSpeed(m, m.racingOpeningLap()));
        }
        eveluate.sort((a, b) -> Double.compare(b.speed, a.speed));
        System.out.println("\n<<<<<-----Opening lap----->>>>>");
        System.out.println("|Brand     |Racer     |No   |Speed   |");
        for(RacerWithSpeed rws : eveluate){
            rws.motor.showResultOpeningLap(rws.speed);
        }
    }

    public static void champion(){
        if (eveluate.isEmpty()) {
            System.out.println("No racers are evaluated yet!");
            return;
        }

        RacerWithSpeed champ = eveluate.getFirst();
        System.out.println(" ");
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      🏆 The Champion of 2025 🏆      ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.printf(" Brand : %-10s\n", champ.motor.getBrand());
        System.out.printf(" Racer : %-10s\n", champ.motor.getRacer());
        System.out.printf(" No    : %-5d\n", champ.motor.getNo());
        System.out.printf(" Speed : %-8.2f km/h\n", champ.speed);

    }

    public static void main(String[] args) {
        greet();
        addRacer();
        showResultFormationLap();
        sortSpeedOpeningLap();
        champion();
    }

}