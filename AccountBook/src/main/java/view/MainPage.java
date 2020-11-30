package view;

import domain.Member;

import javax.swing.*;

public class MainPage {

    private Member loginedMember;

    private JFrame mainFrame;
    private JPanel mainPanel;

    public MainPage(Member loginedMember) {
        this.loginedMember = loginedMember;
        initUI();
    }

    private void initUI() {
        this.mainFrame = new JFrame();
        this.mainPanel = new JPanel();
    }
}
