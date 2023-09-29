
package com.gcda.dao;


import static com.gcda.connection.ConnectionDB.getConnectionDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gcda.domain.Student;

/**
 *
 * @author SENA
 */
public class StudentDao {
    
    public List<Student> listar(){
        List<Student> students = new ArrayList<>();
        
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnectionDB();
        String sql = "SELECT * FROM student ORDER BY id";
        
        try (con) {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Student student1 = new Student();
                student1.setNombre(rs.getString("firts_name"));
                student1.setApellido(rs.getString("last_name"));
                student1.setTelefono(rs.getString("phone"));
                student1.setEmail(rs.getString("email"));
                student1.setId_Student(rs.getInt("idStudent"));
                students.add(student1);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en la xonsulta: " + e.getMessage());
        }
        
        return students;
    }

    public boolean searchStudentId(Student student){

        PreparedStatement ps;
        ResultSet  rs;
        Connection con = getConnectionDB();
        String sql = "SELECT *   FROM student WHERE idStudent = ?";


        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,student.getId_Student());
            rs=ps.executeQuery();
            while (rs.next()){
                student.setNombre(rs.getString("firts_name"));
                student.setApellido(rs.getString("last_name"));
                student.setTelefono(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                return true;
            }
        }catch (Exception ex){
            System.out.println("Ocurrio un error en la busqueda por id" + ex.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception ex){
                System.out.println("hubo un error al intentar realizar la conexion" + ex.getMessage());
            }

        }
        return  false;

    }
    public boolean addStudent(Student student){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnectionDB();
        String sql = "INSERT INTO student(firts_name, last_name, phone, email)" + "VALUE(?,?,?,?)";

        try {
            ps =con.prepareStatement(sql);
            ps.setString(1, student.getNombre());
            ps.setString(1, student.getApellido());
            ps.setString(1, student.getTelefono());
            ps.setString(1, student.getEmail());
            return true;
        }catch (Exception ex){
            System.out.println("Ocurrio un error en la creacion. " + ex.getMessage());

        }finally {
            try {
                con.close();
            }catch (Exception ex){
                System.out.println("Ocurrio un error al cerrar la conexion. " + ex.getMessage());
            }
        }

        return false;
    }
    
    public List<Student> buscar(){
        List<Student> students = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnectionDB();
        String sql = "SELECT * FROM student";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setNombre(rs.getString("firts_name"));

                student.setApellido(rs.getString("last_name"));

                student.setTelefono(rs.getString("phone"));

                student.setEmail(rs.getString("emial"));

                student.setId_Student(rs.getInt("idStudent"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al realizar la busqueda. "+ e.getMessage());
        }
        
        return students;
    }

    public boolean actualizar(Student student){
        Connection con = getConnectionDB();
        String sql = "UPDATE student SET firts_name =?, last_name=?,phone=?, email =?";

        try(PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1, student.getNombre());
            ps.setString(1,student.getApellido());
            ps.setString(1, student.getTelefono());
            ps.setString(1,student.getEmail());
            ps.setInt(1,student.getId_Student());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Ocurrio un error en  la actualizacion de datos. "+e.getMessage());
        }
        return false;
    }
    public void eliminar(int id_estudiante){
        Connection con = getConnectionDB();
        String sql = "UPDATE FROM student Where idStudent =?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id_estudiante);
            ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Ocurrio un error en la eliminacion de datos. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentDao studentdao = new StudentDao();
        //List<Student> studentList = studentdao.listar();
        //studentList.forEach(System.out::println);
        Student objectStudent = new Student(1);
        System.out.println("objectStudent = " + objectStudent);
        boolean foundObject = studentdao.searchStudentId(objectStudent);
        if(foundObject){
            System.out.println("foundObject = " + foundObject);
        }else{
            System.out.println("no fue encontrado");
        }
//        System.out.println("add new student");
//        Student objectStudent2 = new Student("Gabriel", "Duarte", "3025965432","duartearias2002@gmail.com");
//        boolean objectUpdate = studentdao.addStudent(objectStudent2);
    }
}



