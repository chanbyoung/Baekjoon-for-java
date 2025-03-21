import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, char[]> tree = new HashMap<>();
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 트리 구성
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            tree.put(root, new char[] { left, right });
        }

        preorder('A');
        inorder('A');
        postorder('A');

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    // 전위 순회 (루트 - 왼쪽 - 오른쪽)
    public static void preorder(char node) {
        if (node == '.') return;

        pre.append(node);
        preorder(tree.get(node)[0]);
        preorder(tree.get(node)[1]);
    }

    // 중위 순회 (왼쪽 - 루트 - 오른쪽)
    public static void inorder(char node) {
        if (node == '.') return;

        inorder(tree.get(node)[0]);
        in.append(node);
        inorder(tree.get(node)[1]);
    }

    // 후위 순회 (왼쪽 - 오른쪽 - 루트)
    public static void postorder(char node) {
        if (node == '.') return;

        postorder(tree.get(node)[0]);
        postorder(tree.get(node)[1]);
        post.append(node);
    }
}