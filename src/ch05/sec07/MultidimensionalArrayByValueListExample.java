package ch05.sec07;

public class MultidimensionalArrayByValueListExample
{
    public static void main(String[] args) {
        int[][] scores = {
                {80,90,96},
                {76,88}
        };

        System.out.println("1차원 배열 길이(반의 수) : "+scores.length);
        System.out.println("2차원 배열 길이(첫 번째 반의 학생 수) : "+scores[0].length);
        System.out.println("2차원 배열 길이(두 번째 반의 학생 수) : "+scores[1].length);

        //첫 번째 반의 세 번째 학생의 점수
        System.out.println("score[0][2]: "+scores[0][2]);

        //두 번째 반의 두 번째 학생의 점수
        System.out.println("score[1][1]: "+scores[1][1]);

        int class1Sum = 0;
        for(int i =0; i<scores[0].length; i++){
            class1Sum += scores[0][i];
        }

        System.out.println("첫 번째 반의 평균 점수 :"+(double)class1Sum/scores[0].length);

        int class2Sum = 0;
        for(int i =0; i<scores[1].length; i++){
            class2Sum += scores[1][i];
        }

        System.out.println("두 번째 반의 평균 점수 :"+ (double)class2Sum/scores[1].length);
    }

}
