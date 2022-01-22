class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class TreeDiameter {

    public static int findDiameter(TreeNode root) {

        if(root==null) return 0;

        //diameter of tree either passes through this root
        int d = findRadius(root.left,0) + findRadius(root.right,0);

        //or another node as root
        int k = Math.max(findDiameter(root.left),findDiameter(root.right));

        return Math.max(d,k);
    }

    public static int findRadius(TreeNode node, int count) {
        if(node==null) return 0;
        if(node.left==null && node.right==null) return count+1;
        return Math.max(findRadius(node.left,count+1),findRadius(node.right,count+1));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
