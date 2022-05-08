package com.gl.problem.floorbuild;

import java.util.*;

public class FloorConstruction {

	public static Queue<String> analyseFloorConstruction(Integer[] inFloors, int size) {

		Queue<String> resultArr = new LinkedList<>();
		Stack<Integer> tempStack = new Stack<>();
		Stack<Integer> sortedStack = new Stack<>();
		Queue<Integer> floorsConstructed = new LinkedList<>();

		for (int i = 0; i < inFloors.length; i++) {
			floorsConstructed.add(inFloors[i]);
		}

		Arrays.sort(inFloors);

		for (int i = 0; i < inFloors.length; i++) {
			sortedStack.push(inFloors[i]);
		}

		String tempRes = "";
		while (!sortedStack.isEmpty()) {

			int nextFloor = floorsConstructed.remove();
			tempStack.push(nextFloor);

			int srtStackTop = sortedStack.peek();

			if (srtStackTop > nextFloor) {
				resultArr.add(" ");
			} else {
				while (!tempStack.isEmpty() && tempStack.peek() == sortedStack.peek()) {
					tempRes += " " + tempStack.pop();
					sortedStack.pop();
				}
				resultArr.add(tempRes);
				tempRes = "";
			}
		}
 		return resultArr;
	}

	public static void main(String[] args) {
		Integer inArr[] ;
		Scanner sc = new Scanner(System.in);
		int size;
		
		System.out.println("Enter the total no of floors in the building");
		size = sc.nextInt();
		inArr = new Integer[size];
		for (int i = 1; i < size+1; i++) {
			System.out.println("\nEnter the floor size given on day :\r\n" + i + ": ");
			inArr[i-1] = sc.nextInt();			       
		}
		Queue<String> resultArr  = analyseFloorConstruction(inArr, inArr.length);
		System.out.println("The order of construction is as follows \\n");
		int dayCnt = 1;
		while(!resultArr.isEmpty()) {
			String result = resultArr.remove();			 
				System.out.println(" Day "+ dayCnt + ": " +result);
				dayCnt++;				
 
		}
	}

}
