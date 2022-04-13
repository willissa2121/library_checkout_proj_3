package library.wslibrarycheckout.library.controller;

import library.wslibrarycheckout.library.entity.Book;
import library.wslibrarycheckout.library.model.BookDTO;
import library.wslibrarycheckout.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
//this was to fix the cors issue for ui on my local
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Object> addBook(@RequestBody @Valid Book book){

      return  bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int bookId){
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("/removeBook/{id}")
    public Book removeBookById(@PathVariable("id") int bookId){
        return bookService.removeBookById(bookId);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable("id") int bookId, @RequestBody BookDTO bookDTO) {
        return bookService.updateBookById(bookId, bookDTO);
    }

    @PostMapping("/author")
    public List<Book> getBookForAuthor( @RequestBody BookDTO bookDTO){
        return bookService.getBookByAuthorId(bookDTO.getAuthorFullName());
    }
}
