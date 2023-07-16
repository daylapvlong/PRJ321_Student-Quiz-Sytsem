/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin's
 */
public class Account {
    private int Id;
    private String name;
    private String email;
    private String password;
    private int isStudent;
    private int isTeacher;
    
    public Account(){};

    public Account(int Id, String name, String email, String password, int isStudent, int isTeacher) {
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isStudent = isStudent;
        this.isTeacher = isTeacher;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(int isStudent) {
        this.isStudent = isStudent;
    }

    public int getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(int isTeacher) {
        this.isTeacher = isTeacher;
    }

    @Override
    public String toString() {
        return "Account{" + "Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password + ", isStudent=" + isStudent + ", isTeacher=" + isTeacher + '}';
    }
}
