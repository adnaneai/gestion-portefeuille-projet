package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.TypeRelationDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.TypeRelationNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/types-relation")
public interface TypeRelationRestController {

    @GetMapping
    List<TypeRelationDTO> getAllTypesRelation();

    @GetMapping("/id/{id}")
    TypeRelationDTO getTypeRelationById(@PathVariable Long id) throws TypeRelationNotFoundException;

    @GetMapping("/nom/{nomTypeRelation}")
    TypeRelationDTO getTypeRelationByNom(@PathVariable String nomTypeRelation) throws TypeRelationNotFoundException;

    @PostMapping
    TypeRelationDTO createTypeRelation(@RequestBody TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException;

    @PutMapping("/id/{id}")
    TypeRelationDTO updateTypeRelation(@PathVariable Long id, @RequestBody TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteTypeRelation(@PathVariable Long id) throws TypeRelationNotFoundException;
}