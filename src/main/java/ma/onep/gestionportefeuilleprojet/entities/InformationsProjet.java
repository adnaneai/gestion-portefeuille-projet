package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InformationsProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformationsProjet;

    private Date dateDemarrage;
    private String duree;
    private float cout;

    @OneToOne(mappedBy = "informationsProjet")
    private Demande demande;
}
