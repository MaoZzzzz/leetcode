import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.parseInt(scanner.nextLine());
        String[] nodes = scanner.nextLine().split(" ");
        int[][] edges = new int[nums][nums];
        for (int i = 0; i < edges.length; i++) {
            edges[i][i] = 1;
        }
        for (int i = 0; i < nodes.length; i++) {
            edges[Integer.parseInt(nodes[i])][Integer.parseInt(nodes[i]) - 1] = 1;
            edges[Integer.parseInt(nodes[i]) - 1][Integer.parseInt(nodes[i])] = 1;
        }


    }

    public static void re(int start, int target, int[][] edges) {
        if (edges[start][target] == 1) {

        }
    }
}
