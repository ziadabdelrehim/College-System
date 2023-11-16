package sample;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements IGPA {

    public static ArrayList<Student> StudentsList=new ArrayList<> ();
    private ArrayList<StudentSubject> SS=new ArrayList<> ();


    public Student()
    {

    }

    public Student(String name, String id)
    {
        super(name,id);
    }

    public void AddSubject(StudentSubject subject)
    {

        SS.add (subject);
    }

    public List<StudentSubject> getSS() {
        return SS;
    }



    @Override
    public String GetID()
    {
        return this.Id;
    }

    @Override
    public String GetName() {
        return super.GetName ();
    }



    @Override
    public double CalcGPA()
    {
        int TotalSD=0;
        double TotalPoints=0;
        int TotalHours=0;

        for (int i=0;i<LectureDegrees.LDList.size ();i++)
        {




            if(LectureDegrees.LDList.get (i).Reg.equals (this.Id))
            {
                for(int j=0;j<SectionDegrees.ListOfSD.size ();j++)
                {
                    if(SectionDegrees.ListOfSD.get (j).Reg.equals (this.Id) && SectionDegrees.ListOfSD.get (j).SubName.equals (LectureDegrees.LDList.get (i).SubName))
                    {
                        for(int k=0;k<Subject.SubjectsList.size ();k++)
                        {
                            if(Subject.SubjectsList.get (k).Name==LectureDegrees.LDList.get (i).SubName)
                            {
                                TotalSD=0;
                                TotalSD=LectureDegrees.LDList.get (i).getSeventh20 ()+LectureDegrees.LDList.get (i).getTwelfth15 ()
                                        +LectureDegrees.LDList.get (i).getTen ()+LectureDegrees.LDList.get (i).getFinal ()
                                        +SectionDegrees.ListOfSD.get (j).getSeventh10 ()+SectionDegrees.ListOfSD.get (j).getTwelfth5 ();


                                if(TotalSD>=97)
                                {
                                        TotalPoints=TotalPoints+(4*Subject.SubjectsList.get (k).CreditHours);

                                        TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if(TotalSD>=93)
                                {
                                    TotalPoints=TotalPoints+(3.83*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if(TotalSD>=89)
                                {
                                    TotalPoints=TotalPoints+(3.67*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if (TotalSD>=84)
                                {
                                    //B+
                                    TotalPoints=TotalPoints+(3.3*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if(TotalSD>=80)
                                {
                                    //B
                                    TotalPoints=TotalPoints+(3*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if (TotalSD>=76)
                                {
                                    //B-
                                    TotalPoints=TotalPoints+(2.67*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if (TotalSD>=73)
                                {
                                    //C+
                                    TotalPoints=TotalPoints+(2.3*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if (TotalSD>=70)
                                {
                                    //C
                                    TotalPoints=TotalPoints+(2*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if(TotalSD>=67)
                                {
                                    //C-
                                    TotalPoints=TotalPoints+(1.67*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if(TotalSD>=64)
                                {
                                    //D+
                                    TotalPoints=TotalPoints+(1.3*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else if(TotalSD>=60)
                                {
                                    //D
                                    TotalPoints=TotalPoints+(1*Subject.SubjectsList.get (k).CreditHours);
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }
                                else
                                {
                                    //F

                                    TotalPoints=TotalPoints+0;
                                    TotalHours=TotalHours+Subject.SubjectsList.get (k).CreditHours;
                                }


                            }
                        }
                    }
                }

            }

        }


        return TotalPoints/TotalHours;
    }
}
