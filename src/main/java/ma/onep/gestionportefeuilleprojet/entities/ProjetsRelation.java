package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProjetsRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjetRelation;

    @OneToMany(mappedBy = "projetsRelation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DesignationProjet>  designationProjets;

    @OneToMany(mappedBy = "projetsRelation",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TypeRelation> typeRelations;

    @OneToOne(mappedBy = "projetsRelation")
    private Demande demande;
}
