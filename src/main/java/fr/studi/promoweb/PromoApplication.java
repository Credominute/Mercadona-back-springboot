package fr.studi.promoweb;

public class PromoApplication {

    public static void main(String[] args) {

        int dureePromotionModif = dureePromotion(4, 1);
        System.out.println("La durée de la promotion est de " + dureePromotionModif + " semaines!");

    }
    public static int dureePromotion(int dureePromotionModif, int dureePromotion) {
        return dureePromotionModif - dureePromotion;
    }


}
