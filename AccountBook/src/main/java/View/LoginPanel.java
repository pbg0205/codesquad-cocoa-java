package View;

import javax.swing.*;

public class LoginPanel extends JPanel {

    private LoginImagePannel loginImagePannel;

    private JButton loginButton;
    private JButton signUpButton;

    private JLabel idLabel;
    private JLabel pwLabel;

    private JTextField idTextField;
    private JTextField pwTextField;

    public LoginPanel() {
        setupPanel();
        addImage();
        addComponent();
    }

    private void setupPanel() {
        setSize(280, 400);
        setLayout(null);
    }

    private void addImage() {
        this.loginImagePannel = new LoginImagePannel();
        add(loginImagePannel);
    }

    private void addComponent() {
        int initX = 10;
        int initY = 250;
        addLoginComponents(initX, initY);
        addButtons(initX, initY);
    }

    private void addLoginComponents(int x, int y) {

        idLabel = new JLabel("ID");
        idLabel.setBounds(x + 20, y, 80, 25);
        add(idLabel);

        pwLabel = new JLabel("PW");
        pwLabel.setBounds(x + 20, y + 40, 80, 25);
        add(pwLabel);

        idTextField = new JTextField(20);
        idTextField.setBounds(x + 60, y, 180, 25);
        add(idTextField);

        pwTextField = new JTextField(20);
        pwTextField.setBounds(x + 60, y + 40, 180, 25);
        add(pwTextField);
    }

    private void addButtons(int x, int y) {
        loginButton = new JButton("Login");
        loginButton.setBounds(x + 20, y + 80, 80, 25);
        add(loginButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(x + 160, y + 80, 80, 25);
        add(signUpButton);
    }
}
