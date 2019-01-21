package com.wangkiing.arithmetic.srot;

import com.wangkiing.arithmetic.datastructure.DataStructureUtil;

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
	* 	创建一个堆
	*	把堆顶元素(最大值)和堆尾元素互换
	*	把堆的尺寸缩小1，并调用minHeapFixDown从新的堆顶元素开始进行堆调整
	*	重复步骤2，直到堆的尺寸为1
	*分类 -------------- 内部比较排序
	* 数据结构 ---------- 数组
	* 最差时间复杂度 ---- O(nlogn)
	* 最优时间复杂度 ---- O(nlogn)
	* 平均时间复杂度 ---- O(nlogn)
	* 所需辅助空间 ------ O(1)
	* 稳定性 ------------ 不稳定
	* @param args
	 */
	public static void minHeapSort(int[] args){
		int index = args.length;
		DataStructureUtil.buildMinHeap(args);
		for (int i = index-1; i >=1; i--)  
	    {  
			int temp = args[i];
			args[i] = args[0];
			args[0]=temp;
			DataStructureUtil.minHeapFixDown(args, 0, i);  
	    }  
	}
	
	
	/**
	 * Quick Sort - 快速排序
	 *快速排序使用分治策略(Divide and Conquer)来把一个序列分为两个子序列。步骤为：
	 *从序列中挑出一个元素，作为"基准"(pivot).
	 *把所有比基准值小的元素放在基准前面，所有比基准值大的元素放在基准的后面（相同的数可以到任一边），这个称为分区(partition)操作。
	 *对每个分区递归地进行步骤1~3，递归的结束条件是序列的大小是0或1，这时整体已经被排好序了。
	 *
	 *分类 ------------ 内部比较排序
     * 数据结构 --------- 数组
     * 最差时间复杂度 ---- 每次选取的基准都是最大的元素（或者每次都是最小），导致每次只划分出了一个子序列，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
     * 最优时间复杂度 ---- 每次选取的基准都能使划分均匀，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
     * 平均时间复杂度 ---- O(nlogn)
     * 所需辅助空间 ------ O(logn)～O(n),主要是递归造成的栈空间的使用(用来保存left和right等局部变量),取决于递归树的深度
     *                   一般为O(logn),最差为O(n)（基本有序的情况）
     * 稳定性 ---------- 不稳定
	 * @param args
	 */
	public static void quickSort(int[] args){
		partition(args,0,args.length-1);
	}
	
	/**
	 * 划分函数，分治解决
	 * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
	 * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
	 * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
	 * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
	 * @param args 数组
	 * @param left 区间数据最左值
	 * @param right 区间数据最右值
	 * @return 返回左右的界限值
	 */
	private static void partition(int[] args,int left,int right){
		if(left<right){
			//从最右边开始挖坑
			int temp = args[left];
			int i = left;
			int j = right;
			//小于temp的放左边，大于temp的放右边
			while(i<j){
				//从右往左找，找到第一个小于temp的值
				while(i<j&&args[j]>=temp){
					j--;
				}
				//防止找过界
				if(i<j){
					//将a[j]填充到a[i]里
					args[i] = args[j];
					i++;
				}
				
				//从左往右找，找到第一个大于temp的值	
				while(i<j&&args[i]<=temp){
					i++;
				}
				//防止找过界
				if(i<j){
					//将a[i]填充到a[j]里
					args[j] = args[i];
					j--;
				}
				
					
			}
			//当j=i时，左右分配完毕，将temp放入args[i]中
			args[i] = temp;
			//递归调用
			partition(args,0,i-1);
			partition(args,i+1,right);
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
