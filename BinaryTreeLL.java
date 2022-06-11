import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL{
  BinaryNode root;


  public BinaryTreeLL(){
    this.root = null;
  }




  //PreOrder Traversal

  void preOrder(BinaryNode node){
    if(node == null){
      return;
    }
    System.out.print(node.value +" ");
    preOrder(node.left);
    preOrder(node.right);
    
  }

  //InOrder Traversal

  void inOrder(BinaryNode node){
    if(node == null){
      return;
    }
    inOrder(node.left);
    System.out.print(node.value +" ");
    inOrder(node.right);
    
  }

  //PostOrder Traversal
  void postOrder(BinaryNode node){
    if(node == null){
    return;
  }
  postOrder(node.left);
  postOrder(node.right);
  System.out.print(node.value +" ");
  }


  //Level Order Traversal

  void levelOrder(){
   Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
   queue.add(root);
    while(!queue.isEmpty()){
    BinaryNode currentNode = queue.remove();
    System.out.print(currentNode.value +" ");
      if(currentNode.left != null){
        queue.add(currentNode.left);
      }
       if(currentNode.right != null){
        queue.add(currentNode.right);
      }
      
    }
    
    
  }
  // Search Method
  public void search(String value){
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
   queue.add(root);
   while(!queue.isEmpty()){
     BinaryNode presentNode = queue.remove();
     if(presentNode.value == value){
       System.out.println("Value "+value+" is found in the tree");
     }else{
       if(presentNode.left !=null){
         queue.add(presentNode.left);
       }
       if(presentNode.right != null){
         queue.add(presentNode.right);
       }
     }
   }
     System.out.println("Value "+value+" is not found in the tree");
 
    
  }
  //Insert Method
   void insert(String value){
     BinaryNode newNode = new BinaryNode();
     newNode.value = value;
     if(root == null){
       root = newNode;
       System.out.println("Successfully inserted");
       return;
        }
     Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
     queue.add(root);
     while(!queue.isEmpty()){
       BinaryNode presentNode = queue.remove();
       if(presentNode.left == null){
         presentNode.left = newNode;
         System.out.println("Successfully inserted");
         break;
         
       }else if(presentNode.right == null){
         presentNode.right = newNode;
         System.out.println("Successfully inserted");
         break;
       }else{
         queue.add(presentNode.left);
         queue.add(presentNode.right);
       }
     }
     
    
  }

  //Find deepest Node
  public BinaryNode findDeepestNode(){
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    BinaryNode presentNode = null;
    while(!queue.isEmpty()){
      presentNode = queue.remove();
      if(presentNode.left != null){
        queue.add(presentNode.left);
      }
        if(presentNode.right != null){
        queue.add(presentNode.right);
      }
    }
    return presentNode;
  }
  //Delete deepest node

 public void deleteDeepestNode(){
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
   BinaryNode previousNode, presentNode = null;
   while(!queue.isEmpty()){
     previousNode = presentNode;
     presentNode = queue.remove();
     if(presentNode.left == null){
       previousNode.right = null;
       return;
     }
     else if(presentNode.right == null){
       previousNode.left = null;
       return;
     }
     queue.add(presentNode.left);
     queue.add(presentNode.right);
   }
   
   
    
  }
  //Delete Given Node
  void deleteNode(String value){
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryNode presentNode = queue.remove();
      if(presentNode.value == value){
        presentNode.value = findDeepestNode().value;
        deleteDeepestNode();
        System.out.println("The node is deleted");
        return;
      }else{
        if (presentNode.left != null){
          queue.add(presentNode.left);
          
        }
         if (presentNode.right != null){
          queue.add(presentNode.right);
          
        }
      }
    }
    System.out.println("The node does not exist in this BT!");
    
  }
  

  
   
  
    
}