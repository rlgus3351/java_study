package javaproject;

public class Ex26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("1111*");
//		System.out.println("111**");
//		System.out.println("11***");
//		System.out.println("1****");
//		System.out.println("*****");
		
		// 1대신 스페이스 공백 넣어주기
//---------------------------------------case 1-------------------------------------//
		for(int i=0; i<5; i++) {
			for(int j=4; j>i; j--) {
				System.out.print(" "); // 공백 4~0번 출력하는 for문
			}
			for(int k=0; k<i+1; k++) {	//i의 개수 0일때 별 1번출력 | i가 1일때 별 2번 출력 
				System.out.print("*");
			}
			System.out.println();
			
//----------------------------------------case 2------------------------------------//
//			System.out.println("    *");
//			System.out.println("   **");
//			System.out.println("  ***");
//			System.out.println(" ****");
//			System.out.println("*****");
			
		}
	}

}
