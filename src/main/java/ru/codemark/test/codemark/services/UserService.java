package ru.codemark.test.codemark.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.codemark.test.codemark.data.UserAnswer;
import ru.codemark.test.codemark.entities.User;
import ru.codemark.test.codemark.repositories.UserRepository;
import ru.codemark.test.codemark.validators.UserValidator;

import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private UserValidator userValidator;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createNewUser(User user) throws NotFoundException {
       return userRepository.save(user);
    }

    public User getUserByLogin(String login){
        return userRepository.getUserByLogin(login);
    }

    public void deleteUserByLogin(String login){
        userRepository.delete(userRepository.getUserByLogin(login));
    }

    public void updateUser(User user) {
        User localUser = getUserByLogin(user.getLogin());
        localUser.setLogin(user.getLogin());
        localUser.setName(user.getName());
        localUser.setPassword(user.getPassword());

        localUser.setRoles(user.getRoles());

        userRepository.saveAndFlush(user);
        }

}
