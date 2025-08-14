package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class IdentificationProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIdentificationProjet;
    private String idProjet;
    private String intituleProjet;
    private String typeProjet;
    private String etapeActuelleProjet;
    @OneToOne
    @JoinColumn(name = "identificationProjet")
    private Demande demande;
}
