package library.wslibrarycheckout.library.controller;

import io.swagger.annotations.ApiOperation;
import library.wslibrarycheckout.library.entity.Book;
import library.wslibrarycheckout.library.entity.Librarian;
import library.wslibrarycheckout.library.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;


    @PostMapping
    @ApiOperation(value = "Add Librarian")
    public Librarian addLibrarian(@RequestBody Librarian librarian){

        return librarianService.addLibrarian(librarian);
    }

}
