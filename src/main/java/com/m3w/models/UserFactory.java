package com.m3w.models;

public class UserFactory {

    public User createUser(int id, String name, String surname, int phone, String email, String password, String userType) {

        UserType enumUserType = UserType.valueOf(userType);

        switch (enumUserType){
            case STUDENT:
                Student student = new Student(id, name, surname, phone, email, password, userType);
                return student;
            case MENTOR:
                Mentor mentor = new Mentor(id, name, surname, phone, email, password, userType);
                return mentor;
            case EMPLOYEE:
                Employee employee = new Employee(id, name, surname, phone, email, password, userType);
                return employee;
            case MANAGER:
                Manager manager = new Manager(id, name, surname, phone, email, password, userType);
                return manager;

            default:
                return null;
        }
    }
}
