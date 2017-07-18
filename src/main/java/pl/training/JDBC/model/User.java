package pl.training.JDBC.model;

import java.util.List;

/**
 * Created by sit0 on 18.07.17.
 */
public class User {

    public enum Gender {male,female}

    private int id;

    private Address address;

    private String name;

    private String surName;

    private Gender gender;

    private String eMail;

    private String phoneNumber;

    private List<Book> books;


}
