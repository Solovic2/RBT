package eg.edu.alexu.csd.filestructure.redblacktree;

public class RedBlackTree <T extends Comparable<T>, V> implements IRedBlackTree<T,V> {
	
	private myNode root=null;
	
	
	@Override
	public INode<T, V> getRoot() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		return root==null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root=null;
	}

	@Override
	public V search(T key) {
		if(root == null) return null;
		myNode found = searching(root, key);
		if(found == null )return null;
		return (V) found.getValue();
	}

	@Override
	public boolean contains(T key) {
		if(root == null) return false;
		myNode found = searching(root, key);
		if(found == null )return false;
		return true;
	}

	@Override
	public void insert(T key, V value) {
		if(root==null) {
			System.out.println("DSDs");

			myNode node=new  myNode (key, value);
			root=node;
			root.setColor(false);
//			System.out.println((int)root.getKey());

			return;
		}else {
			myNode t=searching(root, key);
			if(t!=null) {
				t.setValue(value);
				return ;
			}
			
			myNode k=insertion(root, key, value);
			System.out.println(k.getKey());
		}
		
	}

	@Override
	public boolean delete(T key) {
		// TODO Auto-generated method stub
		return false;
	}
	public myNode searching(myNode node, T key) {
		if(node == null) return null;

		if( node.getKey()==key) return node;
		int k = key.compareTo((T) node.getKey());
		if( k > 0 ) {
			
			return searching((myNode) node.getRightChild() , key);
		}
			return searching((myNode) node.getLeftChild() , key);
	}
	public myNode insertion(myNode node,T key,V value) {
		myNode temp;
		if(node == null) {
			node = new myNode(key,value);
			return node;
//			System.out.println(node.getKey());
		}
		int k = key.compareTo((T) node.getKey());
		if( k > 0 ) {
			 node.setRightChild(insertion((myNode) node.getRightChild() , key,value));
			 node.getRightChild().setParent(node);
//			System.out.println(node.getKey());
		}else {
		  node.setLeftChild(insertion((myNode) node.getLeftChild() , key,value));
		  node.getLeftChild().setParent(node);
//			System.out.println(" "+node.getKey());
		}
		return node;
	}
	void inorderRec(myNode iNode) { 
        if (iNode != null) { 
            inorderRec((myNode) iNode.getLeftChild()); 
            System.out.println(iNode.getKey()); 
            inorderRec((myNode) iNode.getRightChild()); 
        } 
    } 
}
