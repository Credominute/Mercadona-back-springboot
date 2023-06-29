package fr.studi.promoweb.ws;

import fr.studi.promoweb.pojo.Promotion;
import fr.studi.promoweb.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiRegistration.API_REST
        +ApiRegistration.PROMOTION)
@RestController
public class PromotionWs {

    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public List<Promotion> getAllPromotion(){
        return promotionService.getAllPromotion();
    }

    @GetMapping("{id}")
    public Promotion getPromotionById(@PathVariable("id") Long id){
        return promotionService.getPromotionById(id);
    }

    @PostMapping
    public void createPromotion(@RequestBody Promotion promotion){

    }

    @PutMapping("{id}")
    public void updatePromotionById(@RequestBody Promotion promotion,
                                @PathVariable Long id){

    }

    @DeleteMapping("{id}")
    public void deletePromotionById(@PathVariable Long id){

    }

}
