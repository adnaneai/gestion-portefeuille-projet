package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.AutresInformationDTO;
import ma.onep.gestionportefeuilleprojet.entities.AutresInformation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AutresInformationMapperImp implements AutresInformationMapper {

    @Override
    public AutresInformationDTO fromAutreInformation(AutresInformation autresInformation) {
        AutresInformationDTO autresInformationDTO = new AutresInformationDTO();
        BeanUtils.copyProperties(autresInformation, autresInformationDTO);
        return autresInformationDTO;
    }

    @Override
    public AutresInformation fromAutreInformationDTO(AutresInformationDTO autresInformationDTO) {
        AutresInformation autresInformation = new AutresInformation();
        BeanUtils.copyProperties(autresInformationDTO, autresInformation);
        return autresInformation;
    }
}
