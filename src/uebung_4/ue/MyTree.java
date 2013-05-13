package uebung_4.ue;

import kapitel_3.work.generics.Tree;

public class MyTree<T> extends Tree<T> {
	private Node<T> appendAble = null;
	private Node<T> current = null;
	
	protected void breadthFirstAppend(Node<T> newNode) {
	    if (appendAble == null) {
	        root = newNode;
	        appendAble = newNode;
	    } else {
	        if (appendAble.left == null) {
	            appendAble.left = newNode;
	        } else if (appendAble.right == null) {
	            appendAble.right = newNode;
	        } else {
	            while (appendAble.isRightChild()) {
	                appendAble = appendAble.parent;
	            }
	            if (appendAble.isLeftChild()) {
	                appendAble = appendAble.parent.right;
	            }
	            while (appendAble.left != null) {
	                appendAble = appendAble.left;
	            }
	            appendAble.left = newNode;
	        }
            newNode.parent = appendAble;
	    }
	}
	
	protected void breadthFirstAppend2(Node<T> newNode) {
	    if (current == null) {
	        root = newNode;
	    } else {
	        if (current.isLeftChild()) {
	            current = current.parent;
	            current.right = newNode;
	        } else {
	            while (current.isRightChild()) {
	                current = current.parent;
	            }
	            if (current.isLeftChild()) {
	                current = current.parent.right;
	            }
	            while (current.left != null) {
	                current = current.left;
	            }
	            current.left = newNode;
	        }
	    }
        newNode.parent = current;
        current = newNode;
	}
	
	protected void breathFirstAppend3(Node<T> newNode) {
	    if (current == null) {
	        root = newNode;
	    } else {
	        while(current.isRightChild()) {
	            current = current.parent;
	        }
	        if (current.isLeftChild()) {
	            current = current.parent;
	        }
	        if (current.left != null && current.right == null) {
	            current.right = newNode;
	        } else {
	            current = current.right != null ? current.right : current;
	            while (current.left != null) {
	                current = current.left;
	            }
	            current.left = newNode;
	        }
	    }
	    newNode.parent = current;
	    current = newNode;
	}
	
	public void insert(T data) {
		breadthFirstAppend2(new Node<T>(null, data, null));	
	}
}
