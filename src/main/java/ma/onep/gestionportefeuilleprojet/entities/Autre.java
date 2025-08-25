package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class Autre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomAutre;
    @ManyToOne
    @JoinColumn(name = "partiesPrenantes_id")
    private PartiesPrenantes partiesPrenantes;
}
