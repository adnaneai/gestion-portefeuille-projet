package ma.onep.gestionportefeuilleprojet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponsablePMODTO extends UtilisateurDTO {

    private String domaineExpertise;
    private String niveauCertification;
}
