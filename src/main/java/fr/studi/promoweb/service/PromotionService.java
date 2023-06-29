package fr.studi.promoweb.service;

import fr.studi.promoweb.pojo.Produit;
import fr.studi.promoweb.pojo.Promotion;

import java.util.List;

public interface PromotionService {
    List<Promotion> getAllPromotion();

    Promotion getPromotionById(Long id);

    void deletePromotionById(Long id);

    void updatePromotionById(Promotion promotion, Long id);

    void createPromotion(Promotion promotion);
}
