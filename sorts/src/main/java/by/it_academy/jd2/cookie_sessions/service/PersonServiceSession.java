package by.it_academy.jd2.cookie_sessions.service;

import by.it_academy.jd2.cookie_sessions.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PersonServiceSession {
    public static void saveSession(String name, String lastName, int age,
                                   HttpServletRequest req){
        Person person = new Person(name, lastName, age);
        HttpSession session = req.getSession();
        session.setAttribute("person", person);
    }

    public static Person loadSession(HttpServletRequest req) throws ClassNotFoundException {
        HttpSession session = req.getSession();
        Person person = (Person) session.getAttribute("person");
        if (person != null ){
            return person;
        }
        throw new ClassNotFoundException("нету в сессии вашего персона");

    }
}
