package fr.studi.promoweb.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long produit_id;

    private String libele1;

    private String description;

    private Float prix;

    private String image;

    public Produit(String libele1, String description, Float prix, String image) {
        this.libele1 = libele1;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Produit() {

    }
}
