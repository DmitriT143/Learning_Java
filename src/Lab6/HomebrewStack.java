package Lab6;

public class HomebrewStack<T>{
    private T[] data;
    private int size;
    public HomebrewStack(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void addItem(T input){
        size++;
        data[size] = input;
    }
    public T pop(){
        T temp = data[size];
        data[size] = null;
        size--;
        return temp;
    }
    public T peak(){
        return data[size];
    }
    public int size(){return size;}
}

