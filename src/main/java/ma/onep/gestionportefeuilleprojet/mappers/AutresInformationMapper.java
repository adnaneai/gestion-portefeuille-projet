package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.AutresInformationDTO;
import ma.onep.gestionportefeuilleprojet.entities.AutresInformation;

public interface AutresInformationMapper {
    public AutresInformationDTO fromAutreInformation(AutresInformation autresInformation);
    public  AutresInformation fromAutreInformationDTO(AutresInformationDTO autresInformationDTO);
}
