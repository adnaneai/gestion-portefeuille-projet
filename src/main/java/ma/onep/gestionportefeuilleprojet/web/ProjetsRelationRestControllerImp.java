package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.ProjetsRelationDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.ProjetsRelationNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.ProjetsRelationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ProjetsRelationRestControllerImp implements ProjetsRelationRestController {

    private final ProjetsRelationService projetsRelationService;

    @Override
    public List<ProjetsRelationDTO> getAllProjetsRelations() {
        return projetsRelationService.findAllProjetRelation();
    }

    @Override
    public ProjetsRelationDTO getProjetsRelationById(Long id) throws ProjetsRelationNotFoundException {
        return projetsRelationService.findProjetRelationById(id);
    }

    @Override
    public ProjetsRelationDTO createProjetsRelation(ProjetsRelationDTO projetsRelationDTO) {
        return projetsRelationService.saveProjetRelation(projetsRelationDTO);
    }

    @Override
    public ProjetsRelationDTO updateProjetsRelation(Long id, ProjetsRelationDTO projetsRelationDTO) throws ProjetsRelationNotFoundException {
        return projetsRelationService.updateProjetRelation(id, projetsRelationDTO);
    }

    @Override
    public ProjetsRelationDTO deleteProjetsRelation(Long id) throws ProjetsRelationNotFoundException {
        return projetsRelationService.deleteProjetRelation(id);
    }
}