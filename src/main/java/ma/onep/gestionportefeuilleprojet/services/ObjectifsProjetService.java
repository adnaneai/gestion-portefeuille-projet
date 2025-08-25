package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.ObjectifsProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.ObjectifsProjetNotFoundException;

import java.util.List;

public interface ObjectifsProjetService {
    public List<ObjectifsProjetDTO> findAll();
    public ObjectifsProjetDTO findById(Long id) throws ObjectifsProjetNotFoundException;
    public List<ObjectifsProjetDTO> findByNomObjectifsProjet(String nomObjectifsProjet) throws ObjectifsProjetNotFoundException;
    public ObjectifsProjetDTO saveObjectifsProjet(ObjectifsProjetDTO objectifsProjetDTO);
    public ObjectifsProjetDTO updateObjectifsProjet(Long id,ObjectifsProjetDTO objectifsProjetDTO) throws ObjectifsProjetNotFoundException;
    public void deleteObjectifsProjet(Long id) throws ObjectifsProjetNotFoundException;
}
