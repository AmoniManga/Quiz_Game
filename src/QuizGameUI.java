import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizGameUI {
    private JPanel cardPanel;
    private JPanel mainPanel, loginPanel, existingLoginPanel;
    private CardLayout cardLayout;
    private JLabel headerLabel;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6;
    private JTextField userField, existingUserField;
    private JPasswordField passField, rePassField, existingPassField;

    // Stored credentials
    private String savedUsername = "";
    private String savedPassword = "";

    public QuizGameUI() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        createMainPanel();
        createLoginPanel();
        createExistingLoginPanel();

        cardPanel.add(mainPanel, "Main");
        cardPanel.add(loginPanel, "Login");
        cardPanel.add(existingLoginPanel, "ExistingLogin");
    }

    private void createMainPanel() {
        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.WHITE);

        headerLabel = new JLabel("<html><center>Welcome to the CyberQuest quiz!<br>" +
                "This assignment is for Dr. Agada's COSC 402 class, Software & OS Security.<br>" +
                "Pick an option below to get started.</center></html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 26));
        headerLabel.setBounds(50, 40, 900, 160);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(headerLabel);

        Font btnFont = new Font("Arial", Font.PLAIN, 20);

        btn1 = new JButton("1. Login");
        btn1.setFont(btnFont);
        btn1.setBounds(200, 220, 600, 60);
        btn1.addActionListener(e -> cardLayout.show(cardPanel, "Login"));
        mainPanel.add(btn1);

        ActionListener loginWarning = e -> JOptionPane.showMessageDialog(mainPanel,
                "You must login before using! Click the first button!",
                "Access Denied",
                JOptionPane.WARNING_MESSAGE);

        btn2 = new JButton("2. Password Security Challenge");
        btn3 = new JButton("3. Phishing Detection Challenge");
        btn4 = new JButton("4. Encryption Basics Challenge");
        btn5 = new JButton("5. View Scores");

        JButton[] restrictedBtns = {btn2, btn3, btn4, btn5};

        int yPos = 300;
        for (JButton b : restrictedBtns) {
            b.setFont(btnFont);
            b.setBounds(200, yPos, 600, 60);
            b.addActionListener(loginWarning);
            mainPanel.add(b);
            yPos += 80;
        }

        btn6 = new JButton("6. Exit");
        btn6.setFont(btnFont);
        btn6.setBounds(200, 620, 600, 60);
        btn6.addActionListener(e -> {
            JOptionPane.showMessageDialog(mainPanel,
                    "Goodbye! Thanks for playing CyberQuest.",
                    "Exit",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
        mainPanel.add(btn6);
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(null);
        loginPanel.setBackground(Color.WHITE);

        Font labelFont = new Font("Arial", Font.PLAIN, 28);

        JLabel uLabel = new JLabel("Create Username / Email");
        uLabel.setFont(labelFont);
        uLabel.setBounds(200, 50, 600, 40);

        userField = new JTextField();
        userField.setBounds(200, 100, 600, 60);

        JLabel pLabel = new JLabel("Create Password");
        pLabel.setFont(labelFont);
        pLabel.setBounds(200, 200, 600, 40);

        passField = new JPasswordField();
        passField.setBounds(200, 250, 600, 60);

        JLabel rLabel = new JLabel("Re-Enter Password");
        rLabel.setFont(labelFont);
        rLabel.setBounds(200, 350, 600, 40);

        rePassField = new JPasswordField();
        rePassField.setBounds(200, 400, 600, 60);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 22));
        submitBtn.setBounds(200, 550, 600, 60);

        submitBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            String rePassword = new String(rePassField.getPassword());

            if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                JOptionPane.showMessageDialog(loginPanel,
                        "Please fill in all fields!",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!password.equals(rePassword)) {
                JOptionPane.showMessageDialog(loginPanel,
                        "Passwords do not match!",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Save credentials
            savedUsername = username;
            savedPassword = password;

            // Remove warning and replace buttons 2-5 actions
            JButton[] restrictedBtns = {btn2, btn3, btn4, btn5};

            for (JButton b : restrictedBtns) {
                for (ActionListener al : b.getActionListeners()) {
                    b.removeActionListener(al);
                }

                b.addActionListener(ev -> {
                    existingUserField.setText("");
                    existingPassField.setText("");
                    cardLayout.show(cardPanel, "ExistingLogin");
                });
            }

            cardLayout.show(cardPanel, "Main");
        });

        loginPanel.add(uLabel);
        loginPanel.add(userField);
        loginPanel.add(pLabel);
        loginPanel.add(passField);
        loginPanel.add(rLabel);
        loginPanel.add(rePassField);
        loginPanel.add(submitBtn);
    }

    private void createExistingLoginPanel() {
        existingLoginPanel = new JPanel(null);
        existingLoginPanel.setBackground(Color.WHITE);

        Font labelFont = new Font("Arial", Font.PLAIN, 28);

        JLabel uLabel = new JLabel("Enter Existing Username / Email");
        uLabel.setFont(labelFont);
        uLabel.setBounds(200, 100, 600, 40);

        existingUserField = new JTextField();
        existingUserField.setBounds(200, 150, 600, 60);

        JLabel pLabel = new JLabel("Enter Existing Password");
        pLabel.setFont(labelFont);
        pLabel.setBounds(200, 280, 600, 40);

        existingPassField = new JPasswordField();
        existingPassField.setBounds(200, 330, 600, 60);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Arial", Font.BOLD, 22));
        submitBtn.setBounds(200, 500, 600, 60);

        submitBtn.addActionListener(e -> {
            String enteredUsername = existingUserField.getText();
            String enteredPassword = new String(existingPassField.getPassword());

            if (!enteredUsername.equals(savedUsername) || !enteredPassword.equals(savedPassword)) {
                JOptionPane.showMessageDialog(existingLoginPanel,
                        "Username or password is incorrect!",
                        "Login Failed",
                        JOptionPane.WARNING_MESSAGE);
            }
            // If correct: do nothing
        });

        existingLoginPanel.add(uLabel);
        existingLoginPanel.add(existingUserField);
        existingLoginPanel.add(pLabel);
        existingLoginPanel.add(existingPassField);
        existingLoginPanel.add(submitBtn);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CyberQuest Quiz");
        QuizGameUI myUI = new QuizGameUI();
        frame.setContentPane(myUI.cardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
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

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}