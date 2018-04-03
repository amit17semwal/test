package sample.java8.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample {

	public static void main(String[] args) {
		// streamExpmple1();
		// streamGroupByExample();
		// dateTimeFormatDemo();
		//buildStread();
		//streamToCollection();
		/*try {
			readStreamOfLinesUsingFilesWithTryBlock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	//watchServiceDemo();
		dateDemo();

	}

	public static void streamExpmple1() {

		List<Person> listPerson = Arrays.asList(new Person(3, "a", "z", 30), new Person(4, "b", "y", 29),
				new Person(1, "c", "x", 28), new Person(2, "d", "w", 27));

		listPerson.stream().filter(t -> t.age > 28).forEach(p -> System.out.println(p));

		List<String> lines = Arrays.asList("spring", "node", "mkyong");
		/*
		 * lines.stream().filter(t->!t.equals("mkyong")).
		 * forEach(p->System.out.println(p));
		 */
		List<String> result = lines.stream().filter(line -> !"mkyong".equals(line)).collect(Collectors.toList());
		result.forEach(System.out::println); // output : spring, node

		List<String> collect = listPerson.stream().map(x -> x.getFname()).collect(Collectors.toList());
		collect.forEach(System.out::print);
	}

	static void streamGroupByExample() {
		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);

		List<String> ls = items.stream().map(i -> i.toUpperCase()).collect(toList());
		ls.forEach(i -> System.out.println(i));
	}

	static void dateTimeFormatDemo() {
		DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder();
		formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME).appendLiteral("@").appendZoneOrOffsetId();
		DateTimeFormatter formatter = formatterBuilder.toFormatter();
		System.out.println(formatter.format(ZonedDateTime.now()));
	}

	static void buildStread() {
		Stream<String> stringStream = Stream.of("A", "B", "C", "D");
		stringStream.forEach(System.out::println);
		
		stringStream.map(String::toLowerCase).forEach(System.out::println);
	}
	
	static void streamToCollection()
	{
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.print(evenNumbersList);
        Optional<Integer> opt = list.stream().reduce((a,b)-> a+b);
        System.out.println(opt);
	}
	
	private static void readStreamOfLinesUsingFilesWithTryBlock() throws IOException
	{
	    Path path = Paths.get("c:/Semwal", "Vs.text");
	  //When filteredLines is closed, it closes underlying stream as well as underlying file.
	    try(Stream<String> filteredLines = Files.lines(path)
	                                    //test if file is closed or not
	                                    .onClose(() -> System.out.println("File closed"))
	                                    .filter(s -> s.contains("password"))){
	        Optional<String> hasPassword = filteredLines.findFirst();
	        if(hasPassword.isPresent()){
	            System.out.println(hasPassword.get());
	        }
	    }
	}
	
	private static void dateDemo(){
	     
		String anotherDate = "04 Apr 2016";
		 
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate random = LocalDate.parse(anotherDate, df);
		 
		System.out.println(anotherDate + " parses as " + random);
		
		
		String s = "07 12 2017";
		DateTimeFormatter df1  = DateTimeFormatter.ofPattern("dd MM yyyy");
		LocalDate ldDateTime = LocalDate.parse(s,df1);
		System.out.println(ldDateTime);
		
		
		
	}
	
	private static void watchServiceDemo(){
		Path path = Paths.get("c:/Semwal");
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WatchKey watchKey = null;
		while (true) {
		    try {
				watchKey = watchService.poll(10, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    if(watchKey != null) {
		        watchKey.pollEvents().stream().forEach(event -> System.out.println(event.context()));
		    }
		    watchKey.reset();
		}
	}
}
