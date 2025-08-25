package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.DesignationProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DesignationProjetNotFoundException;

import java.util.List;

public interface DesignationProjetService {
    public List<DesignationProjetDTO> findAllDesignationProjet();
    public DesignationProjetDTO findDesignationProjetById(Long id) throws DesignationProjetNotFoundException;
    public DesignationProjetDTO findDesignationProjetByName(String nomDesignationProjet) throws DesignationProjetNotFoundException;
    public DesignationProjetDTO saveDesignationProjet(DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException;
    public DesignationProjetDTO updateDesignationProjet(Long id,DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException;
    public void deleteDesignationProjet(Long id) throws DesignationProjetNotFoundException;
}
