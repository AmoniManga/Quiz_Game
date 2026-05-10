import javax.swing.*;
import java.awt.*;

public class QuizGameUI {
    private JPanel mainPanel;
    private JLabel headerLabel;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6;

    public QuizGameUI() {
        mainPanel = new JPanel();
        headerLabel = new JLabel();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();

        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(headerLabel);
        mainPanel.add(btn1);
        mainPanel.add(btn2);
        mainPanel.add(btn3);
        mainPanel.add(btn4);
        mainPanel.add(btn5);
        mainPanel.add(btn6);

        headerLabel.setText("<html><center>Welcome to the CyberQuest quiz!<br>" +
                "This assignment is for Dr. Agada's COSC 402 class, Software & OS Security.<br>" +
                "Pick an option below to get started.</center></html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 26));
        headerLabel.setBounds(50, 40, 900, 160);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Font btnFont = new Font("Arial", Font.PLAIN, 20);

        btn1.setText("1. Login");
        btn1.setFont(btnFont);
        btn1.setBounds(200, 220, 600, 60);

        btn2.setText("2. Password Security Challenge");
        btn2.setFont(btnFont);
        btn2.setBounds(200, 300, 600, 60);

        btn3.setText("3. Phishing Detection Challenge");
        btn3.setFont(btnFont);
        btn3.setBounds(200, 380, 600, 60);

        btn4.setText("4. Encryption Basics Challenge");
        btn4.setFont(btnFont);
        btn4.setBounds(200, 460, 600, 60);

        btn5.setText("5. View Scores");
        btn5.setFont(btnFont);
        btn5.setBounds(200, 540, 600, 60);

        btn6.setText("6. Exit");
        btn6.setFont(btnFont);
        btn6.setBounds(200, 620, 600, 60);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CyberQuest Quiz");
        QuizGameUI myUI = new QuizGameUI();
        frame.setContentPane(myUI.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 800);
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