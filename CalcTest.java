class Calculator {
private
  static boolean UseFloat;
public
  static void EnableFloat() {
    UseFloat= true;
  }

  static void DisableFloat() {
    UseFloat= false;
  }

  static int Add(int arg1, int arg2) {
    return arg1 + arg2;
  }

  static double Add(double arg1, double arg2) throws Exception{
    if (!UseFloat) 
      throw new Exception("Floats are disabled"); 
   return arg1 + arg2;
  }

  static int Subtract(int arg1, int arg2) {
    return Add(arg1, -arg2);
  }
 
  static double Subtract(double arg1, double arg2) throws Exception {
    if (!UseFloat)
      throw new Exception("Floats are disabled"); 
    return Add(arg1, -arg2);
  }

  static int Mult(int arg1, int arg2) {
    return arg1 * arg2;
  }

  static double Mult(double arg1, double arg2) throws Exception{
    if (!UseFloat) 
      throw new Exception("Floats are disabled"); 
    return arg1 * arg2;
  }
}

class CalcTest {
  static Calculator c;
  
  public static void Check(boolean v, String msgSuccess, String msgFailure) {
      if (v) {
          System.out.println(msgSuccess);
      }
      else
          System.out.println(msgFailure);
  }
  
  public static void main(String[] args) throws Exception{

    //System.out.println("WTF");
    Check(c.Add(1,0) == 1, "OK","Addition to zero failed");
    Check(c.Add(2,3) == 5,"OK","2+3!=5" );

    Check(c.Mult(1,0) == 0,"OK","Multiplication by zero failed");
    Check(c.Mult(2,3) == 6,"OK","2*3!=6" );
    Check(c.Mult(100,100) == 10000,"OK","100*100!=10000");
  
    c.DisableFloat();
    boolean b = false;
    try {
      c.Mult(1.0,1.0);
    }
    catch (Exception E) {
      b= true;
    }
    Check(b,"OK","Float disabling doesn't work");

    b = false;
    try {
      c.Add(1.0,1.0);
    }
    catch (Exception E) {
      b= true;
    }
    Check(b,"OK","Float disabling doesn't work");
    
    c.EnableFloat();

    Check(c.Mult(1.1,0) == 0.0,"OK","float multiplication by zero failed");
    Check(c.Mult(2.5,4) == 10.0,"OK","2.5*4!=10" );
    Check(c.Mult(1.5,1000) == 1500.0,"OK","1.5*1000!=1500");
    Check(c.Add(1.1,1.2) == 2.3,"OK","1.1+1.2=2.3");

  }

}
