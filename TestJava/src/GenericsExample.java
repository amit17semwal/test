class Node<L, R> {
	private L leftNode;
	private R rightNode;

	public Node(L left, R right) {
		leftNode = left;
		rightNode = right;
	}

	public L getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(L leftNode) {
		this.leftNode = leftNode;
	}

	public R getRightNode() {
		return rightNode;
	}

	public void setRightNode(R rightNode) {
		this.rightNode = rightNode;
	}

}

public class GenericsExample {

	public static void main(String[] args) {
		Node node = new Node("Russel",
				new Integer(10));
		String name = (String)node.getLeftNode();
		Integer rank =(Integer) node.getRightNode();

		Object nameAsObj = node.getLeftNode();

		System.out.println(name + " " + rank + " " + nameAsObj);
	}

}