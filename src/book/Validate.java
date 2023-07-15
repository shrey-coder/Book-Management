package book;

public class Validate {
  public static int validate(Jframe j)
  {
      if(j.t1.getText().equals("") || j.t2.getText().equals("") || j.t3.getText().equals("")
              || j.t4.getText().equals("") || j.t5.getText().equals("") || j.t6.getText().equals("")
              || j.t7.getText().equals("") || j.t8.getText().equals(""))
          return 0;
      return 1;
  }
  public static int validate(Update_frame uf)
  {
      if( uf.t2.getText().equals("") || uf.t3.getText().equals("")
              || uf.t4.getText().equals("") || uf.t5.getText().equals("") || uf.t6.getText().equals("")
              || uf.t7.getText().equals("") || uf.t8.getText().equals(""))
          return 0;
      return 1;
  }
}
