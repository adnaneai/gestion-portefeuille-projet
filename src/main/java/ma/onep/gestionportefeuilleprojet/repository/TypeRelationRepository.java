package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.TypeRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRelationRepository extends JpaRepository<TypeRelation, Long> {

    public Optional<TypeRelation> findByNomTypeRelation(String nomTypeRelation);
}
