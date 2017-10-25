
package records;
import java.sql.*;


public class rec 
{
    public static int highscr; 
    public static Statement st;
    public static Connection con;
    public rec()
        
    {
        try
            {
                int h;
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3307/rec","root","1234");
                st=con.createStatement();
                ResultSet rs=rec.st.executeQuery("select * from info");
                while(rs.next())
                {
                    h=rs.getInt("Score");
                    if(h>highscr) highscr=h;
                }
            }
            catch(Exception q)
            {
                q.printStackTrace();
            }
    }
           
    
}
