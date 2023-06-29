package fr.studi.promoweb.ws;

import fr.studi.promoweb.pojo.Categorie;
import fr.studi.promoweb.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiRegistration.API_REST
        +ApiRegistration.CATEGORIE)
@RestController
public class CategorieWs {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getAllCategorie(){
        return categorieService.getAllCategorie();
    }

    @GetMapping("{id}")
    public Categorie getCategorieById(@PathVariable("id") Long id){
        return categorieService.getCategorieById(id);
    }

    @PostMapping
    public void createCategorie(@RequestBody Categorie categorie){

    }

    @PutMapping("{id}")
    public void updateCategorieById(@RequestBody Categorie categorie,
                                    @PathVariable Long id){

    }

    @DeleteMapping("{id}")
    public void deleteCategorieById(@PathVariable Long id){

    }

}
