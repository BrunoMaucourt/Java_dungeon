/**
 * Classe correspondant à l'une des armes des monstres
 */
public class Massue extends ArmeMonstre{
    Massue(String nomDeArme, int pointAttaqueArme, int pointAttaqueCritique, int tauxCoupCritique, int tauxAttaqueBonus,String nomAttaqueBonus){
        this.nomDeArme = nomDeArme;
        this.pointAttaqueArme = pointAttaqueArme;
        this.pointAttaqueCritique = pointAttaqueCritique;
        this.tauxCoupCritique = tauxCoupCritique;
        this.tauxAttaqueBonus = tauxAttaqueBonus;
        this.nomAttaqueBonus = nomAttaqueBonus;
    }
}
