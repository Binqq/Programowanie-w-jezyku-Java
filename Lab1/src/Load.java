import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Load.
 */
public class Load
{
    /**
     * The Exam question.
     */
    List<Question> examQuestion = new ArrayList<>();
    /**
     * The Exam answer.
     */
    List<Answer> examAnswer = new ArrayList<>();
    /**
     * The Quest.
     */
    Question quest;
    /**
     * The Answr.
     */
    Answer answr ;

    /**
     * Load exam.
     *
     * @param fileName the file name
     */
    void LoadExam(String fileName)
    {

        BufferedReader br = null;
        String line= "";
        String cvsSplitBy = ",";
        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null)
            {

                String[] qua = line.split(cvsSplitBy);
                quest=new Question();
                quest.questionNumber = Integer.parseInt(qua[0]);
                quest.contentOfQuestion = qua[1];
                quest.firstAnswer = qua[2];
                quest.secondAnswer = qua[3];
                quest.thirdAnswer = qua[4];
                quest.fourthAnswer = qua[5];
                quest.goodAnswer = Integer.parseInt(qua[6]);
                quest.pointsForQuestion = Integer.parseInt(qua[7]);
                examQuestion.add(quest);

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

    /**
     * Load answer.
     *
     * @param fileName the file name
     */
    void LoadAnswer(String fileName)
    {
        BufferedReader br = null;
        String line= "";
        String cvsSplitBy = ",";

        try
        {
            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null)
            {   answr= new Answer();
                String[] qua = line.split(cvsSplitBy);
                answr.questionNumber = Integer.parseInt(qua[0]);
                answr.goodAnswer = Integer.parseInt(qua[1]);
                examAnswer.add(answr);
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

    /**
     * Save result.
     *
     * @param result the result
     */
    void SaveResult(Examresult result,List<Question> examQuestion)
    {
    String path = "Wyniki.csv";

    Exam exam=new Exam();
    int a;
    a=exam.calculateNote(examQuestion,result);
    ArrayList<Examresult> out  =new ArrayList<>();
    String s;
    s=result.points+","+result.goodAnswers+","+result.badAnswers+","+a;
    try{

        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }catch(IOException ex){
        System.out.print("Nie mogę zapisać pliku");
    }}
}
