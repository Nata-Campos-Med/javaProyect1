
//package model;


public interface IStudentDAO {

  
    public String addStudent(String sentenceAddStudent);
    public Student obtainStudent(String sentenceObtainStudent);
    public String updateStudent(String sentenceUpdateStudent);
    public String deleteStudent(String sentenceDeleteStudent);


    public String showStudents(String sentenceShowStudents);
    public String inquirieStudents(String sentenceObtainStudent, int typeInquirie);
    public int countStudents(String sentenceCountStudents);
}

