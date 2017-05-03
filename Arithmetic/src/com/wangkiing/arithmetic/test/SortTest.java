package com.wangkiing.arithmetic.test;

import org.junit.Test;

import com.wangkiing.arithmetic.srot.SortUtil;


public class SortTest {
	
	/**
	 * 冒泡排序
	 */
	@Test
	public void testBubbleSort() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("冒泡排序前:"+SortUtil.argsToString(args));
		long before = System.currentTimeMillis();
		SortUtil.bubbleSrot(args);
		long after = System.currentTimeMillis();
		System.out.println("冒泡排序后:"+SortUtil.argsToString(args));
		System.out.println("冒泡排序时间:"+(after-before));
	}
	
	
	/**
	 * 选择排序
	 */
	@Test
	public void testSelectSort() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("选择排序前:"+SortUtil.argsToString(args));
		long before = System.currentTimeMillis();
		SortUtil.selectSrot(args);
		long after = System.currentTimeMillis();
		System.out.println("选择排序后:"+SortUtil.argsToString(args));
		System.out.println("选择排序时间:"+(after-before));
	}
	
	
	
	/**
	 * 直接插入排序
	 */
	@Test
	public void testInsertSort() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("插入排序前:"+SortUtil.argsToString(args));
		long before = System.currentTimeMillis();
		SortUtil.insertSort(args);
		long after = System.currentTimeMillis();
		System.out.println("插入排序后:"+SortUtil.argsToString(args));
		System.out.println("插入排序时间:"+(after-before));
	}
	
	/**
	 * 希尔排序
	 */
	@Test
	public void testShellSort() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("希尔排序前:"+SortUtil.argsToString(args));
		long before = System.currentTimeMillis();
		SortUtil.shellSort(args);
		long after = System.currentTimeMillis();
		System.out.println("希尔排序后:"+SortUtil.argsToString(args));
		System.out.println("希尔排序时间:"+(after-before));
	}

	/**
	 * 归并排序
	 */
	@Test
	public void testMergeSort() {
		int[] args1 = new int[11];
		int[] args2 = new int[11];
		for(int i =0;i<11;i++){
			args1[i] = (int) (Math.random()*100);
			args2[i] = (int) (Math.random()*100);
		}
		
		System.out.println("递归归并排序前:"+SortUtil.argsToString(args1));
		long before1 = System.currentTimeMillis();
		SortUtil.mergeSortRecursion(args1);
		long after1 = System.currentTimeMillis();
		System.out.println("递归归并排序后:"+SortUtil.argsToString(args1));
		System.out.println("递归归并排序时间:"+(after1-before1));
		
		System.out.println("非递归归并排序前:"+SortUtil.argsToString(args2));
		long before2 = System.currentTimeMillis();
		SortUtil.mergeSortNotRecursion(args2);
		long after2 = System.currentTimeMillis();
		System.out.println("非递归归并排序后:"+SortUtil.argsToString(args2));
		System.out.println("非递归归并排序时间:"+(after2-before2));
	}
	
	/**
	 * 堆排序
	 */
	@Test
	public void testHeapSort() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("堆排序前:"+SortUtil.argsToString(args));
		long before = System.currentTimeMillis();
		SortUtil.heapSort(args);
		long after = System.currentTimeMillis();
		System.out.println("堆排序后:"+SortUtil.argsToString(args));
		System.out.println("堆排序时间:"+(after-before));
	}
}
