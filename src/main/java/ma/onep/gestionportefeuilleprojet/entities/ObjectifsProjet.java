package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ObjectifsProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjectifsProjet;

    private String nomObjectifsProjet;

    @OneToOne(mappedBy = "objectifsProjet")
    private Demande demande;
}
