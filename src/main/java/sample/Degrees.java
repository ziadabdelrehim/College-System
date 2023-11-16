package sample;

public class Degrees
{
    protected String Reg;
    protected String SubName;

    public Degrees()
    {

    }

    public Degrees(String reg,String subname)
    {
        this.SubName = subname;
        this.Reg = reg;

    }

    public void setReg(String reg) {
        Reg = reg;
    }

    public String getReg() {
        return Reg;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    public String getSubName() {
        return SubName;
    }




}
