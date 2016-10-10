package oop;

/**
 * Created by RazieL on 10.10.2016.
 */
public class StoreNumbers {
    private boolean[] numbers = new boolean[100];

    public void store(int num) {
        numbers[num] = true;
    }

    public boolean isStored(int num) {
        return numbers[num];
    }

    public static void main(String[] args) {
        StoreNumbers sn = new StoreNumbers();
        System.out.println(sn.isStored(2));
        sn.store(2);
        System.out.println(sn.isStored(2));
    }
}
