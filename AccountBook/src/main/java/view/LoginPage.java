package view;

import dao.MemberDao;
import domain.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LoginPage {
    private final String TITLE = "쿠크 샐러드";

    private JFrame loginFrame;
    private LoginPanel loginPanel;

    public LoginPage() {
        initComponent();
        initLoginUI();
    }

    private void initComponent() {
        loginFrame = new JFrame();
        loginPanel = new LoginPanel();
    }

    private void initLoginUI() {
        loginFrame.setTitle(TITLE);
        loginFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);
        loginFrame.setSize(loginPanel.getSize());
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }

    /*
     * 로그인 패널
     */
    public class LoginPanel extends JPanel {
        private MemberDao memberDao;

        private LoginImagePannel loginImagePannel;

        private JButton loginButton;
        private JButton signUpButton;

        private JLabel idLabel;
        private JLabel pwLabel;

        private JTextField idTextField;
        private JPasswordField passwordField;

        public LoginPanel() {
            initMemberDao();
            setupPanel();
            addImage();
            addComponent();
        }

        private void initMemberDao() {
            this.memberDao = new MemberDao();
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

            passwordField = new JPasswordField(20);
            passwordField.setBounds(x + 60, y + 40, 180, 25);
            add(passwordField);
        }

        private void addButtons(int x, int y) {
            loginButton = new JButton("Login");
            loginButton.setBounds(x + 20, y + 80, 80, 25);
            loginButton.addActionListener(new LoginListener());
            add(loginButton);

            signUpButton = new JButton("Sign Up");
            signUpButton.setBounds(x + 160, y + 80, 80, 25);
            signUpButton.addActionListener(new signListener());
            add(signUpButton);
        }

        /*
         * login 결과 전달
         */
        class LoginListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                Member member = new Member(id, password);
                System.out.println(id + " " + password);

                if(memberDao.hasMember(member)) {
                    JOptionPane.showMessageDialog(loginFrame, "로그인에 성공하였습니다.");
                    System.out.println("결과 있음:" + id + " " + password);
                    member = memberDao.getMemberData(member);
                    System.out.println(member.getCsvRecords());
//                    loginFrame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(loginFrame, "로그인에 실패하였습니다.");
                }
            }
        }

        class signListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //회원가입 창으로 이동
                new SignUpPage();
            }
        }
    }
}
