package com.company.dev.maths.algos;

public class TreeProgramming {

	

	public static void main(String[] args) {
		TreeProgramming trees = new TreeProgramming();
		
		BinaryTreeNode<Integer> ileft = new BinaryTreeNode<Integer>(2);
		ileft.addLeft(new BinaryTreeNode<Integer>(1));
		
		BinaryTreeNode<Integer> iright = new BinaryTreeNode<Integer>(500);
		iright.addLeft(new BinaryTreeNode<Integer>(100));
		iright.addRight(new BinaryTreeNode<Integer>(1000));
		
		BinaryTreeNode<Integer> itree = new BinaryTreeNode<Integer>(ileft,30,iright);
		itree.print();
	}
	
	static class BinaryTreeNode<T extends Comparable<T>> {
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		T data;
		public BinaryTreeNode(){
			this(null);
		}
		public BinaryTreeNode(T data){
			this(null,data,null);
		}
		public BinaryTreeNode(BinaryTreeNode<T> left, T data, BinaryTreeNode<T> right){
			this.left=left;
			this.data=data;
			this.right=right;
		}
		boolean addLeft(BinaryTreeNode<T> left){
			if(this.left!=null) return false;
			this.left=left;
			return true;
		}
		boolean addRight(BinaryTreeNode<T> right){
			if(this.right!=null) return false;
			this.right=right;
			return true;
		}
		boolean addData(T data){
			if(data!=null)return false;
			this.data=data;
			return true;
		}
		void print(){
			_print(this);
		}
		private void _print(BinaryTreeNode<T> tree){
			System.out.println("tree: "+tree.data);
			while(tree.left!=null){
				//System.out.println("current <left>"+tree.data);
				tree=tree.left;
				_print(tree);
			}
			System.out.println("data "+tree.data);
			while(tree.right!=null){
				System.out.println("current <right>"+tree.data);
				tree=tree.right;
				_print(tree);
			}
		}
		private void _printLDR(BinaryTreeNode<T> tree){
			while(tree.left!=null){
				_print(tree.left);
			}
			System.out.println(tree.data);
			while(tree.right!=null){
				_print(tree.right);
			}
		}
	}

}
