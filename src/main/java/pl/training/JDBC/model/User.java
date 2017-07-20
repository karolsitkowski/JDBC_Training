package pl.training.JDBC.model;

import java.util.List;

/**
 * Created by sit0 on 18.07.17.
 */
public class User {

    public enum Gender {male,female}

    private int id;

    private Address address;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String eMail;

    private String phoneNo;


    private List<Book> books;

}
