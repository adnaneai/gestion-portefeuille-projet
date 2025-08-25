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

    private Statut statut;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "identification_projet_id")
    private IdentificationProjet identificationProjet;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parties_prenantes_id")
    private PartiesPrenantes partiesPrenantes;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "objectifs_projet_id")
    private ObjectifsProjet objectifsProjet;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "description_sommaire_prestations_id")
    private DescriptionSommairePrestations descriptionSommairePrestations;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "informations_projet_id")
    private InformationsProjet informationsProjet;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "projets_relation_id")
    private ProjetsRelation projetsRelation;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "autres_information_id")
    private AutresInformation autresInformation;

    @ManyToOne
    @JoinColumn(name = "demandeur_id")
    private Demandeur demandeur;

    @ManyToOne
    @JoinColumn(name = "responsable_pmo_id")
    private ResponsablePMO responsablePMO;
}
