package book;
import java.awt.event.*;
import java.sql.*;

public class Actionevent implements ActionListener{
    Jframe j=null;
    Actionevent(Jframe j)
    {
        this.j=j;
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == j.b1)
        {
            j.f.add_books(j);
            j.db.add_books(j);
            
        }
        else if(a.getSource() == j.b2)
        {
           j.f.insert_all_books(j);
           j.db.insert_all_books(j);
        }
        else if(a.getSource() == j.b3)
        {
//           j.db.show_books(j);
            j.f.show_books(j);
        }
        else if(a.getSource() == j.b4)
        {
//            j.db.delete_book(j);
            j.f.delete_books(j);
        }
        else if(a.getSource() == j.b5)
        {
            j.f.update_books(j);
        }
        else if(a.getSource() == j.cb1)
        {
            j.f.search_book(j);
        }
    }
}
