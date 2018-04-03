import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DirSize {

  //private static final Logger LOGGER = LoggerFactory.getLogger(DirSize.class);

  private static class SizeOfFileTask extends RecursiveTask<Long> {

    private static final long serialVersionUID = -196522408291343951L;
static int i =0;
    private final File file;

    public SizeOfFileTask(final File file) {
      this.file = Objects.requireNonNull(file);
    }

    @Override
    protected Long compute() {
   //   DirSize.LOGGER.debug("Computing size of: {}", file);
    	System.out.println("Coputing size of {}" + file);
      if (file.isFile()) {
        return file.length();
      }
 i++;
      final List<SizeOfFileTask> tasks = new ArrayList<>();
      final File[] children = file.listFiles();
      if (children != null) {
        for (final File child : children) {
          final SizeOfFileTask task = new SizeOfFileTask(child);
          task.fork();
          tasks.add(task);
        }
      }

      long size = 0;
      for (final SizeOfFileTask task : tasks) {
        size += task.join();
      }
      System.out.println(i);
      return size;
    }
    
  }

  public static long sizeOf(final File file) {
    final ForkJoinPool pool = new ForkJoinPool();
    try {
      return pool.invoke(new SizeOfFileTask(file));
    } finally {
      pool.shutdown();
    }
  }

  private DirSize() {}
  
  public static void main(String a[]) {
	  try{
	  ForkJoinPool fp = new ForkJoinPool();
	  ForkJoinTask<Long> f  = new SizeOfFileTask(new File("C:\\Semwal\\Projects\\SDP"));
	  fp.execute(f);
	  System.out.println(f.get());
	  } catch (Exception e) {
		  System.out.println("error");
	  }
  }

}