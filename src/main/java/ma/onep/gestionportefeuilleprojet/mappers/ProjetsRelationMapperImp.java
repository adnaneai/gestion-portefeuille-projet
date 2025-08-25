package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.ProjetsRelationDTO;
import ma.onep.gestionportefeuilleprojet.entities.ProjetsRelation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProjetsRelationMapperImp implements ProjetsRelationMapper {

    @Override
    public ProjetsRelationDTO fromProjetsRelation(ProjetsRelation projetsRelation) {
        ProjetsRelationDTO dto = new ProjetsRelationDTO();
        BeanUtils.copyProperties(projetsRelation, dto);
        return dto;
    }

    @Override
    public ProjetsRelation fromProjetsRelationDTO(ProjetsRelationDTO projetsRelationDTO) {
        ProjetsRelation entity = new ProjetsRelation();
        BeanUtils.copyProperties(projetsRelationDTO, entity);
        return entity;
    }
}
