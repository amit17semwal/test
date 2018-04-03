package com.test.A;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class TestConstructor {

	TestConstructor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*int a = 27;
		int b = 47;
		System.out.println(GCF(b, a));
		System.out.println(b % a);*/
	 //System.out.println(8>>2);//1000
		//s.int
		TestConstructor t = new TestConstructor();
		t.sum();
	}

	public synchronized void sum(){
		System.out.println(sum1(5));
	}
	
public synchronized int sum1(int a){
		return a+10;
	}
	public static int GCF(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return (GCF(b, a % b));
		}
	}

	public static int LCM(int a, int b) {
		return (a * b) / GCF(a, b);
	}

}


 class CountingFactorizer {
private final AtomicLong count = new AtomicLong(0);
public long getCount() { return count.get(); }
public void service() {

count.incrementAndGet();
}
}
