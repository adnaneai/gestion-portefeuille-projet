package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.ObjectifsProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.ObjectifsProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.ObjectifsProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ObjectifsProjetRestControllerImp implements ObjectifsProjetRestController {

    private ObjectifsProjetService objectifsProjetService;

    @Override
    public List<ObjectifsProjetDTO> getAllObjectifsProjet() {
        return objectifsProjetService.findAll();
    }

    @Override
    public ObjectifsProjetDTO getObjectifsProjetById(Long id) throws ObjectifsProjetNotFoundException {
        return objectifsProjetService.findById(id);
    }

    @Override
    public List<ObjectifsProjetDTO> getObjectifsProjetByNom(String nomObjectifsProjet) throws ObjectifsProjetNotFoundException {
        return objectifsProjetService.findByNomObjectifsProjet(nomObjectifsProjet);
    }

    @Override
    public ObjectifsProjetDTO createObjectifsProjet(ObjectifsProjetDTO objectifsProjetDTO) {
        return objectifsProjetService.saveObjectifsProjet(objectifsProjetDTO);
    }

    @Override
    public ObjectifsProjetDTO updateObjectifsProjet(Long id, ObjectifsProjetDTO objectifsProjetDTO) throws ObjectifsProjetNotFoundException {
        return objectifsProjetService.updateObjectifsProjet(id, objectifsProjetDTO);
    }

    @Override
    public void deleteObjectifsProjet(Long id) throws ObjectifsProjetNotFoundException {
        objectifsProjetService.deleteObjectifsProjet(id);
    }
}