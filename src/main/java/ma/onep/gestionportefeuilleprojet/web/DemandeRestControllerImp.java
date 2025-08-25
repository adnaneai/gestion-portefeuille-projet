package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DemandeDTO;
import ma.onep.gestionportefeuilleprojet.enums.Statut;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.DemandeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class DemandeRestControllerImp implements DemandeRestController {
    private DemandeService demandeService;

    @Override
    public List<DemandeDTO> findAll() {
        return demandeService.findAll();
    }

    @Override
    public DemandeDTO findById(Long id) throws DemandeNotFoundException {
        return demandeService.findById(id);
    }

    @Override
    public List<DemandeDTO> findByStatut(Statut statut) throws DemandeNotFoundException {
        return demandeService.findByStatut(statut);
    }

    @Override
    public DemandeDTO findByDemandeurId(Long id) throws DemandeNotFoundException {
        return demandeService.findByDemandeurId(id);
    }

    @Override
    public DemandeDTO findByResponsablePMOId(Long id) throws DemandeNotFoundException {
        return demandeService.findByResponsablePMOId(id);
    }

    @Override
    public DemandeDTO save(DemandeDTO demandeDTO) {
        return demandeService.saveDemande(demandeDTO);
    }

    @Override
    public DemandeDTO updateById(DemandeDTO demandeDTO, Long id) throws DemandeNotFoundException {
        return demandeService.updateById(demandeDTO, id);
    }

    @Override
    public DemandeDTO updateByDemandeurId(DemandeDTO demandeDTO, Long id) throws DemandeNotFoundException {
        return demandeService.updateByDemandeurId(demandeDTO, id);
    }

    @Override
    public DemandeDTO updateByResponsablePMO(DemandeDTO demandeDTO, Long id) throws DemandeNotFoundException {
        return demandeService.updateByResponsablePMO(demandeDTO, id);
    }

    @Override
    public void deleteById(Long id) throws DemandeNotFoundException {
        demandeService.deleteById(id);
    }

    @Override
    public void deleteByDemandeurId(Long id) throws DemandeNotFoundException {
        demandeService.deleteByDemandeurId(id);
    }

    @Override
    public void deleteByResponsablePMO(Long id) throws DemandeNotFoundException {
        demandeService.deleteByResponsablePMO(id);
    }
}
