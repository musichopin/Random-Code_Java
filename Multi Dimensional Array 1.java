package com.example.java;

public class Main {

	public static void main(String[] args) {

		int[][] bucky = { { 1, 2, 3, 4 }, { 5, 6, 7 }, { 9 } };
		// bucky [row] [column]
		bucky[0][1] = 5;
		// y ekseninin (j) sað tarafta bulunmasýna dikkat (column)
		bucky[2][0] = 3;
		// x ekseninin (i) tabloda aþaðý indikçe artmasýna dikkat (row)
		for (int i = 0; i < bucky.length; i++) { // column/outer array baz alýnýr
			for (int j = 0; j < bucky[i].length; j++) { // row baz alýnýr
				
				System.out.print(bucky[i][j]);
			}
			System.out.println();
		}

	}

}
/*
1534
567
3
*/
