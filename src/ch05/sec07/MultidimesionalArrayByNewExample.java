package ch05.sec07;

public class MultidimesionalArrayByNewExample
{
    public static void main(String[] args) {
        int[][] mathScores = new int[2][3];
        for(int i = 0; i<mathScores.length;i++){
            for(int j = 0; j<mathScores[i].length;j++){
                System.out.println("mathScores["+i+"]["+j+"] : "+mathScores[i][j]);
            }
        }
        System.out.println();

        mathScores[0][0] = 80;
        mathScores[0][1] = 83;
        mathScores[0][2] = 85;
        mathScores[1][0] = 86;
        mathScores[1][1] = 90;
        mathScores[1][2] = 92;

        int totalStudent = 0;
        int totalMathSum = 0;

        for(int i = 0; i<mathScores.length; i++){
            totalStudent += mathScores[i].length;
            for(int j = 0; j<mathScores[i].length; j++){
                totalMathSum += mathScores[i][j];
            }
        }
        System.out.println("전체 학생의 수학 점수 평균 : "+(double)totalMathSum/totalStudent);

        //각 반의 학생 수가 다를 경우 점수 저장을 위한 2차원 배열 생성
        int[][] englishScores = new int[2][];
        englishScores[0] = new int[2];
        englishScores[1] = new int[3];

        for(int i = 0; i<englishScores.length; i++){
            for(int j = 0; j<englishScores[i].length; j++){
                System.out.println("englishScores["+i+"]["+j+"] : "+mathScores[i][j]);
            }
        }
        englishScores[0][0] = 90;
        englishScores[0][1] = 91;
        englishScores[1][0] = 92;
        englishScores[1][1] = 93;
        englishScores[1][2] = 94;

        totalStudent = 0;
        int totalEnglishSum = 0;
        for(int i = 0; i<englishScores.length; i++){
            totalStudent += englishScores[i].length;
            for(int j = 0; j<englishScores[i].length; j++){
                totalEnglishSum += englishScores[i][j];
            }
        }
        System.out.println("전체 학생의 영어 점수 평균 : "+(double)totalEnglishSum/totalStudent);

    }
}
