import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * The type Test.
 */
public class Test
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */

    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }
}
