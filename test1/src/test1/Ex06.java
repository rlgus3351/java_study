package test1;

public class Ex06 {
	public static void main(String[] args) {
		int result = 0;
		for(int i=1; i<78; i++) {
			result += (78-i)*i;
		}
		System.out.println(result);
	}

}
