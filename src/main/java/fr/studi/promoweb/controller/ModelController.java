package fr.studi.promoweb.controller;

import fr.studi.promoweb.model.Model;
import fr.studi.promoweb.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping(value = "get/{modelId}")
    public Model getModelById(@PathVariable int modelId) {
        return modelRepository.findModelById(modelId);
    }
}
