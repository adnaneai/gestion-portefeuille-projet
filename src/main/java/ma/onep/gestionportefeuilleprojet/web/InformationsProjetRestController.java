package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.InformationsProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.InformationsProjetNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/informations-projet")
public interface InformationsProjetRestController {

    @GetMapping
    List<InformationsProjetDTO> getAllInformationsProjets();

    @GetMapping("/id/{id}")
    InformationsProjetDTO getInformationsProjetById(@PathVariable Long id) throws InformationsProjetNotFoundException;

    @GetMapping("/date-demarrage/{date}")
    List<InformationsProjetDTO> getInformationsProjetByDateDemarrage(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") Date date) throws InformationsProjetNotFoundException;

    @GetMapping("/duree/{duree}")
    List<InformationsProjetDTO> getInformationsProjetByDuree(@PathVariable String duree) throws InformationsProjetNotFoundException;

    @GetMapping("/cout/{cout}")
    List<InformationsProjetDTO> getInformationsProjetByCout(@PathVariable float cout) throws InformationsProjetNotFoundException;

    @PostMapping
    InformationsProjetDTO createInformationsProjet(@RequestBody InformationsProjetDTO informationsProjetDTO);

    @PutMapping("/id/{id}")
    InformationsProjetDTO updateInformationsProjet(@PathVariable Long id, @RequestBody InformationsProjetDTO informationsProjetDTO) throws InformationsProjetNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteInformationsProjet(@PathVariable Long id) throws InformationsProjetNotFoundException;
}