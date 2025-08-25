package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.ProjetsRelationDTO;
import ma.onep.gestionportefeuilleprojet.entities.ProjetsRelation;

public interface ProjetsRelationMapper {
    public ProjetsRelationDTO fromProjetsRelation(ProjetsRelation projetsRelation);
    public ProjetsRelation fromProjetsRelationDTO(ProjetsRelationDTO projetsRelationDTO);
}
