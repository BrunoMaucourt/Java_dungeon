public class Couteau extends  ArmeMonstre {
    Couteau(String nomDeArme, int pointAttaqueArme, int pointAttaqueCritique, int tauxCoupCritique, int tauxAttaqueBonus,String nomAttaqueBonus){
        this.nomDeArme = nomDeArme;
        this.pointAttaqueArme = pointAttaqueArme;
        this.pointAttaqueCritique = pointAttaqueCritique;
        this.tauxCoupCritique = tauxCoupCritique;
        this.tauxAttaqueBonus = tauxAttaqueBonus;
        this.nomAttaqueBonus = nomAttaqueBonus;
    }
}
