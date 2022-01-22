class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class MaximumPathSum {

    public static int findMaximumPathSum(TreeNode root) {

        if(root==null) return 0;
        //determine max sum of path passing through root
        int i = root.val + findMaximumPathSumHelper(root.left) + findMaximumPathSumHelper(root.right);

        //or treat children as roots of paths
        int j = Math.max(findMaximumPathSum(root.left),findMaximumPathSum(root.right));

        return Math.max(i,j);
    }

    public static int findMaximumPathSumHelper(TreeNode node) {
        if(node==null) return 0;
        if(node.left==null && node.right==null) return node.val;
        return node.val + Math.max(findMaximumPathSumHelper(node.left),findMaximumPathSumHelper(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
