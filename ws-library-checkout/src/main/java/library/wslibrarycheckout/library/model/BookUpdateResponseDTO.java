package library.wslibrarycheckout.library.model;

import library.wslibrarycheckout.library.enumeration.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateResponseDTO {

    private String name;
    private String isbn;
    private String edition;
    private Date expectedReturnDate;
    private String author;
    private Availability availability;


}
