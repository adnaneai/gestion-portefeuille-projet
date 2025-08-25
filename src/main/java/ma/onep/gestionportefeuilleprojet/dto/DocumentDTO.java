package ma.onep.gestionportefeuilleprojet.dto;

import lombok.*;
import ma.onep.gestionportefeuilleprojet.entities.AutresInformation;
import ma.onep.gestionportefeuilleprojet.entities.Document;
import ma.onep.gestionportefeuilleprojet.enums.TypeDocument;

import java.util.List;

@Getter @Setter
public class DocumentDTO {

    private String nom;
    private TypeDocument typeDocument;
    private String url;
    private AutresInformationDTO autresInformationDTO;

}
