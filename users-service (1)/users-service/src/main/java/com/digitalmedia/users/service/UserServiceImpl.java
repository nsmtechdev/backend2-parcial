package com.digitalmedia.users.service;

import com.digitalmedia.users.model.User;
import com.digitalmedia.users.repository.MongoUserRepository;
import com.digitalmedia.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;
  private final MongoUserRepository mongoUserRepository;


 /* @Override
  public User validateAndGetUserExtraMongo(String username) {
    return mongoUserRepository.validateAndGetUser(username);
  }

  @Override
  public Optional<User> getUserExtraMongo(String username) {
    return mongoUserRepository.getUserExtra(username);
  }

  @Override
  public User saveUserExtraMongo(User user) {
    return mongoUserRepository.saveUserExtra(user);
  }
*/
  @Override
  public User validateAndGetUserExtra(String username) {
    return userRepository.validateAndGetUser(username);
  }

  @Override
  public Optional<User> getUserExtra(String username) {
    return userRepository.getUserExtra(username);
  }

  @Override
  public User saveUserExtra(User user) {
    return userRepository.saveUserExtra(user);
  }
}
