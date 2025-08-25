package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.IdentificationProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.IdentificationProjet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class IdentificationProjetMapperImp implements IdentificationProjetMapper {

    @Override
    public IdentificationProjetDTO fromIdentificationProjet(IdentificationProjet identificationProjet) {
        IdentificationProjetDTO dto = new IdentificationProjetDTO();
        BeanUtils.copyProperties(identificationProjet, dto);
        return dto;
    }

    @Override
    public IdentificationProjet fromIdentificationProjetDTO(IdentificationProjetDTO identificationProjetDTO) {
        IdentificationProjet entity = new IdentificationProjet();
        BeanUtils.copyProperties(identificationProjetDTO, entity);
        return entity;
    }
}
