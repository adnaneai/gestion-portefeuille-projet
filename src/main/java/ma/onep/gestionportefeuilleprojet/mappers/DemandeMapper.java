package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DemandeDTO;
import ma.onep.gestionportefeuilleprojet.entities.Demande;

public interface DemandeMapper {
    public DemandeDTO fromDemande(Demande demande);
    public Demande fromDemandeDTO(DemandeDTO demandeDTO);
}
