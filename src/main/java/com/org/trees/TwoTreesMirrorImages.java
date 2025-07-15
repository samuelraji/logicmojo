package com.org.trees;

public class TwoTreesMirrorImages {

    /*
     2           2
   3   4       4   3
 6  7 9 8    8  9 7  6
     */

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(3);
        tree1.left.left = new TreeNode(6);
        tree1.left.right = new TreeNode(7);
        tree1.right = new TreeNode(4);
        tree1.right.left = new TreeNode(9);
        tree1.right.right = new TreeNode(8);

        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(4);
        tree2.left.left = new TreeNode(7);
        tree2.left.right = new TreeNode(6);
        tree2.right = new TreeNode(3);
        tree2.right.left = new TreeNode(8);
        tree2.right.right = new TreeNode(9);
        boolean result = areMirrorImages(tree1, tree2);
        System.out.println("Are both mirroe images :: "+ result);
    }

    private static boolean areMirrorImages(TreeNode tree1, TreeNode tree2) {
        //if (tree1 == null && tree2 == null) return true;
        //if ((tree1 == null && tree2 != null) || (tree1 != null && tree2 == null)) return false;

        if(tree1 == null && tree2 == null)
        {
            return true;
        }

        if(tree1 == null || tree2 == null)
        {
            return false;
        }

        return (tree1.data == tree2.data) && areMirrorImages(tree1.left, tree2.right) && areMirrorImages(tree1.right, tree2.left);
    }
}
