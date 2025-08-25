package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.ObjectifsProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.ObjectifsProjet;

public interface ObjectifsProjetMapper {
    public ObjectifsProjetDTO fromObjectifsProjet(ObjectifsProjet objectifsProjet);
    public ObjectifsProjet fromObjectifsProjetDTO(ObjectifsProjetDTO objectifsProjetDTO);
}
