package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.ObjectifsProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.ObjectifsProjet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ObjectifsProjetMapperImp implements ObjectifsProjetMapper {

    @Override
    public ObjectifsProjetDTO fromObjectifsProjet(ObjectifsProjet objectifsProjet) {
        ObjectifsProjetDTO dto = new ObjectifsProjetDTO();
        BeanUtils.copyProperties(objectifsProjet, dto);
        return dto;
    }

    @Override
    public ObjectifsProjet fromObjectifsProjetDTO(ObjectifsProjetDTO objectifsProjetDTO) {
        ObjectifsProjet entity = new ObjectifsProjet();
        BeanUtils.copyProperties(objectifsProjetDTO, entity);
        return entity;
    }
}
