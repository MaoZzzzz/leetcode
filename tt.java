import java.util.ArrayList;
import java.util.Scanner;

public class tt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int a = Integer.parseInt(str[2]);

        int res = 0;
        ArrayList<ArrayList<Character>> arrayList = new ArrayList<>();
        String[] tmp = null;
        for (int i = 0; i < n; i++) {
            tmp = scanner.nextLine().split(" ");
            ArrayList<Character> arr = null;
            for (int j = 0; j < tmp.length; j++) {
                arr = new ArrayList<>();
                for (int k = 0; k < a; k++) {
                    arr.add(tmp[j].charAt(k));
                }
            }
            arrayList.add(arr);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m * a; j++) {
                int row = 0;
                int column = 0;
                if (i == n - 1 && j >= m * a - a) {
                    row = 0;
                    column = j - (m * a - a);
                } else if (i != n - 1 && j >= m * a - a) {
                    row = i + 1;
                    column = j - (m * a - a);
                } else if (i == n - 1 && j < m * a - a) {
                    row = 0;
                    column = j + a;
                } else {
                    row = i + 1;
                    column = j + a;
                }

                if (arrayList.get(i).get(j) != arrayList.get(row).get(column)) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}