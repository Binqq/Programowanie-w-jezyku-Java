import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class Exam
{
    public static void main(String [ ] args)
    {

    }
    Examresult result= new Examresult();
    int maxPoints = 0;
    float percentageResult=0;

    Examresult ChceckExam(List<Question> examQuestion,List<Answer> examAnswer)
    {
        for(int i=0;i<examQuestion.size();i++)
        {
            if(examQuestion.get(i).goodAnswer==examAnswer.get(i).goodAnswer){
                result.goodAnswers++;
                result.points=+examQuestion.get(i).pointsForQuestion;
            }else
            {
                result.badAnswers ++;
            }
        }
        return result;
    }
    int MaxPoints(List<Question> examQuestion)
    {
        for(int i=0 ; i<examQuestion.size();i++)
        {
            maxPoints+=examQuestion.get(i).pointsForQuestion;
        }
        return maxPoints;
    }

    int calculateNote(List<Question> examQuestion)
    {
        int note=0;

        percentageResult = result.points/MaxPoints(examQuestion);

        if(percentageResult<0.3)
        {
            note=2;
        }else if(percentageResult>=0.3 && percentageResult<0.6){
            note=3;
        }else if(percentageResult>=0.6 && percentageResult <0.7 )
        {
            note = 4;
        }else if(percentageResult >= 0.7 )
        {
            note=5;
        }
        return note;
    }

}
