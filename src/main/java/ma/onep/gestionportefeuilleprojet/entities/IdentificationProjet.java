package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class IdentificationProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIdentificationProjet;

    private String code;
    private String idProjet;
    private String intituleProjet;
    private String typeProjet;
    private String etapeActuelleProjet;

    // FK vers Demande si besoin bidirectionnel (optionnel)
    @OneToOne(mappedBy = "identificationProjet")
    private Demande demande;
}
