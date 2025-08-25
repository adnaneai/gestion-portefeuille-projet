package ma.onep.gestionportefeuilleprojet.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
public class AutresInformationDTO {

    private List<DocumentDTO> documentDTOS;
    private DemandeDTO demandeDTO;
}
