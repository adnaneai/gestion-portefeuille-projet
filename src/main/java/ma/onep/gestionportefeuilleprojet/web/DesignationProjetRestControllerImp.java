package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DesignationProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DesignationProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.DesignationProjetService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DesignationProjetRestControllerImp implements DesignationProjetRestController {

    private DesignationProjetService designationProjetService;

    @Override
    public List<DesignationProjetDTO> getAllDesignationsProjet() {
        return designationProjetService.findAllDesignationProjet();
    }

    @Override
    public DesignationProjetDTO getDesignationProjetById(Long id) throws DesignationProjetNotFoundException {
        return designationProjetService.findDesignationProjetById(id);
    }

    @Override
    public DesignationProjetDTO getDesignationProjetByNom(String nomDesignationProjet) throws DesignationProjetNotFoundException {
        return designationProjetService.findDesignationProjetByName(nomDesignationProjet);
    }

    @Override
    public DesignationProjetDTO createDesignationProjet(DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException {
        return designationProjetService.saveDesignationProjet(designationProjetDTO);
    }

    @Override
    public DesignationProjetDTO updateDesignationProjet(Long id, DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException {
        return designationProjetService.updateDesignationProjet(id, designationProjetDTO);
    }

    @Override
    public void deleteDesignationProjet(Long id) throws DesignationProjetNotFoundException {
        designationProjetService.deleteDesignationProjet(id);
    }
}