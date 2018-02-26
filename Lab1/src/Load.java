import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Load
{
    List<Question> examQuestion;
    List<Answer> examAnswer;
    Question quest;
    Answer answr;
    void LoadExam(String fileName)
    {

        BufferedReader br = null;
        String line= "";
        String cvsSplitBy = ",";
        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null){
                String[] qua = line.split(cvsSplitBy);
                quest.questionNumber = Integer.parseInt(qua[0]);
                quest.contentOfQuestion = qua[1];
                quest.firstAnswer = qua[2];
                quest.secondAnswer = qua[3];
                quest.thirdAnswer = qua[4];
                quest.fourthAnswer = qua[5];
                quest.goodAnswer = Integer.parseInt(qua[6]);
                quest.pointsForQuestion = Integer.parseInt(qua[7]);
            }
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br !=null)
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
        }
    }

    void LoadAnswer(String fileName)
    {
        BufferedReader br = null;
        String line= "";
        String cvsSplitBy = ",";

        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null){
                String[] qua = line.split(cvsSplitBy);
                answr.questionNumber = Integer.parseInt(qua[0]);
                quest.goodAnswer = Integer.parseInt(qua[1]);
            }
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br !=null)
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
        }
    }
}
