import javax.swing.*;
import java.awt.*;

public class QuizGameUI {
    private JPanel mainPanel;
    private JLabel headerLabel;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6;

    public QuizGameUI() {
        mainPanel = new JPanel(); headerLabel = new JLabel();
        btn1 = new JButton(); btn2 = new JButton();
        btn3 = new JButton(); btn4 = new JButton();
        btn5 = new JButton(); btn6 = new JButton();

        mainPanel.setLayout(null); mainPanel.setBackground(Color.WHITE);
        mainPanel.add(headerLabel);
        mainPanel.add(btn1); mainPanel.add(btn2);
        mainPanel.add(btn3); mainPanel.add(btn4);
        mainPanel.add(btn5); mainPanel.add(btn6);

        headerLabel.setText("<html><center>Welcome to the CyberQuest quiz!<br>" +
                "This assignment is for Dr. Agada's COSC 402 class, Software & OS Security.<br>" +
                "Pick an option below to get started.</center></html>");
        headerLabel.setBounds(10, 20, 480, 100);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setForeground(Color.BLACK);

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
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("CyberQuest Quiz");
        QuizGameUI myUI = new QuizGameUI();
        frame.setContentPane(myUI.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    } {
        $$$setupUI$$$();
    }
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        btn1 = new JButton();
        btn1.setText("Button 2");
        mainPanel.add(btn1);
        btn2 = new JButton();
        btn2.setText("Button3");
        mainPanel.add(btn2);
        final JLabel label1 = new JLabel();
        label1.setEnabled(false);
        label1.setText("headerLabel");
        mainPanel.add(label1);
        btn3 = new JButton();
        btn3.setText("Button 1");
        mainPanel.add(btn3);
        btn4 = new JButton();
        btn4.setText("Button4");
        mainPanel.add(btn4);
        btn5 = new JButton();
        btn5.setText("Button5");
        mainPanel.add(btn5);
        btn6 = new JButton();
        btn6.setText("Button6");
        mainPanel.add(btn6);
    }
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}