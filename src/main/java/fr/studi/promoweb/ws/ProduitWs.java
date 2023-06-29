package fr.studi.promoweb.ws;

import fr.studi.promoweb.pojo.Categorie;
import fr.studi.promoweb.pojo.Produit;
import fr.studi.promoweb.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiRegistration.API_REST
        +ApiRegistration.PRODUIT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProduitWs {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduit() {
        return produitService.getAllProduit();
    }

    @GetMapping("{id}")
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduitById(id);
    }

    @GetMapping(ApiRegistration.CATEGORIE + "{categorie}")
    public List<Produit>getProduitByCategorie(@PathVariable Categorie categorie) {
        return produitService.getAllProduitByCategorie(categorie);
    }

    @PostMapping
    public void createProduit(@RequestBody Produit produit) {
        produitService.createProduit(produit);
    }

    @PutMapping("{id}")
    public void updateProduitById(@RequestBody Produit produit,
                                    @PathVariable Long id){
        produitService.updateProduitById(produit,id);
    }

    @DeleteMapping("{id}")
    public void deleteProduitById(@PathVariable Long id){
        produitService.deleteProduitById(id);
    }
}