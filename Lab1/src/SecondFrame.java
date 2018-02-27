import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Second frame.
 */
public class SecondFrame extends JFrame implements ActionListener{


    /**
     * The Res.
     */
    Examresult res;
    /**
     * The Panel.
     */
    JPanel panel;

    /**
     * The Load exam label.
     */
    JLabel loadExamLabel;
    /**
     * The Load exam field.
     */
    JTextField loadExamField;
    /**
     * The Load exam button.
     */
    JButton loadExamButton;

    /**
     * The Load answer label.
     */
    JLabel loadAnswerLabel;
    /**
     * The Load answer field.
     */
    JTextField loadAnswerField;


    /**
     * The Statistic button.
     */
    JButton StatisticButton;

    /**
     * Instantiates a new Second frame.
     */

    SecondFrame()
    {
        super("Sprawdzanie odpowiedzi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocation(500,200);
        setVisible(true);


        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        loadExamLabel = new JLabel("Podaj nazwe pliku z egzaminem");
        loadExamLabel.setBounds(20,20,200,25);
        panel.add(loadExamLabel);

        loadExamField = new JTextField();
        loadExamField.setBounds(230,20,70,25);
        panel.add(loadExamField);

        loadExamButton = new JButton("Sprawdź prace") ;
        loadExamButton.setBounds(100,200,300,50);
        panel.add(loadExamButton);
        loadExamButton.addActionListener(this);

        loadAnswerLabel = new JLabel("Podaj nazwę pliku z odpowiedziami");
        loadAnswerLabel.setBounds(20,80,200,25);
        panel.add(loadAnswerLabel);

        loadAnswerField = new JTextField();
        loadAnswerField.setBounds(230,80,70,20);
        panel.add(loadAnswerField);

        StatisticButton = new JButton("Histogram");
        StatisticButton.setBounds(380,20,100,25);
        panel.add(StatisticButton);
        StatisticButton.addActionListener(this);



    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Load loader = new Load();
        Exam result = new Exam();

        if(evt.getSource() == loadExamButton)
        {
            String name = loadExamField.getText();
            loader.LoadExam(name);

            String name1 = loadAnswerField.getText();
            loader.LoadAnswer(name1);

            res=result.ChceckExam(loader.examQuestion,loader.examAnswer);
            loader.SaveResult(res,loader.examQuestion);
            JOptionPane.showMessageDialog(this,"zdobyto "+res.points+" z "+result.MaxPoints(loader.examQuestion)+" punktów","Wynik testu",JOptionPane.INFORMATION_MESSAGE);


    }else if(evt.getSource()==StatisticButton)
        {
            int note2=0,note3=0,note4=0,note5=0;
            BufferedReader br = null;
            String line= "";
            String cvsSplitBy = ",";

            try
            {
                br = new BufferedReader(new FileReader("Wyniki.csv"));
                while((line = br.readLine()) != null)
                {
                    String[] qua = line.split(cvsSplitBy);
                   if(Integer.parseInt(qua[3])==2)
                   {
                       note2++;
                   }else if(Integer.parseInt(qua[3])==3)
                   {
                       note3++;
                   }else if(Integer.parseInt(qua[3])==4)
                   {
                       note4++;
                   }
                   else if(Integer.parseInt(qua[3])==5)
                   {
                       note5++;
                   }
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
            DefaultCategoryDataset dcd = new DefaultCategoryDataset();
            dcd.setValue(note2,"Marks","2");
            dcd.setValue(note3,"Marks","3");
            dcd.setValue(note4,"Marks","4");
            dcd.setValue(note5,"Marks","5");

            JFreeChart jFreeChart = ChartFactory.createBarChart("Histogram ocen","","Ilość ocen",dcd, PlotOrientation.VERTICAL,true,true,false);
            CategoryPlot plot = jFreeChart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.black);

            ChartFrame chartFrame = new ChartFrame("Student",jFreeChart,true);
            chartFrame.setVisible(true);
            chartFrame.setSize(500,400);
        }
    }

}
