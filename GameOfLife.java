import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args){
        int rader, kolonner;

        try{
            rader = Integer.parseInt(args[0]);
            kolonner = Integer.parseInt(args[1]);
        } catch (Exception e){
            Scanner sc = new Scanner(System.in);
            System.out.println("Angi antall rader: ");
            rader = sc.nextInt();
            System.out.println("Angi antall kolonner: ");
            kolonner = sc.nextInt();
        }

        Verden verden = new Verden(rader, kolonner);
        verden.tegn();
        for (int i = 0; i < 3; i++){
            verden.oppdatering();
        }
    }
}
