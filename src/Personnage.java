public class Personnage {

    //Atttributs
    protected int pointDeVie;
    protected int attaquesDuHero;
    protected int degatsRecus;
    protected boolean enVie;

    //Constructeur
    Personnage (int PointDeVie, int attaquesDuHero, int degatsRecus, boolean enVie) {
        this.pointDeVie = PointDeVie;
        this.attaquesDuHero = attaquesDuHero;
        this.degatsRecus = degatsRecus;
        this.enVie = enVie;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public int getAttaquesDuHero() {
        return attaquesDuHero;
    }

    public void setAttaquesDuHero(int attaquesDuHero) {
        this.attaquesDuHero = attaquesDuHero;
    }

    public int getDegatsRecus() {
        return degatsRecus;
    }

    public void setDegatsRecus(int degatsRecus) {
        this.degatsRecus = degatsRecus;
    }

    public boolean isEnVie() {
        return enVie;
    }

    public void setEnVie(boolean enVie) {
        this.enVie = enVie;
    }




    /*public void set_PV ( int PV) throws ExceptionFinVie
    {
        if ( PV <= 0 )
        {
            throw new ExceptionFinVie("Le héros est mort.");
        }
        else
        {
            if ( PV <= this.PV_Depart )
                this.PV = PV;
            else this.PV = this.PV_Depart;
        }
    }


*/

}


//pk on fait les getters et setters ?
//
