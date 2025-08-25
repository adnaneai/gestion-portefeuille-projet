package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.onep.gestionportefeuilleprojet.enums.TypeDocument;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocument;
    private String nom;
    private TypeDocument typeDocument;
    private String url;
    @ManyToOne
    @JoinColumn(name = "autresInformation_id")
    private AutresInformation autresInformation;
}
