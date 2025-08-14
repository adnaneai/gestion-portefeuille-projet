package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class DescriptionSommairePrestations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDescriptionSommairePrestations;
    private String description;
    @OneToOne
    @JoinColumn(name = "descriptionSommairePrestations")
    private Demande demande;
}
