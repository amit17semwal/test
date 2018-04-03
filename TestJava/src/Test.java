import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class Test {
	public static void main(String[] args)
			throws IOException {/*
								 * Path upgradePath =
								 * Paths.get("C:\\Semwal\\Projects\\", "system.
								 * conf"); List<String> lines =
								 * Files.readAllLines(upgradePath,
								 * StandardCharsets.UTF_8);
								 * 
								 * System.out.println(lines.size());
								 * 
								 * Set<String> s = new HashSet<>(lines);
								 * System.out.println(s.size());
								 * 
								 */
		/*int input1[] = { 3, 4, 2, 3, 3, 3, 4};
		int input2[] = { 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0 };
		int result[] = survivalcells(input1, input2);
		for(int i:result){
		System.out.print(""+i+",");

		}
*/
		
	    
	    List ls = null;
	    
	    System.out.println(Collections.EMPTY_LIST.equals(ls));
		
	}

	
	public static int[] survivalcells(int[] input1, int[] input2) {
		int rows = input1[0];
		int colums = input1[1];
		int s1 = input1[2];
		int s2 = input1[3];
		int b1 = input1[4];
		int b2 = input1[5];
		int simulation = input1[6];
		int length = input2.length;
		int[] result = new int[length];
		
		List<Integer> nbrs = new ArrayList<>();
		for (int i = 0; i < simulation; i++) {
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < colums; k++) {
					int arrayindex = (rows * j) + j + k;
					nbrs.clear();
					// logic for empty plant;
					if (input2[arrayindex] == 0) {
						int countB = 0;
						for (int nextR = j - 1; nextR <= j + 1; nextR++) {
							if (nextR < 0 || nextR >= rows)
								continue; // row out of bound
							for (int nextC = k - 1; nextC <= k + 1; nextC++) {
								if (nextC < 0 || nextC >= colums)
									continue; // col out of bound
								if (nextR == j && nextC == k)
									continue; // current cell
								System.out.println("Neighboure of [" + j + "][" + k + "]====" + nextR + "" + nextC);
								nbrs.add((rows * nextR) + nextR + nextC);
							}
						}
						for (Integer index : nbrs) {
							try {
								if (input2[index] == 1) {
									countB++;
								}
							} catch (Exception e) {

							}
						}
						if (countB >= b1 && countB <= b2) {
							result[arrayindex] = 1;
							continue;
						}
					} else {
						int countS = 0;
						for (int nextR = j - 1; nextR <= j + 1; nextR++) {
							if (nextR < 0 || nextR >= rows)
								continue; // row out of bound
							for (int nextC = k - 1; nextC <= k + 1; nextC++) {
								if (nextC < 0 || nextC >= colums)
									continue; // col out of bound
								if (nextR == j && nextC == k)
									continue; // current cell
								
								System.out.println("Neighboure of [" + j + "][" + k + "]====" + nextR + "" + nextC);
								nbrs.add((rows * nextR) + nextR + nextC);
							}
						}

						for (Integer index : nbrs) {
							try {
								if (input2[index] == 1) {
									countS++;
								}
							} catch (Exception e) {

							}
						}
						if (countS < s1 || countS > s2) {
							result[arrayindex] = 0;
							continue;
						}
					}
					result[arrayindex] = input2[arrayindex];
				}
			}
			System.arraycopy(result, 0, input2, 0, length);;
		}
		// Write code here
		return input2;
	}

}

class test11 {
	int i;
	public test11(int q){
		i = q;
	}
 public int getI() {
	 return i;
 }
	@Override
	public int hashCode() {
		return 5;
	}
}
