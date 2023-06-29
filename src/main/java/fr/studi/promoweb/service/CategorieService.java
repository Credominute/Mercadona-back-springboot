package fr.studi.promoweb.service;

import fr.studi.promoweb.pojo.Categorie;

import java.util.List;

public interface CategorieService {
    List<Categorie> getAllCategorie();

    Categorie getCategorieById(Long id);

    void deleteCategorieById(Long id);

    void updateCategorieById(Categorie categorie, Long id);

    void createCategorie(Categorie categorie);
}
