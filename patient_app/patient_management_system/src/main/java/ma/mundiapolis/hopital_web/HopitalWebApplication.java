package ma.mundiapolis.hopital_web;

import ma.mundiapolis.hopital_web.entities.Patient;
import ma.mundiapolis.hopital_web.repositories.PatientRepository;
import ma.mundiapolis.hopital_web.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class HopitalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopitalWebApplication.class, args);
    }

//    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Mohammed", new Date(), true,321));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

//    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService){
        return args -> {
            accountService.addnewRole("USER");
            accountService.addnewRole("ADMIN");
            accountService.addnewUser("med","12345678","med@gmail.com","12345678");
            accountService.addnewUser("admin","12345678","admin@gmail.com","12345678");

            accountService.addRoleToUser("med","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");


        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
