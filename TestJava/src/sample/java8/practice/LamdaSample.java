package sample.java8.practice;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author eamisem
 *
 */

interface intf {
	// void greet();
	int add(int i, int j);
}

public class LamdaSample {
	interface operation {
		int perform(int a, int b);
	}

	interface Predicate<T> {
		boolean test(T t);
	}

	public int operateBinary(int a, int b, operation op) {
		return op.perform(a, b);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		LambdaScopeTest st = new LambdaScopeTest();
		LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);

	}

}

class ParameterNames {
	public static void main(String[] args) throws Exception {
		Method method = ParameterNames.class.getMethod("main", String[].class);
		for (final Parameter parameter : method.getParameters()) {
			System.out.println("Parameter: " + parameter.getName());
		}
	}
}

class Class1 {
	protected InnerClass1 ic;

	public Class1() {
		ic = new InnerClass1();
	}

	public void displayStrings() {
		System.out.println(ic.getString() + ".");
		System.out.println(ic.getAnotherString() + ".");
	}

	static public void main(String[] args) {
		/*
		 * Class1 c1 = new Class1(); c1.displayStrings(); List<Integer> list =
		 * Arrays.asList(1,2,3,4,5,6,7); list.stream().map((x) ->
		 * x*x).forEach(System.out::println); int ar1[] = {1,2,3,4,5};
		 * 
		 * System.out.println("--------"); Arrays.parallelPrefix(ar1, (p,q)->
		 * p*q); for(int a : ar1) System.out.println(a);
		 */

		// Optional<String> opt = Optional.ofNullable(str());
		// opt.ifPresent(name -> System.out.println(name.length()));

		Class1 cls1 = new Class1();
		cls1.whenOrElseGetAndOrElseOverlap_thenCorrect();
	}

	public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
		String text = "Text present";

		System.out.println("Using orElseGet:");
		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.println("----defaultText1---" + defaultText);
		System.out.println("Using orElse:");
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println("----defaultText2---" + defaultText);
	}

	public String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}

	static String str() {
		return "ab";
	}

	protected class InnerClass1 {
		public String getString() {
			return "InnerClass1: getString invoked";
		}

		public String getAnotherString() {
			return "InnerClass1: getAnotherString invoked";
		}
	}
}

class LambdaScopeTest {

	public int x = 0;

	Optional<Integer> a = Optional.of(8);

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			// The following statement causes the compiler to generate
			// the error "local variables referenced from a lambda expression
			// must be final or effectively final" in statement A:
			//
			// x = 99;

			Consumer<Integer> myConsumer = (y) -> {
				System.out.println("x = " + x); // Statement A
				System.out.println("y = " + y);
				System.out.println("this.x = " + this.x);
				System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
			};

			myConsumer.accept(x);

		}
	}

	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
			SOURCE sourceCollection, Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();
		for (T t : sourceCollection) {
			result.add(t);
		}
		return result;
	}
}