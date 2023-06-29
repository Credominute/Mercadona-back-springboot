package fr.studi.promoweb.repository;

import fr.studi.promoweb.pojo.Categorie;
import fr.studi.promoweb.pojo.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProduitRepository extends CrudRepository<Produit,Long> {

    @Query("SELECT a FROM Produit a")
    List<Produit> findAllProduit();

    @Query("SELECT a FROM Produit a")
    List<Produit> findProduitByCategorie(Categorie categorie);
}