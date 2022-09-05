package com.example.pp_3_1_1_springboot.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Length(min = 6, max = 12)
    private String login;

    @NotNull
    @Length(min = 4, max = 8)
    private String password;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "second_name")
    private String secondName;
    @Min(18)
    @Max(127)
    private byte age;
    @NotNull
    @Email
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    public User(String login, String password, String firstName, String secondName, byte age, String email) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
    }
}
