public class Celle{
    boolean levende; 
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;

    public Celle(){
        levende = false;
        naboer = new Celle[8];
        antNaboer = 0;
        antLevendeNaboer = 0;
    }
    
    public void settDoed(){
        levende = false;
    }

    public void settLevende(){
        levende = true;
    }

    public boolean erLevende(){
        return levende;
    }

    public char hentStatusTegn(){
        if (levende) return 'O';
        else return '.';
    }

    public void leggTilNabo(Celle nabo){
        naboer[antNaboer] = nabo;
        antNaboer++;
    }

    public void tellLevendeNaboer(){
        antLevendeNaboer = 0;
        for (Celle nabo: naboer){
            if (nabo != null && nabo.erLevende()) antLevendeNaboer++;
        }
    }

    public void oppdaterStatus(){
        tellLevendeNaboer();
        if (levende){
            if (antLevendeNaboer < 2){
                settDoed();
            } else if (antLevendeNaboer < 4){
                settLevende();
            } else {
                settDoed();
            }
        } else {
            if (antLevendeNaboer == 3) settLevende();
        }
    }
}

