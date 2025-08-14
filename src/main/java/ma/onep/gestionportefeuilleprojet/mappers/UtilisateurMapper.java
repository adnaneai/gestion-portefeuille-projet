package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.entities.Demandeur;
import ma.onep.gestionportefeuilleprojet.entities.ResponsablePMO;

public interface UtilisateurMapper {
    public DemandeurDTO fromDemandeur(Demandeur demandeur);
    public Demandeur fromDemandeurDTO(DemandeurDTO demandeurDTO);
    public ResponsablePMODTO fromResponsablePMO(ResponsablePMO responsablePMO);
    public ResponsablePMO fromResponsablePMODTO(ResponsablePMODTO responsablePMODTO);
}
