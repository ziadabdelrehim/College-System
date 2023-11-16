package sample;

import java.util.ArrayList;

public class LectureDegrees extends Degrees
{
    public static ArrayList<LectureDegrees> LDList=new ArrayList<> ();
    private int Seventh20;
    private int Twelfth15;
    private int Ten;
    private int Final;


    public LectureDegrees()
    {

    }

    public LectureDegrees(String reg,String subname,int s,int t,int ten,int f)
    {
        super(reg, subname);

        this.Final=f;
        this.Ten=ten;
        this.Seventh20=s;
        this.Twelfth15=t;
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

    public void setSeventh20(int seventh20) {
        Seventh20 = seventh20;
    }

    public int getSeventh20() {
        return Seventh20;
    }

    public void setTwelfth15(int twelfth15) {
        Twelfth15 = twelfth15;
    }

    public int getTwelfth15() {
        return Twelfth15;
    }

    public void setTen(int ten) {
        Ten = ten;
    }

    public int getTen() {
        return Ten;
    }

    public void setFinal(int aFinal) {
        Final = aFinal;
    }

    public int getFinal() {
        return Final;
    }
}
