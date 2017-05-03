package com.wangkiing.arithmetic.srot;

import java.util.ArrayList;
import java.util.List;

/**
 * 常用排序算法
 * @author wangkiing
 *
 */
public class SortUtil {

	/**
	 * Bubble Sort -冒泡排序
	 *分类 -------------- 内部比较排序
     * 数据结构 ---------- 数组
     * 最差时间复杂度 ---- O(n^2)
     * 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
     * 平均时间复杂度 ---- O(n^2)
     * 所需辅助空间 ------ O(1)
     * 稳定性 ------------ 稳定
	 * @param args 数组
	 * @return
	 */
	public static void bubbleSrot(int[] args){
		int length = args.length;
		for(int i = 0;i<length-1;i++){
			//注意只用比较n-i-1次
			for(int j = 0;j<length-1 - i;j++){
				if(args[j]>args[j+1]){
					int temp = args[j];
					args[j] = args[j+1];
					args[j+1] = temp;
				}
			}
		}
		return;
	}
	

	/**
	 * Select Sort-选择排序
     * 分类 -------------- 内部比较排序
     * 数据结构 ---------- 数组
     * 最差时间复杂度 ---- O(n^2)
     * 最优时间复杂度 ---- O(n^2)
     * 平均时间复杂度 ---- O(n^2)
     * 所需辅助空间 ------ O(1)
     * 稳定性 ------------ 不稳定
	 * @param args 数组
	 * @return
	 */
	public static void selectSrot(int[] args){
		int length = args.length;
		for(int i = 0;i<length-1;i++){
			//注意只用比较n-i-1次
			for(int j = i;j<length-1;j++){
				if(args[i]>args[j+1]){
					int temp = args[i];
					args[i] = args[j+1];
					args[j+1]=temp;
				}
			}
		}
		return;
	}
	
	/**
	 * Insert Sort-插入排序
     * 分类 ------------- 内部比较排序
     * 数据结构 ---------- 数组
     * 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
     * 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
     * 平均时间复杂度 ---- O(n^2)
     * 所需辅助空间 ------ O(1)
     * 稳定性 ------------ 稳定
	 * @param args 数组
	 */
	public static void insertSort(int[] args){
		int length = args.length;
		for(int i = 1;i <length;i++){
			for(int j = 0;j<i;j++){
				if(args[j]>args[i]){
					int temp = args[i];
					for(int k = i;k>j;k--){
						args[k] = args[k-1];
					}
					args[j]=temp;
					break;
				}
			}
		}
	}
	
	/**
	 * Shell Sort - 希尔排序（插入排序升级版）
	 * 将所拍元素组分为多组，每组分别进行插入排序，直到分组数量为1
	 * 分组策略： [1,n/3+1]
	 * 分类 -------------- 内部比较排序
     * 数据结构 ---------- 数组
     * 最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
     * 最优时间复杂度 ---- O(n)
     * 平均时间复杂度 ---- 根据步长序列的不同而不同。
     * 所需辅助空间 ------ O(1)
     * 稳定性 ------------ 不稳定
	 * @param args 元素组
	 */
	public static void shellSort(int[] args){
		int length = args.length;
		int step = 	length/3+1;
		//计算步数
		for(;step>0;step = (step - 1)/3){
			//步长内每个元素遍历
			for(int i = 0;i <step;i++){
				//插入排序开始
				for(int m =i+step;m<length;m+=step){
					for(int j = i;j<m;j+=step){
						if(args[j]>args[m]){
							int temp = args[m];
							for(int k = m;k>j;k-=step){
								args[k] = args[k-step];
							}
							args[j]=temp;
							break;
						}
					}
				}
				//插入排序结束
			}
		}
	}
	
	/**
	 * Meger Sort-归并排序
	 * 把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
	 * 分类 -------------- 内部比较排序
	 * 数据结构 ---------- 数组
	 * 最差时间复杂度 ---- O(nlogn)
	 * 最优时间复杂度 ---- O(nlogn)
	 * 平均时间复杂度 ---- O(nlogn)
	 * 所需辅助空间 ------ O(n)
	 * 稳定性 ------------ 稳定
	 * @param args 待排序数组
	 */
	public static void mergeSortRecursion(int[] args){
		int high = args.length;
		//递归式归并排序
		mergeRecursion(args,0,high-1);
		
	}
	
	public static void mergeSortNotRecursion(int[] args){
		//非递归式归并排序
		mergeNotRecursion(args);
	}
	
	//递归式归并排序(自顶向上)
	private static void mergeRecursion(int[] args,int low,int high){
		int meddle = (low+high)/2;
		if(low < high){
			mergeRecursion(args,low,meddle);
			mergeRecursion(args,meddle+1,high);
			merge(args,low,meddle,high);
		}
	}
	
	// 非递归式归并排序(自底向上)
	private static void mergeNotRecursion(int[] args) {
		int low =0;
		int length = args.length;
		for (int size = 1; size <= length-1; size *= 2) // 子数组的大小初始为1,每轮翻倍
	    {
	        low = 0;
	        while (low + size - 1 <= length-1 )// 后一个子数组存在(需要归并)
	        {
	            int middle = low + size - 1;    
	            int high = middle + size;        
	            if (high > length-1)            // 后一个子数组大小不足size
	                high = length-1;
	            merge(args, low, middle, high);
	            low = high + 1;               // 前一个子数组索引向后移动
	        }
	    }
		
	}
	
	/**
	 * 
	 * @param args 合并数组
	 * @param low 将合并数组中的最小索引
	 * @param meddle  将合并数组中的中间索引
	 * @param high  将合并数组中的最大索引
	 * @return args 合并后的数组
	 */
	private static void merge(int[] args,int low,int meddle,int high){
		int[] temp = new int[high - low +1];
		int length = high - low +1;
		int index1=low;
		int index2=meddle+1;
		int i =0;
		//比较两个数组元素，将小的元素放到临时数组中，知道其中一个数组放完所有元素
		while(index1<=meddle&&index2<=high){
			if(args[index1]>args[index2]){
				temp[i++] = args[index2++];
			}else{
				temp[i++] = args[index1++];
			}
		}
		//当数组1还有剩余元素时，之接全部放在数组后面
		if(index1<=meddle){
			while(index1<=meddle){
				temp[i++] = args[index1++];	
			}
		}
		//当数组2还有剩余元素时，之接全部放在数组后面
		if(index2<=high){
			while(index2<=high){
				temp[i++] = args[index2++];	
			}
		}
		int index=0;
		//将临时数组中排好序的元素放回原数组{
		while( index <length){
			args[low++] = temp[index++];
		}
		
	}
	
	/**
	* Heap Sort -堆排序
	*分类 -------------- 内部比较排序
	* 数据结构 ---------- 数组
	* 最差时间复杂度 ---- O(nlogn)
	* 最优时间复杂度 ---- O(nlogn)
	* 平均时间复杂度 ---- O(nlogn)
	* 所需辅助空间 ------ O(1)
	* 稳定性 ------------ 不稳定
	* @param args
	 */
	public static void heapSort(int[] args){
		int index = args.length;
		int[] newArgs = new int[index];
		buildMinHeap(args);
		for(int i =0;i<index;i++){
			args[i] = args[0];
			minHeapFixDown(args, args.length, index);
		}
	}
	
	/**
	 * 插入堆
	 * 一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。
	 * 它的左右子结点下标分别为2 * i + 1和2 * i + 2。如第0个结点左右子结点下标分别为1和2。
	 * @param args 原来数组
	 * @param i 插入值索引
	 */
	private static void minHeapFixUp(int[] args,int i){
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
	 * 删除堆
	 * 将最后一个数据的值赋给根结点，然后再从根结点开始进行一次从上向下的调整
	 * 调整时先在左右儿子结点中找最小的，如果父结点比这个最小的子结点还小说明不需要调整了，
	 * 反之将父结点和它交换后再考虑后面的结点。相当于从根结点将一个数据的“下沉”过程
	 * @param args 原来数组
	 * @param i 调整节点索引
	 * @param n 节点总总数，即数组长度
	 */
	private static void minHeapFixDown(int[] args,int i,int n){
		int lastNode = args[i];
		int j= 2*i+1;
		while(2*i+1<n){
			if(j+1<n&&args[j+1]<args[j]){
				j++;
			}
			if(args[j]>lastNode){
				break;
			}else{
				args[i] = args[j];
				args[j] = lastNode;
				i=j;
			}
		}
	}
		
	/**
	 * 建立堆
	 * @param args
	 */
	private static void buildMinHeap(int[] args){
		int n = args.length;
		for (int i=n/2-1;i>=0;i--)  
			minHeapFixDown(args,i,n);  
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
