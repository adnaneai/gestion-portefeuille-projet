package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.PartiesPrenantesDTO;
import ma.onep.gestionportefeuilleprojet.entities.PartiesPrenantes;

public interface PartiesPrenantesMapper {
    public PartiesPrenantesDTO fromPartiesPrenante(PartiesPrenantes partiesPrenantes);
    public PartiesPrenantes fromPartiesPrenanteDTO(PartiesPrenantesDTO partiesPrenantesDTO);
}
