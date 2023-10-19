public class Main{
    public static void main(String[] args){
        try {
            IntVector test = new IntVector(-1000);

            System.out.println("Size: " + test.size());

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