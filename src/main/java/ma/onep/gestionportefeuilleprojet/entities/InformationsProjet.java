package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class InformationsProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInformationsProjet;
    private Date dateDemarrage;
    private String duree;
    private float cout;
    @OneToOne
    @JoinColumn(name = "informationsProjet")
    private Demande demande;
}
