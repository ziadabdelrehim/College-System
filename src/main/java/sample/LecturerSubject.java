package sample;

import java.util.ArrayList;
import java.util.List;

public class LecturerSubject extends Subject
{
    public static ArrayList<LecturerSubject> LecturerSubjects=new ArrayList<> ();

    protected ArrayList<Student> students = new ArrayList<> ();

    public LecturerSubject()
    {

    }

    public LecturerSubject(String name,String code, int credit, String semester)
    {
        super(name, code, credit, semester);


    }
    public LecturerSubject(String name,String semester)
    {
        super(name, semester);

    }
    public LecturerSubject(String name)
    {
        super(name);
    }

    @Override
    public String GetName() {
        return super.GetName ();
    }

    public void setStudents(Student student)
    {
        students.add (student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
