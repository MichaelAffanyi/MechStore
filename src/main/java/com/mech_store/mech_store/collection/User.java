package com.mech_store.mech_store.collection;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
public class User {
    @Id
    private String id;
    @NotBlank
    @Size(min = 3)
    private String firstname;
    @NotBlank
    @Size(min = 3)
    private String lastname;

    @Email
    @Size(min = 8)
    private String email;
    @NotBlank
    @Size(min = 5)
    private String username;
    @NotBlank
    @Size(min = 8)
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
