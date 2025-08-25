package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class Beneficitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomBeneficitaire;
    @ManyToOne
    @JoinColumn(name = "partiesPrenantes_id")
    private PartiesPrenantes partiesPrenantes;
}
