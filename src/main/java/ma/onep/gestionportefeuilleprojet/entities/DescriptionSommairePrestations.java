package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DescriptionSommairePrestations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDescriptionSommairePrestations;

    private String nomDescriptionSommairePrestations;

    @OneToOne(mappedBy = "descriptionSommairePrestations")
    private Demande demande;
}
