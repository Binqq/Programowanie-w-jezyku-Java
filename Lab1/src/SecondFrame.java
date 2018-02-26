import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame extends JFrame implements ActionListener{
    JPanel panel;

   JLabel loadExamLabel;
  JTextField loadExamField;
  JButton loadExamButton;

  JLabel loadAnswerLabel;
  JTextField loadAnswerField;
  JButton loadAnswerButton;

    SecondFrame()
    {
        super("Sprawdzanie odpowiedzi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);
        setLocation(500,200);
        setVisible(true);


        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        loadExamLabel = new JLabel("Podaj nazwe pliku z egzaminem");
        loadExamLabel.setBounds(20,20,150,25);
        panel.add(loadExamLabel);

        loadExamField = new JTextField();
        loadExamField.setBounds(180,20,70,25);
        panel.add(loadExamField);

        loadExamButton = new JButton("Ok") ;
        loadExamButton.setBounds(270,20,75,20);
        panel.add(loadExamButton);
        loadExamButton.addActionListener(this);

        loadAnswerLabel = new JLabel("Podaj nazwę pliku z odpowiedziami");
        loadAnswerLabel.setBounds(20,80,150,25);
        panel.add(loadAnswerLabel);

        loadAnswerField = new JTextField();
        loadAnswerField.setBounds(180,80,70,20);
        panel.add(loadAnswerField);

        loadAnswerButton = new JButton("ok");
        loadAnswerButton.setBounds(270,80,75,20);
        panel.add(loadAnswerButton);
        loadAnswerButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Load loader = new Load();
        if(evt.getSource() == loadExamButton)
        {
            String name = loadExamField.getText();
            loader.LoadExam(name);
        }else if(evt.getSource()==loadAnswerButton)
        {
            String name = loadAnswerField.getText();
            loader.LoadAnswer(name);
        }

    }
}
