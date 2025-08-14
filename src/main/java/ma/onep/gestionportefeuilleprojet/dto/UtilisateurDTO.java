package ma.onep.gestionportefeuilleprojet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class UtilisateurDTO {
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String telephone;
    private String mdp;
}
