package com.pwr.internetowypomocnik.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Bartek on 07.06.2016.
 */
@Component
@Scope("session")
public class LoggedUser {

    private long id_user;

    private String login;
    private String password;
    private String email;
    private String first_name;
    private String second_name;
    private Integer age;
    private String sex;

    private Integer body_status_id;
    private Integer diet_id;

    public LoggedUser(long id_user, String password, String login, String email, String first_name, String second_name, Integer age, String sex, Integer body_status_id, Integer diet_id) {
        this.id_user = id_user;
        this.password = password;
        this.login = login;
        this.email = email;
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.sex = sex;
        this.body_status_id = body_status_id;
        this.diet_id = diet_id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getBody_status_id() {
        return body_status_id;
    }

    public void setBody_status_id(Integer body_status_id) {
        this.body_status_id = body_status_id;
    }

    public Integer getDiet_id() {
        return diet_id;
    }

    public void setDiet_id(Integer diet_id) {
        this.diet_id = diet_id;
    }
}
