package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.AutreDTO;
import ma.onep.gestionportefeuilleprojet.entities.Autre;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AutreMapperImp implements AutreMapper {

    @Override
    public AutreDTO fromAutre(Autre autre) {
        AutreDTO autreDTO = new AutreDTO();
        BeanUtils.copyProperties(autre, autreDTO);
        return autreDTO;
    }

    @Override
    public Autre fromAutreDTO(AutreDTO autreDTO) {
        Autre autre = new Autre();
        BeanUtils.copyProperties(autreDTO, autre);
        return autre;
    }
}
