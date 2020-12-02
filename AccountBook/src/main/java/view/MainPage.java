package view;

import domain.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private Member loginedMember;
    private String title;

    private JFrame mainFrame;

    private MainPanel mainPanel;
    private AssetPanel assetPanel;
    private GraphPanel graphPanel;

    public MainPage(Member loginedMember) {
        initLoginMember(loginedMember);
        setFrameTitle();
        initUI();
        setupUI();
    }

    private void setFrameTitle() {
        this.title = loginedMember.getId() + "님의 가계부";
    }

    private void initLoginMember(Member loginedMember) {
        this.loginedMember = loginedMember;
    }

    private void initUI() {
        this.mainFrame = new JFrame();
        this.mainPanel = new MainPanel();
        this.assetPanel = new AssetPanel();
    }

    private void setupUI() {
        mainFrame.setTitle(title);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel.add(assetPanel);
        mainFrame.add(mainPanel);

        mainFrame.setSize(mainPanel.getSize());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    private class MainPanel extends JPanel {
        private JButton assetButton;
        private ImageIcon assetIcon;

        private JButton graphButton;
        private ImageIcon graphIcon;

        private JButton logoutButton;
        private ImageIcon logoutIcon;

        public MainPanel() {
            setupMainPanel();
            initButtons();
        }

        private void setupMainPanel() {
            setSize(480, 600);
            setLayout(null);
            setBackground(Color.white);
        }

        private void initButtons() {
            int initX = 0;
            int initY = 520;
            int buttonRowSize = 160;
            int buttonColSize = 50;
            int gap = 160;

            addAssetButton(initX, initY, buttonRowSize, buttonColSize);
            addGraphButton(initX + gap, initY, buttonRowSize, buttonColSize);
            addLogOutButton(initX + gap * 2, initY, buttonRowSize, buttonColSize);
        }

        private void addAssetButton(int x, int y, int rowSize, int colSize) {
            assetButton = new JButton();
            assetIcon = new ImageIcon(".\\AccountBook\\src\\main\\resources\\assetIcon.png");
            assetIcon = changeSize(assetIcon);
            assetButton.setIcon(assetIcon);
            assetButton.setBorderPainted(false);
            assetButton.setBackground(Color.white);
            assetButton.setBounds(x, y, rowSize, colSize);
            assetButton.addActionListener(e -> {
//                assetPanel.setVisible(true);
//                graphPanel.setVisible(false);
            });
            add(assetButton);
        }

        private void addGraphButton(int x, int y, int rowSize, int colSize) {
            graphButton = new JButton();
            graphIcon = new ImageIcon(".\\AccountBook\\src\\main\\resources\\graphIcon.png");
            graphIcon = changeSize(graphIcon);
            graphButton.setIcon(graphIcon);
            graphButton.setBorderPainted(false);
            graphButton.setBackground(Color.white);
            graphButton.addActionListener(e -> {
//                assetPanel.setVisible(false);
//                graphPanel.setVisible(true);
            });
            graphButton.setBounds(x, y, rowSize, colSize);
            add(graphButton);
        }

        private void addLogOutButton(int x, int y, int rowSize, int colSize) {
            logoutButton = new JButton();
            logoutIcon = new ImageIcon(".\\AccountBook\\src\\main\\resources\\logoutIcon.png");
            logoutIcon = changeSize(logoutIcon);

            logoutButton.setIcon(logoutIcon);
            logoutButton.setBackground(Color.white);
            logoutButton.setBorderPainted(false);
            logoutButton.setBounds(x, y, rowSize, colSize);
            logoutButton.addActionListener(e -> {
                mainFrame.setVisible(false);
                mainFrame = null;
                JOptionPane.showMessageDialog(mainFrame, "로그아웃 되었습니다.");
                new LoginPage();
            });
            add(logoutButton);
        }

        private ImageIcon changeSize(ImageIcon imageIcon) {
            Image image = imageIcon.getImage();
            Image ImageChangedSize = image.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
            return new ImageIcon(ImageChangedSize);
        }
    }

    private class AssetPanel extends JPanel {
        private JLabel assetLabel;
        private JLabel assetSumLabel;

        private JButton addButton;
        private JButton modifyButton;
        private JButton deleteButton;

        private ImageIcon addIcon;
        private ImageIcon modifyIcon;
        private ImageIcon deleteIcon;


        private JTable assetTable;
        private Font sumFont;

        public AssetPanel() {
            setupAssetPanel();
            setupSumFont();
            setupAssetSum();
            setupButtons();
            setUpAssetTable();
        }

        private void setupAssetPanel() {
            setSize(480, 500);
            setBackground(Color.white);
            setLayout(null);
        }

        private void setupSumFont() {
            sumFont = new Font("맑은 고딕", Font.BOLD, 25);
        }

        private void setupAssetSum() {
            int initX = 10;
            int initY = 30;

            addAssetLabel(initX, initY);
            addAssetSumLabel(initX, initY);
        }

        private void setupButtons() {
            int initX = 300;
            int initY = 20;
            int width = 50;
            int height = 50;
            int gap = 55;

            setupAddButton(initX, initY, width, height);
            setupModifyButton(initX + gap, initY, width, height);
            setupDeleteButton(initX + gap * 2, initY, width, height);
        }

        private void setupAddButton(int x, int y, int width, int height) {
            addButton = new JButton();

            addIcon = new ImageIcon(".\\AccountBook\\src\\main\\resources\\addIcon.png");
            addIcon = changeSize(addIcon);
            addButton.setIcon(addIcon);

            addButton.setBorderPainted(false);
            addButton.setBackground(Color.white);
            addButton.setBounds(x, y, width, height);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            add(addButton);
        }

        private void setupModifyButton(int x, int y, int width, int height) {
            modifyButton = new JButton();

            modifyIcon = new ImageIcon(".\\AccountBook\\src\\main\\resources\\modifyIcon.png");
            modifyIcon = changeSize(modifyIcon);
            modifyButton.setIcon(modifyIcon);

            modifyButton.setBorderPainted(false);
            modifyButton.setBackground(Color.white);
            modifyButton.setBounds(x, y, width, height);

            add(modifyButton);
        }

        private void setupDeleteButton(int x, int y, int width, int height) {
             deleteButton = new JButton();

            deleteIcon = new ImageIcon(".\\AccountBook\\src\\main\\resources\\deleteIcon.png");
            deleteIcon = changeSize(deleteIcon);
            deleteButton.setIcon(deleteIcon);

            deleteButton.setBorderPainted(false);
            deleteButton.setBackground(Color.white);
            deleteButton.setBounds(x, y, width, height);

            add(deleteButton);
        }

        private void addAssetLabel(int x, int y) {
            assetLabel = new JLabel("현재 자산");
            assetLabel.setFont(sumFont);
            assetLabel.setBounds(x, y, 120, 30);
            add(assetLabel);
        }

        private void addAssetSumLabel(int x, int y) {
            int balance = loginedMember.getBalance();
            assetSumLabel = new JLabel(String.valueOf(balance));
            assetSumLabel.setFont(sumFont);
            assetSumLabel.setBounds(x + 180, y, 100, 30);
            add(assetSumLabel);
        }

        private ImageIcon changeSize(ImageIcon imageIcon) {
            Image image = imageIcon.getImage();
            Image ImageChangedSize = image.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
            return new ImageIcon(ImageChangedSize);
        }

        private void setUpAssetTable() {
            String columnNames[] = getColumnsNames();
            String rowDate[][] = getRecordsAsStringArr();

            assetTable = new JTable(rowDate, columnNames);
            assetTable.setBounds(50, 100, 330, 400);
            assetTable.getColumn("날짜").setPreferredWidth(110);
            assetTable.setRowHeight(20);

            assetTable.getTableHeader().setReorderingAllowed(false); /* column 이동 불가 */

            JScrollPane scrollPane = new JScrollPane(assetTable);
            scrollPane.setBounds(10, 100, 450, 400);

            add(scrollPane);
        }

        private String[] getColumnsNames() {
            return new String[] {"날짜","세부 사항", "금액", "카테고리", "지불방식"};
        }

        private String[][] getRecordsAsStringArr() {
            return loginedMember.getRecordsAsArrayForm();
        }
    }

    private class GraphPanel extends JPanel {

    }
}