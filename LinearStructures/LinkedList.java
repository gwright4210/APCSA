package LinearStructures;

import java.util.Iterator;
import java.lang.Iterable;


public class LinkedList<E> {
    private int size = 0;

    private Node<E> head, tail;

    public LinkedList(){

    }
    
    public LinkedList(E[] objects){
        for(int i = 0; i < objects.length; i++){
            //add(objects[i]);
        }
    }

    public void add(E e){
        add(size, e);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    public int indexOf(E e){
        if(size == 0) return -1;

        int index = 0;
        Node<E> current = head;
        do{
            if(current.element == e){
                return index;
            }
        } while (current != null);
        return -1;
    }


    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if(tail== null){
            tail = head;
        }
    }

    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(tail == null){
            head = tail = newNode; //Only has one node
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void add(int index, E e){
        if(index == 0) addFirst(e);
        else if(index >= size) addLast(e);
        else{
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next; // advance the pointer
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E getFirst(){
        if(size == 0) return null;
        return head.element;
    }

    public E getLast(){
        if(size == 0) return null;
        return tail.element;
    }

    public E removeFirst(){
        if(size == 0) return null;
        else{
            Node<E> temp = head; // save the head
            head = head.next; // move the head down the chain by one 
            size--;
            if(head == null) tail = null;
            return temp.element;
        }
    }

    public E removeLast(){
        if(size == 0) return null;
        else if(size ==1) {
            Node<E> temp = head;
            clear();
            return temp.element;
        }
        else{
            Node<E> current = head;

            for(int i = 0; i < size - 2; i++ ){
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public void clear(){
        size = 0;
        head = tail = null;
    }
    
   public E remove(int index){
        if(size == 0) return null;
        else if(size ==1) {
            Node<E> temp = head;
            clear();
            return temp.element;
        }
        else{
            Node<E> current = head;

            for(int i = 0; i < index-2; i++ ){
                current = current.next;
            }

            Node<E> temp = current.next;
            current.next = current.next.next;
            size--;
            return temp.element;
        }
    }
   

   public E get(int index){
    if(size == 0) return null;
        else if(size ==1) {
            Node<E> temp = head;
            return temp.element;
        }
        else{
            Node<E> current = head;

            for(int i = 0; i < index-1; i++ ){
                current = current.next;

            }
            return current.element;
        }
   }


   public int lastIndexOf(E e){
        int lastIndex = -1;
        Node<E> current = head;
        for(int i = 0; i < size - 1; i++){
            current = current.next;
            if(current.element == e){
                lastIndex = i;  
            }
        }
        return lastIndex;
   }

   // make new node and remove old node
   public E set(int index, E e){
        if(size == 0) return null;
        else if(size ==1) {
            head.element = e;
            return head.element;
        }
        else{
            Node<E> current = head;

            for(int i = 0; i < index-1; i++ ){
                current = current.next;
            }
            E oldValue = current.element;
            current.element = e;
            return oldValue;
        }
   }


    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    //class inside of another class
    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext(){
            return(current.next != null);
        }
        @Override
        public E next(){
            return (current.next).element;
        }
        @Override
        public void remove(){
            LinkedList.this.remove(indexOf(current.element));
    }

   
    //Why is it static? - 
    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element){
            this.element = element;
        }
    }
}
