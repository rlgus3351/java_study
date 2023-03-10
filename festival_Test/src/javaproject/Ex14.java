package javaproject;

public class Ex14 {
	public static String getMiddle(String a) {// 문자열 String getMiddle메소드를 작성(매개변수 타입 : 문자형)
		int num = a.length(); // 문자열의 수를 알기위해 .length를 써서 num에 저장한다.
		if (num % 2 == 1) {// 문자열이 홀수 일때
			num = num / 2; // 문자열의 가운데 값을 출력하면 된다.
			// substring = 문자열의 출력하고싶은 범위를 입력하여 출력한다.
			String substr = a.substring(num, num + 1);
			return substr;
		} else {
			num = num / 2;
			// 짝수는 나눈 값에 -+1을 하여 가운데 문자를 출력받는다.
			String substr = a.substring(num-1, num + 1);
			return substr;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문제. getMiddle 메소드는 하나의 단어를 입력받아 가운데 글자를 반환하도록 만들어본다.
		// 단어의 길이가 짝수일 경우 가운데 두글자를 반환하면 되고
		// 단어의 길이가 홀수일 경우에는 가운데 한글자를 반환한다.
		System.out.println(getMiddle("power"));
	}

}
