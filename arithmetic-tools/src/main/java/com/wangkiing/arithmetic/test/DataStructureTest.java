package com.wangkiing.arithmetic.test;

import org.junit.Test;

import com.wangkiing.arithmetic.datastructure.DataStructureUtil;
import com.wangkiing.arithmetic.srot.SortUtil;


public class DataStructureTest {
	
	/**
	 * 最小堆
	 */
	@Test
	public void testBubbleSort() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("生成堆前:"+DataStructureUtil.argsToString(args));
		long before = System.currentTimeMillis();
		DataStructureUtil.buildMinHeap(args);
		long after = System.currentTimeMillis();
		System.out.println("生成堆后:"+DataStructureUtil.argsToString(args));
		System.out.println("生成堆时间:"+(after-before));
		System.out.println("--------------------------------------------------");
	}
	
	
	/**
	 * 最大堆
	 */
	@Test
	public void testSelectSort() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("选择排序前:"+DataStructureUtil.argsToString(args));
		long before = System.currentTimeMillis();
		DataStructureUtil.buildMaxHeap(args);
		long after = System.currentTimeMillis();
		System.out.println("选择排序后:"+DataStructureUtil.argsToString(args));
		System.out.println("选择排序时间:"+(after-before));
		System.out.println("--------------------------------------------------");
	}
	
}
