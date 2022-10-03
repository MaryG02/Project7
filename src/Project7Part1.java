import java.util.Scanner;
import java.util.Random;
//Group #1
public class Project7Part1 {

    public static void printArray(int[] Array) {
        for (int j : Array) {
            System.out.print(j + " ");
        }
    }


    public static int[] randomArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            int num = random.nextInt(10);
            arr[i] = num;
        }

        return arr;
    }

    public static int arraySize() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, please input the number of elements");
        String input = scan.nextLine();
        int size = Integer.parseInt(input);
        return size;
    }
    public static int[] Sort(int[] arr) {
        int temp = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isSorted = true; // optimization for outer loop, skips already sorted largest elements
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    isSorted = false;
                }
            }
        }
        return arr;
    }

    public static boolean IsYes(Scanner scan) {
        String userInput = scan.nextLine().trim().toLowerCase();

        if (userInput.equals("y")) {
            return true;
        } else
            return false;

    }
    public static int[] InputInt(int[] arr){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the elements of Array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.print("The array is:\n");

        return arr;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Print y to begin");
        while (IsYes(scan)) {
            int[] arr = new int[arraySize()];
            System.out.println("To generate an array type gen, to input the values yourself type anything");
            String userInput = scan.nextLine().trim().toLowerCase();
            if (userInput.equals("gen")) {
                System.out.print("The array is:\n");
                randomArray(arr);
                printArray(arr);
                Sort(arr);
                System.out.println("\nThe sorted array is:");
                printArray(arr);
            } else {
                InputInt(arr);
                printArray(arr);
                Sort(arr);
                System.out.println("\nThe sorted array is:");
                printArray(arr);
            }
            System.out.println("\nIf you want ot repeat enter Y, to finish type anything");
        }
    }
}
