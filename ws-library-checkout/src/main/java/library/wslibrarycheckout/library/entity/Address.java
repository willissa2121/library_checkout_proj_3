package library.wslibrarycheckout.library.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Librarian librarian;



}
