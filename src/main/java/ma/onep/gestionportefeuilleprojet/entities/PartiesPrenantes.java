package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class PartiesPrenantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartiesPrenantes;
    private String moa;
    private String moe;
    private String amo;
    private String beneficitaire;
    private List<String> autres;
    @OneToOne
    @JoinColumn(name = "partiesPreantes")
    private Demande demande;
}
