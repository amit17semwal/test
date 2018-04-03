import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
	/*
	 * public static void main(String[] args) { final int a = 10, b = 15, c = 5,
	 * d = 6; Thread t1 = new Thread(new A(a, b)); Thread t2 = new Thread(new
	 * B(c, d)); }
	 */
	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

		/*
		 * ExecutorService executerService = Executors.newFixedThreadPool(2);
		 * 
		 * Task task1 = new Task(4, 2);
		 * 
		 * Task task2 = new Task(3, 4);
		 * 
		 * Future<Integer> asyncResult1 = executerService.submit(task1);
		 * 
		 * Future<Integer> asyncResult2 = executerService.submit(task2);
		 * 
		 * System.out.println(" Final output is - "+asyncResult1.get() *
		 * asyncResult2.get()); Scanner s = new Scanner(System.in); String str =
		 * s.next(); int i = Integer.parseInt(str);
		 * System.out.println(palinDrom(str));
		 * System.out.println(printFacto(i)); System.out.println(findDivi(1, 10,
		 * 1));
		 * 
		 * Scanner s = new Scanner(System.in); int N = s.nextInt();
		 * 
		 * for (int i = 0; i < N; i++) { String str = s.next();
		 * System.out.println(reverse(str)); }
		 * 
		 * int[] a = { 1, 4, 3 }; System.out.println(getHelth(a, 2));
		 */

		/*
		 * int j[] = {1,2,3,4,5}; System.out.println(product(j, 5)); } public
		 * static long product(int a[],int size) { long rs = 1; Long mo =
		 * power(10, 9)+7; for(int i=0;i<a.length-1;i++) { rs= rs *(a[i] % mo);
		 * } return rs;
		 */
		/*
		 * Scanner s = new Scanner(System.in); int n = s.nextInt(); char[] vowel
		 * = {'a','e','i','o','u'}; for (int i = 0; i < n; i++) { String str =
		 * s.next(); int length = str.length(); str=str.replace("www.","");
		 * for(int j=0; j<vowel.length;j++) { str=
		 * str.replace(""+vowel[j]+"",""); }
		 * System.out.println(str.length()+1+"/"+length); } //count numbers
		 * System.out.println(count("sadw96aeafae4awdw2wd100awd"));
		 * 
		 * String s =
		 * "ypewxdqfkkjwqncklyvxgfbumiocbmbgmaxghajqarqcvbrebuyjidwptmkfbaoahdpruwutrmryujecxrbveddjomyvexxghhakxjuqnguydrhuwxagbdwdyeljcsncxqqfadsnpeyehgfdfksspudwkgchbkksjccwkxulrnhjjkmpugjaeuwomtxumrohoehnqtigiqgbrygustntkgdmpqyrfydvkmlpjlvhgxkptdsgrpopnsgvlrxfeysmmoahpngcvfwrppegumpyvwvhmmfetpabalqorpwcgxvuuwcdguuxiokeirvrewvcqfmqbdupjnxqsfbnepueodyqwabohbtmumxscxndrvxwqcjwcrxlrhghvjlftslkurdqnkxkcufccxpnokwiysqudchnesvrddolaqjojxymneiyeknuvxacjubstruaqphhioeqmmoifmauwbvspdpxkawiyvwwbodegilgrmpkkjdlurmydhrwdyptgjbjotetaoobkojlbonychfksuhecjolanxakmnfnmsmyvonhwypfvsrjwxvitjhdycvklalktdeybkpxvrkrhrcekofonihvpfesnkmwdluhdvbdpqcjrpmaruoeimardfovrxgiehuyyhuwapexicadhpnirqoaswyaslxovwstcxnfggrbabamnsqceowalqrntrqmmjferlinkuhcfclonosclnntvvuubimyjprsd";
		 * 
		 * System.out.println(printHack(s));
		 */
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line); String firstArray = br.readLine(); String
		 * secondArray = br.readLine();
		 * 
		 * String intArr1[] = firstArray.split(" "); String intArr2[] =
		 * secondArray.split(" "); for (int i = 0; i < N; i++) { //
		 * Integer.parseInt(intArr1[i])+Integer.parseInt(intArr2[i]);
		 * System.out.print(Integer.parseInt(intArr1[i]) +
		 * Integer.parseInt(intArr2[i]) + " "); }
		 */
		// System.out.println(getWall("WBW"));

		/*
		 * String ls1 =
		 * "13 18 14 16 16 4 13 11 11 3 0 13 1 7 5 11 14 1 1 3 9 0 13 18 16 1 16 12 16 0 11 13 5 7 1 6 13 1 7 0 14"
		 * ; String ls2 =
		 * "13 7 6 13 14 11 12 9 8 3 3 19 4 10 5 0 8 11 0 3 15 18 12 17 1 13 19 0 5 13 4 10 5 14 8 5 19 17 8 6 0"
		 * ;
		 * 
		 * System.out.println(getStone(ls1,ls2,41));
		 */
		/*
		 * String s = "Amit kumar Semwal"; String str[] = s.split(" "); String
		 * result = ""; for(int i =0; i<str.length;i++) { if(i==str.length -1) {
		 * result += str[i]; break; } result += str[i].charAt(0)+". "; }
		 * System.out.println(result);
		 */
		String str = "zazabcdefghgfgfededededcdefghghijkjihihgfe";
		// completeString(str);
		// getCount("12134");
		// printPlayfull(str);
		/*
		 * int a ='z'; System.out.println(a);
		 * 
		 * arrayCalc("3 3 3 5 3", 5);
		 */

		// String line = "574674546476";
		// printSum(line);

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); String
		 * strA[] = line.split(" "); int N = Integer.parseInt(strA[1]); int
		 * size= Integer.parseInt(strA[0]); String nu= br.readLine(); String[]
		 * strArNm = nu.split(" "); for (int i = 0; i < N; i++) { String fNum=
		 * br.readLine(); boolean rs = false; for(int j =0 ; j<strArNm.length;
		 * j++) { if(strArNm[j]== fNum){ rs = true; break; } } if(rs)
		 * System.out.println("YES"); else System.out.println("NO"); }
		 */
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); String
		 * strA[] = line.split(" "); int N = Integer.parseInt(strA[1]); int
		 * size= Integer.parseInt(strA[0]); String nu= br.readLine(); String[]
		 * strArNm = nu.split(" "); int intAr[] = new int[size]; for(int
		 * in=0;in<size;in++){ intAr[in] = Integer.parseInt(strArNm[in]); } for
		 * (int i = 0; i < N; i++) { String fNum= br.readLine(); int fNm =
		 * Integer.parseInt(fNum); boolean rs = binTree(0,size-1,fNm,intAr);
		 * 
		 * if(rs) System.out.println("YES"); else System.out.println("NO"); }
		 */

		int intAr[] = { 50, 40, 30, 20, 10 };

		for (int i = 0; i < intAr.length - 1; i++) {
			for (int j = i + 1; j < intAr.length; j++) {
				if (intAr[i] > intAr[j]) {
					int tem = intAr[i];
					intAr[i] = intAr[j];
					intAr[j] = tem;
				}
			}
		}
		System.out.println(binarySearch(intAr, 50));
	}

	static int[] quickSort(int[] data) {
		int lenD = data.length;
		int pivot = 0;
		int ind = lenD / 2;
		int i, j = 0, k = 0;
		if (lenD < 2) {
			return data;
		} else {
			int[] L = new int[lenD];
			int[] R = new int[lenD];
			int[] sorted = new int[lenD];
			pivot = data[ind];
			for (i = 0; i < lenD; i++) {
				if (i != ind) {
					if (data[i] < pivot) {
						L[j] = data[i];
						j++;
					} else {
						R[k] = data[i];
						k++;
					}
				}
			}
			int[] sortedL = new int[j];
			int[] sortedR = new int[k];
			System.arraycopy(L, 0, sortedL, 0, j);
			System.arraycopy(R, 0, sortedR, 0, k);
			sortedL = quickSort(sortedL);
			sortedR = quickSort(sortedR);
			System.arraycopy(sortedL, 0, sorted, 0, j);
			sorted[j] = pivot;
			System.arraycopy(sortedR, 0, sorted, j + 1, k);
			return sorted;
		}
	}

	static int binarySearch(int[] inputArr, int key) {

		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key > inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	static boolean binTree(int start, int end, int num, int str[]) {
		int mi = ((start + end) / 2);
		if (mi <= end && mi >= start) {

			if (str[mi] == num) {
				return true;
			} else if (str[mi] < num) {
				return binTree(start, mi - 1, num, str);

			} else {
				return binTree(mi + 1, end, num, str);
			}
		} else if (str[start] == num) {
			return true;
		}
		return false;
	}

	static void printSum(String line) {
		for (int i = 0; i < line.length(); i++) {
			int count = 0;
			int n = Integer.parseInt("" + line.charAt(i));
			if (n % 2 == 0) {
				count++;
			}
			for (int j = i + 1; j < line.length(); j++) {
				n = Integer.parseInt("" + line.charAt(j));
				if (n % 2 == 0) {
					count++;
				}
			}
			System.out.print(count + " ");
		}
	}

	static void arrayCalc(String str, int size) {
		int[] intArr = new int[size];
		String[] arr = str.split(" ");
		int min = 0, count = 0;
		int val = 0;
		for (int i = 0; i < arr.length; i++) {
			val = Integer.parseInt(arr[i]);
			if (i == 0) {
				min = val;
				count++;
			} else if (min > val) {
				min = val;
				count = 1;
			} else if (min == val) {
				count++;
			}
		}
		if (count % 2 != 0) {
			System.out.println("Lucky");
		} else {
			System.out.println("Unlucky");
		}

	}

	static void changeCase() {

		String line = "Jamia Hamdard";
		String result = "";
		int n1 = 2;
		int n2 = 9;
		int val = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (i != n1 - 1 && i != n2 - 1) {
				result += ch;
			} else if ((i == n1 - 1 || i == n2 - 1) && (ch >= 65 && ch <= 90 || ch >= 95 && ch <= 122)) {
				if (ch < 97) {
					val = ch + 32;
					ch = (char) val;
					result += (ch);
				} else {
					val = ch - 32;
					ch = (char) val;
					result += (ch);
				}
			} else {
				result += ch;
			}
		}
		System.out.println(result);
	}

	static void printPlayfull(String line1) {
		boolean rs = true;
		for (int j = 0; j < line1.length() - 1; j++) {
			int a = line1.charAt(j);
			int b = line1.charAt(j + 1);
			int diff = Math.abs(a - b);
			if (diff != 1 && diff != 25) {
				System.out.println(j);
				rs = false;
				break;
			}
		}
		if (!rs)
			System.out.println("NO");
		else
			System.out.println("YES");
	}

	static void printbinary(String str) {

		boolean rs = false;
		int aCount = 0, bCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0') {
				if (bCount < 6) {
					bCount = 0;
				}
				aCount++;
			}
			if (str.charAt(i) == '1') {
				if (aCount < 6) {
					aCount = 0;
				}
				bCount++;
			}

		}
		if (aCount > 5 || bCount > 5) {
			System.out.print("Sorry, sorry!");
		} else {
			System.out.print("Good luck!");
		}

	}

	static void getCount(String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("0", 6);
		map.put("1", 2);
		map.put("2", 5);
		map.put("3", 5);
		map.put("4", 4);
		map.put("5", 5);
		map.put("6", 6);
		map.put("7", 3);
		map.put("8", 7);
		map.put("9", 6);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			int n = map.get("" + str.charAt(i));
			count += n;
		}
		System.out.println(count);
	}

	static void completeString(String str) {
		boolean b = false;
		for (int k = 97; k < 123; k++) {
			b = false;
			for (int j = 0; j < str.length(); j++) {
				int val = str.charAt(j);
				if (val == k) {
					b = true;
					break;
				}
			}
			if (!b)
				break;
		}
		if (b) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static String getStone(String s1, String s2, int len) {
		String st1[] = s1.split(" ");
		String st2[] = s2.split(" ");
		int[] a = new int[len];
		int[] b = new int[len];
		for (int i = 0; i < len; i++) {
			a[i] = Integer.parseInt(st1[i]);
			b[i] = Integer.parseInt(st2[i]);
		}
		int count = 1, aMax = 0, aCount = 0, bMax = 0, bCount = 0;
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			count = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (temp == a[j])
					count++;
			}
			if (count > aCount) {
				aMax = temp;
				aCount = count;
			}
			if (count == aCount && aMax < temp) {
				aMax = temp;
			}
		}
		for (int i = 0; i < b.length; i++) {
			int temp = b[i];
			count = 1;
			for (int j = i + 1; j < b.length; j++) {
				if (temp == b[j])
					count++;
			}
			if (count > bCount) {
				bMax = temp;
				bCount = count;
			}
			if (count == bCount && bMax < temp) {
				bMax = temp;
			}
		}

		if (aMax > bMax) {
			return "Rupam";
		} else if (bMax > aMax) {
			return "Ankit";
		} else {
			return "Tie";
			/*
			 * if(aCount > bCount) { return "Rupam"; } else if(aCount < bCount)
			 * { return "Ankit"; }
			 */}

	}

	static int getWall(String str) {
		int count = 0, count1 = 0, noOfWall = 0;
		boolean ok = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'W' && count1 < 2 && !ok) {
				count1++;
			}
			if (str.charAt(i) == 'B') {
				ok = true;
				noOfWall += count1;
				noOfWall += count;
				count = 0;
				count1 = 0;

			}
			if (ok && str.charAt(i) == 'W' && count < 2) {
				count++;
				if (count == 2) {
					noOfWall += count;
					ok = false;
					count = 0;
				}
			}
		}
		return noOfWall;
	}

	static int printHack(String in) {
		String hck = "hackerearth";
		if (hck.length() > in.length()) {
			return 0;
		}
		int count = 0, i = 0, j = 0;
		int h = 0, a = 0, c = 0, k = 0, e = 0, r = 0, t = 0;
		while (i < in.length()) {
			if (j == hck.length()) {
				count++;
				j = 0;
			}
			if (in.charAt(i) == 'h') {
				h++;
			} else if (in.charAt(i) == 'a') {
				a++;
			} else if (in.charAt(i) == 'c') {
				c++;
			} else if (in.charAt(i) == 'k') {
				k++;
			} else if (in.charAt(i) == 'e') {
				e++;
			} else if (in.charAt(i) == 'r') {
				r++;
			} else if (in.charAt(i) == 't') {
				t++;
			}
			i++;
		}
		return count;

	}

	static int count(String str) {
		String st = "";
		boolean b = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 58 && str.charAt(i) > 47) {
				st += str.charAt(i);
				b = true;
				continue;
			}
			if (b)
				st += "@";
			b = false;
		}
		String[] aa = st.split("@");
		return aa.length;
	}

	public static String factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}

	public static long power(int a, int b) {
		long power = 1;
		for (int c = 0; c < b; c++)
			power *= a;
		return power;
	}

	public static int getHelth(int[] a, int opr) {
		int health = 0;
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int max = a[i];
			for (int j = i; j < a.length; j++) {
				if (a[j] < min) {
					max = min;
					min = a[j];
				}
				if (a[j] > max) {
					max = a[j];
				}
			}
			System.out.println("min" + min + "--max" + max);
			health += (min * max);
			min = a[i];
			max = a[i];
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < min) {
					max = min;
					min = a[j];
				}
				if (a[j] > max) {
					max = a[j];
				}
			}
			System.out.println("min" + min + "--max" + max);
			System.out.println("*" + min * max);
			health += (min * max);
		}
		return health;
	}

	public static String palinDrom(String s) {
		String result = "Yes";
		if (s != null && s.length() > 1 && s.length() < 100) {
			int lenght = s.length() - 1;

			for (int i = 0; i < s.length() / 2; i++) {
				if (i == lenght || i > lenght) {
					break;
				}
				if (!(s.charAt(i) == s.charAt(lenght--))) {
					return "NO";
				}
			}
		} else {
			return "NO";
		}
		return result;
	}

	public static int printFacto(int i) {
		int result = 1;
		if (i > 0) {
			for (; i > 1; i--) {
				result = i * result;
			}
		}
		return result;
	}

	public static int findDivi(int l, int r, int k) {
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (i % k == 0) {
				count++;
			}
		}
		return count;
	}

	public static String reverse(String str) {
		if (str.length() == 1) {
			return str;
		}
		String rs = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rs += "" + str.charAt(i) + "";
		}
		return rs;
	}

	static class Task implements Callable<Integer> {

		Integer val1 = null;
		Integer val2 = null;

		public Task(Integer a, Integer b) {
			this.val1 = a;
			this.val2 = b;
		}

		@Override
		public Integer call() throws Exception {
			return this.val1 + this.val2;
		}

	}

	private static volatile int a, b, c, d;

	private static volatile int a1, a2;

	public static void main2(String[] arg) {

		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		b = scanner.nextInt();

		c = scanner.nextInt();
		d = scanner.nextInt();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				a1 = a + b;
				System.out.println(a1);
			}

		};
		Thread add = new Thread(r1);
		add.start();

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				a2 = c + d;
				System.out.println(a2);
			}

		};

		Thread add2 = new Thread(r2);
		add2.start();

		/*
		 * try { add2.join(); add.join(); } catch (InterruptedException ex) { }
		 */

		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				int ans = a1 * a2;
				System.out.println(ans);
			}
		};

		Thread mul = new Thread(r3);
		mul.start();

		try {
			mul.join();
		} catch (InterruptedException ex) {
		}
	}
}
