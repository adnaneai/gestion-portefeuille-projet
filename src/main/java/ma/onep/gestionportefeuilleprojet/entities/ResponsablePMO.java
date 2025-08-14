package ma.onep.gestionportefeuilleprojet.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@DiscriminatorValue("RESPONSABLE_PMO")
public class ResponsablePMO extends Utilisateur {

    private String domaineExpertise;
    private String niveauCertification;
    @OneToMany(mappedBy = "responsablePMO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Demande> demandes;
}
