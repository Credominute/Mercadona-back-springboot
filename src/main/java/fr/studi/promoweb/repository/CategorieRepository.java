package fr.studi.promoweb.repository;

import fr.studi.promoweb.pojo.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie,Long> {

    @Query("SELECT a FROM Categorie a")
    List<Categorie> findAllCategorie();

}
