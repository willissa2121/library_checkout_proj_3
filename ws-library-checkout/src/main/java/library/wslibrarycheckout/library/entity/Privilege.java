package library.wslibrarycheckout.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import library.wslibrarycheckout.library.enumeration.PrivilegeType;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Privilege {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PrivilegeType privilegeType;

//    @JsonIgnore
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}
