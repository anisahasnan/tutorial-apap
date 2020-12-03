package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel getUserByUsername(String username);
    UserModel updatePassword(UserModel user, String newPass);
    boolean validateOldPassword(UserModel user, String oldPassInput);
}
