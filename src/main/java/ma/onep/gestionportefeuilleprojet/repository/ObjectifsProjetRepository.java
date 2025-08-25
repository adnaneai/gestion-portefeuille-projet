package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.ObjectifsProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectifsProjetRepository extends JpaRepository<ObjectifsProjet, Long> {
    public List<ObjectifsProjet> findByNomObjectifsProjetContainingIgnoreCase(String nomObjectifsProjet);
    public boolean existsById(Long id);
}
