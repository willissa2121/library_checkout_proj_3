package library.wslibrarycheckout.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="librarian_id", referencedColumnName = "id")
//    @JsonIgnore
    private Librarian librarian;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "role_id", updatable = false)
//    private Librarian librarian;

    @ManyToMany
    @JoinTable(
            name = "role_priv",
            joinColumns = @JoinColumn(name = "priv_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Enumerated(EnumType.STRING)
    private List<Privilege> privileges;
}
