package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.TypeRelationDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.TypeRelationNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.TypeRelationService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TypeRelationRestControllerImp implements TypeRelationRestController {

    private TypeRelationService typeRelationService;

    @Override
    public List<TypeRelationDTO> getAllTypesRelation() {
        return typeRelationService.findAllTypeRelation();
    }

    @Override
    public TypeRelationDTO getTypeRelationById(Long id) throws TypeRelationNotFoundException {
        return typeRelationService.findTypeRelationById(id);
    }

    @Override
    public TypeRelationDTO getTypeRelationByNom(String nomTypeRelation) throws TypeRelationNotFoundException {
        return typeRelationService.findTypeRelationByName(nomTypeRelation);
    }

    @Override
    public TypeRelationDTO createTypeRelation(TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException {
        return typeRelationService.saveTypeRelation(typeRelationDTO);
    }

    @Override
    public TypeRelationDTO updateTypeRelation(Long id, TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException {
        return typeRelationService.updateTypeRelation(id, typeRelationDTO);
    }

    @Override
    public void deleteTypeRelation(Long id) throws TypeRelationNotFoundException {
        typeRelationService.deleteTypeRelation(id);
    }
}