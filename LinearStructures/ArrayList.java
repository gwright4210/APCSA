package LinearStructures;

//generic class
public class ArrayList<E> {
    //protected is public in the package, but private outside the package
    protected static final int INITIAL_CAPACITY = 10;

    private int size = 0;

    @SuppressWarnings("unchecked")
    private E[] data = (E[])new Object[INITIAL_CAPACITY];

    public ArrayList() {}

    public ArrayList(E[] objects){
        for(int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }
@SuppressWarnings("unchecked")
    private void ensureCapacity(){
        if(size >= data.length){
            E[] newData = (E[])new Object[size * 2 + 1];

            System.arraycopy(data, 0, newData, 0, size);
            data = newData;

        }
    }

    public void add(E e){
        add(size, e);
    }

    public void add(int index, E e){
        ensureCapacity();

        for(int i = size - 1; i >= index; i--){
            data[i+1] = data[i]; //right shift insert
        }
        data[index]  = e;
        size++;
    }
    //TODO: bring over the toString method from IntVector
    // Test this ArrayList class' add functions in Main
    // Push to github
    @Override
    public String toString(){
        if(size == 0) return"[]"; //empty array
        String t = "[" + data[0];
        for(int i = 1; i < size; i++){
            t += ", " + data[i];
        }
        return t + "]";
    }
}
