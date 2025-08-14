package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class ProjetsRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjetRelation;
    private String descriptionProjet;
    private List<String> typeRelations;
    @OneToOne
    @JoinColumn(name = "projetsRelation")
    private Demande demande;
}
