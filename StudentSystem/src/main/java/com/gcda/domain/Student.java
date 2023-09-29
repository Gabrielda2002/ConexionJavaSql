package com.gcda.domain;

public class Student {
    private int id_Student;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    
    public Student(){
    }
    
   public Student(int id_Student){
       this.id_Student = id_Student;
   }
   public Student (String nombre, String apellido, String telefono, String email){
       this.nombre = nombre;
       this.apellido = apellido;
       this.telefono = telefono;
       this.email = email;
   }

    public Student(int id_Student, String nombre, String apellido, String telefono, String email) {
        this.id_Student = id_Student;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

   
    public int getId_Student() {
        return id_Student;
    }

    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_Student=" + id_Student +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}