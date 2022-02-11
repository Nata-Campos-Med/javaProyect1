//package model;

public class Student {
    private int id_student; // primary key data base
    private String names, last_names, date_b, inst_mail, personal_mail, program;
    private long cp_number, house_number;
       
            
        public Student() {
        
        }
        
     public Student(int id_student, String names, String last_names, String date_b, String inst_mail, String personal_mail, long cp_number, long house_number, String program) {
        this.id_student = id_student;
        this.names = names;
        this.last_names = last_names;
        this.date_b = date_b;
        this.inst_mail = inst_mail; //key
        this.personal_mail = personal_mail;
        this.cp_number = cp_number;
        this.house_number = house_number;
        this.program = program;
     }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public String getDate_b() {
        return date_b;
    }

    public void setDate_b(String date_b) {
        this.date_b = date_b;
    }

    public String getInst_mail() {
        return inst_mail;
    }

    public void setInst_mail(String inst_mail) {
        this.inst_mail = inst_mail;
    }

    public String getPersonal_mail() {
        return personal_mail;
    }

    public void setPersonal_mail(String personal_mail) {
        this.personal_mail = personal_mail;
    }

    public long getCp_number() {
        return cp_number;
    }

    public void setCp_number(long cp_number) {
        this.cp_number = cp_number;
    }

    public long getHouse_number() {
        return house_number;
    }

    public void setHouse_number(long house_number) {
        this.house_number = house_number;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
     
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombres: ").append(this.getNames());
        sb.append("\nApellidos: ").append(this.getLast_names());
        sb.append("\nFecha nacimiento: ").append(this.getDate_b());
        sb.append("\nCorreo institucional: ").append(this.getInst_mail());
        sb.append("\nCorreo personal: ").append(this.getPersonal_mail());
        sb.append("\nNúmero de teléfono celular: ").append(this.getCp_number());
        sb.append("\nNúmero de teléfono fijo: ").append(this.getHouse_number());
        sb.append("\nPrograma académico: ").append(this.getProgram());
        sb.append("\n");
        return sb.toString();
    }
}
