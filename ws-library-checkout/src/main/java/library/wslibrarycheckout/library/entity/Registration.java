package library.wslibrarycheckout.library.entity;

import javax.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String email;
    private String userName;
    private String password;

    @OneToOne(mappedBy = "registration")
    private Librarian librarian;

    @OneToOne(mappedBy = "registration")
    private Student student;
}
