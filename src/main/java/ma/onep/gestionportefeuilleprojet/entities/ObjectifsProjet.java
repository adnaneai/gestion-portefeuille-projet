package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class ObjectifsProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjectifsProjet;
    private String description;
    @OneToOne
    @JoinColumn(name = "objectifsProjet")
    private Demande demande;
}
