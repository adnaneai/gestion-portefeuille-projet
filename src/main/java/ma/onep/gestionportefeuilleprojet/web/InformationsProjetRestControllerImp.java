package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.InformationsProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.InformationsProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.InformationsProjetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class InformationsProjetRestControllerImp implements InformationsProjetRestController {

    private InformationsProjetService informationsProjetService;

    @Override
    public List<InformationsProjetDTO> getAllInformationsProjets() {
        return informationsProjetService.findAllInformationsProjets();
    }

    @Override
    public InformationsProjetDTO getInformationsProjetById(Long id) throws InformationsProjetNotFoundException {
        return informationsProjetService.findInformationsProjetById(id);
    }

    @Override
    public List<InformationsProjetDTO> getInformationsProjetByDateDemarrage(Date date) throws InformationsProjetNotFoundException {
        return informationsProjetService.findInformationProjetByDateDemarrage(date);
    }

    @Override
    public List<InformationsProjetDTO> getInformationsProjetByDuree(String duree) throws InformationsProjetNotFoundException {
        return informationsProjetService.findInformationProjetByDuree(duree);
    }

    @Override
    public List<InformationsProjetDTO> getInformationsProjetByCout(float cout) throws InformationsProjetNotFoundException {
        return informationsProjetService.findInformationsProjetCout(cout);
    }

    @Override
    public InformationsProjetDTO createInformationsProjet(InformationsProjetDTO informationsProjetDTO) {
        return informationsProjetService.saveInformationsProjet(informationsProjetDTO);
    }

    @Override
    public InformationsProjetDTO updateInformationsProjet(Long id, InformationsProjetDTO informationsProjetDTO) throws InformationsProjetNotFoundException {
        return informationsProjetService.updateInformationsProjet(id, informationsProjetDTO);
    }

    @Override
    public void deleteInformationsProjet(Long id) throws InformationsProjetNotFoundException {
        informationsProjetService.deleteInformationsProjet(id);
    }
}