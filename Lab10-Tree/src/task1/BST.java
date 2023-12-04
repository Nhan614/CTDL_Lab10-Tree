package task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if(root == null) {
			root = new BNode<>(e);
		}else {
			this.root = root.add(root, e);
		}
    }

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (root == null) {
			return -1;
		}
		if (node == root.getData()) {
			return 0;
		}

		int re = -1;
		BNode<E> tmp = root;
		while (tmp.getData() == null) {
			if (node == tmp.getData()) {
				re++;
				break;
			} else if (node.compareTo(tmp.getData()) < 0) {
				re++;
				tmp = tmp.getLeft();
			} else if (node.compareTo(tmp.getData()) > 0) {
				re++;
				tmp = tmp.getRight();
			}
		}
		return re;
	}
//	public int depth(E node) {
//		if(root == null) {
//			return -1;
//		}else {
//			return root.depth(node, root, 0);
//		}
//	}

	// compute the height of BST
	public int height() {
		if(this.root== null) return 0;

	    int leftDepth = root.nodeDepth(this.root.getLeft(), 1);
	    int rightDepth = root.nodeDepth(this.root.getRight(), 1);

	    int height = (leftDepth > rightDepth) ? leftDepth: rightDepth;

	    return height;
	}

	// Compute total nodes in BST
	public int size() {
		return root.size(root);
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root == null)
			return false;
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		return root.findMin(root);
	}

	// Find the maximum element in BST
	public E findMax() {
		return root.findMax(root);
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		} else {
			root.remove(root, e);
			return true;
		}
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		return root.descendants(data, root);
	}

	// get the ancestors of a node
	public List<E> ancestors(E e) {
		return root.ancestors(e);
	}

	// display BST using inorder approach
	public void inorder() {
		root.inorder(root);
		System.out.println();
	}

	// display BST using preorder approach
	public void preorder() {
		root.preorder(root);
		System.out.println();
	}

	// display BST using postorder approach
	public void postorder() {
		root.postorder(root);
		System.out.println();
	}
	
	public static void main(String[] args) {
		BST<Integer> b2 = new BST<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(9);
		l1.add(7);
		b2.add(l1);
		
		
		BST<Integer> b1 = new BST<>();
		
		b1.add(10);
		b1.add(15);
		b1.add(5);
		b1.add(3);
		b1.add(16);
		b1.add(9);
		
		b2.inorder();
		b1.inorder();		
		System.out.println("Size: " + b1.size());
		System.out.println("contain 10: " + b1.contains(10));
		System.out.println("Min: " + b1.findMin());
		System.out.println("Max: " + b1.findMax());
		b1.remove(5);
		b1.inorder();
		
	System.out.println("ancestors: " + b1.ancestors(15));
	System.out.println("--------------------------------------------------");
	System.out.println("inorder: "); b1.inorder();
	System.out.println("--------------------------------------------------");
	System.out.println("preorder: "); b1.preorder();
	System.out.println("--------------------------------------------------");
	System.out.println("postorder: "); b1.postorder();
	}
}
