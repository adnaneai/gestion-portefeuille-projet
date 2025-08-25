package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.AutreDTO;
import ma.onep.gestionportefeuilleprojet.entities.Autre;

public interface AutreMapper {
    public AutreDTO fromAutre(Autre autre);
    public Autre fromAutreDTO(AutreDTO autreDTO);
}
