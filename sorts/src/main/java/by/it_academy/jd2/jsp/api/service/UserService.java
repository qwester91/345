package by.it_academy.jd2.jsp.api.service;

import by.it_academy.jd2.jsp.api.core.dto.User;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserService {
    private List<User> listOfUsers;
    private static UserService instance;
    private UserService() {
        listOfUsers = new ArrayList<>();
        User admin = new User("admin", "admin", "admin",LocalDate.now());
        admin.setRole("admin");
        listOfUsers.add(admin);
    }

    public static UserService getInstance() {
        if (instance==null){
            instance = new UserService();
        }
        return instance;
    }

    public void register (User user) throws IllegalAccessException {
        for (User users : listOfUsers) {
            if(user.getLogin().equals(users.getLogin())){
                throw new IllegalAccessException("Пользователь с таким логином уже существует");
            }
        }
        listOfUsers.add(user);
    }

    public void logIn(String login, String password, HttpSession session) throws IllegalAccessException {
        for (User user : listOfUsers) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                session.setAttribute("user", user);
                return;
        }
//            else if(user.getLogin().equals(login) && !user.getPassword().equals(password)){
//                throw new IllegalAccessException("неверная пара логин/пароль");
//            } else if (!user.getLogin().equals(login)) {
//                throw new IllegalAccessException("Пользователя с таким логином не существует");
//            }
        }
    }

   public User getUser(String login) throws ClassNotFoundException {
       for (User user : listOfUsers) {
           if (user.getLogin().equals(login))
               return user;
       }
       throw new ClassNotFoundException("пользователя с логином " + login + " не существует");
   }
}
