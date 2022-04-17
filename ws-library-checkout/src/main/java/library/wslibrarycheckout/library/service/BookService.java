package library.wslibrarycheckout.library.service;

import library.wslibrarycheckout.library.dao.AuthorRepository;
import library.wslibrarycheckout.library.dao.BookRepository;
import library.wslibrarycheckout.library.entity.Author;
import library.wslibrarycheckout.library.entity.Book;
import library.wslibrarycheckout.library.enumeration.Availability;
import library.wslibrarycheckout.library.exceptionhandling.Response;
import library.wslibrarycheckout.library.model.AddBookDTO;
import library.wslibrarycheckout.library.model.BookDTO;
import library.wslibrarycheckout.library.exceptionhandling.CannotBeFoundException;
import library.wslibrarycheckout.library.model.BookUpdateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<Object> addBook(AddBookDTO book) {
        Response<Book> resp;
        Set result = new HashSet();

        Author author = new Author();
        author.setEmail(book.getAuthorEmail());
        author.setFullName(book.getFullName());
        authorRepository.save(author);

        Book b = new Book();
        b.setAuthor(author);
        b.setEdition(book.getEdition());
        b.setExpectedReturnDate(book.getExpectedReturnDate());
        b.setIsbn(book.getIsbn());
        b.setName(book.getName());
        b.setAvailability(book.getAvailability());
        b.setAuthorEmail(book.getEmail());

        if(bookRepository.save(b) != null){
            result.add(b);
            resp = new Response<>("Book Added ", true, new Date(), HttpStatus.CREATED, result);
        } else {
            resp = new Response<>("Book could not be Added ", true, new Date(), HttpStatus.CREATED, result);
        }
        return new ResponseEntity(resp, resp.getHttpStatus());
    }

    public Book removeBookById(int bookId) {
        Optional<Book> mayBeBook = bookRepository.findById(bookId);
        if(mayBeBook.isPresent()){
            bookRepository.delete(mayBeBook.get());
        } else {
            throw new CannotBeFoundException("Book with id" + " "+ " cannot be found");
        }
        return null;
    }

    public Book removeBookByISBN(String isbn) {
        Optional<Book> mayBeBook = bookRepository.findByIsbn(isbn);
        if(mayBeBook.isPresent()){
            bookRepository.delete(mayBeBook.get());
        } else {
            throw new CannotBeFoundException("Book with id" + " "+ " cannot be found");
        }
        return null;
    }

    public Optional<Book> getBookById(int bookId) {

        Optional<Book> mayBeBook = bookRepository.findById(bookId);

        if(mayBeBook.isPresent()){
            return mayBeBook;
        } else {
            throw new CannotBeFoundException("Book with id " + bookId+ " cannot be found");
        }
    }

    public Book updateBookById(int bookId, BookDTO bookDTO) {
        Optional<Book> mayBeBook = bookRepository.findById(bookId);

        if(mayBeBook.isPresent()){
           mayBeBook.get().setAvailability(bookDTO.getAvailability());
           mayBeBook.get().setExpectedReturnDate((bookDTO.getExpectedReturnDate()));
           bookRepository.save(mayBeBook.get());
        } else {
            throw new CannotBeFoundException("Book with id " + bookId+ " cannot be found, so update is not successful!");
        }
        return null;
    }

    public List<Book> getBookByAuthorId(String authorName) {


        List<Book> bookList = bookRepository.findAll();

       List<Book> bookForAuthor = bookList.stream().filter(book -> book.getAuthor().getFullName().equalsIgnoreCase(authorName)).collect(Collectors.toList());

        return bookForAuthor;
    }

    public List<Book> getAllBooksbookDTO() {
        return bookRepository.findAll();
    }

    public BookUpdateResponseDTO updateBookByIsbn(String isbn, BookUpdateResponseDTO book) {

        Optional<Book> mayBeBook = bookRepository.findByIsbn(isbn);
        BookUpdateResponseDTO bookUpdateResponseDTO = new BookUpdateResponseDTO();
        if(mayBeBook.isPresent()){
           mayBeBook.get().setAvailability(book.getAvailability());
           mayBeBook.get().setExpectedReturnDate(book.getExpectedReturnDate());
           mayBeBook.get().setEdition(book.getEdition());

            bookRepository.save(mayBeBook.get());
           bookUpdateResponseDTO.setAvailability(book.getAvailability());
           bookUpdateResponseDTO.setExpectedReturnDate(book.getExpectedReturnDate());
           bookUpdateResponseDTO.setEdition(book.getEdition());
        } else {
            throw new CannotBeFoundException("Book with id" + " "+ " cannot be found");
        }
        return bookUpdateResponseDTO;
    }

    public Book checkoutBook(String isbn, Book book) {
        Optional<Book> mayBeBook = bookRepository.findByIsbn(isbn);

        long millis=System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(millis);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sqlDate);
        cal.setTime(sqlDate);
        cal.add(Calendar.DAY_OF_YEAR,14);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        java.sql.Date newSqlDate = new java.sql.Date(cal.getTimeInMillis());




        if(mayBeBook.isPresent()){
            mayBeBook.get().setAvailability(Availability.CHECKEDOUT);
            mayBeBook.get().setExpectedReturnDate(newSqlDate);
            mayBeBook.get().setEdition(book.getEdition());

            bookRepository.save(mayBeBook.get());
            book.setAvailability(book.getAvailability());
            book.setExpectedReturnDate(book.getExpectedReturnDate());
        } else {
            throw new CannotBeFoundException("Book with id" + " "+ " cannot be found");
        }
        return book;
    }
}
