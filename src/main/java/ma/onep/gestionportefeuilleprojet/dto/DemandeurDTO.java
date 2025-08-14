package ma.onep.gestionportefeuilleprojet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DemandeurDTO extends UtilisateurDTO {
    private Long matricule;
    private String direction;
}
