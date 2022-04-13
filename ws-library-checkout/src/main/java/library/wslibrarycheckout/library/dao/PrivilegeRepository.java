package library.wslibrarycheckout.library.dao;

import library.wslibrarycheckout.library.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
}
