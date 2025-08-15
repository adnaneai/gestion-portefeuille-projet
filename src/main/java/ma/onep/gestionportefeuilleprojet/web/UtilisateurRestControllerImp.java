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
public class UtilisateurRestControllerImp implements  UtilisateurRestController {
    private UtilisateurService utilisateurService;

    @Override
    @GetMapping("/utilisateurs")
    public List<UtilisateurDTO> findAllUtilisateurs() {
        return utilisateurService.findAll();
    }

    @Override
    @GetMapping("/demandeurs")
    public List<DemandeurDTO> findAllDemandeur() {
        return utilisateurService.findAllDemandeur();
    }

    @Override
    @GetMapping("/responsablepmos")
    public List<ResponsablePMODTO> findAllResponsablePMO() {
        return utilisateurService.findAllResponsablePMO();
    }

    @Override
    @GetMapping("/demandeurs/id/{id}")
    public DemandeurDTO findDemandeurById(@PathVariable(name = "id") Long id) throws UtilisateurNotFoundException {
        return utilisateurService.findDemandeurById(id);
    }

    @Override
    @GetMapping("/demandeurs/matricule/{idMatricule}")
    public DemandeurDTO findDemandeurByMatricule(@PathVariable(name = "idMatricule") Long idMatricule) throws DemandeurNotFoundException {
        return utilisateurService.findDemandeurByMatricule(idMatricule);
    }

    @Override
    @GetMapping("/responsablepmos/id/{id}")
    public ResponsablePMODTO findResponsablePMOById(@PathVariable(name = "id") Long id) throws ResponsablePMONotFoundException {
        return utilisateurService.findResponsablePMOById(id);
    }

    @Override
    @PostMapping("/demandeurs")
    public DemandeurDTO saveDemandeur(@RequestBody DemandeurDTO demandeurDTO) {
        return utilisateurService.saveDemandeur(demandeurDTO);
    }

    @Override
    @PostMapping("/responsablepmos")
    public ResponsablePMODTO saveResponsablePMO(@RequestBody ResponsablePMODTO responsablePMODTO) {
        return utilisateurService.saveResponsablePMO(responsablePMODTO);
    }

    @Override
    @PutMapping("/demandeurs/id/{id}")
    public DemandeurDTO updateDemandeurById(@RequestBody DemandeurDTO demandeurDTO,@PathVariable(name = "id") Long id) throws UtilisateurNotFoundException {
        return utilisateurService.updateDemandeurById(demandeurDTO,id);
    }

    @Override
    @PutMapping("/demandeurs/matricule/{idMatricule}")
    public DemandeurDTO updateDemandeurByMatricule(@RequestBody DemandeurDTO demandeurDTO,@PathVariable(name = "idMatricule") Long idMatricule) throws DemandeurNotFoundException {
        return utilisateurService.updateDemandeurByMatricule(demandeurDTO,idMatricule);
    }

    @Override
    @PutMapping("/responsablepmos/id/{id}")
    public ResponsablePMODTO updateResponsablePMO(@RequestBody ResponsablePMODTO responsablePMODTO,@PathVariable(name = "id") Long id) throws ResponsablePMONotFoundException {
        return utilisateurService.updateResponsablePMOById(responsablePMODTO,id);
    }

    @Override
    @DeleteMapping("/demandeurs/id/{id}")
    public void deleteDemandeurById(@PathVariable(name = "id") Long id) throws UtilisateurNotFoundException {
        utilisateurService.deleteDemandeurById(id);
    }

    @Override
    @DeleteMapping("/demandeurs/matricule/{idMatricule}")
    public void deleteDemandeurByMatricule(@PathVariable(name = "idMatricule") Long idMatricule) throws DemandeurNotFoundException {
        utilisateurService.deleteDemandeurByMatricule(idMatricule);
    }

    @Override
    @DeleteMapping("/responsablepmos/id/{id}")
    public void deleteResponsableById(@PathVariable(name = "id") Long id) throws ResponsablePMONotFoundException {
        utilisateurService.deleteResponsablePMOById(id);
    }
}
