package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.dto.UtilisateurDTO;
import ma.onep.gestionportefeuilleprojet.entities.Demandeur;
import ma.onep.gestionportefeuilleprojet.entities.ResponsablePMO;
import ma.onep.gestionportefeuilleprojet.entities.Utilisateur;

public interface UtilisateurMapper {
    public UtilisateurDTO fromUtilisateur(Utilisateur utilisateur);
    public Utilisateur  fromUtilisateurDTO(UtilisateurDTO utilisateurDTO);
    public DemandeurDTO fromDemandeur(Demandeur demandeur);
    public Demandeur fromDemandeurDTO(DemandeurDTO demandeurDTO);
    public ResponsablePMODTO fromResponsablePMO(ResponsablePMO responsablePMO);
    public ResponsablePMO fromResponsablePMODTO(ResponsablePMODTO responsablePMODTO);
}
