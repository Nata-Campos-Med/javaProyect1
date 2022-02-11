//package model;

public class StudentDTO {

    private final StudentDAO studentDAO;

    public StudentDTO() {
        
        this.studentDAO = new StudentDAO(Sentences.CREATE_DB);
    }

    
    
    public String addStudent(Student student) {
        String sentenceAddStudent = String.format(Sentences.ADD_STUDENT,
                student.getNames(),
                student.getLast_names(),
                student.getDate_b(),
                student.getInst_mail(),
                student.getPersonal_mail(),
                student.getCp_number(),
                student.getHouse_number(),
                student.getProgram());
        return this.studentDAO.addStudent(sentenceAddStudent);
    }

    
    
    public String updateStudent(Student student) {
        String sentenceUpdateStudent = String.format(Sentences.UPDATE_STUDENT,
                student.getPersonal_mail(),
                String.valueOf(student.getCp_number()),
                String.valueOf(student.getHouse_number()),
                student.getProgram(),
                student.getId_student());
        return this.studentDAO.updateStudent(sentenceUpdateStudent);
    }

    
    
    public String deleteStudent(String inst_mail) {
        String sentenceDeleteStudent = String.format(Sentences.DELETE_STUDENT, inst_mail);
        return this.studentDAO.deleteStudent(sentenceDeleteStudent);
    }

   
    
    public String studentsDirectory() {
        return this.studentDAO.showStudents(Sentences.LIST_STUDENT);
    }

    
     
    public Student obtainStudent(String inst_mail) {
        String sentenceObtainStudent = String.format(Sentences.SEARCH_STUDENT_MAIL, inst_mail);
        return this.studentDAO.obtainStudent(sentenceObtainStudent);
    }

    
    
    public String obtainMail(String inst_mail) {
        String sentenceObtainStudent = String.format(Sentences.SEARCH_STUDENT_MAIL, inst_mail);
        return this.studentDAO.inquirieStudents(sentenceObtainStudent, 1);
    }

    
    public String obtainLName(String last_names) {
        String sentenceObtainStudent = String.format(Sentences.SEARCH_STUDENT_LNAMES, last_names);
        return this.studentDAO.inquirieStudents(sentenceObtainStudent, 2);
    }

    
    
    public String obtainProgram(String program) {
        String sentenceObtainStudent = String.format(Sentences.SEARCH_STUDENT_PROGRAM, program);
        return this.studentDAO.inquirieStudents(sentenceObtainStudent, 3);
    }

   
     
    public int countStudentProgram(String program) {
        String sentenceCountStudents = String.format(Sentences.COUNT_STUDENTS_PROGRAM, program);
        return this.studentDAO.countStudents(sentenceCountStudents);
    }

    
     
    public String obtainStudentDateB(String date_b) {
        String sentenceObtainStudents = String.format(Sentences.SEARCH_STUDENT_DATEB, date_b);
        return this.studentDAO.inquirieStudents(sentenceObtainStudents, 4);
    }

    
    
    public String obtainCpNumber(String cp_number) {
        String sentenceObtainStudents = String.format(Sentences.SEARCH_STUDENT_CPNUMBER, cp_number);
        return this.studentDAO.inquirieStudents(sentenceObtainStudents, 5);
    }

    
    
    public boolean thereAreStudents() {
        return this.studentDAO.countStudents(Sentences.COUNT_STUDENT) != 0;
    }
}

 

class Sentences {

      protected final static String CREATE_DB = "CREATE TABLE IF NOT EXISTS \"estudiantes\" (\n"
            + "	\"id_estudiante\" INTEGER NOT NULL PRIMARY KEY,\n"
            + "	\"nombres\"	TEXT NOT NULL,\n"
            + "	\"apellidos\" TEXT NOT NULL,\n"
            + "	\"fecha_nacimiento\" TEXT NOT NULL,\n"
            + "	\"correo_institucional\" TEXT NOT NULL,\n"
            + "	\"correo_personal\"	TEXT NOT NULL,\n"
            + "	\"num_celular\"	TEXT NOT NULL,\n"
            + "	\"num_fijo\" TEXT NOT NULL,\n"
            + "	\"programa_academico\" TEXT NOT NULL,\n"
            + "	PRIMARY KEY(\"id_estudiante\")\n"
            + ");";

   
    protected final static String SEARCH_STUDENT_MAIL = "SELECT * FROM estudiantes WHERE correo_institucional = '%s'";
    protected final static String SEARCH_STUDENT_LNAMES = "SELECT * FROM estudiantes WHERE apellidos = '%s'";
    protected final static String SEARCH_STUDENT_PROGRAM = "SELECT * FROM estudiantes WHERE programa_academico = '%s'";
    protected final static String SEARCH_STUDENT_DATEB = "SELECT * FROM estudiantes WHERE fecha_nacimiento = '%s'";
    protected final static String SEARCH_STUDENT_CPNUMBER = "SELECT * FROM estudiantes WHERE num_celular = '%s'";

    
    protected final static String ADD_STUDENT = "INSERT INTO estudiantes "
            + "(id_estudiante, nombres, apellidos, fecha_nacimiento, "
            + "correo_institucional, correo_personal, num_celular, num_fijo, programa_academico) "
            + "VALUES (NULL, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";

    
    protected final static String UPDATE_STUDENT = "UPDATE estudiantes SET "
            + "correo_personal = '%s', num_celular = '%s', num_fijo = '%s', programa_academico = '%s' "
            + "WHERE id_estudiante = '%d'";

   
    protected final static String DELETE_STUDENT = "DELETE FROM estudiantes WHERE correo_institucional = '%s'";

    protected final static String LIST_STUDENT = "SELECT * FROM estudiantes";

    protected final static String COUNT_STUDENT = "SELECT count(*) FROM estudiantes";

    protected final static String COUNT_STUDENTS_PROGRAM = "SELECT count(*) FROM estudiantes WHERE programa_academico = '%s'";

}
