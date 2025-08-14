package ma.onep.gestionportefeuilleprojet.mappers;

import lombok.Getter;
import lombok.Setter;
import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.entities.Demandeur;
import ma.onep.gestionportefeuilleprojet.entities.ResponsablePMO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurMapperImp implements  UtilisateurMapper {

    @Override
    public DemandeurDTO fromDemandeur(Demandeur demandeur) {
        DemandeurDTO  demandeurDTO = new DemandeurDTO();
        BeanUtils.copyProperties(demandeur, demandeurDTO);
        return demandeurDTO;
    }

    @Override
    public Demandeur fromDemandeurDTO(DemandeurDTO demandeurDTO) {
        Demandeur demandeur = new Demandeur();
        BeanUtils.copyProperties(demandeurDTO, demandeur);
        return demandeur;
    }

    @Override
    public ResponsablePMODTO fromResponsablePMO(ResponsablePMO responsablePMO) {
        ResponsablePMODTO responsablePMODTO = new ResponsablePMODTO();
        BeanUtils.copyProperties(responsablePMO, responsablePMODTO);
        return responsablePMODTO;
    }

    @Override
    public ResponsablePMO fromResponsablePMODTO(ResponsablePMODTO responsablePMODTO) {
        ResponsablePMO responsablePMO = new ResponsablePMO();
        BeanUtils.copyProperties(responsablePMODTO, responsablePMO);
        return responsablePMO;
    }
}
