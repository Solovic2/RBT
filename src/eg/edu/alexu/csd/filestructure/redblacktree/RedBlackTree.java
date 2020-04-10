package eg.edu.alexu.csd.filestructure.redblacktree;

import java.util.ArrayList;

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
			System.out.println(" root "+k.getKey());
			for(int i=0;i<arr.size();i++) {
				System.out.println(" "+arr.get(i).getKey());
			}
			
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
	int l=0;
	int r=0;
	ArrayList <myNode> arr=new ArrayList <myNode>(4);
	int count=1;

	public myNode insertion(myNode node,T key,V value) {
		myNode temp;
		if(node == null) {
			node = new myNode(key,value);
			temp=node;
//			arr= new ArrayList<myNode>(4);
			if(arr.size()==0) arr.add((myNode) node);
			else arr.set(0,(myNode) node);
			count=1;
			System.out.println("her is the last node"+arr.get(0).getKey());
			return node;
		}
		int k = key.compareTo((T) node.getKey());
		if( k > 0 ) {
			 node.setRightChild(insertion((myNode) node.getRightChild() , key,value));
			 r++;
		}else {
		  node.setLeftChild(insertion((myNode) node.getLeftChild() , key,value));
		  l++;
		}
		if(node != null) {
//			System.out.println("parents"+node.getKey());
			if(arr.size()<=2)arr.add((myNode) node);
			else arr.set(count, (myNode) node);
//			System.out.println(arr.get(count).getKey()+ " here ");
			if(count==2 && arr.get(count-1)!=null && node.getLeftChild()!=null) {
//				System.out.println(arr.get(count-1).getKey()+ " beffffor" + " af " + node.getLeftChild().getKey());
				if(arr.get(count-1).getKey()!=node.getLeftChild().getKey()) {
//				 System.out.println("left "+node.getLeftChild().getKey());
					if(arr.size()==3)arr.add((myNode) node.getLeftChild());
					else arr.set(3, (myNode) node.getLeftChild());
//				System.out.println(arr.get(3).getKey() + " left");
				}
				

			}
			 if(count==2 &&arr.get(count-1)!=null && node.getRightChild()!=null) {
//					System.out.println(arr.get(count-1).getKey()+ " beffffor"+ "Df" + node.getRightChild().getKey());

				if(arr.get(count-1).getKey()!=node.getRightChild().getKey()) {
//				System.out.println("right "+node.getRightChild().getKey());
				if(arr.size()==3)arr.add((myNode) node.getRightChild());

				else arr.set(3,(myNode) node.getRightChild());
//				System.out.println(arr.get(3).getKey() + " rgit");

				}
			 }
//			 count =1;
			 count++;
			 if(count == 3) {
				 count=1;
			 }
			 
		}
//		System.out.println(count );
//		System.out.println(arr.size());

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
