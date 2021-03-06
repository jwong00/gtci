import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        // TODO: Write your code here

        Deque <TreeNode> cache = new ArrayDeque<>();
        cache.add(root);
        int level = 0;

        while(!cache.isEmpty()) {
            level++;
            int sz = cache.size();
            for(int i=0;i<sz;i++) {

                TreeNode node = cache.poll();

                if(node.left==null && node.right==null) return level;

                if(node.left!=null) cache.add(node.left);
                if(node.right!=null) cache.add(node.right);

            }

        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
