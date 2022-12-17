package BackJoon;

import java.util.Scanner;

public class Array4344 {
	Scanner sc = new Scanner(System.in);
	
	int[][] mainArray = null;
	int caseTotal = 1;
	int currentCaseNumber= 0;
	
	
	public static void main(String[] args) {

		
		Array4344 array = new Array4344();
		
		while (true){
			array.execute();
		}

	}
	
	public void execute() {
		

		
		String sentence = null;
		if(mainArray == null) {
			sentence = chooseSentence(mainArray, currentCaseNumber);
			//1. 가변배열 만들기(케이스 수를 고려한 배열 만들기)
			int arrayLength = Integer.parseInt(answer(sentence));
			
			mainArray = makeValiableArray(arrayLength);
		}else if (mainArray != null && caseTotal != currentCaseNumber) {
			//2.유동적 다차원 배열 만들기(케이스 별 학생 수를 고려한 다차원 배열)
			caseTotal = mainArray.length;
			sentence = chooseSentence(mainArray, currentCaseNumber);
			
			for (int i = 0; i < caseTotal; i++) {
				currentCaseNumber = i;
				sentence = (currentCaseNumber + 1) + sentence;
				int subLength = Integer.parseInt(answer(sentence));
				addSubArray(currentCaseNumber, subLength);		
			}
			currentCaseNumber = currentCaseNumber + 1;
			
		}else if (mainArray != null && caseTotal == currentCaseNumber) {
			sentence = chooseSentence(mainArray, currentCaseNumber);
			for(int i = 0; i < caseTotal; i++) {
				int studentTotal = mainArray[i].length;
				addStudentScore(i, studentTotal, sentence);
				
			}
			
			
		}
		
		
	}
	

	public void addStudentScore (int currentCase, int studentTotal, String sentence) {
		String frontSentence = sentence.substring(0,sentence.lastIndexOf(","));
		String backSentence = sentence.substring(sentence.lastIndexOf(",")+1);
		
		for(int i = 0 ; i < studentTotal; i++) {
			int currentStudentNumber = i;
			//() 번 째 케이스의 () 번 째 학생의 점수
			sentence = (currentCase + 1) + frontSentence+  (currentStudentNumber + 1) + backSentence;
			int studentScore = Integer.parseInt(answer(sentence));
			
			mainArray[currentCase][currentStudentNumber] = studentScore;
		}
		
		
		
		
	}
	
	public void addSubArray(int currentCaseNumber, int subLength) {
		//2-1. 케이스별 학생수 고려한 다차원 배열 생성
		mainArray[currentCaseNumber] = new int[subLength];
			
	}
	

	public int[][] makeValiableArray(int arrayLength) {
		//1-1.가변배열 생성
		int[][] tempMainArray  = new int [arrayLength][];
		
		
		return tempMainArray;
	}
	
	
	//문장고르기
	public String chooseSentence(int[][] mainArray, int currentCaseNumber) {

		String sentence = null;
		
		
		if(mainArray == null) {
			sentence = "테스트 케이스의 개수는";//배열의 length 결정
		}else if (mainArray != null && caseTotal != currentCaseNumber) {
			sentence =  "번 째 케이스 학생 수는";//케이스별 학생 수
		}else if (mainArray != null && caseTotal == currentCaseNumber) {
			sentence = "번 째 케이스의 , 번 째 학생의 점수";//케이스별 학생 점수
		}

		
		
		
		return sentence;
	}
	
	
	//질문기
	public String answer (String question) {
		String reply;
		

		System.out.println(question + "?");
		reply = sc.next();
		
		//System.out.println(reply);
		//sc.close(); 미리 닫아서 오류 발생
		
		
		return reply;
	
	}

}
