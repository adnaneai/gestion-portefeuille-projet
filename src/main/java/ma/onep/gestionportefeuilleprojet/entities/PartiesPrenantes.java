package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PartiesPrenantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartiesPrenantes;

    private String moa;
    private String moe;
    private String amo;
    @OneToMany(mappedBy = "partiesPrenantes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Beneficitaire> beneficitaires;
    @OneToMany(mappedBy = "partiesPrenantes",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autre> autres;
    @OneToOne(mappedBy = "partiesPrenantes")
    private Demande demande;
}
