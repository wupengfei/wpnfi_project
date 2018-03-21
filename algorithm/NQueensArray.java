package edu.bjtu.sse;

import java.util.ArrayList;
import java.util.List;

public class NQueensArray {

	/**
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		int[][] mark = new int[n][n];
		List<Character[]> location = new ArrayList<>();

		this.initialLocation(location, n);
		produceQueen(0, n, location, result, mark);

		return result;
	}

	/**
	 * @param k
	 * @param n
	 * @param location
	 * @param result
	 * @param mark
	 */
	public void produceQueen(int k, int n, List<Character[]> location, List<List<String>> result, int[][] mark) {
		if (k == n) {
			ArrayList<String> rl = new ArrayList<>();
			for (Character[] chars : location) {
				StringBuffer sb = new StringBuffer();

				for (Character character : chars) {
					sb.append(character);
				}
				rl.add(sb.toString());
			}
			result.add(rl);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (mark[k][i] == 0) {
				int[][] copyMark = new int[n][n];
				this.copyMark(mark, copyMark);
				location.get(k)[i] = 'Q';
				this.setDownTheQueen(k, i, mark);
				this.produceQueen(k + 1, n, location, result, mark);
				mark = copyMark;
				location.get(k)[i] = '.';
			}
		}
	}

	public void copyMark(int[][] mark, int[][] copyMark) {
		for (int i = 0; i < mark.length; i++) {
			for (int j = 0; j < mark[i].length; j++) {
				copyMark[i][j] = mark[i][j];
			}
		}
	}

	public void setDownTheQueen(int x, int y, int[][] mark) {
		int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1, };
		int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
		mark[x][y] = 1;
		for (int i = 1; i < mark.length; i++) {

			for (int j = 0; j < 8; j++) {
				int step_x = x + i * dx[j];
				int step_y = y + i * dy[j];
				if (step_x >= 0 && step_x <= mark.length - 1 && step_y >= 0 && step_y <= mark.length - 1) {
					mark[step_x][step_y] = 1;
				}
			}

		}
	}

	/**
	 * 
	 * @param location
	 */
	public void initialLocation(List<Character[]> location, int n) {
		for (int i = 0; i < n; i++) {
			Character[] chars = new Character[n];
			for (int j = 0; j < n; j++) {
				chars[j] = '.';
			}
			location.add(chars);
		}
	}

	public static void main(String[] args) {
		NQueensArray nq = new NQueensArray();
		long start = System.currentTimeMillis();
		List<List<String>> result = nq.solveNQueens(4);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(result.toString());

	}

}
