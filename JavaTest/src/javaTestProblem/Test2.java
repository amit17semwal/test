package javaTestProblem;


class Super 
{ 
    private void who()
    {
        System.out.println("Inside private method Super(who)");
    }
  
    public static void whoAmI()
    {
        System.out.println("Inside static method, Super(whoAmI)");
    }
  
    public void whoAreYou()
    {
        who();
        System.out.println("Inside virtual method, Super(whoAreYou)");
    }
}
 
class Sub extends Super
{ 
    private void who()
    {
        System.out.println("Sub(who)");
    }
  
    public static void whoAmI()
    {
        System.out.println("Sub(whoAmI)");
    }
  
    public void whoAreYou()
    {
        who();
        System.out.println("Sub(whoAreYou)");
    }
}
public class Test2
{
    public static void main(String args[]) 
    {
        Super p = new Sub();  
        p.whoAmI(); 
        p.whoAreYou(); 
    }
}