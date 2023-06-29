package fr.studi.promoweb.repository;

import fr.studi.promoweb.pojo.Promotion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion,Long> {

    @Query("SELECT a FROM Promotion a")
    List<Promotion> findAllPromotion();

}
