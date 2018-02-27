import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type My frame.
 */
public class MyFrame extends JFrame implements ActionListener
{
   
    /**
     * The Second frame.
     */
    public SecondFrame secondFrame;
    @Override
    public void actionPerformed(ActionEvent evt) {

        secondFrame = new SecondFrame();

       this.setVisible(false);
    }

    /**
     * Convert to multiline string.
     *
     * @param orig the orig
     * @return the string
     */
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
    private JPanel panel;

    /**
     * Instantiates a new My frame.
     */
    public MyFrame(){
        super("Sprawdzacz kolokwiów") ;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setLocation(50,50);


       // setLayout(new GridLayout(2,5));

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JLabel WelcomeLabel = new JLabel();
        WelcomeLabel.setMaximumSize(new Dimension(0,0));
        WelcomeLabel.setText(convertToMultiline("Witaj w programie Sprawdzacz egzaminów\n Program ten służy do sprawdzania egzaminów  Jego celem jest również przedstawienie wyników w przystępny sposób"));
        WelcomeLabel.setBounds(20,-20,300,300);
        panel.add(WelcomeLabel);

        JButton button = new JButton("Start");
        button.setBounds(90,200,100,25);
        panel.add(button);
        button.addActionListener(this);

        setVisible(true);

    }
}
