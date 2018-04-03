import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class StackTest {
	public void sh(double a){
		System.out.println("int");
	}
	public void sh(Integer a){
		System.out.println("long");
	}
public static void main(String[] args) {
	
	Stack s  = new Stack(3);
	synchronized (s) {
		s.notify();	
		Thread t  = new Thread();
	}
	System.out.println("hello");
	
	/*s.pop();
	s.push(4);
	s.push(4);
	s.push(4);
	s.push(4);
	s.pop();
	List<String> list = Collections.emptyList(); new ArrayList<>();
	list.add("amit");
	list.add("semwal");
	System.out.println(list);*/
	//System.out.println(CCC.class);
	//StackTest  s = new StackTest();
	
	//byte b =127;
	//s.sh(b);
	/*if(b++ >0) {
		System.out.println("hi");
	}else {
		System.out.println("ih");
	}*/
}
}

class Stack {
	private int size;
	private int[]data;
	private int top;
	
	Stack(int size){
		this.size =size;
		data = new int[size];
		top=-1;
	}
	public void push(int item){
		if(top == size-1){
		System.out.println("stack is already full");
		} else {
			data[++top] = item;
			System.out.println("item :"+item +" inserted in stack");
		}
	}
	public void pop(){
		if(top>0){
		System.out.println("item :"+data[--top]+" removed from stack");
		}
		else {
			System.out.println("stack is empty");
		}
	}
	public void wati1(){
		try {
			synchronized (this) {
				this.wait(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void notify1(){
	//synchronized(this) {
		this.notify();
	//}
}
}
class CCC{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "AAA";
	}
}