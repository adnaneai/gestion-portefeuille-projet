package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.PartiesPrenantesDTO;
import ma.onep.gestionportefeuilleprojet.entities.PartiesPrenantes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PartiesPrenantesMapperImp implements PartiesPrenantesMapper {

    @Override
    public PartiesPrenantesDTO fromPartiesPrenante(PartiesPrenantes partiesPrenantes) {
        PartiesPrenantesDTO dto = new PartiesPrenantesDTO();
        BeanUtils.copyProperties(partiesPrenantes, dto);
        return dto;
    }

    @Override
    public PartiesPrenantes fromPartiesPrenanteDTO(PartiesPrenantesDTO partiesPrenantesDTO) {
        PartiesPrenantes entity = new PartiesPrenantes();
        BeanUtils.copyProperties(partiesPrenantesDTO, entity);
        return entity;
    }
}
