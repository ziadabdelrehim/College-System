package sample;

import java.util.ArrayList;

public class Subject
{
    public static ArrayList<Subject> SubjectsList=new ArrayList<> ();
    protected String  Name;
    protected String Code;
    protected int CreditHours;
    protected String Semester;






    public void setName(String name) {
        Name = name;
    }


    public void setCode(String code) {
        Code = code;
    }

    public String getCode() {
        return Code;
    }

    public void setCreditHours(int creditHours) {
        CreditHours = creditHours;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getSemester() {
        return Semester;
    }

    public Subject()
    {

    }

    public Subject(String name,String code,int credit,String semester)
    {
        this.Name = name;
        this.Code = code;
        this.CreditHours = credit;
        this.Semester = semester;
    }

    public Subject(String name,String semester)
    {
        this.Name = name;
        this.Semester = semester;
    }

    public Subject(String name)
    {
        this.Name = name;
    }

    public String GetName()
    {
        return this.Name;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "Name='" + Name + '\'' +
                ", Code='" + Code + '\'' +
                ", CreditHours=" + CreditHours +
                ", Semester='" + Semester + '\'' +
                '}';
    }
}
