package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.InformationsProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.InformationsProjet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class InformationsProjetMapperImp implements InformationsProjetMapper {

    @Override
    public InformationsProjetDTO fromInformationsProjet(InformationsProjet informations) {
        InformationsProjetDTO dto = new InformationsProjetDTO();
        BeanUtils.copyProperties(informations, dto);
        return dto;
    }

    @Override
    public InformationsProjet fromInformationsProjetDTO(InformationsProjetDTO informations) {
        InformationsProjet entity = new InformationsProjet();
        BeanUtils.copyProperties(informations, entity);
        return entity;
    }
}
