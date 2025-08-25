package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.PartiesPrenantesDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.PartiesPrenantesNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.PartiesPrenantesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class PartiesPrenantesRestControllerImp implements PartiesPrenantesRestController {

    private PartiesPrenantesService partiesPrenantesService;

    @Override
    public List<PartiesPrenantesDTO> getAllPartiesPrenantes() {
        return partiesPrenantesService.findAll();
    }

    @Override
    public PartiesPrenantesDTO getPartiesPrenantesById(Long id) throws PartiesPrenantesNotFoundException {
        return partiesPrenantesService.findById(id);
    }

    @Override
    public List<PartiesPrenantesDTO> getPartiesPrenantesByMOA(String moa) throws PartiesPrenantesNotFoundException {
        return partiesPrenantesService.findAllPartiesPrenantesByMOA(moa);
    }

    @Override
    public List<PartiesPrenantesDTO> getPartiesPrenantesByMOE(String moe) throws PartiesPrenantesNotFoundException {
        return partiesPrenantesService.findAllPartiesPrenantesByMOE(moe);
    }

    @Override
    public List<PartiesPrenantesDTO> getPartiesPrenantesByAMO(String amo) throws PartiesPrenantesNotFoundException {
        return partiesPrenantesService.findAllPartiesPrenantesByAMO(amo);
    }

    @Override
    public PartiesPrenantesDTO createPartiesPrenantes(PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException {
        return partiesPrenantesService.savePartiesPrenantes(partiesPrenantesDTO);
    }

    @Override
    public PartiesPrenantesDTO updatePartiesPrenantes(Long id, PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException {
        return partiesPrenantesService.updatePartiesPrenantesById(id, partiesPrenantesDTO);
    }

    @Override
    public void deletePartiesPrenantes(Long id) throws PartiesPrenantesNotFoundException {
        partiesPrenantesService.deletePartiesPrenantesById(id);
    }
}