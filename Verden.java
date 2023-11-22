public class Verden {
    public Rutenett rutenett;
    public int genNr;
    private int kol;

    public Verden(int rader, int kolonner){
        rutenett = new Rutenett(rader, kolonner);
        genNr = 0;
        kol = kolonner;
    }

    public void tegn(){
        System.out.println("=".repeat(5*kol));
        System.out.println("Generasjon " + genNr + ": ");
        System.out.println("=".repeat(5*kol));
        rutenett.tegnRutenett();
        System.out.println("Antall levende celler: " + rutenett.antallLevende() + "\n");
    }

    public void oppdatering(){
        for (Celle[] rad: rutenett.rutene){
            for (Celle celle: rad){
                celle.oppdaterStatus();
            }
        }
        genNr++;
        tegn();
    }
}
