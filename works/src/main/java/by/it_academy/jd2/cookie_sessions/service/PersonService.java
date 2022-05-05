package by.it_academy.jd2.cookie_sessions.service;

import by.it_academy.jd2.cookie_sessions.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonService {
    public static void save(String name, String lastName, int age,
                            HttpServletResponse resp, HttpServletRequest req, String saveTo)
            throws IOException {
        if ("cookie".equals(saveTo)){
            PersonServiceCookie.saveCookie(name, lastName, age, resp);
        }else if ("session".equals(saveTo)){
            PersonServiceSession.saveSession(name, lastName, age, req);
        }
    }


    public static Person load( HttpServletRequest req, String saveTo)
            throws IOException, ClassNotFoundException {
        Person person;
        if ("cookie".equals(saveTo)){
             person = PersonServiceCookie.loadCookie(req);
            return person;
        }else if ("session".equals(saveTo)){
            person = PersonServiceSession.loadSession(req);
            return person;
        }
        throw new ClassNotFoundException("нету персона");
    }
}
