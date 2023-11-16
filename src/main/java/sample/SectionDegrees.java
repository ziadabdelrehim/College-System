package sample;

import java.util.ArrayList;

public class SectionDegrees extends Degrees
{
    public static ArrayList<SectionDegrees> ListOfSD=new ArrayList<> ();
    private int Seventh10;
    private int Twelfth5;

    public SectionDegrees()
    {

    }

    public SectionDegrees(String reg,String subname,int s,int t)
    {

        super(reg, subname);

        this.Seventh10=s;
        this.Twelfth5=t;
    }

    @Override
    public void setReg(String reg) {
        super.setReg (reg);
    }

    @Override
    public String getReg() {
        return super.getReg ();
    }

    @Override
    public void setSubName(String subName) {
        super.setSubName (subName);
    }

    @Override
    public String getSubName() {
        return super.getSubName ();
    }

    public void setSeventh10(int seventh10) {
        Seventh10 = seventh10;
    }

    public int getSeventh10() {
        return Seventh10;
    }

    public void setTwelfth5(int twelfth5) {
        Twelfth5 = twelfth5;
    }

    public int getTwelfth5() {
        return Twelfth5;
    }
}
