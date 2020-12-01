package view;

import dao.MemberDao;
import domain.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage {
    private String TITLE = "로그인 페이지";

    private JFrame signUpFrame;
    private SignUpPanel signUpPanel;

    public SignUpPage() {
        initComponent();
        setupFrame();
    }

    private void initComponent() {
        signUpFrame = new JFrame();
        signUpPanel = new SignUpPanel();
    }

    private void setupFrame() {
        signUpFrame.setTitle(TITLE);
        signUpFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        signUpFrame.add(signUpPanel);
        signUpFrame.setSize(signUpPanel.getSize());
        signUpFrame.setLocationRelativeTo(null);
        signUpFrame.setResizable(false);
        signUpFrame.setVisible(true);
    }


    class SignUpPanel extends JPanel {

        private MemberDao memberDao;

        private JLabel idLabel;
        private JLabel pwLabel;
        private JLabel pwLabel2;
        private JLabel balanceLabel;

        private JTextField idTextField;
        private JPasswordField passwordField;
        private JPasswordField passwordField2;
        private JTextField balanceField;

        private JButton okButton;
        private JButton cancelButton;

        public SignUpPanel() {
            initMemberDao();
            setupPanel();
            addComponent();
        }

        private void initMemberDao() {
            memberDao = new MemberDao();
        }

        private void setupPanel() {
            setSize(270, 320);
            setLayout(null);
        }

        private void addComponent() {
            addSignUpLabels();
            addButtons();
            addSignUpTexts();
        }

        /*
         * labels
         */

        private void addSignUpLabels() {
            int initX = 30;
            int initY = 30;
            int gapOfY = 50;

            addIdLabel("ID", initX, initY);
            addPwLabel("PW", initX, initY + gapOfY);
            addPw2Label("PW2", initX, initY + gapOfY * 2);
            addBalanceLabel("BALANCE", initX, initY + gapOfY * 3);
        }

        /*
         * TextArea
         */
        private void addSignUpTexts() {
            int initX = 100;
            int initY = 30;
            int gapOfY = 50;

            addIdTextField(initX, initY);
            addPwField(initX, initY + gapOfY);
            addPw2Field(initX, initY + gapOfY * 2);
            addBalanceField(initX, initY + gapOfY * 3);
        }

        private void addIdTextField(int x, int y) {
            idTextField = new JTextField(20);
            idTextField.setBounds(x, y, 120, 25);
            add(idTextField);
        }

        private void addPwField(int x, int y) {
            passwordField = new JPasswordField(20);
            passwordField.setBounds(x, y, 120, 25);
            add(passwordField);
        }

        private void addPw2Field(int x, int y) {
            passwordField2 = new JPasswordField(20);
            passwordField2.setBounds(x, y, 120, 25);
            add(passwordField2);
        }

        private void addBalanceField(int x, int y) {
            balanceField = new JTextField(20);
            balanceField.setBounds(x, y, 120, 25);
            add(balanceField);
        }

        /*
         * button
         */
        private void addIdLabel(String name, int x, int y) {
            idLabel = new JLabel(name);
            idLabel.setBounds(x, y, 80, 25);
            add(idLabel);
        }

        private void addPwLabel(String name, int x, int y) {
            pwLabel = new JLabel(name);
            pwLabel.setBounds(x, y, 80, 25);
            add(pwLabel);
        }

        private void addPw2Label(String name, int x, int y) {
            pwLabel2 = new JLabel(name);
            pwLabel2.setBounds(x, y, 80, 25);
            add(pwLabel2);
        }

        private void addBalanceLabel(String name, int x, int y) {
            balanceLabel = new JLabel(name);
            balanceLabel.setBounds(x, y, 80, 25);
            add(balanceLabel);
        }

        private void addButtons() {
            int initX = 30;
            int initY = 230;

            addOkButton("OK", initX, initY);
            addCancelButton("CANCEL", initX + 80, initY);
        }

        private void addOkButton(String name, int x, int y) {
            okButton = new JButton(name);
            okButton.setBounds(x, y, 80, 25);
            okButton.addActionListener(new SignUpPanel.OkListener());
            add(okButton);
        }

        private void addCancelButton(String name, int x, int y) {
            cancelButton = new JButton(name);
            cancelButton.setBounds(x + 30, y, 80, 25);
            cancelButton.addActionListener(new CancelListener());
            add(cancelButton);
        }


        class OkListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Member member = makeDto();
                System.out.println("여기까지");

                if (hasDuplcatedId(member)) {
                    JOptionPane.showMessageDialog(signUpFrame, "중복된 아이디가 존재합니다.");
                    return;
                }
                if (!areSamePassword()) {
                    JOptionPane.showMessageDialog(signUpFrame, "비밀번호가 일치하지 않습니다.");
                    return;
                }
                if (!member.isPasswordType()) {
                    JOptionPane.showMessageDialog(signUpFrame, "특수문자가 포함되어 있지 않습니다.");
                    return;
                }
                JOptionPane.showMessageDialog(signUpFrame, "회원가입이 완료되셨습니다.");
                addMemberInMemberDao(member);

                signUpFrame.setVisible(false);
                signUpFrame = null;
            }

            private Member makeDto() {
                String id = String.valueOf(idTextField.getText());
                String pw = String.valueOf(passwordField.getPassword());
                int balance = Integer.parseInt(balanceField.getText());

                return new Member(id, pw, balance);
            }

            private void addMemberInMemberDao(Member member) {
                memberDao.addMember(member);
            }

            private boolean hasDuplcatedId(Member member) {
                return memberDao.hasSameId(member);
            }

            private boolean areSamePassword() {
                String password = String.valueOf(passwordField.getPassword());
                String password2 = String.valueOf(passwordField2.getPassword());

                return password.equals(password2);
            }
        }

        class CancelListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpFrame.setVisible(false);
                signUpFrame = null;
            }
        }
    }
}