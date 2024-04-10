/*
 * Copyright ©️ 2024 Daniel Silva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Models;

public class StudentCourses {
    private String studentID;
    private String CRN;
    private String courseID;
    private String courseName;
    private String term;
    private String facultyID;
    private String grade;

    public StudentCourses() {
    }

    public StudentCourses(String studentID, String CRN, String courseID, String courseName, String term, String facultyID, String grade) {
        this.studentID = studentID;
        this.CRN = CRN;
        this.courseID = courseID;
        this.courseName = courseName;
        this.term = term;
        this.facultyID = facultyID;
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCRN() {
        return CRN;
    }

    public void setCRN(String cRN) {
        CRN = cRN;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}
