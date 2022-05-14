/* Design algorithms for the following operations for a binary tree T: 
• preorderNext(p): Return the position visited after p in a preorder 
traversal of T (or null if p is the last node visited). 
• inorderNext(p): Return the position visited after p in an inorder 
traversal of T (or null if p is the last node visited). 
• postorderNext(p): Return the position visited after p in a postorder 
traversal of T (or null if p is the last node visited). 
What are the worst-case running times of your algorithms? */

public class Question6 {
    Node root;
    class Node{
        public Node left;
        public Node right;
        public int val;

        public Node(int val){
            this.val = val;
        }   
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node curr = root;
        while(curr != null) {
            if (curr.val > value) {
                curr = curr.right;
            } else {
                curr  =curr.left;

            }
        }
        curr = newNode;
        
    }

 public static void main(String [] args){

    
    Question6 treeNode = new Question6();
    treeNode.insert(5);
    treeNode.insert(4);
    treeNode.insert(7);

    System.out.println(treeNode);


 }

}
