//package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO implements IStudentDAO {

    private final Linkage linkage;

    public StudentDAO(String createDB) {
        this.linkage = new Linkage(createDB);
    }
    
    @Override
    public String addStudent(String sentenceAddStudent) {
        String mssg = "";
        try {
            this.linkage.connect();
            if (this.linkage.executeSentencesSQL(sentenceAddStudent) != 0) {
                mssg = "Se agregó el estudiante\n";
            }
        } catch (SQLException sqlException) {
            if (sqlException.getMessage().contains("A UNIQUE constraint failed")) {
                mssg = "Ya existe otro estudiante inscrito con el mismo correo institucional\n";
            } else {
                System.err.println(sqlException);
            }
        } finally {
            this.linkage.disconnect();
        }
        return mssg;
    }

   
    
    @Override
    public Student obtainStudent(String sentenceObtainStudent) {
        Student student = new Student();
        try {
            this.linkage.connect();
            ResultSet answer = this.linkage.checkRecords(sentenceObtainStudent);
            if (answer.next()) {
                student = returnStudent(answer);
            } else {
                student = null;
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        } finally {
            this.linkage.disconnect();
        }
        return student;
    }

   
     
    @Override
    public String updateStudent(String sentenceUpdateStudent) {
        String mssg = "";
        try {
            this.linkage.connect();
            if (this.linkage.executeSentencesSQL(sentenceUpdateStudent) != 0) {
                //.executeSentencesSQL(sentenceUpdateStudent
                mssg = "Se modificó el estudiante\n";
            } else {
                mssg = "El estudiante no se encuentra registrado en el instituto\n";
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        } finally {
            this.linkage.disconnect();
        }
        return mssg;
    }

   
     
    @Override
    public String deleteStudent(String sentenceDeleteStudent) {
        String mssg = "";
        try {
            this.linkage.connect();
            if (this.linkage.executeSentencesSQL(sentenceDeleteStudent) != 0) {
                mssg = "Se eliminó el estudiante\n";
            } else {
                mssg = "El estudiante no se encuentra registrado en el instituto\n";
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        } finally {
            this.linkage.disconnect();
        }
        return mssg;
    }

     
    
    @Override
    public String showStudents(String sentenceShowStudents) {
        StringBuilder bcd = new StringBuilder();
        try {
            this.linkage.connect();
            ResultSet answer = this.linkage.checkRecords(sentenceShowStudents);
            while (answer.next()) {
                bcd.append(returnStudent(answer).toString());
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        } finally {
            this.linkage.disconnect();
        }
        return bcd.toString();
    }

  
     
    @Override
    public int countStudents(String sentenceCountStudents) {
        int counterStudents = 0;
        try {
            this.linkage.connect();
            ResultSet answer = this.linkage.checkRecords(sentenceCountStudents);
            if (answer.next()) {
                counterStudents = answer.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            this.linkage.disconnect();
        }
        return counterStudents;
    }

   
     
    @Override
    public String inquirieStudents(String sentenceObtainStudent, int typeInquirie) {
        try {
            this.linkage.connect();
            switch (typeInquirie) {
                case 1:
                    return this.inquirieMail(sentenceObtainStudent);
                case 2:
                    return this.inquirieLastName(sentenceObtainStudent);
                case 3:
                    return this.inquirieProgram(sentenceObtainStudent);
                case 4:
                    return this.inquirieDateB(sentenceObtainStudent);
                case 5:
                    return this.inquirieCpNumber(sentenceObtainStudent);
                default:
                    return "";
            }
        } catch (SQLException sQLException) {
            System.err.println(sQLException.getMessage());
        } finally {
            this.linkage.disconnect();
        }
        return "";
    }

    
     
    private String inquirieMail(String sentenceInstMail) throws NullPointerException {
        try {
            return obtainStudent(sentenceInstMail).toString();
        } catch (NullPointerException bcd) {
            return "El estudiante no se encuentra registrado en el instituto\n";
        }
    }

    
    
    private String inquirieLastName(String sentenceLastName) throws SQLException {
        StringBuilder bcd = new StringBuilder();
        ResultSet answer = this.linkage.checkRecords(sentenceLastName);
        while (answer.next()) {
            bcd.append(returnStudent(answer).toString());
        }
        if (bcd.toString().equals("")) {
            bcd.append("No hay resultados para esa consulta");
        }
        return bcd.toString();
    }

    
     
    private String inquirieProgram(String sentenceProgram) throws SQLException {
        StringBuilder bcd = new StringBuilder();
        Student student;
        ResultSet answer = this.linkage.checkRecords(sentenceProgram);
        while (answer.next()) {
            student = returnStudent(answer);
            bcd.append(student.getLast_names()).append(" ").append(student.getNames());
        }
        if (bcd.toString().equals("")) {
            bcd.append("No hay resultados para esa consulta");
        }
        return bcd.toString();
    }

   
    
    private String inquirieDateB(String sentenceDateB) throws SQLException {
        StringBuilder bcd = new StringBuilder();
        ResultSet answer = this.linkage.checkRecords(sentenceDateB);
        while (answer.next()) {
            bcd.append(returnStudent(answer).toString());
        }
        if (bcd.toString().equals("")) {
            bcd.append("No hay resultados para esa consulta");
        }
        return bcd.toString();
    }

    
     
    private String inquirieCpNumber(String sentenceCpNumber) throws SQLException {
        StringBuilder bcd = new StringBuilder();
        Student student;
        ResultSet answer = this.linkage.checkRecords(sentenceCpNumber);
        while (answer.next()) {
            student = returnStudent(answer);
            bcd.append(student.getLast_names()).append(" ").
                    append(student.getNames()).append(" ").
                    append(student.getProgram());
        }
        if (bcd.toString().equals("")) {
            bcd.append("No hay resultados para esa consulta");
        }
        return bcd.toString();
    }

     
    
    private Student returnStudent(ResultSet answer) throws SQLException {
        Student student = new Student();
        student.setId_student(answer.getInt("id_estudiante"));
        student.setNames(answer.getString("nombres"));
        student.setLast_names(answer.getString("apellidos"));
        student.setDate_b(answer.getString("fecha_nacimiento"));
        student.setInst_mail(answer.getString("correo_institucional"));
        student.setPersonal_mail(answer.getString("correo_personal"));
        student.setCp_number(Long.parseLong(answer.getString("num_celular")));
        student.setHouse_number(Long.parseLong(answer.getString("num_fijo")));
        student.setProgram(answer.getString("programa_academico"));
        return student;
    }
}
    

    