package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.InformationsProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.InformationsProjet;

public interface InformationsProjetMapper {
    public InformationsProjetDTO fromInformationsProjet(InformationsProjet informations);
    public InformationsProjet fromInformationsProjetDTO(InformationsProjetDTO informations);
}
