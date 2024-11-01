import java.util.ArrayList;
import java.util.Collections;

class Test {
    static int[] arr = new int[] { 10, 324, 45, 90, 9808, 9808, 9809};
    static ArrayList<Integer> arr_new = new ArrayList<Integer>();
    static ArrayList<Integer> largestArr = new ArrayList<Integer>();
    static int sum = 0;

    static ArrayList arrayToAList() {
        for (int i : arr) {
            arr_new.add(i);
        }
        return arr_new;
    }

    static int largest() {
        int max = Collections.max(arr_new);
        arr_new.remove(Integer.valueOf(max));
        largestArr.add(max);
        if (largestArr.size() == 2) {
            for (int num : largestArr) {
                sum += num;
            }
        }
        return max;
    }

    static int sumOfTwoLargest() {
        arrayToAList();
        for (int i = largestArr.size(); i < 2; i++) {
            largest();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum of two largest number is " + sumOfTwoLargest());
    }
}
