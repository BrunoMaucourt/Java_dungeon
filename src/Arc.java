/**
 * Arme du héro
 */
public class Arc extends ArmeHero{
    /**
     * Constructeur de l'objet arc
     * @param nomDeArme
     * @param pointAttaqueArme
     * @param pointAttaqueCritique
     * @param tauxCoupCritique
     * @param tauxAttaqueBonus
     * @param nomAttaqueBonus
     */
    Arc(String nomDeArme, int pointAttaqueArme, int pointAttaqueCritique, int tauxCoupCritique, int tauxAttaqueBonus,String nomAttaqueBonus){
        this.nomDeArme = nomDeArme;
        this.pointAttaqueArme = pointAttaqueArme;
        this.pointAttaqueCritique = pointAttaqueCritique;
        this.tauxCoupCritique = tauxCoupCritique;
        this.tauxAttaqueBonus = tauxAttaqueBonus;
        this.nomAttaqueBonus = nomAttaqueBonus;
    }
}
