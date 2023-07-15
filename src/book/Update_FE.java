
package book;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;

 class Update_FE implements FocusListener{
     Update_frame uf;
     Update_FE(Update_frame uf)
     {
         this.uf=uf;
     }
     
     public void focusGained(FocusEvent e)
     {}
   
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()==uf.t1 && uf.t1.getText().equals("")==false)
        {
           String id=uf.t1.getText();
           try{
               Integer.parseInt(id);
           }
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(uf,"Enter valid bookid\n"+"Eg 1,100,23,...." ,"Vook_id" , JOptionPane.INFORMATION_MESSAGE);
               uf.t1.grabFocus();
           }
        }
        else if(e.getSource()==uf.t5 && uf.t5.getText().equals("")==false)
        {
            try{
                String date=uf.t5.getText();
            {
                Date.valueOf(date);
            }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(uf,"Enter date in given format: YYYY-MM-DD\n EG 2023-01-22");
                uf.t5.grabFocus();
            }
        }
        else if(e.getSource()==uf.t6 && uf.t6.getText().equals("")==false)
        {
            try
            {
                 Double.parseDouble(uf.t6.getText());
                if(uf.t7.getText().equals("")==false)
                {
                    double tot_price=Integer.parseInt(uf.t7.getText())*Double.parseDouble(uf.t6.getText());
                    uf.t8.setText(""+tot_price);
                }  
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(uf,"Enter valid price\nEg 250.50,250,...");
                uf.t6.grabFocus();
            }
        }
        else if(e.getSource()==uf.t7 && uf.t7.getText().equals("")==false)
        {
            try{
                    Integer.parseInt(uf.t7.getText());
                if(uf.t6.getText().equals("")==false)
                {
                    double tot_price=Integer.parseInt(uf.t7.getText())*Double.parseDouble(uf.t6.getText());
                    uf.t8.setText(""+tot_price);
                } 
                
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(uf,"Enter valid quantity\nEg 5,10,50...");
                uf.t7.grabFocus();
            }
        }
    }
}
