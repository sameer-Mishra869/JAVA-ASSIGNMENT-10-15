import java.util.Scanner;

public class RollNumberLookupService {

    static int linearSearch(int[] arr, int key) {

        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i] == key) {
                System.out.println("Linear search : found at index " + i +
                " (" + comparisons + " comparisons)");
                return i;
            }
        }


        System.out.println("Linear search : not found (" + comparisons + " comparisons)");
        return -1;
    }


    static int binarySearch(int[] arr, int key) {

        int low  = 0;
        int high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {

            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == key) {
                System.out.println("Binary search : found at index " + mid +
                            " (" + comparisons + " comparisons)");
                return mid;
            }

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        System.out.println("Binary search : not found (" + comparisons + " comparisons)");
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int[] rolls = {101, 103, 107, 110, 115, 120, 130};

        System.out.println("===== Roll Number Lookup Service =====");


        System.out.print("Registered rolls: ");
        for (int roll : rolls) {
            System.out.print(roll + " ");
        }
        System.out.println();

        while (true) {

            System.out.print("Query roll number (-1 to stop): ");
            int key = sc.nextInt();

            if (key == -1) {
                break;
            }

            int linearResult = linearSearch(rolls, key);
            int binaryResult = binarySearch(rolls, key);


            if (linearResult == binaryResult) {
                System.out.println("Both methods agree.");
            } else {
                System.out.println("Methods disagree.");
            }
        }

        sc.close();
    }
}