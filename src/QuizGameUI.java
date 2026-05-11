import javax.swing.*; import java.awt.*; import java.awt.event.*;

public class QuizGameUI {
    private JPanel cardPanel;
    private JPanel mainPanel, loginPanel, existingLoginPanel, readingPanel;
    private CardLayout cardLayout;
    private JLabel headerLabel, readingHeaderLabel;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6;
    private JTextField userField, existingUserField;
    private JPasswordField passField, rePassField, existingPassField;

    private String savedUsername = ""; private String savedPassword = ""; private String selectedReadingTitle = "";

    public QuizGameUI() {
        cardLayout = new CardLayout(); cardPanel = new JPanel(cardLayout);

        createMainPanel(); createLoginPanel();
        createExistingLoginPanel(); createReadingPanel();

        cardPanel.add(mainPanel, "Main");
        cardPanel.add(loginPanel, "Login");
        cardPanel.add(existingLoginPanel, "ExistingLogin");
        cardPanel.add(readingPanel, "Reading");
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

        ActionListener loginWarning = e -> JOptionPane.showMessageDialog(
                mainPanel,
                "You must login before using! Click the first button!",
                "Access Denied",
                JOptionPane.WARNING_MESSAGE
        );

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
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Goodbye! Thanks for playing CyberQuest.",
                    "Exit",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.exit(0);
        });
        mainPanel.add(btn6);
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 12) return false;
        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else hasSpecial = true;
        }
        return hasLetter && hasNumber && hasSpecial;
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
        submitBtn.setBounds(200, 520, 600, 60);

        JButton homeBtn = new JButton("Go back to homepage");
        homeBtn.setFont(new Font("Arial", Font.BOLD, 20));
        homeBtn.setBounds(200, 600, 600, 50);
        homeBtn.addActionListener(e -> cardLayout.show(cardPanel, "Main"));

        submitBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            String rePassword = new String(rePassField.getPassword());

            if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                JOptionPane.showMessageDialog(
                        loginPanel,
                        "Please fill in all fields!",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            } if (!password.equals(rePassword)) {
                JOptionPane.showMessageDialog(
                        loginPanel,
                        "Passwords do not match!",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            } if (!isValidPassword(password)) {
                JOptionPane.showMessageDialog(
                        loginPanel,
                        "Please make sure your password has:\n" +
                                "• Minimum 12 characters\n" +
                                "• At least one letter\n" +
                                "• At least one number\n" +
                                "• At least one special character\n" +
                                "NOTE: Passwords are case sensitive",
                        "Invalid Password",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            savedUsername = username; savedPassword = password;
            JButton[] restrictedBtns = {btn2, btn3, btn4};
            for (JButton b : restrictedBtns) {
                for (ActionListener al : b.getActionListeners()) {
                    b.removeActionListener(al);
                }
                b.addActionListener(ev -> {
                    existingUserField.setText("");
                    existingPassField.setText("");

                    if (b == btn2) {
                        selectedReadingTitle = "Password Security Reading";
                    } else if (b == btn3) {
                        selectedReadingTitle = "Phishing Detection Reading";
                    } else if (b == btn4) {
                        selectedReadingTitle = "Encryption Basics Reading";
                    } else if (b == btn5) {
                        selectedReadingTitle = "View Scores";
                    }
                    cardLayout.show(cardPanel, "ExistingLogin");
                });
            }
            for (ActionListener al : btn5.getActionListeners()) {
                btn5.removeActionListener(al);
            }
            btn5.addActionListener(ev -> {
                existingUserField.setText("");
                existingPassField.setText("");
                selectedReadingTitle = "View Scores";
                cardLayout.show(cardPanel, "ExistingLogin");
            });
            cardLayout.show(cardPanel, "Main");
        });
        loginPanel.add(uLabel); loginPanel.add(userField);
        loginPanel.add(pLabel); loginPanel.add(passField);
        loginPanel.add(rLabel); loginPanel.add(rePassField);
        loginPanel.add(submitBtn); loginPanel.add(homeBtn);
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
        submitBtn.setBounds(200, 470, 600, 60);

        JButton homeBtn = new JButton("Go back to homepage");
        homeBtn.setFont(new Font("Arial", Font.BOLD, 20));
        homeBtn.setBounds(200, 550, 600, 50);
        homeBtn.addActionListener(e -> cardLayout.show(cardPanel, "Main"));

        submitBtn.addActionListener(e -> {
            String enteredUsername = existingUserField.getText();
            String enteredPassword = new String(existingPassField.getPassword());
            if (!enteredUsername.equals(savedUsername) || !enteredPassword.equals(savedPassword)) {
                JOptionPane.showMessageDialog(
                        existingLoginPanel,
                        "Login has failed!",
                        "Login Failed",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                if (selectedReadingTitle.equals("View Scores")) {
                    JOptionPane.showMessageDialog(
                            existingLoginPanel,
                            "No scores to view!",
                            "Scores",
                            JOptionPane.WARNING_MESSAGE
                    );
                    cardLayout.show(cardPanel, "Main");
                } else {
                    readingHeaderLabel.setText(selectedReadingTitle);
                    cardLayout.show(cardPanel, "Reading");
                }
            }
        });
        existingLoginPanel.add(uLabel); existingLoginPanel.add(existingUserField);
        existingLoginPanel.add(pLabel); existingLoginPanel.add(existingPassField);
        existingLoginPanel.add(submitBtn); existingLoginPanel.add(homeBtn);
    }

    private void createReadingPanel() {
        readingPanel = new JPanel(null);
        readingPanel.setBackground(Color.WHITE);

        readingHeaderLabel = new JLabel("", SwingConstants.LEFT);
        readingHeaderLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        readingHeaderLabel.setBounds(10, 10, 900, 50);
        readingPanel.add(readingHeaderLabel);

        JButton startQuizBtn = new JButton("Start Quiz");
        startQuizBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        startQuizBtn.setBounds(350, 500, 300, 60);

        startQuizBtn.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    readingPanel,
                    "Are you sure you want to start the quiz?\n" +
                            "You cannot undo this action.",
                    "Quiz Confirmation",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (choice == JOptionPane.OK_OPTION) {
            }
        });
        JButton homeBtn = new JButton("Go back to homepage");
        homeBtn.setFont(new Font("Arial", Font.BOLD, 24));
        homeBtn.setBounds(250, 580, 500, 60);
        homeBtn.addActionListener(e -> cardLayout.show(cardPanel, "Main"));
        readingPanel.add(startQuizBtn); readingPanel.add(homeBtn);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CyberQuest Quiz");
        QuizGameUI myUI = new QuizGameUI();
        frame.setContentPane(myUI.cardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    } {
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