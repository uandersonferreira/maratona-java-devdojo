public class JavaBank extends JFrame{
    private static final long serialVersionUID = 1L;
    //Make these variables publicly available
    public String name;
    public int accountNum;
    public int balance;

    //Create a new object based on the immutable class
    CompanyColor companyColor = new CompanyColor();
    //Create a new Color object and set the RGB values based on the immutable class fields
    private Color myColor = new Color
    (companyColor.getR(), companyColor.getG(), companyColor.getB());

    //Jpanel for user inputs
    private Jpanel inputDetailJPanel;

}