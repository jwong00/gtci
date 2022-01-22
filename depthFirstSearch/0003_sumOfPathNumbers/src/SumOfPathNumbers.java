import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return findSumOfPathNumbersHelper(root, 0);
    }

    public static int  findSumOfPathNumbersHelper(TreeNode node, int sum) {
        if(node==null) return 0;
        if(node.left==null && node.right==null) return 10*sum + node.val;
        return findSumOfPathNumbersHelper(node.left, 10*sum + node.val) +
                findSumOfPathNumbersHelper(node.right,10*sum + node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
