package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeurNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.UtilisateurNotFoundException;

import java.util.List;

public interface UtilisateurRestController {

    public List<DemandeurDTO> findAllDemandeur();
    public DemandeurDTO findDemandeurById(Long id) throws UtilisateurNotFoundException;
    public DemandeurDTO findDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException;
    public DemandeurDTO saveDemandeur(DemandeurDTO demandeurDTO);
    public DemandeurDTO updateDemandeurById(DemandeurDTO demandeurDTO,Long id) throws UtilisateurNotFoundException;
    public DemandeurDTO updateDemandeurByMatricule(DemandeurDTO demandeurDTO,Long idMatricule) throws DemandeurNotFoundException;
    public void deleteDemandeurById(Long id) throws UtilisateurNotFoundException;
    public void deleteDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException;
}
