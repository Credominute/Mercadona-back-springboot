package fr.studi.promoweb.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long promotion_id;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Long pourcentageRemise;

    @OneToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
