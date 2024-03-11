public class BST
{
  static class Node{
    int value;
    Node left;
    Node right;

    Node(int value)
    {
      this.value = value;
    }
  }

  public static Node insertNode(Node root,int value)
  {
    if(root == null)
    {
      root = new Node(value);
      return root;
    }
    if(value < root.value)
    {
      root.left = insertNode(root.left, value);
    }
    else
    {
      root.right = insertNode(root.right, value);
    }

    return root;
  }

  public static void inOrder(Node root)
  {
    if(root == null)
    {
      return;
    }
    inOrder(root.left); //l
    System.out.print(root.value + " ");//root
    inOrder(root.right); //r
  }

  public static void preOrder(Node root)
  {
    if(root == null)
    {
      return;
    }
    System.out.print(root.value + " ");//root
    inOrder(root.left); //l
    inOrder(root.right); //r
  }

  public static void postOrder(Node root)
  {
    if(root == null)
    {
      return;
    }
    inOrder(root.left); //l
    inOrder(root.right); //r
    System.out.print(root.value + " ");//root
  }
  public static void main(String[] args) {
    int[] values = {5,1,3,4,2,7};
    Node root = null;

    for(int i=0;i<values.length;i++)
    {
      root = insertNode(root, values[i]);
    }
    System.out.println("In order");
    inOrder(root);
    System.out.println();
    System.out.println("Pre order");
    preOrder(root);
    System.out.println();
    System.out.println("Post order");
    postOrder(root);
  }
}