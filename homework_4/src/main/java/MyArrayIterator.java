import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayIterator implements Iterator<Object> {
    private Object[] arr;
    private int index;

    MyArrayIterator(Object[] arg) {
        arr = arg;
        index = -1;
    }

    @Override
    public boolean hasNext() {
        if(index<(arr.length-1))
            return true;
        else
            return false;
    }

    @Override
    public Object next() {
        int pos = ++index;
        if(pos<0 || pos >= arr.length)
            throw new NoSuchElementException();
        return arr[pos];
    }

    public static void main(String[] args) {
        Object[] arr = new Object[]{1,2,3,11,11,12,21,34,56,77,88,88,65,43};
        MyArrayIterator iterArr = new MyArrayIterator(arr);
        while(iterArr.hasNext())
        {
            System.out.println(iterArr.next());
        }
    }
}
