/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin's
 */
public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private int categoryId;

    public Course(){}

    public Course(int courseId, String courseName, String description, int categoryId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.categoryId = categoryId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", courseName=" + courseName + ", description=" + description + ", categoryId=" + categoryId + '}';
    }
    
    
    
    
}
