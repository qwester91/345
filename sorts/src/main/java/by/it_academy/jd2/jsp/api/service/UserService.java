package by.it_academy.jd2.jsp.api.service;

import by.it_academy.jd2.jsp.api.core.dto.Roles;
import by.it_academy.jd2.jsp.api.core.dto.User;
import by.it_academy.jd2.jsp.statistics.StatisticsService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserService {
    private List<User> listOfUsers;
    private final StatisticsService statisticsService = StatisticsService.getInstance();

    private static final UserService instance = new UserService();
    private UserService() {
        listOfUsers = new ArrayList<>();
        User admin = new User("admin", "admin", "admin",LocalDate.now());
        admin.setRole(Roles.ADMIN);
        listOfUsers.add(admin);
    }

    public static UserService getInstance() {

        return instance;
    }

    public void register (User user) throws IllegalAccessException {
        for (User users : listOfUsers) {
            if(user.getLogin().equals(users.getLogin())){
                throw new IllegalAccessException("User with login " + user.getLogin() + ", already exist");
            }
        }
        listOfUsers.add(user);
        statisticsService.addCountUser();
    }

    public void logIn(String login, String password, HttpSession session) throws IllegalAccessException {
       boolean isLogin = false;
        for (User user : listOfUsers) {
            if (user.getLogin().equals(login)){
                if(user.getPassword().equals(password)){
                session.setAttribute("user", user);
                isLogin = true;
                } else {
                throw new IllegalAccessException("incorrect values of login/password");
                }
            }
        }
        if (!isLogin){
            throw new IllegalAccessException("user with this login does not exist");
        }
    }

   public User getUser(String login) throws ClassNotFoundException {
       for (User user : listOfUsers) {
           if (user.getLogin().equals(login))
               return user;
       }
       throw new ClassNotFoundException("user with login " + login + " does not exist");
   }
}
