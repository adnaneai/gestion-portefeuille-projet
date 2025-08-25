package ma.onep.gestionportefeuilleprojet.dto;

import lombok.*;
import ma.onep.gestionportefeuilleprojet.entities.Demande;

import java.util.Date;

@Getter @Setter
public class InformationsProjetDTO {

    private Date dateDemarrage;
    private String duree;
    private float cout;
    private DemandeDTO demandeDTO;
}
