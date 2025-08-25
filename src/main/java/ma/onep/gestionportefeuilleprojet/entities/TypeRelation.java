package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class TypeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomTypeRelation;
    @ManyToOne
    @JoinColumn(name = "projetsRelation")
    private ProjetsRelation projetsRelation;
}
