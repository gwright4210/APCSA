
public class IntVector {
    private final static int INITIAL_CAPACITY = 10;
    private int[] arr = new int[INITIAL_CAPACITY];
    private int size = 0;


    public IntVector() {}

    public IntVector(int capacity){
       if(capacity < 0){
           throw new IllegalArgumentException();
       }
       arr = new int[capacity];
            
    }

    public int size(){return size;}

    //CRUD is 99% of business
    // CRUD, Create, Read, Update, Delete

    private void testBounds(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
    
    private void tryResize(){
        if(size >= arr.length-1){
            //making new temp array
            int[] temp = new int[1 + arr.length * 2];
            //copy data over
            for(int i = 0; i < size; i++){
                temp[i] = arr[i];
            }
            //set old array to temp array
            arr = temp;
        }
    }
    //insert the value n at the end of the vector
    public void add(int n){
        tryResize(); //gaurntee capacity first
        arr[size++] = n;
    }

    // Read
    public int get(int index){
        testBounds(index);
        return arr[index];
    }
    // Clear
    public void clear(){
        arr = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public void set(int index, int value){
        testBounds(index);
        arr[index] = value;
    }
/**
 * Sets the elemetn at 'index' eqaul to 'value'
 * Shifts elements to the right
 * Returns 'true' if the value was successfully inserted, false otherwis
 * @param index The position i which the value will be inserted
 * @param value The numerical value to be added
 */


public boolean add(int index, int value){
   testBounds(index);
   tryResize();
   for(int i = size + 1; i > index; i--){
    arr[i] = arr[i-1];
   }
   arr[index] = value;
   size++;
   return true;
}

/**
 * Removes the first instance of 'value' found in the list
 * Shifts remaining values if neccessary
 * Returns 'true' if the value was successfully removed, false otherwis
 *The list remains unchanged if the value does not exist in the list
 * @param value The numerical value to be removed if it exists
 */

 public boolean remove(int value){
   boolean found = false;
   for(int i = 0; i < size-1; i++){
    if(arr[i] == value || found){
       found = true;
       arr[i] = arr[i+1];
    }
   }
   if(found) size--;
   return found;
 }
 
    @Override
    public String toString(){
        if(size == 0) return"[]"; //empty array
        String t = "[" + arr[0];
        for(int i = 1; i < size; i++){
            t += ", " + arr[i];
        }
        return t + "]";
    }
}