package com.digitalmedia.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

  @Id
  private String username;
  private String avatar;
  private String email;
  private String firstName;
  private String lastName;
  private String extraUser;

  public User(String username) {
    this.username = username;
  }

}
