package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.BeneficitaireDTO;
import ma.onep.gestionportefeuilleprojet.entities.Beneficitaire;

public interface BeneficitaireMapper {
    public BeneficitaireDTO fromBeneficitaire(Beneficitaire beneficitaire);
    public Beneficitaire fromBeneficitaireDTO(BeneficitaireDTO beneficitaireDTO);
}
