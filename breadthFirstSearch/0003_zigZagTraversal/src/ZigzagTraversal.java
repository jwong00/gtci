import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Deque<TreeNode> cache = new ArrayDeque<>();
        cache.add(root);
        boolean leftToRight = false;

        while(!cache.isEmpty()) {
            int sz = cache.size();

            List<Integer> level = new ArrayList<>();
            for(int i=0;i<sz;i++) {
                TreeNode node = cache.poll();
                level.add(node.val);

                if(leftToRight) {
                    if(node.left!=null) cache.offer(node.left);
                    if(node.right!=null) cache.offer(node.right);
                }
                else {
                    if(node.right!=null) cache.offer(node.right);
                    if(node.left!=null) cache.offer(node.left);
                }

                leftToRight = !leftToRight;
            }

            result.add(level);

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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
