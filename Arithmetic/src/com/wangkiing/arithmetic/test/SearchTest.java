package com.wangkiing.arithmetic.test;

import org.junit.Test;

import com.wangkiing.arithmetic.datastructure.DataStructureUtil;
import com.wangkiing.arithmetic.search.SearchUtil;
import com.wangkiing.arithmetic.srot.SortUtil;


public class SearchTest {
	
	/**
	 * 顺序查找
	 */
	@Test
	public void testSequentialSearch() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("原数组:"+DataStructureUtil.argsToString(args));
		int index = (int) (Math.random()*10);
		long before = System.currentTimeMillis();
		int i = SearchUtil.sequenceSearch(args,args[index]);
		long after = System.currentTimeMillis();
		System.out.println("查找值下标:"+index);
		System.out.println("相同值下标:"+i);
		System.out.println("查找时间:"+(after-before));
		System.out.println("--------------------------------------------------");
	}
	
	/**
	 * 二分查找
	 */
	@Test
	public void testBinarySearch() {
		int[] args = new int[10];
		for(int i =0;i<10;i++){
			args[i] = (int) (Math.random()*100);
		}
		
		System.out.println("原数组:"+DataStructureUtil.argsToString(args));
		//有序化数组
		SortUtil.quickSort(args);
		System.out.println("有序化数组:"+DataStructureUtil.argsToString(args));
		int index = (int) (Math.random()*10);
		long before = System.currentTimeMillis();
		int i = SearchUtil.binarySearch(args,args[index],0,args.length-1);
		long after = System.currentTimeMillis();
		System.out.println("查找值下标:"+index);
		System.out.println("相同值下标:"+i);
		System.out.println("查找时间:"+(after-before));
		System.out.println("--------------------------------------------------");
	}
	
	
}
