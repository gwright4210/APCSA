public class Main{
    public static void main(String[] args){
        try {
            IntVector test = new IntVector();

            System.out.println("Size: " + test.size());

            for(int i = 0; i < 20; i++){
                test.add(1);
            }
            test.add(7, 5);
            test.add(2, 4);
            System.out.println(test);
            test.remove(4);
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