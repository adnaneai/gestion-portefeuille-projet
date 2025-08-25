package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class DesignationProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDesignationProjet;
    @ManyToOne
    @JoinColumn(name = "projetsRelation")
    private ProjetsRelation projetsRelation;
}
