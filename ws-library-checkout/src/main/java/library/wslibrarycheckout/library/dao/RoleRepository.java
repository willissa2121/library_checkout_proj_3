package library.wslibrarycheckout.library.dao;

import library.wslibrarycheckout.library.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
