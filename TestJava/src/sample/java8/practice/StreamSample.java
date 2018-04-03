package sample.java8.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class StreamSample {
	private enum Status {
		OPEN, CLOSED
	};

	private static final class Task {
		private final Status status;
		private final Integer points;

		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}

		public Integer getPoints() {
			return points;
		}

		public Status getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}
	public static class Car {/*
	    public static Car create( final Supplier< Car > supplier ) {
	        return supplier.get();
	    }              
	        
	    public static void collide( final Car car ) {
	        System.out.println( "Collided " + car.toString() );
	    }
	        
	    public void follow( final Car another ) {
	        System.out.println( "Following the " + another.toString() );
	    }
	        
	    public void repair() {   
	        System.out.println( "Repaired " + this.toString() );
	    }
	*/}
	public static void main(String[] args) {
		final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13),
				new Task(Status.CLOSED, 8));
		final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();
		System.out.println("Total points: " + totalPointsOfOpenTasks);
		
		
		 long[] arrayOfLong = new long [ 50 ];		
			
	        Arrays.parallelSetAll( arrayOfLong, 
	            index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
	        Arrays.stream( arrayOfLong ).limit( 20 ).forEach( 
	            i -> System.out.print( i + " " ) );
	        System.out.println();
			
	        Arrays.parallelSort( arrayOfLong );		
	        Arrays.stream( arrayOfLong ).limit( 20 ).forEach( 
	            i -> System.out.print( i + " " ) );
	        System.out.println();
	        
	        
	}
}