package edu.ucdenver.fallnotification;

import java.util.Calendar;

public class Patient {
    private String firstName;
    private String lastName;
    private int roomNumber;
    private int age;
    public Calendar[] sessions;

    private Patient(String firstName, String lastName, int roomNumber, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
