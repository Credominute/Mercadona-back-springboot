package fr.studi.promoweb.repository;

import fr.studi.promoweb.pojo.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {

    @Query("SELECT a FROM Admin a")
    List<Admin> findAllAdmin();

}
