import LinearStructures.ArrayList;

public class Main {
    public static void main(String[] args){
       ArrayList<String> strings = new ArrayList<>();
       ArrayList<Integer> nums = new ArrayList<>();

       strings.add("Cat");
       strings.add("Hat");
       strings.add("Fat");

       nums.add(4);
       nums.add(6);
       nums.add(3);
    
       System.out.println(strings);
       System.out.println(nums);

    }
}