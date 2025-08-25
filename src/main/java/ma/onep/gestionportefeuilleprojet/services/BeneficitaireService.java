package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.BeneficitaireDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.BeneficitaireNotFoundException;

import java.util.List;

public interface BeneficitaireService {
    public List<BeneficitaireDTO>  findAll();
    public BeneficitaireDTO findById(Long id) throws BeneficitaireNotFoundException;
    public List<BeneficitaireDTO> findByNomBeneficitaire(String nomBeneficitaire) throws BeneficitaireNotFoundException;
    public BeneficitaireDTO saveBeneficitaire(BeneficitaireDTO beneficitaire) throws BeneficitaireNotFoundException;
    public BeneficitaireDTO updateBeneficitaireById(Long id,BeneficitaireDTO beneficitaireDTO) throws BeneficitaireNotFoundException;
    public void deleteBeneficitaireById(Long id) throws BeneficitaireNotFoundException;
}
