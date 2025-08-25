package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.IdentificationProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.IdentificationProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.IdentificationProjetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class IdentificationProjetRestControllerImp implements IdentificationProjetRestController {

    private IdentificationProjetService identificationProjetService;

    @Override
    public List<IdentificationProjetDTO> getAllIdentificationProjets() {
        return identificationProjetService.findAllIdentificationProjets();
    }

    @Override
    public IdentificationProjetDTO getIdentificationProjetById(Long id) throws IdentificationProjetNotFoundException {
        return identificationProjetService.findByIdIdentificationProjet(id);
    }

    @Override
    public IdentificationProjetDTO getIdentificationProjetByCode(String code) throws IdentificationProjetNotFoundException {
        return identificationProjetService.findByCodeIdentificationProjet(code);
    }

    @Override
    public IdentificationProjetDTO getIdentificationProjetByIdProjet(String idProjet) throws IdentificationProjetNotFoundException {
        return identificationProjetService.findByIdProjetIdentificationProjet(idProjet);
    }

    @Override
    public IdentificationProjetDTO getIdentificationProjetByIntitule(String intitule) throws IdentificationProjetNotFoundException {
        return identificationProjetService.findByIntituleProjetIdentificationProjet(intitule);
    }

    @Override
    public IdentificationProjetDTO createIdentificationProjet(IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {
        return identificationProjetService.saveIdentificationProjet(identificationProjetDTO);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetById(Long id, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {
        return identificationProjetService.updateIdentificationProjetByIdIdentificationProjet(id, identificationProjetDTO);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetByCode(String code, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {
        return identificationProjetService.updateIdentificationProjetByCode(code, identificationProjetDTO);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetByIdProjet(String idProjet, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {
        return identificationProjetService.updateIdentificationProjetByIdProjet(idProjet, identificationProjetDTO);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetByIntitule(String intitule, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {
        return identificationProjetService.updateIdentificationProjetByIntituleProjet(intitule, identificationProjetDTO);
    }

    @Override
    public void deleteIdentificationProjetById(Long id) throws IdentificationProjetNotFoundException {
        identificationProjetService.deleteIdentificationProjetByIdIdentificationProjet(id);
    }

    @Override
    public void deleteIdentificationProjetByCode(String code) throws IdentificationProjetNotFoundException {
        identificationProjetService.deleteIdentificationProjetByCodeIdentificationProjet(code);
    }

    @Override
    public void deleteIdentificationProjetByIdProjet(String idProjet) throws IdentificationProjetNotFoundException {
        identificationProjetService.deleteIdentificationProjetByIdProjet(idProjet);
    }

    @Override
    public void deleteIdentificationProjetByIntitule(String intitule) throws IdentificationProjetNotFoundException {
        identificationProjetService.deleteIdentificationProjetByIntituleProjet(intitule);
    }
}