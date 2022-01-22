import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        // TODO: Write your code here
        Deque<TreeNode> cache = new ArrayDeque<>();
        cache.add(root);

        while(!cache.isEmpty()) {
            int sz = cache.size();


            for(int i=0;i<sz;i++) {

                TreeNode node = cache.poll();

                if(node.left!=null) cache.offer(node.left);
                if(node.right!=null) cache.offer(node.right);

                if(node.val==key) return cache.poll();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
