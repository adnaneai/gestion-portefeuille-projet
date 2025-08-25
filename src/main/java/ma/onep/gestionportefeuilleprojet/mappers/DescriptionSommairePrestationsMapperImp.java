package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DescriptionSommairePrestationsDTO;
import ma.onep.gestionportefeuilleprojet.entities.DescriptionSommairePrestations;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DescriptionSommairePrestationsMapperImp implements DescriptionSommairePrestationsMapper {

    @Override
    public DescriptionSommairePrestationsDTO fromDescriptionSommairePrestations(DescriptionSommairePrestations descriptionSommairePrestations) {
        DescriptionSommairePrestationsDTO dto = new DescriptionSommairePrestationsDTO();
        BeanUtils.copyProperties(descriptionSommairePrestations, dto);
        return dto;
    }

    @Override
    public DescriptionSommairePrestations fromDescriptionSommairePrestationsDTO(DescriptionSommairePrestationsDTO descriptionSommairePrestationsDTO) {
        DescriptionSommairePrestations entity = new DescriptionSommairePrestations();
        BeanUtils.copyProperties(descriptionSommairePrestationsDTO, entity);
        return entity;
    }
}
