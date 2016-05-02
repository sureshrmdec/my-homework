package lintcode;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preorderTraversalHelper(result, root);
        return result;
    }
    private static void preorderTraversalHelper(ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalHelper(result, root.left);
        preorderTraversalHelper(result, root.right);
    }
	public static ArrayList<Integer> preorderTraversalNR(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
		result.add(root.val);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (visited.get(node.hashCode()) == null) { // first visiting
				stack.push(node);
				visited.put(node.hashCode(), 1);
				if (node.left == null) {
				    continue;
				}
				//  System.out.println("push left node:" + node.left.val);
				result.add(node.left.val);
				stack.add(node.left);
			} else if (visited.get(node.hashCode()) == 1) { //seconde visiting
			    if (node.right == null) {
				    continue;
				}
				//  System.out.println("push right node:" + node.right.val);
				result.add(node.right.val);
				stack.add(node.right);
			}
		}
        return result;
	}
    public static List<Integer> preorderTraversalJiuzhang(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();
        
        if (root == null) {
            return preorder;
        }
        
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return preorder;
    }
    //######## inorder #########
    // 注意在询问面试官，当root == null时候，改定义怎样的返回值。这是一个，定义一些边界值，异常的改怎么处理
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        inorderTraversalHelper(root, result);
        return result;
    }
    private void inorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }
    public ArrayList<Integer> inorderTraversalNR(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        if (root == null) {
            return inorder;
        }
        return inorder;
    }
    //######## postorder #########
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // 分冶算法
        ArrayList<Integer> postorder = new ArrayList<Integer>();
        if (root == null) {
            return postorder;
        }
        postorder.addAll(postorderTraversal(root.left));
        postorder.addAll(postorderTraversal(root.right));
        postorder.add(root.val);
        return postorder;
    }
	public static void main(String[] args) {
	    int[][] arrays = {
			null,
	    	{},
	   		{1, 2, 1},
 			{1, 2, 6, 3, 4, 5, 6,6}
	   	};
	   	for(int[] array:arrays){
	    	TreeNode root=TreeNode.buildTreeByArray(array);
	    	System.out.println("##### result:" + BinaryTreeTraversal.preorderTraversal(root));
	    	System.out.println("##### result:" + BinaryTreeTraversal.preorderTraversalNR(root));
    	}
	}
}
