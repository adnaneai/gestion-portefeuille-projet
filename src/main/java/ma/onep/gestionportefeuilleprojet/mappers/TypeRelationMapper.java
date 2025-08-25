package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.TypeRelationDTO;
import ma.onep.gestionportefeuilleprojet.entities.TypeRelation;

public interface TypeRelationMapper {
    public TypeRelationDTO fromTypeRelation(TypeRelation typeRelation);
    public TypeRelation fromTypeRelationDTO(TypeRelationDTO typeRelationDTO);
}
