package fr.studi.promoweb.pojo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int categorie_id;

    private String libele2;

    public Categorie(String libele2) {
        this.libele2 = libele2;
    }

    public Categorie() {
    }
}