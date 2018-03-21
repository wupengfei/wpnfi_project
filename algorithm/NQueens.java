package edu.bjtu.sse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * N�ʺ�����
 * @author wupengfei
 *
 */
public class NQueens  {

	/**
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<ArrayList<Integer>> mark = new ArrayList<ArrayList<Integer>>();
		List<Character[]> location = new ArrayList<>();
		
		this.initialMark(mark, n);
		this.showMark(mark);
		this.initialLocation(location, n);
		this.showLocation(location);
		produceQueen(0,n,location,result,mark);
		 
		return result;
    }
	

	/**
	 * [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
	 * @param k
	 * @param n
	 * @param location
	 * @param result
	 * @param mark
	 */
	public void produceQueen(int k, int n, List<Character[]> location, List<List<String>> result,
			List<ArrayList<Integer>> mark) {
			if(k == n){// k==n ʱ����������˴�0��n-1�е�ɨ��
				ArrayList<String> rl = new ArrayList<>();
				for(Character[] chars:location){
					StringBuffer sb = new StringBuffer();
			
					for (Character character : chars) {
						sb.append(character);
					}
					rl.add(sb.toString());
				}
				result.add(rl);
				return ;
			}
			for (int i = 0; i < n; i++) {
				if(mark.get(k).get(i).equals(0)){ //����������Ϊ0���Է��ûʺ�
					List<ArrayList<Integer>> copyMark = new ArrayList<ArrayList<Integer>>();
					this.copyMark(mark, copyMark);
					location.get(k)[i] = 'Q';
					this.setDownTheQueen(k, i, mark);
					this.produceQueen(k+1, n, location, result, mark); //�ݹ���һ�еĻʺ�λ��
					mark = copyMark;
					location.get(k)[i] = '.';
				}
			}
	}
	
	
	public void copyMark(List<ArrayList<Integer>> mark,List<ArrayList<Integer>> copyMark){
		for (int i = 0; i < mark.size(); i++) {
			ArrayList<Integer> inner = new ArrayList<>();
			for (int j = 0; j < mark.get(i).size(); j++) {
				inner.add(mark.get(i).get(j));
			}
			copyMark.add(inner);
		}
	}

	/**
	 * mark[x][y] ��ʾһ������
	 * dx �ϣ� �£�����
	 * @param x
	 * @param y
	 * @param mark �������
	 */
	public void  setDownTheQueen(int x,int y,List<ArrayList<Integer>> mark ){
		int[] dx = { //��������
			-1,1,0,0,-1,-1,1,1,
		};
		int[] dy = {
			 0,0,-1,1,-1,1,-1,1	
		};
		mark.get(x).set(y, 1); // mark[x][y]
		for (int i = 1; i < mark.size(); i++) { //��1��ʼ��һֱ�����̵ı�Ե 1��mark.size()
			
			for (int j = 0; j < 8; j++) { //8������
				int step_x = x + i*dx[j];  // x + (1*-1), x + (1*1)
				int step_y = y + i*dy[j];  // y + (1*0),y + (1*0)
				if(step_x>=0 && step_x<=mark.size()-1 && step_y>=0 && step_y<=mark.size()-1){
					mark.get(step_x).set(step_y, 1);
				}
			}
			
		} 
	}
	
	/**
	 * չʾmark�����е�����
	 * @param mark
	 */
	public void showMark(List<ArrayList<Integer>> mark) {
		System.out.println("---------------------------------------");
		for (ArrayList<Integer> arrayList : mark) {
			for (Integer integer : arrayList) {
				System.out.print(  integer  + "\t" );
			}
			System.out.println();
		}
		System.out.println("---------------------------------------");
	}
	
	/**
	 * ��ʾ�ʺ�λ������
	 * @param location
	 */
	public void showLocation(List<Character[]> location) {
		for (Character[] characters : location) {
			for (Character character : characters) {
				System.out.print(character + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param location
	 */
	public void initialLocation(List<Character[]> location,int n){
		for (int i = 0; i < n; i++) {
			Character[] chars = new Character[n];
			for (int j = 0; j < n; j++) {
				chars[j] = '.';
			}
			location.add(chars);
		}
		System.out.println("-----------------λ�������ʼ���ɹ�!lcoation-----------------");

	}
	
	/**
	 * ��ʼ������
	 * @param mark
	 * @param n
	 */
	public void initialMark(List<ArrayList<Integer>> mark,int n){
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> inner = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				inner.add(0);
			}
			mark.add(inner);
		}
		System.out.println("-----------------��������ʼ���ɹ�!mark-----------------");
	}
	
	public static void main(String[] args) {
		  NQueens nq = new NQueens();
		  long start = System.currentTimeMillis();
		  List<List<String>> result = nq.solveNQueens(4);
		  long end = System.currentTimeMillis();
		  System.out.println(end-start);
		  System.out.println(result.toString());
		  
		  for (List<String> arrayList : result) {
			  
			for (String string : arrayList) {
				System.out.println(string);
			}
			System.out.println();
			
		}
		 /*List<ArrayList<Integer>> mark = new ArrayList<ArrayList<Integer>>();
		 List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		 ArrayList<Character[]> location = new ArrayList<>();

		 nq.initialMark(mark, 4);
		 nq.showMark(mark);
		 
		 nq.setDownTheQueen(0, 0, mark);
		 nq.showMark(mark);
		 
		 List<ArrayList<Integer>> copyMark = new ArrayList<ArrayList<Integer>>();
		 nq.copyMark(mark, copyMark);
		 System.out.println("-------------����mark����---------------");
		 nq.showMark(copyMark);
		 
		 
		 nq.initialLocation(location, 4);
		 nq.showLocation(location);*/
		 
	 
		 
	 
		 
	}

}
