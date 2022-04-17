package library.wslibrarycheckout.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String userName;
    private String password;

    @OneToOne(mappedBy = "registration")
    private Librarian librarian;

    @OneToOne(mappedBy = "registration")
    private Student student;
}
