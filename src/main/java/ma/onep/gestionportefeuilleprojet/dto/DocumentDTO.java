package ma.onep.gestionportefeuilleprojet.dto;

import lombok.*;
import ma.onep.gestionportefeuilleprojet.enums.TypeDocument;

@Getter @Setter
public class DocumentDTO {

    private String nom;
    private TypeDocument typeDocument;
    private String url;
    private AutresInformationDTO autresInformationDTO;

}
