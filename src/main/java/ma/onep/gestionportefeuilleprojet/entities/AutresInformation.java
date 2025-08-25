package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AutresInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutresInformation;

    @OneToMany(mappedBy = "autresInformation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Document> documents;

    @OneToOne(mappedBy = "autresInformation")
    private Demande demande;
}
