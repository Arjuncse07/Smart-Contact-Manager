package com.scm.arjun.scm20.entities;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "USER")
@Table(name = "USER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

@Id
private String userId;

@Column(name="user_name", nullable = false)
private String name;

@Column(unique = true, nullable = false)
private String email;    

private String password;

private String gender;

@Column(length = 1000)
private String about;

@Column(length = 1000)
private String profilePic;

private String phoneNumber;

private boolean enable = false;
private boolean emailVerified = false;
private boolean phoneNumberVerified = false;

//SignUp >> Google, Facebook, Tweet
@Enumerated(value = EnumType.STRING)   //enables user to update the string enum in database
private Providers provider = Providers.SELF;
private String providerUserId;

@OneToMany(mappedBy = "user",
cascade = CascadeType.ALL,
fetch = FetchType.LAZY,
orphanRemoval = true)
private List<Contacts> contacts = new ArrayList<>();






}
