package ma.onep.gestionportefeuilleprojet.dto;

import lombok.Getter;
import lombok.Setter;
import ma.onep.gestionportefeuilleprojet.enums.Statut;

@Getter @Setter
public class DemandeDTO {
    private Long idDemande;
    private Statut statut;
    private IdentificationProjetDTO identificationProjetDTO;
    private PartiesPrenantesDTO partiesPrenantesDTO;
    private ObjectifsProjetDTO objectifsProjetDTO;
    private DescriptionSommairePrestationsDTO descriptionSommairePrestationsDTO;
    private InformationsProjetDTO informationsProjetDTO;
    private ProjetsRelationDTO projetsRelationDTO;
    private AutresInformationDTO autresInformationDTO;
    private DemandeurDTO demandeur;
    private ResponsablePMODTO responsablePMO;

}
