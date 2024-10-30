import java.util.ArrayList;

class GfG {
    static ArrayList<Integer> findDistinct(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // Check if this element is included in result
            int j;
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    break;

            // Include this element if not included previously
            if (i == j)
                res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45, };

        ArrayList<Integer> res = findDistinct(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
