package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DesignationProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.DesignationProjet;

public interface DesignationProjetMapper {
    public DesignationProjetDTO fromDesignationProjet(DesignationProjet designationProjet);
    public DesignationProjet fromDesignationProjetDTO(DesignationProjetDTO designationProjetDTO);
}
