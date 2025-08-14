package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.onep.gestionportefeuilleprojet.enums.Statut;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDemande;
    private Statut status;
    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private IdentificationProjet identificationProjet;
    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PartiesPrenantes partiesPrenantes;
    @OneToOne(mappedBy = "demande",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ObjectifsProjet objectifsProjet;
    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DescriptionSommairePrestations descriptionSommairePrestations;
    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private InformationsProjet informationsProjet;
    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProjetsRelation projetsRelation;
    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AutresInformation autresInformation;
    @ManyToOne
    @JoinColumn(name = "demandeur_id")
    private Demandeur demandeur;
    @ManyToOne
    @JoinColumn(name = "responsablePMO_id")
    private ResponsablePMO responsablePMO;
}
