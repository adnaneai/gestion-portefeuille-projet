package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.ProjetsRelationDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.ProjetsRelationNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/projets-relations")
public interface ProjetsRelationRestController {

    @GetMapping
    List<ProjetsRelationDTO> getAllProjetsRelations();

    @GetMapping("/id/{id}")
    ProjetsRelationDTO getProjetsRelationById(@PathVariable Long id) throws ProjetsRelationNotFoundException;

    @PostMapping
    ProjetsRelationDTO createProjetsRelation(@RequestBody ProjetsRelationDTO projetsRelationDTO);

    @PutMapping("/id/{id}")
    ProjetsRelationDTO updateProjetsRelation(@PathVariable Long id, @RequestBody ProjetsRelationDTO projetsRelationDTO) throws ProjetsRelationNotFoundException;

    @DeleteMapping("/id/{id}")
    ProjetsRelationDTO deleteProjetsRelation(@PathVariable Long id) throws ProjetsRelationNotFoundException;
}