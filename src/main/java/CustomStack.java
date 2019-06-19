public class CustomStack {
    public static final int SEGMENT = 8; // se prefara a fi declarate inaintea celorlalte tipuri de date
    int[] data;
    int size;

    public CustomStack() {
        data = new int[SEGMENT];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void push(int value) { // insereaza in stiva
        if (data.length == size) {
            increaseCapacity();
        }
        data[size] = value;
        size++;
    }

    public int get(int index){
        System.out.println(data[index]);
        return data[index];
    }

    public int searchObject(int value ){
        for(int i = 0; i < data.length; i++){
            if( data[i] == value){
                return i;
            }

        }
        return -1;
    }


    public void increaseCapacity() {
        int[] b = new int[data.length + SEGMENT];
        for (int i = 0; i < data.length; i++) {
            b[i] = data[i];
        }
        data = b;
    }

    public int peek() { //returneaza valoarea celui mai de sus element, nu il elimina
        return data[size - 1];
    }

    public int pop() { // sterge ultimul element din stiva
        int value = data[size - 1];
        data[size - 1] = 0;
        size--; // dupa ce s-a sters scadem cu o unitate index-ul
        return value;
    }
}

