package library.wslibrarycheckout.library.dao;


import library.wslibrarycheckout.library.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    Registration getByUserName(String userName);
}
