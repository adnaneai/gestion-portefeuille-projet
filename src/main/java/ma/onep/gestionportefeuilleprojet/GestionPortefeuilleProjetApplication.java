package ma.onep.gestionportefeuilleprojet;

import ma.onep.gestionportefeuilleprojet.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionPortefeuilleProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPortefeuilleProjetApplication.class, args);
	}
}
