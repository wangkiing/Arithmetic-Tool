package com.wangkiing.arithmetic.datastructure;

/**
 * 常用数据结构
 * @author wangkiing
 *
 */
public class DataStructureUtil {


	/**
	 * 建立最小堆
	 * @param args
	 */
	public static void buildMinHeap(int[] args){
		int n = args.length;
		for (int i=n/2-1;i>=0;i--)  
			minHeapFixDown(args,i,n);  
	}
	
	/**
	 * 插入最小堆
	 * 一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。
	 * 它的左右子结点下标分别为2 * i + 1和2 * i + 2。如第0个结点左右子结点下标分别为1和2。
	 * @param args 原来数组
	 * @param i 插入值索引
	 */
	public static void minHeapFixUp(int[] args,int i){
		int parent = (i-1) / 2;
		int newNode= args[i];
		while(parent>0&&i!=0){
			if(args[parent]<=newNode){
				break;
			}else{
				args[i] = args[parent];
				args[parent] = newNode;
				i=parent;
				parent = (parent-1) / 2;
			}
		}
		
	}
	
	/**
	 * 删除最小堆
	 * 将最后一个数据的值赋给根结点，然后再从根结点开始进行一次从上向下的调整
	 * 调整时先在左右儿子结点中找最小的，如果父结点比这个最小的子结点还小说明不需要调整了，
	 * 反之将父结点和它交换后再考虑后面的结点。相当于从根结点将一个数据的“下沉”过程
	 * @param args 原来数组
	 * @param i 调整节点索引
	 * @param n 节点总总数，即数组长度
	 */
	public static void minHeapFixDown(int[] args,int i,int n){
		int lastNode = args[i];
		int j= 2*i+1;
		while(j<n){
			//如果是右节点小，则j+1
			if(j+1<n&&args[j+1]<args[j]){
				j++;
			}
			//如果子节点均大于移动节点，则替换节点，反之则移动节点
			if(args[j]>lastNode){
				break;
			}else{
				args[i] = args[j];
				args[j] = lastNode;
				i=j;
				j=2*i+1;
			}
		}
	}
		
	
	/**
	 * 建立最大堆
	 * @param args
	 */
	public static void buildMaxHeap(int[] args){
		int n = args.length;
		for (int i=n/2-1;i>=0;i--)  
			maxHeapFixDown(args,i,n);  
	}
	
	/**
	 * 插入最大堆
	 * 一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。
	 * 它的左右子结点下标分别为2 * i + 1和2 * i + 2。如第0个结点左右子结点下标分别为1和2。
	 * @param args 原来数组
	 * @param i 插入值索引
	 */
	public static void maxHeapFixUp(int[] args,int i){
		int parent = (i-1) / 2;
		int newNode= args[i];
		while(parent>0&&i!=0){
			if(args[parent]>=newNode){
				break;
			}else{
				args[i] = args[parent];
				args[parent] = newNode;
				i=parent;
				parent = (parent-1) / 2;
			}
		}
		
	}
	
	/**
	 * 删除最大堆
	 * 将最后一个数据的值赋给根结点，然后再从根结点开始进行一次从上向下的调整
	 * 调整时先在左右儿子结点中找最大的，如果父结点比这个最大的子结点还大说明不需要调整了，
	 * 反之将父结点和它交换后再考虑后面的结点。相当于从根结点将一个数据的“下沉”过程
	 * @param args 原来数组
	 * @param i 调整节点索引
	 * @param n 节点总总数，即数组长度
	 */
	public static void maxHeapFixDown(int[] args,int i,int n){
		int lastNode = args[i];
		int j= 2*i+1;
		while(j<n){
			//如果是右节点小，则j+1
			if(j+1<n&&args[j+1]>args[j]){
				j++;
			}
			//如果子节点均大于移动节点，则替换节点，反之则移动节点
			if(args[j]<lastNode){
				break;
			}else{
				args[i] = args[j];
				args[j] = lastNode;
				i=j;
				j=2*i+1;
			}
		}
	}
	
	/**
	 * 数组toString
	 * @param args 数组
	 * @return String 
	 */
	public static String argsToString(int[] args){
		StringBuffer stringBuffer = new StringBuffer();
		for(int a : args){
			if(stringBuffer.length()==0){
				stringBuffer.append(a);
			}else{
				stringBuffer.append(","+a);
			}
		}
		return stringBuffer.toString();
	}
	
}
