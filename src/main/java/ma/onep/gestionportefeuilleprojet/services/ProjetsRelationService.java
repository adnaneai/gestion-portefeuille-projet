package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.ProjetsRelationDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.ProjetsRelationNotFoundException;

import java.util.List;

public interface ProjetsRelationService {
    public List<ProjetsRelationDTO> findAllProjetRelation();
    public ProjetsRelationDTO findProjetRelationById(Long id) throws ProjetsRelationNotFoundException;
    public ProjetsRelationDTO saveProjetRelation(ProjetsRelationDTO projetsRelationDTO);
    public ProjetsRelationDTO updateProjetRelation(Long id,ProjetsRelationDTO projetsRelationDTO) throws ProjetsRelationNotFoundException;
    public ProjetsRelationDTO deleteProjetRelation(Long id) throws ProjetsRelationNotFoundException;
}
