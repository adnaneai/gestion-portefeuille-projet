package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.TypeRelationDTO;
import ma.onep.gestionportefeuilleprojet.entities.TypeRelation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TypeRelationMapperImp implements TypeRelationMapper {

    @Override
    public TypeRelationDTO fromTypeRelation(TypeRelation typeRelation) {
        TypeRelationDTO dto = new TypeRelationDTO();
        BeanUtils.copyProperties(typeRelation, dto);
        return dto;
    }

    @Override
    public TypeRelation fromTypeRelationDTO(TypeRelationDTO typeRelationDTO) {
        TypeRelation entity = new TypeRelation();
        BeanUtils.copyProperties(typeRelationDTO, entity);
        return entity;
    }
}
