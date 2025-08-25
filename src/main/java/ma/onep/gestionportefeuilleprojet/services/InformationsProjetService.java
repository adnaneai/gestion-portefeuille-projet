package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.InformationsProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.InformationsProjetNotFoundException;

import java.util.Date;
import java.util.List;

public interface InformationsProjetService {
    public List<InformationsProjetDTO> findAllInformationsProjets();
    public InformationsProjetDTO findInformationsProjetById(Long id) throws InformationsProjetNotFoundException;
    public List<InformationsProjetDTO> findInformationProjetByDateDemarrage(Date date) throws InformationsProjetNotFoundException;
    public List<InformationsProjetDTO> findInformationProjetByDuree(String duree) throws InformationsProjetNotFoundException;
    public List<InformationsProjetDTO> findInformationsProjetCout(float cout) throws InformationsProjetNotFoundException;
    public InformationsProjetDTO saveInformationsProjet(InformationsProjetDTO informationsProjetDTO);
    public InformationsProjetDTO updateInformationsProjet(Long id,InformationsProjetDTO informationsProjetDTO) throws InformationsProjetNotFoundException;
    public void deleteInformationsProjet(Long id) throws InformationsProjetNotFoundException;
}
