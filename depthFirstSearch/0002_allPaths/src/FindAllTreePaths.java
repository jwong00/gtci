import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPathsHelper(root,sum,path,allPaths);
        return allPaths;
    }

    public static void findPathsHelper(TreeNode node, int sum, List<Integer> path, List<List<Integer>> allPaths) {
        if(node==null) return;

        path.add(node.val);

        if(node.left==null && node.right==null && node.val==sum) allPaths.add(new ArrayList<Integer>(path));
        else {
            findPathsHelper(node.left,sum-node.val,path,allPaths);
            findPathsHelper(node.right,sum-node.val,path,allPaths);
        }

        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
