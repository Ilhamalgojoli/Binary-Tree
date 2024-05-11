public class BTN{   
    class BTNode<T>{
        BTNode left,right ;
        T data ;

        public BTNode(T item){
            left = null ;
            right = null ;
            data = item ;
        }
        public void setLeft(BTNode n){
            left = n ;
        }
        public void setRight(BTNode n){
            right = n ;
        }
        public BTNode getRight(){
            return right ;
        }
        public BTNode getLeft(){
            return left ;
        }
        public void setdata(T d){
            data = d ;
        }
        public T getData(){
            return data ;
        }
    }
    class BinaryTree<T>{
        private BTNode root ;

        public BinaryTree(){
            root = null ;
        }
        public boolean isEmpty(){
            return root == null ;
        }
        public void insert(T data){
            root = insert(root, data);
        }
        private BTNode insert(BTNode node,T data){
            if(node == null){
                node = new BTNode(data);
            }else{
                if(node.getLeft() == null){
                    node.left = insert(node.left, data);
                }else{
                    node.right = insert(node.right, data);
                }
            }
            return node ;
        }
        public int countNode(){
            return countNode(root) ;
        }
        public int countNode(BTNode r){
            if (r == null){
                return 0 ;
            }else{
                int i = 1 ;
                i += countNode(r.getLeft());
                i += countNode(r.getRight());
                return i ;
            }
        }
        public boolean search(BTNode r,T val){
            if(r.getData() == val){
                return true ;
            }if(r.getLeft() != null){
                if(search(r.getLeft(), val))
                    return true ;
            }if(r.getRight() != null){
                if(search(r.getRight(), val))
                    return true ;
            }
            return false ;
        }
        public boolean search(T val){
            return search(root, val);
        }
        public void inOrder(BTNode r){
            if (r != null){
                inOrder(r.getLeft());
                System.out.print(r.getData() + " ");
                inOrder(r.getRight());
            }
        }
        public void inOrder(){
            inOrder(root);
        }
        public void preOrder(BTNode r){
            if (r != null){
                System.out.print(r.getData() + " ");
                preOrder(r.getLeft());
                preOrder(r.getRight());
            }
        }
        public void preOrder(){
            preOrder(root);
        }
        public void postOrder(BTNode r){
            if(r != null){
                postOrder(r.getLeft());
                postOrder(r.getRight());
                System.out.print(r.getData() + " ");
            }
        }
        public void postOrder(){
            postOrder(root);
        }
    }
    public static void main(String[] args){
        BTN btn = new BTN();
        BTN.BinaryTree binaryTree = btn.new BinaryTree();

        binaryTree.insert(23);
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(8);
        binaryTree.insert(11);
        binaryTree.insert(4);
        binaryTree.insert(7);
        
        System.out.println("Inorder : ");   
        binaryTree.inOrder();
        System.out.println();
        System.out.println("Pre Order : " );
        binaryTree.preOrder();
        System.out.println();
        System.out.println("PostOrder : "); 
        binaryTree.postOrder();
        
    }
}
