
public class BST<T extends Comparable<T>> {
    private Node<T> root;
    
    BST()
    {
    	root = null;
    }
    boolean add(T value) {
        if (root == null) {
              root = new Node<T>(value);
              return true;
        } else
              return root.add(value);
  }
    boolean search(T value) {
        if (root == null)
              return false;
        else
              return root.search(value);
  }
    boolean remove(T value) {
        if (root == null)
              return false;
        else {
              if (root.getValue() == value) {
                    Node<T> temp = new Node<T>(null);//was 0
                    temp.setLeft(root);
                    boolean result = root.remove(value, temp);
                    root = temp.getLeft();
                    return result;
              } else {
                    return root.remove(value, null);
              }
        }
  }
	void inorder()
	{
		pinorder(root);
	}
	private void pinorder(Node<T> temp)
	{
		if(temp != null)
		{
			pinorder(temp.getLeft());
			System.out.println(temp.getValue());
			pinorder(temp.getRight());
		}

	}
	 <type>void print( type input )
	 {
		 System.out.println(input);
	 }
}
