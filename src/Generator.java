import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by junxiang92 on 13/9/16.
 */
public class Generator {
    public final static int RANDOM_ORDER = 0;
    public final static int ASC_ORDER = 1;
    public final static int DESC_ORDER= 2;

    private int size;
    private int type;

    public Generator(int size, int type) {
        this.size = size;
        this.type = type;
    }

    public int[] generate() {
        switch (type) {
            case RANDOM_ORDER: return generateRandom();
            case ASC_ORDER: return generateAsc();
            case DESC_ORDER: return generateDesc();
        }
        return null;
    }

    private int[] generateRandom() {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i + 1;

        Random rgen = new Random();  // Random number generator

        for (int i=0; i<arr.length; i++) {
            int randomPosition = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }

        return arr;
    }

    private int[] generateAsc() {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i + 1;

        return arr;
    }

    private int[] generateDesc() {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;

        return arr;
    }
}
