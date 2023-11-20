public class Rutenett{
    int antKolonner;
    int antRader;
    Celle[][] rutene;

    public Rutenett (int antKolonner, int antRader){
        this.antKolonner = antKolonner;
        this.antRader = antRader;
        rutene = new Celle[antKolonner][antRader];
    }
    
    public void lagCelle(int rad, int kolonne){
        Celle celle = new Celle();
        if (Math.random() <= 0.3333){
            celle.settLevende();
        }
        rutene[rad][kolonne] = celle;
    }

    public void fyllMedTilfeldigeCeller(){
        for (int rad = 0; rad < antRader; rad++){
            for (int kolonne = 0; kolonne < antKolonner; kolonne++){
                lagCelle(rad, kolonne);
            }
        }
    }

    public Celle hentCelle(int rad, int kolonne){
        return rutene[rad][kolonne];
    }

    public void tegnRutenett(){

    }

    public void settNaboer(int rad, int kolonne){

    }

    public void kobleAlleCeller(){

    }

    public int antallLevende(){
        ...
    }
}
