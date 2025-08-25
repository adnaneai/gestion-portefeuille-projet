package ma.onep.gestionportefeuilleprojet.dto;

import lombok.*;

import java.util.List;


@Getter @Setter
public class PartiesPrenantesDTO {

    private String moa;
    private String moe;
    private String amo;
    private List<BeneficitaireDTO> beneficitaireDTOS;
    private List<AutreDTO> autres;
    private DemandeDTO demandeDTO;
}
