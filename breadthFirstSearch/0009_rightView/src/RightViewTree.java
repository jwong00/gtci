import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        Deque<TreeNode> cache = new ArrayDeque<>();
        cache.add(root);

        while(!cache.isEmpty()) {
            int sz = cache.size();

            for(int i=0;i<sz;i++) {

                TreeNode node = cache.poll();

                if(node.left!=null) cache.offer(node.left);
                if(node.right!=null) cache.offer(node.right);


                if(i==sz-1) result.add(node);
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
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}

