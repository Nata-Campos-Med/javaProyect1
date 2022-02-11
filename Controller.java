
//package controller;

//import model.StudentDTO;
//import view.View;

public class Controller {
    private final StudentDTO studentDTO;
    private final View view;

    public Controller() {
        this.studentDTO = new StudentDTO();
        this.view = new View();
    }

     
    public boolean thereAreStudents() {
        return this.studentDTO.thereAreStudents();
    }

   
    public void caseModifyStudent() {
        if (thereAreStudents()) {
            this.view.modify_Student(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    public void caseDeleteStudent() {
        if (thereAreStudents()) {
            this.view.delete_Student(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    public void caseStudentsDirectory() {
        if (thereAreStudents()) {
            this.view.show_Directory(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    // Menu Principal 
    public void driveStudents() {
        int option;
        do {
            option = this.view.principalMenu();
            switch (option) {
                case 1:
                    this.view.enterStudent(this.studentDTO);
                    break;
                case 2:
                    inquiries(this.view.inquiriesMenu());
                    break;
                case 3:
                    caseModifyStudent();
                    break;
                case 4:
                    caseDeleteStudent();
                    break;
                case 5:
                    caseStudentsDirectory();
                    break;
                case 6:
                    this.view.exit_message();
                    break;
                default:
                    System.out.println("Error: Opción no válida");
                    break;
            }
        } while (option != 6);
    }

    
    //menu consultas
    public void inquiries(int option) {
        switch (option) {
            case 1:
                inquirieStudentMail();
                break;
            case 2:
                inquirieStudentLName();
                break;
            case 3:
                inquirieStudentProgram();
                break;
            case 4:
                countStudentProgram();
                break;
            case 5:
                inquirieStudentDateB();
                break;
            case 6:
                inquirieStudentCpNumber();
                break;
            default:
                System.out.println("No ingreso una opción valida");
                break;
        }
    }

    public void inquirieStudentMail() {
        if (thereAreStudents()) {
            this.view.searchStudentMail(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    public void inquirieStudentLName() {
        if (thereAreStudents()) {
            this.view.searchStudentLName(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    public void inquirieStudentProgram() {
        if (thereAreStudents()) {
            this.view.searchStudentProgram(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    public void inquirieStudentDateB() {
        if (thereAreStudents()) {
            this.view.searchStudentDateB(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    public void countStudentProgram() {
        if (thereAreStudents()) {
            this.view.countStudentsProgram(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }

    public void inquirieStudentCpNumber() {
        if (thereAreStudents()) {
            this.view.searchStudentCPnumber(this.studentDTO);
        } else {
            System.out.println("No existen estudiantes\n");
        }
    }
}

