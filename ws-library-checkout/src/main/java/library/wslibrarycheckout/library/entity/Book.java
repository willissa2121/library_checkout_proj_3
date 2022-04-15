package library.wslibrarycheckout.library.entity;


import library.wslibrarycheckout.library.enumeration.Availabilty;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table
@Data
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 25)
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String authorEmail;

    private String edition;

    @Enumerated(EnumType.STRING)
    private Availabilty availabilty;

    private Date expectedReturnDate;
    @NotNull
    @Column(unique = true)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id", updatable = false)
    private Author author;

}
