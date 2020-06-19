package com.m3w.models;

public class UserFactory {

    public User createUser(int id, String name, String surname, int phone, String email, char password, String userType) {

        UserType enumUserType = UserType.valueOf(userType.toUpperCase());

        switch (enumUserType){
            case STUDENT:
                return new Student(id, name, surname, phone, email, password, userType);
            case MENTOR:
                return new Mentor(id, name, surname, phone, email, password, userType);
            case EMPLOYEE:
                return new Employee(id, name, surname, phone, email, password, userType);
            case MANAGER:
                return new Manager(id, name, surname, phone, email, password, userType);
            default:
                return null;
        }
    }
}
