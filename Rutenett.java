public class Rutenett{
    public int antKolonner;
    public int antRader;
    public Celle[][] rutene;

    public Rutenett (int antRader, int antKolonner){
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
        fyllMedTilfeldigeCeller();
    }
    
    private void lagCelle(int rad, int kolonne){
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
        try{
            return rutene[rad][kolonne];
        } catch (Exception e){
            return null;
        }
        
    }

    public void tegnRutenett(){
        System.out.print("+---".repeat(antKolonner).concat("+\n"));
        for (Celle[] rad: rutene){
            System.out.print("|");
            for (Celle rute: rad){
                System.out.print(" ".concat(Character.toString(rute.hentStatusTegn())).concat(" |"));
            }
            System.out.println();
            System.out.print("+---".repeat(antKolonner).concat("+\n"));
        }
    }

    public void settNaboer(int rad, int kolonne){
        int[][] relativePositions = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}
        };
    
        for (int[] offset : relativePositions) {
            hentCelle(rad, kolonne).leggTilNabo(hentCelle(rad + offset[0], kolonne + offset[1]));
        }
        
    }

    public void kobleAlleCeller(){
        for (int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                settNaboer(rad, kol);
            }
        }
    }

    public int antallLevende(){
        int antLevende = 0;
        for (Celle[] rad: rutene){
            for (Celle celle: rad){
                if (celle.levende){
                    antLevende++;
                }
            }
        }
        return antLevende;
    }

}
