
public class Run {

	public static void main(String[] args) {
		
		BST<Integer> b = new BST<Integer>();
		
		b.add((int) 'a');
		b.add((int) 'b');
		b.add((int) 'c');
		b.add((int) 'd');
		b.inorder();
	}

}
