package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.TypeRelationDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.TypeRelationNotFoundException;

import java.util.List;

public interface TypeRelationService {
    public List<TypeRelationDTO> findAllTypeRelation();
    public TypeRelationDTO findTypeRelationById(Long id) throws TypeRelationNotFoundException;
    public TypeRelationDTO findTypeRelationByName(String nomTypeRelation) throws TypeRelationNotFoundException;
    public TypeRelationDTO saveTypeRelation(TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException;
    public TypeRelationDTO updateTypeRelation(Long id, TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException;
    public void deleteTypeRelation(Long id) throws TypeRelationNotFoundException;
}