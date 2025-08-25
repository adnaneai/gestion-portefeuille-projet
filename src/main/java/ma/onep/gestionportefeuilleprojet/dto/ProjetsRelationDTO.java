package ma.onep.gestionportefeuilleprojet.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
public class ProjetsRelationDTO {

    private List<DesignationProjetDTO>  designationProjetDTOS;
    private List<TypeRelationDTO> typeRelationDTOS;
    private DemandeDTO demandeDTO;
}
