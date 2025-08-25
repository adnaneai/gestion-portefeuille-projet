package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.PartiesPrenantesDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.PartiesPrenantesNotFoundException;

import java.util.List;

public interface PartiesPrenantesService {

    public List<PartiesPrenantesDTO> findAll();
    public PartiesPrenantesDTO findById(Long id) throws PartiesPrenantesNotFoundException;
    public List<PartiesPrenantesDTO> findAllPartiesPrenantesByMOA(String moa) throws PartiesPrenantesNotFoundException;
    public List<PartiesPrenantesDTO> findAllPartiesPrenantesByMOE(String moe) throws PartiesPrenantesNotFoundException;
    public List<PartiesPrenantesDTO> findAllPartiesPrenantesByAMO(String amo) throws PartiesPrenantesNotFoundException;
    public PartiesPrenantesDTO savePartiesPrenantes(PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException;
    public PartiesPrenantesDTO updatePartiesPrenantesById(Long idPartiesPrenantes, PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException;
    public void deletePartiesPrenantesById(Long idPartiesPrenantes);
}
