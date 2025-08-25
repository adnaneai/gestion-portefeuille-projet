package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.IdentificationProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.IdentificationProjet;

public interface IdentificationProjetMapper {
    public IdentificationProjetDTO fromIdentificationProjet(IdentificationProjet identificationProjet);
    public IdentificationProjet fromIdentificationProjetDTO(IdentificationProjetDTO identificationProjetDTO);
}
