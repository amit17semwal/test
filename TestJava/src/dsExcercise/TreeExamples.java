package dsExcercise;

//Iterative Queue based Java program to do level order traversal
//of Binary Tree

/* importing the inbuilt java classes required for the program */
import java.util.Queue;
import java.util.LinkedList;

/* Class to represent Tree node */
class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = null;
     right = null;
 }
}

/* Class to print Level Order Traversal */
public class TreeExamples {

 Node root;

 /* Given a binary tree. Print its nodes in level order
  using array for implementing queue  */
 void printLevelOrder() 
 {
	 Queue<Node> q = new LinkedList<>();
	 
	 q.add(root);
	 
	 while(!q.isEmpty()){
	
		 Node temp = q.poll();
		 System.out.println("-"+temp.data);
		 if(temp.left!=null)
		 q.add(temp.left);
		 if(temp.right!=null)
		 q.add(temp.right);
		 
		 
	 }
 }
 /* function to print level order traversal of tree*/
 void printLevelOrder1()
 {
     int h = height(root);
     System.out.println("Hight of tree is " + h);
     int i;
     for (i=1; i<=h; i++)
         printGivenLevel(root, i);
 }

 /* Compute the "height" of a tree -- the number of
 nodes along the longest path from the root node
 down to the farthest leaf node.*/
 int height(Node root)
 {
     if (root == null)
        return 0;
     else
     {
         /* compute  height of each subtree */
         int lheight = height(root.left);
         int rheight = height(root.right);
          
         /* use the larger one */
         if (lheight > rheight)
             return(lheight+1);
         else return(rheight+1); 
     }
 }

 /* Print nodes at the given level */
 void printGivenLevel (Node root ,int level)
 {
     if (root == null)
         return;
     if (level == 1)
         System.out.print(root.data + " ");
     else if (level > 1)
     {
         printGivenLevel(root.left, level-1);
         printGivenLevel(root.right, level-1);
     }
 }

 public static void main(String args[]) 
 {
     /* creating a binary tree and entering 
      the nodes */
     TreeExamples tree_level = new TreeExamples();
     tree_level.root = new Node(1);
     tree_level.root.left = new Node(2);
     tree_level.root.right = new Node(3);
     tree_level.root.left.left = new Node(4);
     tree_level.root.left.right = new Node(5);

     System.out.println("Level order traversal of binary tree is - ");
     tree_level.printLevelOrder1();
 }
}


/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Structure of BST node*/

class GfG
{
   /* This function should insert a new node with given data and
      return root of the modified tree  */
    Node insert(Node root, int data)
    {
    	Node n = new Node(data);
         if(root == null)
        	return n;
         else
         {
        	 Node temp = root;
        	 Node  pre = temp;
        	 while(temp!=null) {
        		 pre = temp;
        		 if(temp.data > data) {
        			 temp = temp.left;
        		 }
        		 else {
        			 temp = temp.right;
        		 }
        	 }
        	if(pre.data >data) 
        		pre.right = n;
        	else
        		pre.left = n;
        	return n;
         }
         
        	 
    }
}