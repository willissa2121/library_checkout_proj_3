package library.wslibrarycheckout.library.service;

import library.wslibrarycheckout.library.dao.LibrarianRepository;
import library.wslibrarycheckout.library.dao.PrivilegeRepository;
import library.wslibrarycheckout.library.dao.RoleRepository;
import library.wslibrarycheckout.library.entity.Book;
import library.wslibrarycheckout.library.entity.Librarian;
import library.wslibrarycheckout.library.entity.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Librarian addLibrarian(Librarian librarian) {


        librarian.getRoles().stream().forEach(role->{
            role.getPrivileges().stream().forEach(privilege -> {
                privilegeRepository.save(privilege);
            });
            roleRepository.save(role);
        });
        return librarianRepository.save(librarian);
    }
}
