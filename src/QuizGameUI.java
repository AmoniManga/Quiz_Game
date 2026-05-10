import javax.swing.*; import java.util.*; import java.io.*;

public class QuizGameUI {
    private JPanel mainPanel;
    private JButton button2Button;
    private JButton button1Button;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Game");
        frame.setContentPane(new QuizGameUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
