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

    private Long pourcentRemise;

    public Promotion(LocalDate dateDebut, LocalDate dateFin, Long pourcentRemise) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pourcentRemise = pourcentRemise;
    }

    public Promotion(){
        //Constructeur vide pour Spring
    }

    public boolean equals(Promotion obj) {
        return this.promotion_id.equals(obj.getPromotion_id()) &&
                this.dateDebut.equals(obj.getDateDebut()) &&
                this.dateFin.equals(obj.getDateFin()) &&
                this.pourcentRemise.equals(obj.getPourcentRemise());
    }

    @OneToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
