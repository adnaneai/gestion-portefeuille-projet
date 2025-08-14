package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@DiscriminatorValue("DEMANDEUR")
public class Demandeur extends Utilisateur {
    private Long matricule;
    private String direction;
    @OneToMany(mappedBy = "demandeur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Demande> demandes;
}
