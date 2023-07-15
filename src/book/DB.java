package book;
import java.sql.*;
import javax.swing.JOptionPane;

public class DB {
    Connection conn=null;
    PreparedStatement ps=null;
    PreparedStatement ps1=null;
    PreparedStatement ps2=null;
    PreparedStatement delete=null;
    PreparedStatement update=null;
    CallableStatement cs=null;
    public int i=0;
    DB()
    {
        try{   
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shrey","root","Sdmysql@1234");
        cs=conn.prepareCall("{call update_book_price()}");
        ps=conn.prepareStatement("insert into book values(?,?,?,?,?,?,?,?)");
        ps1=conn.prepareStatement("select * from book");
        ps2=conn.prepareStatement("select count(*) from book");
        delete=conn.prepareStatement("delete from book where bookid=?");
        update=conn.prepareStatement("update book set bookname=?,author=?,publication=?,date_of_publ=?,price=?,qty_ordered=?,tot_cost=? where bookid=?");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
    public void add_books(Jframe j)
    {
        int v=Validate.validate(j);
        if(v==1)
        {
        try
        {
            System.out.println(i);
            i++;
            j.db.ps.setInt(1, Integer.parseInt(j.t1.getText()));
            j.db.ps.setString(2, j.t2.getText());
            j.db.ps.setString(3, j.t3.getText());
            j.db.ps.setString(4, j.t4.getText());
            j.db.ps.setDate(5,Date.valueOf(j.t5.getText()));
            j.db.ps.setDouble(6, Double.parseDouble(j.t6.getText()));
            j.db.ps.setInt(7,Integer.parseInt(j.t7.getText()));
            j.db.ps.setDouble(8, Double.parseDouble(j.t8.getText()));
            j.db.ps.addBatch();
            j.setEmpty();
//            if(i==1)
//                j.l9.setText("Book"+i+"\n");
//            else
//                j.l9.setText(j.l9.getText()+"Book"+i+"\n");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        else
        {
        JOptionPane.showMessageDialog(j, "Fields cannot be empty");}
    }
    
    public void insert_all_books(Jframe j)
    {
        try
        {
            int[]arr= j.db.ps.executeBatch();
//            j.setEmpty();
        }
        catch(Exception e)
        {
            System.out.println(e);
               
        }
    }
    
    public void show_books(Jframe j)
    {
        String[][] data=null;
        String[]column_name;
        int count=0;
        try
        {
            ResultSet rs=j.db.ps1.executeQuery();
            ResultSet rs1=j.db.ps2.executeQuery();
            rs1.next();
            ResultSetMetaData rsmd = rs.getMetaData();
            int rows=Integer.parseInt(rs1.getString(1));
            int columns=rsmd.getColumnCount();
            column_name = new String[columns];
            for(int i=1;i<=columns;i++)
            {
                column_name[i-1]=rsmd.getColumnName(i);
            }
            data=new String[rows][columns];
            while(rs.next())
            {
                for(int i=1;i<=columns;i++)
                {
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            new View_frame(data,column_name);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void delete_book(Jframe j)
    {
        try
        {
           int id=Integer.parseInt(JOptionPane.showInputDialog(j, "Enter book_id which you want to delete", "Delete",JOptionPane.PLAIN_MESSAGE ));
           j.db.delete.setInt(1, id);
           int success=j.db.delete.executeUpdate();
           if(success==0)
           {
                JOptionPane.showMessageDialog(j, "Enter valid book id","Deletion", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void update_book_price()
    {
        try{
        ResultSet rs=cs.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
