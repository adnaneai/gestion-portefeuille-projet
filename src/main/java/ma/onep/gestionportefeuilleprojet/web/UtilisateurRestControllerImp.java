package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.dto.UtilisateurDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeurNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.ResponsablePMONotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.UtilisateurNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class UtilisateurRestControllerImp implements UtilisateurRestController {
    private final UtilisateurService utilisateurService;

    @Override
    public List<UtilisateurDTO> findAllUtilisateurs() {
        return utilisateurService.findAll();
    }

    @Override
    public List<DemandeurDTO> findAllDemandeur() {
        return utilisateurService.findAllDemandeur();
    }

    @Override
    public List<ResponsablePMODTO> findAllResponsablePMO() {
        return utilisateurService.findAllResponsablePMO();
    }

    @Override
    public DemandeurDTO findDemandeurById(Long id) throws UtilisateurNotFoundException {
        return utilisateurService.findDemandeurById(id);
    }

    @Override
    public DemandeurDTO findDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException {
        return utilisateurService.findDemandeurByMatricule(idMatricule);
    }

    @Override
    public ResponsablePMODTO findResponsablePMOById(Long id) throws ResponsablePMONotFoundException {
        return utilisateurService.findResponsablePMOById(id);
    }

    @Override
    public DemandeurDTO saveDemandeur(DemandeurDTO demandeurDTO) {
        return utilisateurService.saveDemandeur(demandeurDTO);
    }

    @Override
    public ResponsablePMODTO saveResponsablePMO(ResponsablePMODTO responsablePMODTO) {
        return utilisateurService.saveResponsablePMO(responsablePMODTO);
    }

    @Override
    public DemandeurDTO updateDemandeurById(DemandeurDTO demandeurDTO, Long id) throws UtilisateurNotFoundException {
        return utilisateurService.updateDemandeurById(demandeurDTO, id);
    }

    @Override
    public DemandeurDTO updateDemandeurByMatricule(DemandeurDTO demandeurDTO, Long idMatricule) throws DemandeurNotFoundException {
        return utilisateurService.updateDemandeurByMatricule(demandeurDTO, idMatricule);
    }

    @Override
    public ResponsablePMODTO updateResponsablePMO(ResponsablePMODTO responsablePMODTO, Long id) throws ResponsablePMONotFoundException {
        return utilisateurService.updateResponsablePMOById(responsablePMODTO, id);
    }

    @Override
    public void deleteDemandeurById(Long id) throws UtilisateurNotFoundException {
        utilisateurService.deleteDemandeurById(id);
    }

    @Override
    public void deleteDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException {
        utilisateurService.deleteDemandeurByMatricule(idMatricule);
    }

    @Override
    public void deleteResponsableById(Long id) throws ResponsablePMONotFoundException {
        utilisateurService.deleteResponsablePMOById(id);
    }
}
