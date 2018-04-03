package sample.java8.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.net.ssl.ExtendedSSLSession;

interface interface1{
	void show();
	public static int get(){
		return 4;
	}
}
@FunctionalInterface
interface Foo {
    String method(String string);
    
    default void show(){
    	System.out.println("Hi this is a show mehthod");
    }
}

interface intrf2  {
	/*default void show(){
		System.out.println("This is another show method");
	}*/
}


interface interf3 extends Foo,intrf2 {
	
}


public class LamdaSample2 {
	
	public static void main(String[] args) {
	    
		List<Person> listPerson = Arrays.asList(
				new Person(3, "a", "z", 30),
				new Person(4, "b", "y", 29),
				new Person(1, "c", "x", 28),
				new Person(2, "d", "w", 27));
		System.out.println(interface1.get());
		System.out.println("====Before sort===");
		
		Thread th = new Thread(()-> {
			System.out.println("Hello how are you");
		});
		th.start();
			
		String s = add("Amit", str-> str+" Semwal");
		System.out.println(s);
		
		//printAll(listPerson);

		//listPerson.sort((a,b) -> a.lastname.compareTo(b.lastname));
		//listPerson.forEach(p->System.out.println(p));	
	/*	
		Collections.sort(listPerson,(p1,p2)->p1.lastname.compareTo(p2.lastname));
		System.out.println("====After sort===");
		printSpl(listPerson,p-> p.id>3, p-> System.out.println(p));
		
		int a= 20;
		int b =30;
		doProcess(50, i-> System.out.println("Sum is" + (i+b)));
	*/	
		Thread t  = new Thread(LamdaSample2::show);
		t.start();
		
		int[]a = {1,2,3,4,5};
		int key = 2;
		difPrint(a, key, (d,b)-> System.out.println(d+b));
		
		
		
	}
	static public String add(String string, Foo foo) {
	    return foo.method(string);
	}
	static void difPrint(int[] a, int k, BiConsumer<Integer, Integer> bi) {
		for(int i : a) {
			bi.accept(i, k);
		}
	}
	
	static void printFunction(List<Person>  ls, Predicate<Person> pr) {
	 for(Person p : ls) {
		 if(pr.test(p)) {
			 System.out.println(p.lastname);
		 }
	 }
	}
	static void show() {
		System.out.println("Show method ");
	}
	static void doProcess(int i, ProcessDummy p) {
		p.perform(i);
	}
	
	static void printAll(List<Person> p) {
		for(Person p1 : p )
			System.out.println(p1);
	}
	static void printSpl(List<Person> p, Predicate<Person> p2,Consumer<Person> c) {
		for(Person p1 : p )
			if(p2.test(p1))
				c.accept(p1);
	}
}

interface ProcessDummy
{
	void perform(int i);
	
}
class Person {
	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lastname=" + lastname + ", age=" + age + "]";
	}

	public Person(int id, String fname, String lastname, int age) {
		super();
		this.id = id;
		this.fname = fname;
		this.lastname = lastname;
		this.age = age;
	}

	int id;
	String fname;
	String lastname;
	int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}