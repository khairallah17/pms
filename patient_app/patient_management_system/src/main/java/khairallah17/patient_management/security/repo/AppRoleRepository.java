package khairallah17.patient_management.security.repo;

import khairallah17.patient_management.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
}
