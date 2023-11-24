package khairallah17.patient_management.security.service;

import khairallah17.patient_management.security.entities.AppUser;
import khairallah17.patient_management.security.entities.AppRole;

public interface AccountService {
    AppUser addnewUser(String username, String password, String email, String confirmPassword);
    AppRole addnewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);

    AppUser loadUserByUsername(String username);
}
