package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.BeneficitaireDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.BeneficitaireNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/beneficitaires")
public interface BeneficitaireRestController {

    @GetMapping
    List<BeneficitaireDTO> getAllBeneficiaires();

    @GetMapping("/id/{id}")
    BeneficitaireDTO getBeneficitaireById(@PathVariable Long id) throws BeneficitaireNotFoundException;

    @GetMapping("/nom/{nomBeneficitaire}")
    List<BeneficitaireDTO> getBeneficiairesByNom(@PathVariable String nomBeneficitaire) throws BeneficitaireNotFoundException;

    @PostMapping
    BeneficitaireDTO createBeneficitaire(@RequestBody BeneficitaireDTO beneficitaireDTO) throws BeneficitaireNotFoundException;

    @PutMapping("/id/{id}")
    BeneficitaireDTO updateBeneficitaire(@PathVariable Long id, @RequestBody BeneficitaireDTO beneficitaireDTO) throws BeneficitaireNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteBeneficitaire(@PathVariable Long id) throws BeneficitaireNotFoundException;
}