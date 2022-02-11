
//package view;

import java.util.Scanner;
//import model.Student;
//import model.StudentDTO;


public class View {
    
    private static final String ENTER_NAMES = "Ingresar nombres: ";
    private static final String ENTER_LAST_NAMES = "Ingresar apellidos: ";
    private static final String ENTER_DATE_B = "Ingresar fecha de nacimiento (YYYY-MM-DD): ";
    private static final String ENTER_INST_MAIL = "Ingresar correo institucional: ";
    private static final String ENTER_PERSONAL_MAIL = "Ingresar correo personal: ";
    private static final String ENTER_CP_NUMBER = "Ingresar número de celular: ";
    private static final String ENTER_HOUSE_NUMBER = "Ingresar número fijo: ";
    private static final String ENTER_PROGRAM = "Ingresar programa: ";

    private final Scanner az;

    public View() {
        this.az = new Scanner(System.in);
    
    }
    
    public int principalMenu() {
    
        System.out.println("INSTITUTO LA FLORESTA\n"
                + "Seleccione tarea a realizar:\n"
                + " 1. Ingresar estudiante\n"
                + " 2. Buscar estudiante\n"
                + " 3. Modificar estudiante\n"
                + " 4. Eliminar Estudiante\n"
                + " 5. Ver directorio de estudiantes\n"
                + " 6. Salir\n"
                + "Opción: ");
        return passInt();
    }
    
    public int inquiriesMenu() {
        System.out.println("Consultas \n"
                + "Seleccione consulta a realizar: \n"
                + "1. Buscar estudiante por correo electrónico \n"
                + "2. Buscar estudiante por apellidos \n"
                + "3. Buscar por programa \n"
                + "4. Buscar cantidad de estudiantes por programa \n"
                + "5. Buscar por fecha de nacimiento \n"
                + "6. Buscar por número de celular \n"
                + "Opción:");
        return passInt();
    }
    public void enterStudent(StudentDTO studentDTO){
        Student student = new Student();
        System.out.println("Ingresar estudiante");
        student.setNames(passString(ENTER_NAMES));
        student.setLast_names(passString(ENTER_LAST_NAMES));
        student.setDate_b(passString(ENTER_DATE_B));
        student.setInst_mail(passString(ENTER_INST_MAIL));
        student.setPersonal_mail(passString(ENTER_PERSONAL_MAIL));
        student.setCp_number(passLong(ENTER_CP_NUMBER));
        student.setHouse_number(passLong(ENTER_HOUSE_NUMBER));
        student.setProgram(passString(ENTER_PROGRAM));
        System.out.println(studentDTO.addStudent(student));
    }
    
    public void searchStudentMail(StudentDTO studentDTO){
        
        System.out.println("1. Buscar estudiante por correo electrónico");
        System.out.println(studentDTO.obtainMail(passString(ENTER_INST_MAIL)));
                                      //getXmail(passString(ENTER_INST_MAIL)
    }
    
    public void searchStudentLName(StudentDTO studentDTO){
        
        System.out.println("2. Buscar estudiante por apellidos");
        System.out.println(studentDTO.obtainLName(passString(ENTER_LAST_NAMES)));
    }
    
    public void searchStudentProgram(StudentDTO studentDTO) {
        System.out.println("3. Buscar por programa");
        System.out.println(studentDTO.obtainProgram(passString(ENTER_PROGRAM)));
    }
    
    public void countStudentsProgram(StudentDTO studentDTO){
        System.out.println("4. Buscar cantidad de estudiantes por programa");
        String program = passString(ENTER_PROGRAM);
        int amount = studentDTO.countStudentProgram(program);
        System.out.printf("Cantidad estudiantes %s: %d\n", program, amount);
    }
    
    public void searchStudentDateB(StudentDTO studentDTO){
        System.out.println("5. Buscar por fecha de nacimiento");
        System.out.println(studentDTO.obtainStudentDateB(passString("Ingresar fecha de nacimiento:")));
    }
    
    public void searchStudentCPnumber(StudentDTO studentDTO){
        System.out.println("6. Buscar por número de celular");
        String phoneNumber = String.valueOf(passLong(ENTER_CP_NUMBER));
        System.out.println(studentDTO.obtainCpNumber(phoneNumber));
    }
    
    public void delete_Student(StudentDTO studentDTO) {
        System.out.println("Eliminar estudiante");
        System.out.println(studentDTO.deleteStudent(passString(ENTER_INST_MAIL)));
    }

    public void modify_Student(StudentDTO studentDTO) {
        System.out.println("Modificar estudiante");
        Student student = studentDTO.obtainStudent(passString(ENTER_INST_MAIL));
        if (student != null) {
            student.setPersonal_mail(passString(ENTER_PERSONAL_MAIL));
            student.setCp_number(passLong(ENTER_CP_NUMBER));
            student.setHouse_number(passLong(ENTER_HOUSE_NUMBER));
            student.setProgram(passString(ENTER_PROGRAM));
            System.out.println(studentDTO.updateStudent(student));
        } else {
            System.out.println("El estudiante no se encuentra registrado");
        }
    }

    public void show_Directory(StudentDTO studentDTO) {
        System.out.println("El directorio de los estudiantes");
        System.out.println(studentDTO.studentsDirectory());
    }

    public void exit_message() {
        System.out.println("Hasta pronto");
    }

    private String passString(String mssg) {
        String fact = "";
        do {
            System.out.println(mssg);
            fact = this.az.nextLine();
        } while (fact.equals(""));
        return fact;
    }

    private long passLong(String mssg) {
        long fact = 0;
        do {
            try {
                System.out.println(mssg);
                fact = Long.parseLong(this.az.nextLine());
                return fact;
            } catch (NumberFormatException abc) {
                System.err.println("El dato ingresado no es un número\n");
            }
        } while (fact == 0);
        return fact;
    }

    private int passInt() {
        int fact = 0;
        do {
            try {
                fact = Integer.parseInt(this.az.nextLine());
                return fact;
            } catch (NumberFormatException abc) {
                System.err.println("El dato ingresado no es un número\n");
            }
        } while (fact != 0);
        return fact;
    }

}
