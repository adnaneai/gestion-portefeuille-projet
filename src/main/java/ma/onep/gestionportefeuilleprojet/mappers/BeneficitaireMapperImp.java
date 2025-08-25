package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.BeneficitaireDTO;
import ma.onep.gestionportefeuilleprojet.entities.Beneficitaire;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BeneficitaireMapperImp implements BeneficitaireMapper {

    @Override
    public BeneficitaireDTO fromBeneficitaire(Beneficitaire beneficitaire) {
        BeneficitaireDTO beneficitaireDTO = new BeneficitaireDTO();
        BeanUtils.copyProperties(beneficitaire, beneficitaireDTO);
        return beneficitaireDTO;
    }

    @Override
    public Beneficitaire fromBeneficitaireDTO(BeneficitaireDTO beneficitaireDTO) {
        Beneficitaire beneficitaire = new Beneficitaire();
        BeanUtils.copyProperties(beneficitaireDTO, beneficitaire);
        return beneficitaire;
    }
}
