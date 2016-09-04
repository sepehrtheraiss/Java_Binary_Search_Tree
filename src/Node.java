
public class Node<T extends Comparable<T>> {
      private T value;
      private Node<T> left;
      private Node<T> right;
 
      Node(T value) {
            this.value = value;
            left = null;
            right = null;
      }
      T getValue(){return this.value;}
      Node<T> getLeft(){return this.left;}
      Node<T> getRight(){return this.right;}
      
      void setValue(T value){this.value = value;}
      void setLeft(Node<T> left){this.left = left;}
      void setRight(Node<T> right){this.right = right;}

      boolean add(T value)
      {
    	  switch(value.compareTo(this.value))
    	  {
    	  case -1:
    		  if(left == null)
    		  {
    			  left = new Node<T>(value);
    			  return true;
    		  }
    		  else
    		  {
    			  return left.add(value);
    		  }
    	  case 0:
    		  return false;
    	  case 1:
    		  if(right == null)
    		  {
    			  right = new Node<T>(value);
    			  return true;
    		  }
    		  else
    		  {
    			  return right.add(value);
    		  }
    	  }
    	  return false;
      }

      boolean search(T value)
      {
    	  switch(value.compareTo(this.value))
    	  {
    	  case -1:
    		  if(right == null)
    		  {
    			  return false;
    		  }
    		  else
    		  {
    			  return right.search(value);
    		  }
    	  case 0:
    		  return true;
    	  case 1:
    		  if(left == null)
    		  {
    			  return false;
    		  }
    		  else
    		  {
    			  return left.search(value);
    		  }
    	  }
    	  return false;
      }

      boolean remove(T value, Node<T> parent)
      {
    	  switch(value.compareTo(this.value))
    	  {
    	  case -1:
    		  if(left != null)
    		  {
    			  return left.remove(value, this);
    		  }
    		  else
    		  {
    			  return false;
    		  }
    	  case 1:
    		  if(right != null)
    		  {
    			  return right.remove(value, this);
    		  }
    		  else
    		  {
    			  return false;
    		  }
    	  case 0:
            if (left != null && right != null) 
            {
            this.value = right.minValue();
            right.remove(this.value, this);
            }
            else if (parent.left == this) 
            {
            parent.left = (left != null) ? left : right;
            }
            else if (parent.right == this) 
            {
            parent.right = (left != null) ? left : right;
            }
            return true;
    	  }
    	  return false;
      }

    T minValue() {
          if (left == null)
                return value;
          else
                return left.minValue();
    }
}