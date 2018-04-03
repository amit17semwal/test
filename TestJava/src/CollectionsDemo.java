import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionsDemo {

	public static void main(String[] args) {
		//iteratorDemo();
		Map<String,String> sp  = new HashMap<String, String>(3,2);
		sp.put("S" ,"D");
		sp.put("ss" ,"D");
		sp.put("ssx" ,"D");
		sp.put("sw" ,"D");
		sp.put("AB" ,"D");
		sp.put("ABC" ,"D");
	}
	
	public static void iteratorDemo(){
		ArrayList animal = new ArrayList();
		animal.add("Horse");
		animal.add("Lion");
		animal.add("Tiger");

		Iterator animalItr = animal.iterator();

		while(animalItr.hasNext()) {
			String animalObj = (String)animalItr.next();
			System.out.println(animalObj);
		}
	}
}
