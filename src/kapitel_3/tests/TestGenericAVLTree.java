package kapitel_3.tests;

import kapitel_3.work.generics.AVLTree;
import kapitel_3.work.generics.PGFTree;
import kapitel_3.work.generics.IComparator;
import kapitel_3.work.generics.IKey;

public class TestGenericAVLTree {
	public static void main(String[] args) {
        IComparator<PGFTree<Integer>.PGFProxy> pgfComparator = PGFTree.comparator(new IntegerComparatorGeneric());
		
		AVLTree<PGFTree<Integer>.PGFProxy> avlTree = new AVLTree<PGFTree<Integer>.PGFProxy>(pgfComparator);
		PGFTree<Integer> pgfTree = new PGFTree<Integer>(avlTree);

		final int MAX = 15;

//		Random rand = new Random();
		for (int i = 0; i < MAX; i++) {
//			int n = rand.nextInt(100000);
//			System.out.println("Inserting number " + i + ": " + i);
			avlTree.insert(pgfTree.pgfProxy(i));
		}
		
		IKey<Integer> integerKey = new IntegerKeyGeneric(6);
		IKey<PGFTree<Integer>.PGFProxy> key = PGFTree.key(integerKey);
		
		PGFTree<Integer>.PGFProxy proxy = avlTree.binarySearch(key);
		PGFTree.setNodeFormat(proxy, "[inserted node]");
		PGFTree.setChildFormat(proxy, "[draw=red]");
		
//		System.out.println("Height: " + avlTree.height());
//		System.out.println("IsAVLTree: " + avlTree.isAVLTree());
//		System.out.println("ISBalanced: " + avlTree.isAVLBalanced());

		System.out.println(pgfTree.treeToPGF());
	/*	
		Object data = null;

		int i = 0;
		do {
			i++;
			IFIterator it = avlTree.iterator();
			if (it.hasNext()) {
				data = it.next();
				System.out.println("Get: " + data + ", i = " + i);
				System.out.println("IsAVLTree: " + avlTree.isAVLTree());
				System.out.println("ISBalanced: " + avlTree.isAVLBalanced());
				avlTree.remove(data);
			} else {
				data = null;
			}
		} while(data != null);

*/
//		System.out.println(PrintTree.treeToQTree(avlTree));
/*		
		IntegerKey key = new IntegerKey(0);
		
		for (int i = 0; i < MAX; i++) {
			key.data = i;
			avlTree.remove(key);
			System.out.println("Remove: " + i);

//			avlTree.breadthFirst(new PrintWorker());
		
			System.out.println("Height: " + avlTree.height());
			System.out.println("IsAVLTree: " + avlTree.isAVLTree());
			System.out.println("ISBalanced: " + avlTree.isAVLBalanced());
		}
*/

/*
//		int[] array = {6, 2, 8, 1, 4, 7, 3, 5, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
		for (int i = 0; i < array.length; i++) {
			avlTree.insert(array[i]);
		}
		
		avlTree.breadthFirst(new PrintWorker());

		System.out.println("Height: " + avlTree.height());
		System.out.println("IsAVLTree: " + avlTree.isAVLTree());
		System.out.println("ISBalanced: " + avlTree.isAVLBalanced());
	
		IntegerKey key = new IntegerKey(7);
//		avlTree.remove(key);
	
		for (int i = 0; i < array.length; i++) {
			key.data = array[i];
			avlTree.remove(key);

			avlTree.breadthFirst(new PrintWorker());
		
			System.out.println("Height: " + avlTree.height());
			System.out.println("IsAVLTree: " + avlTree.isAVLTree());
			System.out.println("ISBalanced: " + avlTree.isAVLBalanced());
		}
		
		System.out.println("End");
*/
	}
}
