import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> cache = new ArrayDeque<>();

        cache.add(root);

        List<Integer> level = new ArrayList<>();

        int cur = cache.size(), next = 0;

        while(!cache.isEmpty()) {
            TreeNode node = cache.poll();
            cur--;

            level.add(node.val);

            if(node.left!=null) {
                cache.offer(node.left);
                next++;
            }
            if(node.right!=null) {
                cache.offer(node.right);
                next++;
            }

            if(cur==0) {
                cur = next;
                next = 0;
                result.add(level);
                level = new ArrayList<>();
            }
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
