package tree;

/**
 * @author kelvin
 * @create 2021-03-17 16:59
 */
public class PaperFolding {
    public static void paperFolding(int N) {
        inorderPrint(1, N, "凹");
    }

    private static void inorderPrint(int level, int N, String type) {
        if (level > N) {
            return;
        }
        inorderPrint(level + 1, N, "凹");
        System.out.print(type + " ");
        inorderPrint(level + 1, N, "凸");
    }

    public static void main(String[] args) {
        paperFolding(3);
    }
}
