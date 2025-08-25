package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.AutreDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.AutreNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.AutreService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AutreRestControllerImp implements AutreRestController {

    private final AutreService autreService;

    @Override
    public List<AutreDTO> getAllAutres() {
        return autreService.findAll();
    }

    @Override
    public AutreDTO getAutreById(Long id) throws AutreNotFoundException {
        return autreService.findById(id);
    }

    @Override
    public AutreDTO createAutre(AutreDTO autreDTO) throws AutreNotFoundException {
        return autreService.save(autreDTO);
    }

    @Override
    public AutreDTO updateAutre(Long id, AutreDTO autreDTO) throws AutreNotFoundException {
        return autreService.update(id,autreDTO);
    }
    @Override
    public void deleteAutre(Long id) throws AutreNotFoundException {
        autreService.delete(id);
    }
}