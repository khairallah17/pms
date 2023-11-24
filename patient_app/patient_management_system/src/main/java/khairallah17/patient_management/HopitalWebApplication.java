package khairallah17.patient_management;

import khairallah17.patient_management.entities.Patient;
import khairallah17.patient_management.repositories.PatientRepository;
import khairallah17.patient_management.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HopitalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopitalWebApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Mohammed", new Date(), true,200));
            patientRepository.save(new Patient(null,"test1", new Date(), true,321));
            patientRepository.save(new Patient(null,"rewr111", new Date(), true,31));
            patientRepository.save(new Patient(null,"76lkjl11", new Date(), true,32));
            patientRepository.save(new Patient(null,"ssss11", new Date(), true,301));
            patientRepository.save(new Patient(null,"ss12111", new Date(), true,321));
            patientRepository.save(new Patient(null,"gfhfghfgh", new Date(), true,320));
            patientRepository.save(new Patient(null,"twert345", new Date(), true,321));
            patientRepository.save(new Patient(null,"wer121", new Date(), true,321));
            patientRepository.save(new Patient(null,"hgh12121", new Date(), true,321));
            patientRepository.save(new Patient(null,"saad11", new Date(), true,321));
            patientRepository.save(new Patient(null,"nnn111", new Date(), true,321));
            patientRepository.save(new Patient(null,"mmmmmm", new Date(), true,321));


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
