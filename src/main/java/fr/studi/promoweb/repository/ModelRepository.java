package fr.studi.promoweb.repository;

import fr.studi.promoweb.model.Model;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
public class ModelRepository {
    private static final List<Model> listeDesDesserts = new ArrayList<>();

    static {
        listeDesDesserts.add(new Model(1, "Tiramisu", 7));
        listeDesDesserts.add(new Model(2, "Yaourt", 12));
        listeDesDesserts.add(new Model(3, "Tarte", 6));
    }

    public Model findModelById(int modelID) {
        for (Model model : listeDesDesserts) {
            if (model.getModelId() == modelID) {
                return model;
            }
        }
        return null;
    }

}
