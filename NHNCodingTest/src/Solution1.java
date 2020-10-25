import java.util.Scanner;
import java.util.ArrayList;

class Solution1 {
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
ArrayList<Character> list = new ArrayList<>();
	  int[] numOfTagger = new int[numOfAllPlayers];
	  numOfTagger[0] = 1; // A의 술래횟수 추가
	  char curTagger = 'A'; // 현재술래
	  int taggerIdx = 0; // 술래의 위치
	  
	  for(int i=0; i<numOfAllPlayers-1; i++) {
		  list.add((char)('B'+i));
	  }
	  
	  for(int i=0; i<numOfGames; i++) { // 주어진 횟수만큼 게임 진행
		  
		  int move = numOfMovesPerGame[i];
		  taggerIdx += move;
		  if(taggerIdx<0) { // 음수처리
			  taggerIdx = Math.abs(taggerIdx);
			  int tern = taggerIdx%(numOfAllPlayers-1);
			  if(tern == 0) {
				  taggerIdx = 0;
			  } else {
				  taggerIdx = (numOfAllPlayers-1)-tern;
			  }
		  } else {
			  taggerIdx %= (numOfAllPlayers-1);
		  }
		  
		  // 현재 칸에 수건을 놓는다 ---> 술래에 걸리지 않는 사람인지 확인
		  char target = list.get(taggerIdx);
		  
		  boolean isQuick = false;
		  
		  for(int j=0; j<numOfQuickPlayers; j++) {
			  if(namesOfQuickPlayers[j] == target) {
				  isQuick = true;
				  break;
			  }
		  }
		  
		  if(!isQuick) { // 술래에 걸릴 수 있는 사람인 경우
			  list.add(taggerIdx, curTagger); // 술래였던 사람이 자리를 앉음
				list.remove(taggerIdx+1);
			  curTagger = target; // 술래가 바뀜
			  numOfTagger[target-65]++;
		  } else {
			  numOfTagger[curTagger-65]++;
		  }
		  
	  }

	  for(int i=0; i<numOfAllPlayers-1; i++) {
		  char c = list.get(i);
		  System.out.println(c + " " + numOfTagger[c-65]);
	  }
		System.out.println(curTagger + " " + numOfTagger[curTagger-65]);
  }

  private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
}