package com.mech_store.mech_store.collection;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
public class User {
    @Id
    private String id;
    @NotBlank(message = "First name can't be empty")
    @Size(min = 3, message = "Length should be more than three characters")
    private String firstname;
    @NotBlank(message = "Last name can't be empty")
    @Size(min = 3, message = "Length should be more than three characters")
    private String lastname;

    @Email(message = "Email can't be empty")
    @Size(min = 8, message = "Length should be more than eight characters")
    private String email;
    @NotBlank(message = "Username can't be empty")
    @Size(min = 5, message = "Length should be more than five characters")
    private String username;
    @NotBlank(message = "Password can't be empty")
    @Size(min = 8, message = "Length should be more than eight characters")
    private String password;

    public User(String firstname, String lastname, String dob, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {

    }
}
