/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
//         inorder is left, middle, right
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if(root != null) {
            ArrayList<TreeNode> toProcess = new ArrayList<TreeNode>();
            ArrayList<Boolean> processed = new ArrayList<Boolean>();
            toProcess.add(root);
            processed.add(false);
            int index = 0;
            while(index < toProcess.size()) {
                TreeNode cur = toProcess.get(index);
                if(!processed.get(index)) {
                    processed.set(index, true);
                    if(cur != null) {
                        if(cur.left != null) {
                            toProcess.add(index, cur.left);
                            processed.add(index, false);
                            if(cur.right != null) {
                                toProcess.add(index + 2,cur.right);
                                processed.add(index + 2, false);
                            }
                        } else {
                             if(cur.right != null) {
                                toProcess.add(index + 1,cur.right);
                                processed.add(index + 1, false);
                            }  
                        }
                    }
                } else {
                    inorder.add(cur.val);
                    index = index + 1;
                }
            }
            // System.out.println(toProcess);
            // for(int i = 0; i < toProcess.size(); i++) {
            //     inorder.add(toProcess.get(i).val);
            // }
        }
        return inorder;
    }
}