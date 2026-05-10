import javax.swing.*; import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import java.awt.*;
import java.util.*; import java.io.*;

public class QuizGameUI {
    private JPanel mainPanel; private JLabel headerLabel;
    private JButton btn1; private JButton btn2;
    private JButton btn3; private JButton btn4;
    private JButton btn5; private JButton btn6;

    public QuizGameUI() {
            mainPanel.setLayout(null);
            mainPanel.setPreferredSize(new Dimension(500, 600));
         if (headerLabel != null) {
            headerLabel.setText("<html><center>Welcome to the CyberQuest quiz!<br>" +
                    "This assignment is for Dr. Agada's COSC 402 class, Software & OS Security.<br>" +
                    "Pick an option below to get started.</center></html>");
            headerLabel.setBounds(25, 20, 450, 100);
            headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            headerLabel.setForeground(Color.BLACK); headerLabel.setVisible(true); headerLabel.setOpaque(false);
        }
        btn1.setText("1. Login");
        btn1.setBounds(100, 140, 300, 40);

        btn2.setText("2. Password Security Challenge");
        btn2.setBounds(100, 190, 300, 40);

        btn3.setText("3. Phishing Detection Challenge");
        btn3.setBounds(100, 240, 300, 40);

        btn4.setText("4. Encryption Basics Challenge");
        btn4.setBounds(100, 290, 300, 40);

        btn5.setText("5. View Scores");
        btn5.setBounds(100, 340, 300, 40);

        btn6.setText("6. Exit");
        btn6.setBounds(100, 390, 300, 40);

        mainPanel.revalidate(); mainPanel.repaint();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("CyberQuest Quiz");
        QuizGameUI myUI = new QuizGameUI();
        frame.setContentPane(myUI.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}