import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Deque<TreeNode> cache = new ArrayDeque<>();
        cache.add(root);

        while(!cache.isEmpty()) {
            int sz = cache.size();

            double total = 0;
            for(int i=0;i<sz;i++) {

                TreeNode node = cache.poll();

                total+=node.val;

                if(node.left!=null) cache.offer(node.left);
                if(node.right!=null) cache.offer(node.right);

            }

            result.add(total/sz);

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
