package ma.onep.gestionportefeuilleprojet.dto;

import lombok.Getter;
import lombok.Setter;
import ma.onep.gestionportefeuilleprojet.entities.*;

@Getter @Setter
public class DemandeDTO {
    private Long idDemande;
    private IdentificationProjet identificationProjet;
    private PartiesPrenantes partiesPrenantes;
    private ObjectifsProjet objectifsProjet;
    private DescriptionSommairePrestations descriptionSommairePrestations;
    private InformationsProjet informationsProjet;
    private ProjetsRelation projetsRelation;
    private AutresInformation autresInformation;
}
