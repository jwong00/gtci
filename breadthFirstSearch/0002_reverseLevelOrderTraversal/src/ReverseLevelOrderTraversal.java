import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        Deque<TreeNode> cache = new ArrayDeque<>();
        cache.add(root);

        while(!cache.isEmpty()) {
            int sz = cache.size();

            List<Integer> level = new ArrayList<>();
            for(int i=0;i<sz;i++) {
                TreeNode node = cache.poll();
                level.add(node.val);
                if(node.left!=null) cache.offer(node.left);
                if(node.right!=null) cache.offer(node.right);
            }

            result.add(0,level);

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
