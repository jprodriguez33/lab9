import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
    class Node {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = null;
            right = null;
        }

    }
    public class LevelOrderTraversal {
        public static void main(String[] args) {
            Node root = new Node(4); // root of the tree with data 4
            root.left = new Node(2);
            root.right = new Node(6);
            root.left.left = new Node(1);
            root.left.right = new Node(3);
            root.right.left = new Node(5);
            root.right.right = new Node(7);

            List<Node> res = levelOrder(root);
            for(Node n : res){
                System.out.print(n.data+" ");
            }
        }

        private static List<Node> levelOrder(Node root) {
            List<Node> result = new ArrayList<>(); // to store level order result
            Queue<Node> q = new ArrayDeque<>(); // queue to perform level order
            q.add(root); //adding root as 1st element of queue
            // q -> 4
            while (!q.isEmpty()){
                int size = q.size(); // storing number of nodes at each level
                while (size>0){
                    Node rem = q.poll();// removing node at from the level
                    result.add(rem); // adding it into result
                    if(rem.left!=null){// if left child is present the add it in q for next level
                        q.add(rem.left);
                    }
                    if(rem.right!=null){// if right child is present the add it in q for next level
                        q.add(rem.right);
                    }
                    size--;
                    // here before the start of every level we are calculating the size of that level
                    // so in while loop 2 we are adding left and right children but they will not be processed in the current level
                }
            }
            return result;
        }
}