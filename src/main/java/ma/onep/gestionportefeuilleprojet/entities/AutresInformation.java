package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class AutresInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutresInformation;
    private List<String> descriptions;
    @OneToOne
    @JoinColumn(name = "autresInformation")
    private Demande demande;
}
