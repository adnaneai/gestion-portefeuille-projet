package ma.onep.gestionportefeuilleprojet.dto;

import lombok.*;

@Getter @Setter
public class IdentificationProjetDTO {

    private String code;
    private String idProjet;
    private String intituleProjet;
    private String typeProjet;
    private String etapeActuelleProjet;

    private DemandeDTO demandeDTO;
}
