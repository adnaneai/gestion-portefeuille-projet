package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DemandeDTO;
import ma.onep.gestionportefeuilleprojet.entities.Demande;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DemandeMapperImp implements DemandeMapper {
    @Override
    public DemandeDTO fromDemande(Demande demande) {
        DemandeDTO demandeDTO = new DemandeDTO();
        BeanUtils.copyProperties(demande, demandeDTO);
        return demandeDTO;
    }

    @Override
    public Demande fromDemandeDTO(DemandeDTO demandeDTO) {
        Demande demande = new Demande();
        BeanUtils.copyProperties(demandeDTO, demande);
        return demande;
    }
}
