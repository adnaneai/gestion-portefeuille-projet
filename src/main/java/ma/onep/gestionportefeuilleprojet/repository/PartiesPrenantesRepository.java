package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.PartiesPrenantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PartiesPrenantesRepository extends JpaRepository<PartiesPrenantes, Long> {

    List<PartiesPrenantes> findByMoaContainingIgnoreCase(String moa);

    List<PartiesPrenantes> findByMoeContainingIgnoreCase(String moe);

    List<PartiesPrenantes> findByAmoContainingIgnoreCase(String amo);

    boolean existsById(Long id);
}