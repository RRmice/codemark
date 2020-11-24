package ru.codemark.test.codemark.services;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.codemark.test.codemark.data.UserAnswer;
import ru.codemark.test.codemark.data.UserAnswerError;
import ru.codemark.test.codemark.entities.User;
import ru.codemark.test.codemark.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createNewUser(User user) throws NotFoundException {

        if(userRepository.getUserByLogin(user.getLogin()) != null){
            throw new NotFoundException("User already created");
        }

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

    public UserAnswerError updateErrors(BindingResult result) {

        List<String> errors = result.getAllErrors().stream()
                .map(e -> e.getDefaultMessage()).collect(Collectors.toList());

        return new UserAnswerError().setErrors(errors);

    }



}
