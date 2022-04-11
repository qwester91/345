package by.it_academy.jd2.cookie_sessions.service;

import by.it_academy.jd2.cookie_sessions.dto.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Base64;

public class PersonServiceCookie {
    public static void saveCookie(String name, String lastName, int age,
                                  HttpServletResponse resp)
            throws IOException {
        Person person = new Person(name, lastName, age);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream op = new ObjectOutputStream(byteArrayOutputStream);
        op.writeObject(person);
        String ser = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        Cookie person1 = new Cookie("person",  ser);
        resp.addCookie(person1);
    }

    public static Person loadCookie(HttpServletRequest req) throws IOException, ClassNotFoundException {
        for (Cookie cookie : req.getCookies()) {
            if ("person".equals(cookie.getName())){
                ByteArrayInputStream byteArrayInputStream =
                        new ByteArrayInputStream(Base64.getDecoder().
                                decode(cookie.getValue()));
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Person o = (Person) objectInputStream.readObject();
                return o;
            }
        }
        throw new IllegalArgumentException("нету кук");
    }
}
