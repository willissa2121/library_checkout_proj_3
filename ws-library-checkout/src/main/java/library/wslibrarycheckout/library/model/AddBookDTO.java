package library.wslibrarycheckout.library.model;

import library.wslibrarycheckout.library.enumeration.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookDTO {

    private String name;
    private String isbn;
    private String edition;
    private Date expectedReturnDate;
    private String authorEmail;
    private Availability availability;
    private String fullName;
    private String email;

}
