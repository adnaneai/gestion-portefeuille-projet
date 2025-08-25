package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.AutresInformationDTO;
import ma.onep.gestionportefeuilleprojet.entities.AutresInformation;

public interface AutresInformationMapper {
    public AutresInformationDTO fromAutresInformation(AutresInformation autresInformation);
    public  AutresInformation fromAutresInformationDTO(AutresInformationDTO autresInformationDTO);
}
