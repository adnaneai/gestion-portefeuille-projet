package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.dto.UtilisateurDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeurNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.ResponsablePMONotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.UtilisateurNotFoundException;

import java.util.List;

public interface UtilisateurRestController {

    public List<UtilisateurDTO> findAllUtilisateurs();
    public List<DemandeurDTO> findAllDemandeur();
    public List<ResponsablePMODTO> findAllResponsablePMO();
    public DemandeurDTO findDemandeurById(Long id) throws UtilisateurNotFoundException;
    public DemandeurDTO findDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException;
    public ResponsablePMODTO findResponsablePMOById(Long id) throws ResponsablePMONotFoundException;
    public DemandeurDTO saveDemandeur(DemandeurDTO demandeurDTO);
    public ResponsablePMODTO saveResponsablePMO(ResponsablePMODTO responsablePMODTO);
    public DemandeurDTO updateDemandeurById(DemandeurDTO demandeurDTO,Long id) throws UtilisateurNotFoundException;
    public DemandeurDTO updateDemandeurByMatricule(DemandeurDTO demandeurDTO,Long idMatricule) throws DemandeurNotFoundException;
    public ResponsablePMODTO updateResponsablePMO(ResponsablePMODTO responsablePMODTO,Long id) throws ResponsablePMONotFoundException;
    public void deleteDemandeurById(Long id) throws UtilisateurNotFoundException;
    public void deleteDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException;
    public void deleteResponsableById(Long id) throws ResponsablePMONotFoundException;
}
