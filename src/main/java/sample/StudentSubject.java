package sample;

import java.util.ArrayList;

public class StudentSubject extends Subject
{
    public static ArrayList<StudentSubject> StudentSubjects=new ArrayList<> ();
    private String Reg;
    private SectionDegrees sectionDegreesD;
    private LectureDegrees lectureDegrees;

    public void setReg(String reg) {
        Reg = reg;
    }

    public String getReg() {
        return Reg;
    }



    public StudentSubject()
    {

    }

    public StudentSubject(String name,String code, int credit, String semester,SectionDegrees Sd,LectureDegrees ld)
{
    super(name, code, credit, semester);
    this.sectionDegreesD = Sd;
    this.lectureDegrees=ld;
}

    public StudentSubject(String name,String semester,String reg)
{
    super(name, semester);
    this.Reg = reg;
}

    public StudentSubject(String name,String reg)
{
    this.Name=name;
    this.Reg = reg;
}


    @Override
    public String GetName() {
        return super.GetName ();
    }
}

