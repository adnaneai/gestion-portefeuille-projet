package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.AutreDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.AutreNotFoundException;

import java.util.List;

public interface AutreService {
    public List<AutreDTO> findAll();
    public AutreDTO findById(Long id) throws AutreNotFoundException;
    public AutreDTO save(AutreDTO autreDTO) throws AutreNotFoundException;
    public AutreDTO update(Long id,AutreDTO autreDTO) throws AutreNotFoundException;
    public void delete(Long id) throws AutreNotFoundException;
}
