package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.dto.UtilisateurDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeurNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.UtilisateurNotFoundException;

import java.util.List;

public interface UtilisateurService {
    public List<UtilisateurDTO> findAll();
    public List<DemandeurDTO> findAllDemandeur();
    public List<ResponsablePMODTO> findAllResponsablePMO();
    public DemandeurDTO findDemandeurById(Long id) throws UtilisateurNotFoundException;
    public DemandeurDTO findDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException;
    public ResponsablePMODTO findResponsablePMOById(Long id) throws UtilisateurNotFoundException;
    public DemandeurDTO saveDemandeur(DemandeurDTO demandeurDTO);
    public ResponsablePMODTO saveResponsablePMO(ResponsablePMODTO responsablePMODTO);
    public DemandeurDTO updateDemandeurById(DemandeurDTO demandeurDTO,Long id) throws  UtilisateurNotFoundException;
    public DemandeurDTO updateDemandeurByMatricule(DemandeurDTO demandeurDTO,Long idMatricule) throws  DemandeurNotFoundException;
    public ResponsablePMODTO updateResponsablePMOById(ResponsablePMODTO  responsablePMODTO,Long id) throws UtilisateurNotFoundException;
    public void deleteDemandeurById(Long id) throws UtilisateurNotFoundException;
    public void deleteResponsablePMOById(Long id) throws UtilisateurNotFoundException;
    public void deleteDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException;
}
