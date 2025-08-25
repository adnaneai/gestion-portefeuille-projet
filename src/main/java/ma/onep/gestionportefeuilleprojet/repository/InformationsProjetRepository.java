package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.InformationsProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InformationsProjetRepository extends JpaRepository<InformationsProjet, Long> {

    public List<InformationsProjet> findByDateDemarrage(Date dateDemarrage);
    public List<InformationsProjet> findByDureeContainingIgnoreCase(String duree);
    public List<InformationsProjet> findByCout(float cout);
}
