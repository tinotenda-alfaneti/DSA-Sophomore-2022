public class BinaryTotal<T>{

	private TreeNode<T> root;

	private static class TreeNode<T> {
		private T data;
		private TreeNode<T> left;
		private TreeNode<T> right;

		TreeNode(T dt, TreeNode<T> lft, TreeNode<T> rt) {
			data = dt;
			left = lft;
			right = rt; 
		}

	}
	public BinaryTotal() {
		root = null;
	}

	public void addRoot(T d) {
		TreeNode<T> newRoot = new TreeNode<>(d, null, null);
		root = newRoot;
	}
	public void addLeft(TreeNode<T> parent, TreeNode<T> lc) {
		parent.left = lc;
	}
	public void addRight(TreeNode<T> parent, TreeNode<T> rc) {
		parent.right = rc;
	}

	public static void main(String[] args) {
		BinaryTotal<Integer> test = new BinaryTotal<Integer>();
		test.addRoot(12);
		test.addLeft(test.root, new TreeNode<Integer>(14, null, null));
		test.addRight(test.root, new TreeNode<Integer>(16, null, null));
		test.addRight(test.root.right, new TreeNode<Integer>(18, null, null));
		test.addLeft(test.root.left, new TreeNode<Integer>(5, null, null));

		int theTotal = test.total(test.root);
		System.out.println(theTotal);

	}

	public int total(TreeNode<Integer> rt) {
		if (rt == null) return 0;

		return rt.data + total(rt.left) + total(rt.right);
	}

}