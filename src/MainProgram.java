import java.util.Scanner;

public class MainProgram {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Asking for User input
        System.out.print("Hello! What would you like to do?\n1) Generate Data Set\n2) Merge Sort\n3) Quick Sort\n>> ");
        String input = sc.nextLine();
        if (isInteger(input, 10)) {
            switch (Integer.parseInt(input)) {
                case 1: generateDataSet(); break;
                case 2: mergeSort(); break;
                case 3: quickSort(); break;
                default: System.out.println("Please enter a valid input");
            }
        }

    }

    private static void quickSort() {
        Generator g = new Generator(2000, Generator.DESC_ORDER);
        int arr[] = g.generate();

        QuickSort ms = new QuickSort(arr);
        ms.printArr(arr);
        arr = ms.mergeAll();
        ms.printArr(arr);
        System.out.println("Comparisons: " + ms.getComparisons());
        System.out.println("Swaps: " + ms.getSwaps());
    }

    private static void mergeSort() { // Got Error
        Generator g = new Generator(10, Generator.ASC_ORDER);
        int arr[] = g.generate();

        MergeSort ms = new MergeSort(arr);
        ms.printArr(arr);
        arr = ms.mergeAll();
        ms.printArr(arr);
        System.out.println("Comparisons: " + ms.getComparisons());
        System.out.println("Swaps: " + ms.getSwaps());
    }

    private static void generateDataSet() {
        Generator g = new Generator(200, Generator.RANDOM_ORDER);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
