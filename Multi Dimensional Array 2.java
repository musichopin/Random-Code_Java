package com.example.java;

public class Main {

	public static void main(String[] args) {

		int[][] bucky = new int[3][4];
		for (int i = 0; i < bucky.length; i++) {
			for (int j = 0; j < bucky[i].length; j++) {
				bucky[i][j] = i + j;
				System.out.print(bucky[i][j]);
			}
			System.out.println();
		}

	}

}
/*
0123
1234
2345
*/