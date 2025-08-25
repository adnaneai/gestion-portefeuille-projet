package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DesignationProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.DesignationProjet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DesignationProjetMapperImp implements DesignationProjetMapper {

    @Override
    public DesignationProjetDTO fromDesignationProjet(DesignationProjet designationProjet) {
        DesignationProjetDTO dto = new DesignationProjetDTO();
        BeanUtils.copyProperties(designationProjet, dto);
        return dto;
    }

    @Override
    public DesignationProjet fromDesignationProjetDTO(DesignationProjetDTO designationProjetDTO) {
        DesignationProjet entity = new DesignationProjet();
        BeanUtils.copyProperties(designationProjetDTO, entity);
        return entity;
    }
}
