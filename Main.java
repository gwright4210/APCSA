public class Main{
    public static void main(String[] args){
        try {
            IntVector test = new IntVector();

            System.out.println("Size: " + test.size());

            test.add(5);
            test.add(2, 1);
            System.out.println(test);
            for(int i = 0; i < test.size(); i++){}
               

        } catch(IllegalArgumentException ex){
            System.out.println("That's Illegal!");
        }catch(ArithmeticException ex){
            System.out.println("Bad Math");
        }catch(Exception ex){
            System.out.println("Generic Exception");
        }
       
    }    
}