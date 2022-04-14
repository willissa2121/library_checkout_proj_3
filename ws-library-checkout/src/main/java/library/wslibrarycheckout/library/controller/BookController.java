package library.wslibrarycheckout.library.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Books", description = "Operations pertaining to Books")
//this was to fix the cors issue for ui on my local
//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    @ApiOperation(value = "Add operation to save books")
    public ResponseEntity<Object> addBook(@RequestBody @Valid Book book){

      return  bookService.addBook(book);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get operation to get book by id ")
    public Optional<Book> getBookById(@PathVariable("id") int bookId){
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("/removeBook/{id}")
    @ApiOperation(value = "Delete operation to remove book by id ")
    public Book removeBookById(@PathVariable("id") int bookId){
        return bookService.removeBookById(bookId);
    }

    @PutMapping("/updateBook/{id}")
    @ApiOperation(value = "Update operation to edit book by id ")
    public Book updateBook(@PathVariable("id") int bookId, @RequestBody BookDTO bookDTO) {
        return bookService.updateBookById(bookId, bookDTO);
    }

    @ApiOperation(value = "Get all books of an author ")
    @PostMapping("/author")
    public List<Book> getBookForAuthor( @RequestBody BookDTO bookDTO){
        return bookService.getBookByAuthorId(bookDTO.getAuthorFullName());
    }

    @ApiOperation(value = "Get all books in the library ")
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooksbookDTO();
    }
}
