package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.BeneficitaireDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.BeneficitaireNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.BeneficitaireService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BeneficitaireRestControllerImp implements BeneficitaireRestController {

    private BeneficitaireService beneficitaireService;

    @Override
    public List<BeneficitaireDTO> getAllBeneficiaires() {
        return beneficitaireService.findAll();
    }

    @Override
    public BeneficitaireDTO getBeneficitaireById(Long id) throws BeneficitaireNotFoundException {
        return beneficitaireService.findById(id);
    }

    @Override
    public List<BeneficitaireDTO> getBeneficiairesByNom(String nomBeneficitaire) throws BeneficitaireNotFoundException {
        return beneficitaireService.findByNomBeneficitaire(nomBeneficitaire);
    }

    @Override
    public BeneficitaireDTO createBeneficitaire(BeneficitaireDTO beneficitaireDTO) throws BeneficitaireNotFoundException {
        return beneficitaireService.saveBeneficitaire(beneficitaireDTO);
    }

    @Override
    public BeneficitaireDTO updateBeneficitaire(Long id, BeneficitaireDTO beneficitaireDTO) throws BeneficitaireNotFoundException {
        return beneficitaireService.updateBeneficitaireById(id, beneficitaireDTO);
    }

    @Override
    public void deleteBeneficitaire(Long id) throws BeneficitaireNotFoundException {
        beneficitaireService.deleteBeneficitaireById(id);
    }
}