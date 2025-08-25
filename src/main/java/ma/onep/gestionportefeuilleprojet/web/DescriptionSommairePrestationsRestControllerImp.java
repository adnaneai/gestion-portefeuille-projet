package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DescriptionSommairePrestationsDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DescriptionSommairePrestationsNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.DescriptionSommairePrestationsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class DescriptionSommairePrestationsRestControllerImp implements DescriptionSommairePrestationsRestController {

    private DescriptionSommairePrestationsService descriptionSommairePrestationsService;

    @Override
    public List<DescriptionSommairePrestationsDTO> getAllDescriptionSommairePrestations() {
        return descriptionSommairePrestationsService.findAllDescriptionSommairePrestations();
    }

    @Override
    public DescriptionSommairePrestationsDTO getDescriptionSommairePrestationsById(Long id) throws DescriptionSommairePrestationsNotFoundException {
        return descriptionSommairePrestationsService.findDescriptionSommairePrestationsById(id);
    }

    @Override
    public DescriptionSommairePrestationsDTO createDescriptionSommairePrestations(DescriptionSommairePrestationsDTO descriptionSommairePrestationsDTO) {
        return descriptionSommairePrestationsService.saveDescriptionSommairePrestations(descriptionSommairePrestationsDTO);
    }

    @Override
    public DescriptionSommairePrestationsDTO updateDescriptionSommairePrestations(Long id, DescriptionSommairePrestationsDTO descriptionSommairePrestationsDTO) throws DescriptionSommairePrestationsNotFoundException {
        return descriptionSommairePrestationsService.updateDescriptionSommairePrestations(id, descriptionSommairePrestationsDTO);
    }

    @Override
    public void deleteDescriptionSommairePrestations(Long id) throws DescriptionSommairePrestationsNotFoundException {
        descriptionSommairePrestationsService.deleteDescriptionSommairePrestations(id);
    }
}