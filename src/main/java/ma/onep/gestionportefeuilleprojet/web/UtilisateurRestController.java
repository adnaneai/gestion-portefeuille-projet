package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.dto.UtilisateurDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeurNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.ResponsablePMONotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.UtilisateurNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public interface UtilisateurRestController {

    @GetMapping("/utilisateurs")
    List<UtilisateurDTO> findAllUtilisateurs();

    @GetMapping("/demandeurs")
    List<DemandeurDTO> findAllDemandeur();

    @GetMapping("/responsablepmos")
    List<ResponsablePMODTO> findAllResponsablePMO();

    @GetMapping("/demandeurs/id/{id}")
    DemandeurDTO findDemandeurById(@PathVariable("id") Long id) throws UtilisateurNotFoundException;

    @GetMapping("/demandeurs/matricule/{idMatricule}")
    DemandeurDTO findDemandeurByMatricule(@PathVariable("idMatricule") Long idMatricule) throws DemandeurNotFoundException;

    @GetMapping("/responsablepmos/id/{id}")
    ResponsablePMODTO findResponsablePMOById(@PathVariable("id") Long id) throws ResponsablePMONotFoundException;

    @PostMapping("/demandeurs")
    DemandeurDTO saveDemandeur(@RequestBody DemandeurDTO demandeurDTO);

    @PostMapping("/responsablepmos")
    ResponsablePMODTO saveResponsablePMO(@RequestBody ResponsablePMODTO responsablePMODTO);

    @PutMapping("/demandeurs/id/{id}")
    DemandeurDTO updateDemandeurById(@RequestBody DemandeurDTO demandeurDTO,
                                     @PathVariable("id") Long id) throws UtilisateurNotFoundException;

    @PutMapping("/demandeurs/matricule/{idMatricule}")
    DemandeurDTO updateDemandeurByMatricule(@RequestBody DemandeurDTO demandeurDTO,
                                            @PathVariable("idMatricule") Long idMatricule) throws DemandeurNotFoundException;

    @PutMapping("/responsablepmos/id/{id}")
    ResponsablePMODTO updateResponsablePMO(@RequestBody ResponsablePMODTO responsablePMODTO,
                                           @PathVariable("id") Long id) throws ResponsablePMONotFoundException;

    @DeleteMapping("/demandeurs/id/{id}")
    void deleteDemandeurById(@PathVariable("id") Long id) throws UtilisateurNotFoundException;

    @DeleteMapping("/demandeurs/matricule/{idMatricule}")
    void deleteDemandeurByMatricule(@PathVariable("idMatricule") Long idMatricule) throws DemandeurNotFoundException;

    @DeleteMapping("/responsablepmos/id/{id}")
    void deleteResponsableById(@PathVariable("id") Long id) throws ResponsablePMONotFoundException;
}
