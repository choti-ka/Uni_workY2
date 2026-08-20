public class BoxArray<T>{
    private T[] data = null;
    int pos=0;

    public BoxArray() {
        data =  (T[]) new Object[10];
    }
    public void add(T param) {
        data[pos] = param;
        pos++;
    }
    public int size() {
        return pos;
    }
    public T getData(int i){
        return this.data[i];
    }
}
