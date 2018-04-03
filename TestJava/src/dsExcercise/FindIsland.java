package dsExcercise;

import java.io.IOException;
import java.util.Arrays;

public class FindIsland {
	public static void main(String[] args) throws IOException {
		/*
		 * int[][] a = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1,
		 * 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
		 * System.out.println("Number of Islands is: " + countIslands(a));
		 */

		/*
		 * int R = 3; int C = 6; int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9,
		 * 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } }; spiralPrint(R, C, a);
		 */
		/*
		 * int mat[ ][ ] = { {1, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 0, 0},};
		 * 
		 * System.out.println("Matrix Intially");
		 * 
		 * printMatrix(mat, 3, 4);
		 * 
		 * modifyMatrix(mat, 3, 4); System.out.println(
		 * "Matrix after modification n"); printMatrix(mat, 3, 4);
		 */

		int M[][] = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0 } };

		printMatrix(M, 4, 5);
		findUniqueRows(M, 4, 5);
		System.out.println("After ");
		printMatrix(M, 4, 5);

	}

	static void findUniqueRows(int mat[][], int r, int c) {

		int newUni[][] = new int[r][c];
		for (int i = 0; i < c; i++)
			newUni[0][i] = mat[0][i];

		for (int i = 1; i < r; i++) {
			boolean rs = false;
			for (int j = 0; j < c; j++) {
				if (j == 0) {
					 for (int k = 0; k < r; k++) {
						 outer:for (int l = 0; l < c; l++) {
							if (mat[i][l] != newUni[k][l]) {
								rs = true;
								break outer;
							}
						}
					}
				}
				if(rs)
				 newUni[i][j] = mat[i][j];
				else
					break;
			}

		}
		mat  = newUni;
	}

	static void printMatrix(int mat[][], int row, int col) {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(" " + mat[i][j]);
			}
			System.out.println("");
		}
	}

	static void modifyMatrix(int mat[][], int row, int col) {
		int dummy[][] = new int[3][4];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				dummy[i][j] = mat[i][j];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dummy[i][j] == 1) {
					int k = 0;
					while (k < row) {
						mat[k][j] = 1;
						k++;
					}
					k = 0;
					while (k < col) {
						mat[i][k] = 1;
						k++;
					}
					// break;
				}
			}
		}
	}

	// Returns number of islands in a[][]
	static int countIslands(int a[][]) {
		int n = a.length;
		int m = a[0].length;

		DisjointUnionSets dus = new DisjointUnionSets(n * m);

		/*
		 * The following loop checks for its neighbours and unites the indexes
		 * if both are 1.
		 */
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				// If cell is 0, nothing to do
				if (a[j][k] == 0)
					continue;

				// Check all 8 neighbours and do a union
				// with neighbour's set if neighbour is
				// also 1
				if (j + 1 < n && a[j + 1][k] == 1)
					dus.union(j * (m) + k, (j + 1) * (m) + k);
				if (j - 1 >= 0 && a[j - 1][k] == 1)
					dus.union(j * (m) + k, (j - 1) * (m) + k);
				if (k + 1 < m && a[j][k + 1] == 1)
					dus.union(j * (m) + k, (j) * (m) + k + 1);
				if (k - 1 >= 0 && a[j][k - 1] == 1)
					dus.union(j * (m) + k, (j) * (m) + k - 1);
				if (j + 1 < n && k + 1 < m && a[j + 1][k + 1] == 1)
					dus.union(j * (m) + k, (j + 1) * (m) + k + 1);
				if (j + 1 < n && k - 1 >= 0 && a[j + 1][k - 1] == 1)
					dus.union(j * m + k, (j + 1) * (m) + k - 1);
				if (j - 1 >= 0 && k + 1 < m && a[j - 1][k + 1] == 1)
					dus.union(j * m + k, (j - 1) * m + k + 1);
				if (j - 1 >= 0 && k - 1 >= 0 && a[j - 1][k - 1] == 1)
					dus.union(j * m + k, (j - 1) * m + k - 1);
			}
		}

		// Array to note down frequency of each set
		int[] c = new int[n * m];
		int numberOfIslands = 0;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (a[j][k] == 1) {

					int x = dus.find(j * m + k);

					// If frequency of set is 0,
					// increment numberOfIslands
					if (c[x] == 0) {
						numberOfIslands++;
						c[x]++;
					}

					else
						c[x]++;
				}
			}
		}
		return numberOfIslands;
	}

	// Function print matrix in spiral form
	static void spiralPrint(int m, int n, int a[][]) {
		int i, k = 0, l = 0;
		/*
		 * k - starting row index m - ending row index l - starting column index
		 * n - ending column index i - iterator
		 */

		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}

}

// Class to represent Disjoint Set Data structure
class DisjointUnionSets1 {
	int[] rank, parent;
	int n;

	public DisjointUnionSets1(int n) {
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}

	void makeSet() {
		// Initially, all elements are in their
		// own set.
		for (int i = 0; i < n; i++)
			parent[i] = i;
	}

	// Finds the representative of the set that x
	// is an element of
	int find(int x) {
		if (parent[x] != x) {
			// if x is not the parent of itself,
			// then x is not the representative of
			// its set.
			// so we recursively call Find on its parent
			// and move i's node directly under the
			// representative of this set
			return find(parent[x]);
		}

		return x;
	}

	// Unites the set that includes x and the set
	// that includes y
	void union(int x, int y) {
		// Find the representatives (or the root nodes)
		// for x an y
		int xRoot = find(x);
		int yRoot = find(y);

		// Elements are in the same set, no need
		// to unite anything.
		if (xRoot == yRoot)
			return;

		// If x's rank is less than y's rank
		// Then move x under y so that depth of tree
		// remains less
		if (rank[xRoot] < rank[yRoot])
			parent[xRoot] = yRoot;

		// Else if y's rank is less than x's rank
		// Then move y under x so that depth of tree
		// remains less
		else if (rank[yRoot] < rank[xRoot])
			parent[yRoot] = xRoot;

		else // Else if their ranks are the same
		{
			// Then move y under x (doesn't matter
			// which one goes where)
			parent[yRoot] = xRoot;

			// And increment the the result tree's
			// rank by 1
			rank[xRoot] = rank[xRoot] + 1;
		}
	}
}
