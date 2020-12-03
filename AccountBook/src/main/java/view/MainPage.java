package view;

import dao.RecordDao;
import domain.Member;
import domain.Record;

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
            int buttonRowSize = 240;
            int buttonColSize = 50;
            int gap = 240;

            addAssetButton(initX, initY, buttonRowSize, buttonColSize);
            addLogOutButton(initX + gap, initY, buttonRowSize, buttonColSize);
        }

        private void addAssetButton(int x, int y, int rowSize, int colSize) {
            assetButton = new JButton();
            assetIcon = new ImageIcon(".\\AccountBook\\src\\main\\resources\\assetIcon.png");
            assetIcon = changeSize(assetIcon);
            assetButton.setIcon(assetIcon);
            assetButton.setBorderPainted(false);
            assetButton.setBackground(Color.white);
            assetButton.setBounds(x, y, rowSize, colSize);
            add(assetButton);
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
                new RecordDao(loginedMember.getId()).saveRecords(loginedMember);
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
            addButton.addActionListener(e -> new InsertPage());
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
            modifyButton.addActionListener(e -> new ModifyPage());

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
            deleteButton.addActionListener(e -> new DeletePage());
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
            assetTable.getColumn("No").setPreferredWidth(30);
            assetTable.getColumn("날짜").setPreferredWidth(110);
            assetTable.setRowHeight(20);

            assetTable.getTableHeader().setReorderingAllowed(false); /* column 이동 불가 */

            JScrollPane scrollPane = new JScrollPane(assetTable);
            scrollPane.setBounds(10, 100, 450, 400);

            add(scrollPane);
        }

        private String[] getColumnsNames() {
            return new String[]{"No", "날짜", "세부 사항", "금액", "카테고리", "지불방식"};
        }

        private String[][] getRecordsAsStringArr() {
            return loginedMember.getRecordsAsArrayForm();
        }
    }

    public class InsertPage {
        private String title = "추가";

        private JFrame insertFrame;
        private InsertPage.insertPanel insertPanel;

        public InsertPage() {
            initComponent();
            setupFrame();
        }

        private void initComponent() {
            insertFrame = new JFrame();
            insertPanel = new insertPanel();
        }

        private void setupFrame() {
            insertFrame.setTitle(title);
            insertFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            insertFrame.add(insertPanel);
            insertFrame.setSize(insertPanel.getSize());
            insertFrame.setLocationRelativeTo(null);
            insertFrame.setResizable(false);
            insertFrame.setVisible(true);
        }

        class insertPanel extends JPanel {

            private JLabel dateLabel;
            private JLabel detailLabel;
            private JLabel moneyLabel;
            private JLabel categoryLabel;
            private JLabel payTypeLabel;

            private JTextField dateTextField;
            private JTextField detailTextField;
            private JTextField moneyTextField;
            private JComboBox<String> categoryComboBox;
            private JComboBox<String> payTypeComboBox;

            private JButton okButton;
            private JButton cancelButton;

            private Font font;

            insertPanel() {
                setupInsertPanel();
                addComponents();
                setupFont();
            }

            private void setupInsertPanel() {
                setSize(270, 320);
                setLayout(null);
            }

            private void addComponents() {
                addInsertLabels();
                addInsertTextFields();
                addButtons();
            }

            private void setupFont() {
                font = new Font("맑은 고딕", Font.BOLD, 10);
            }

            private void addInsertLabels() {
                int initX = 30;
                int initY = 30;
                int gapOfY = 40;
                int width = 80;
                int height = 25;

                addDateLabel("날짜", initX, initY, width, height);
                addDetailLabel("세부사항", initX, initY + gapOfY, width, height);
                addMoneyLabel("금액", initX, initY + gapOfY * 2, width, height);
                addCategoryLabel("카테고리", initX, initY + gapOfY * 3, width, height);
                addPayTypeLabel("지불방식", initX, initY + gapOfY * 4, width, height);
            }

            private void addDateLabel(String name, int x, int y, int width, int height) {
                dateLabel = new JLabel(name);
                dateLabel.setBounds(x, y, width, height);
                dateLabel.setFont(font);
                add(dateLabel);
            }

            private void addDetailLabel(String name, int x, int y, int width, int height) {
                detailLabel = new JLabel(name);
                detailLabel.setBounds(x, y, width, height);
                detailLabel.setFont(font);
                add(detailLabel);
            }

            private void addMoneyLabel(String name, int x, int y, int width, int height) {
                moneyLabel = new JLabel(name);
                moneyLabel.setBounds(x, y, width, height);
                moneyLabel.setFont(font);
                add(moneyLabel);
            }

            private void addCategoryLabel(String name, int x, int y, int width, int height) {
                categoryLabel = new JLabel(name);
                categoryLabel.setBounds(x, y, width, height);
                categoryLabel.setFont(font);
                add(categoryLabel);
            }

            private void addPayTypeLabel(String name, int x, int y, int width, int height) {
                payTypeLabel = new JLabel(name);
                payTypeLabel.setBounds(x, y, width, height);
                payTypeLabel.setFont(font);
                add(payTypeLabel);
            }

            private void addInsertTextFields() {
                int initX = 100;
                int initY = 30;
                int gapOfY = 40;
                int width = 120;
                int height = 25;

                addIdDateField(initX, initY, width, height);
                addDetailField(initX, initY + gapOfY, width, height);
                addMoneyField(initX, initY + gapOfY * 2, width, height);
                addCategoryComboBox(initX, initY + gapOfY * 3, width, height);
                addPayTypeComboBox(initX, initY + gapOfY * 4, width, height);
            }

            private void addIdDateField(int x, int y, int width, int height) {
                dateTextField = new JTextField(20);
                dateTextField.setBounds(x, y, width, height);
                dateTextField.setFont(font);
                add(dateTextField);
            }

            private void addDetailField(int x, int y, int width, int height) {
                detailTextField = new JTextField(20);
                detailTextField.setBounds(x, y, width, height);
                detailTextField.setFont(font);
                add(detailTextField);
            }

            private void addMoneyField(int x, int y, int width, int height) {
                moneyTextField = new JTextField(20);
                moneyTextField.setBounds(x, y, width, height);
                moneyTextField.setFont(font);
                add(moneyTextField);
            }

            private void addCategoryComboBox(int x, int y, int width, int height) {
                String[] categories = {"TRANSFORTATION", "FOOD", "CULTURE", "HEALTH", "BEAUTY", "ETC"};
                categoryComboBox = new JComboBox<>(categories);
                categoryComboBox.setBounds(x, y, width, height);
                categoryComboBox.setFont(font);
                add(categoryComboBox);
            }

            private void addPayTypeComboBox(int x, int y, int width, int height) {
                String[] payTypes = {"CARD", "CASH"};
                payTypeComboBox = new JComboBox<>(payTypes);
                payTypeComboBox.setBounds(x, y, width, height);
                payTypeComboBox.setFont(font);
                add(payTypeComboBox);
            }

            /*
             * buttons
             */
            private void addButtons() {
                int initX = 30;
                int initY = 230;
                int gapOfX = 110;
                int width = 80;
                int height = 25;

                addOkButton("OK", initX, initY, width, height);
                addCancelButton("CANCEL", initX + gapOfX, initY, width, height);
            }

            private void addOkButton(String name, int x, int y, int width, int height) {
                okButton = new JButton(name);
                okButton.setBounds(x, y, width, height);
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Record record = getRecordFromTextField();
                        loginedMember.insertRecord(record);
                        System.out.println(loginedMember.getCsvRecords());
                        insertFrame.setVisible(false);
                        insertFrame = null;
                    }

                    private Record getRecordFromTextField() {
                        String date = dateTextField.getText();
                        String detail = detailTextField.getText();
                        int money = Integer.parseInt(moneyTextField.getText());
                        String category = (String) categoryComboBox.getSelectedItem();
                        String payType = (String) payTypeComboBox.getSelectedItem();

                        return new Record(date, detail, money, category, payType);
                    }
                });
                add(okButton);
            }

            private void addCancelButton(String name, int x, int y, int width, int height) {
                cancelButton = new JButton(name);
                cancelButton.setBounds(x, y, width, height);
                cancelButton.addActionListener(e -> {
                    mainFrame.removeAll();
                    mainFrame.repaint();
                });
                add(cancelButton);
            }
        }
    }

    public class ModifyPage {
        private String title = "수정";

        private JFrame modifyFrame;
        private ModifyPanel modifyPanel;

        public ModifyPage() {
            initComponent();
            setupFrame();
        }

        private void initComponent() {
            modifyFrame = new JFrame();
            modifyPanel = new ModifyPanel();
        }

        private void setupFrame() {
            modifyFrame.setTitle(title);
            modifyFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            modifyFrame.add(modifyPanel);
            modifyFrame.setSize(modifyPanel.getSize());
            modifyFrame.setLocationRelativeTo(null);
            modifyFrame.setResizable(false);
            modifyFrame.setVisible(true);
        }

        class ModifyPanel extends JPanel {
            private JLabel indexLabel;
            private JLabel dateLabel;
            private JLabel detailLabel;
            private JLabel moneyLabel;
            private JLabel categoryLabel;
            private JLabel payTypeLabel;

            private JTextField indexTextField;
            private JTextField dateTextField;
            private JTextField detailTextField;
            private JTextField moneyTextField;
            private JComboBox<String> categoryComboBox;
            private JComboBox<String> payTypeComboBox;

            private JButton okButton;
            private JButton cancelButton;

            private Font font;

            ModifyPanel() {
                setupModifyPanel();
                addComponents();
                initFont();
            }

            private void setupModifyPanel() {
                setSize(270, 320);
                setLayout(null);
            }

            private void addComponents() {
                addModifyLabels();
                addModifyTextFields();
                addButtons();
            }

            private void initFont() {
                font = new Font("맑은 고딕", Font.BOLD, 10);
            }

            private void addModifyLabels() {
                int initX = 30;
                int initY = 15;
                int gapOfY = 35;
                int width = 80;
                int height = 25;

                addIndexLabel("수정 No", initX, initY, width, height);
                addDateLabel("날짜", initX, initY + gapOfY, width, height);
                addDetailLabel("세부사항", initX, initY + gapOfY * 2, width, height);
                addMoneyLabel("금액", initX, initY + gapOfY * 3, width, height);
                addCategoryLabel("카테고리", initX, initY + gapOfY * 4, width, height);
                addPayTypeLabel("지불방식", initX, initY + gapOfY * 5, width, height);
            }

            private void addIndexLabel(String name, int x, int y, int width, int height) {
                indexLabel = new JLabel(name);
                indexLabel.setBounds(x, y, width, height);
                indexLabel.setFont(font);
                add(indexLabel);
            }

            private void addDateLabel(String name, int x, int y, int width, int height) {
                dateLabel = new JLabel(name);
                dateLabel.setBounds(x, y, width, height);
                dateLabel.setFont(font);
                add(dateLabel);
            }

            private void addDetailLabel(String name, int x, int y, int width, int height) {
                detailLabel = new JLabel(name);
                detailLabel.setBounds(x, y, width, height);
                detailLabel.setFont(font);
                add(detailLabel);
            }

            private void addMoneyLabel(String name, int x, int y, int width, int height) {
                moneyLabel = new JLabel(name);
                moneyLabel.setBounds(x, y, width, height);
                moneyLabel.setFont(font);
                add(moneyLabel);
            }

            private void addCategoryLabel(String name, int x, int y, int width, int height) {
                categoryLabel = new JLabel(name);
                categoryLabel.setBounds(x, y, width, height);
                categoryLabel.setFont(font);
                add(categoryLabel);
            }

            private void addPayTypeLabel(String name, int x, int y, int width, int height) {
                payTypeLabel = new JLabel(name);
                payTypeLabel.setBounds(x, y, width, height);
                payTypeLabel.setFont(font);
                add(payTypeLabel);
            }

            private void addModifyTextFields() {
                int initX = 100;
                int initY = 15;
                int gapOfY = 35;
                int width = 120;
                int height = 25;


                addIdIndexField(initX, initY, width, height);
                addIdDateField(initX, initY + gapOfY, width, height);
                addDetailField(initX, initY + gapOfY * 2, width, height);
                addMoneyField(initX, initY + gapOfY * 3, width, height);
                addCategoryComboBox(initX, initY + gapOfY * 4, width, height);
                addPayTypeComboBox(initX, initY + gapOfY * 5, width, height);
            }

            private void addIdIndexField(int x, int y, int width, int height) {
                indexTextField = new JTextField(20);
                indexTextField.setBounds(x, y, width, height);
                indexTextField.setFont(font);
                add(indexTextField);
            }

            private void addIdDateField(int x, int y, int width, int height) {
                dateTextField = new JTextField(20);
                dateTextField.setBounds(x, y, width, height);
                dateTextField.setFont(font);
                add(dateTextField);
            }

            private void addDetailField(int x, int y, int width, int height) {
                detailTextField = new JTextField(20);
                detailTextField.setBounds(x, y, width, height);
                detailTextField.setFont(font);
                add(detailTextField);
            }

            private void addMoneyField(int x, int y, int width, int height) {
                moneyTextField = new JTextField(20);
                moneyTextField.setBounds(x, y, width, height);
                moneyTextField.setFont(font);
                add(moneyTextField);
            }

            private void addCategoryComboBox(int x, int y, int width, int height) {
                String[] categories = {"TRANSFORTATION", "FOOD", "CULTURE", "HEALTH", "BEAUTY", "ETC"};
                categoryComboBox = new JComboBox<>(categories);
                categoryComboBox.setBounds(x, y, width, height);
                categoryComboBox.setFont(font);
                add(categoryComboBox);
            }

            private void addPayTypeComboBox(int x, int y, int width, int height) {
                String[] payTypes = {"CARD", "CASH"};
                payTypeComboBox = new JComboBox<>(payTypes);
                payTypeComboBox.setBounds(x, y, width, height);
                payTypeComboBox.setFont(font);
                add(payTypeComboBox);
            }

            /*
             * buttons
             */
            private void addButtons() {
                int initX = 30;
                int initY = 230;
                int gapOfX = 110;
                int width = 80;
                int height = 25;

                addOkButton("OK", initX, initY, width, height);
                addCancelButton("CANCEL", initX + gapOfX, initY, width, height);
            }

            private void addOkButton(String name, int x, int y, int width, int height) {
                okButton = new JButton(name);
                okButton.setBounds(x, y, width, height);
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Record record = getRecord();
                        int index = getIndex();
                        loginedMember.modifyRecord(index, record);
                        modifyFrame.setVisible(false);
                        modifyFrame = null;
                    }

                    private int getIndex() {
                        return Integer.parseInt(indexTextField.getText());
                    }

                    private Record getRecord() {
                        String date = dateTextField.getText();
                        String detail = detailTextField.getText();
                        int money = Integer.parseInt(moneyTextField.getText());
                        String category = categoryComboBox.getSelectedItem().toString();
                        String payType = payTypeComboBox.getSelectedItem().toString();

                        return new Record(date, detail, money, category, payType);
                    }
                });
                add(okButton);
            }

            private void addCancelButton(String name, int x, int y, int width, int height) {
                cancelButton = new JButton(name);
                cancelButton.setBounds(x, y, width, height);
                cancelButton.addActionListener(e -> {
                    modifyFrame.setVisible(false);
                    modifyFrame = null;
                });
                add(cancelButton);
            }
        }
    }

    public class DeletePage {
        private String title = "삭제";

        private JFrame deleteFrame;
        private DeletePanel deletePanel;

        public DeletePage() {
            initComponent();
            setupFrame();
        }

        private void initComponent() {
            deleteFrame = new JFrame();
            deletePanel = new DeletePanel();
        }

        private void setupFrame() {
            deleteFrame.setTitle(title);
            deleteFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            deleteFrame.add(deletePanel);
            deleteFrame.setSize(deletePanel.getSize());
            deleteFrame.setLocationRelativeTo(null);
            deleteFrame.setResizable(false);
            deleteFrame.setVisible(true);
        }

        class DeletePanel extends JPanel {
            private JLabel indexLabel;
            private JTextField indexTextField;

            private JButton okButton;
            private JButton cancelButton;

            private Font font;

            DeletePanel() {
                setupDeletePanel();
                addComponents();
                initFont();
            }

            private void setupDeletePanel() {
                setSize(270, 120);
                setLayout(null);
            }

            private void addComponents() {
                addDeleteLabels();
                addDeleteTextFields();
                addButtons();
            }

            private void initFont() {
                font = new Font("맑은 고딕", Font.BOLD, 10);
            }

            private void addDeleteLabels() {
                int initX = 30;
                int initY = 15;
                int width = 80;
                int height = 25;

                addIndexLabel("수정 No", initX, initY, width, height);
            }

            private void addIndexLabel(String name, int x, int y, int width, int height) {
                indexLabel = new JLabel(name);
                indexLabel.setBounds(x, y, width, height);
                indexLabel.setFont(font);
                add(indexLabel);
            }

            private void addDeleteTextFields() {
                int initX = 100;
                int initY = 15;
                int width = 120;
                int height = 25;

                addIdIndexField(initX, initY, width, height);
            }

            private void addIdIndexField(int x, int y, int width, int height) {
                indexTextField = new JTextField(20);
                indexTextField.setBounds(x, y, width, height);
                indexTextField.setFont(font);
                add(indexTextField);
            }

            /*
             * buttons
             */
            private void addButtons() {
                int initX = 30;
                int initY = 50;
                int gapOfX = 110;
                int width = 80;
                int height = 25;

                addOkButton("OK", initX, initY, width, height);
                addCancelButton("CANCEL", initX + gapOfX, initY, width, height);
            }

            private void addOkButton(String name, int x, int y, int width, int height) {
                okButton = new JButton(name);
                okButton.setBounds(x, y, width, height);
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index = getIndex();
                        loginedMember.deleteRecord(index);

                        deleteFrame.setVisible(false);
                        deleteFrame = null;
                    }

                    private int getIndex() {
                        return Integer.parseInt(indexTextField.getText());
                    }
                });
                add(okButton);
            }

            private void addCancelButton(String name, int x, int y, int width, int height) {
                cancelButton = new JButton(name);
                cancelButton.setBounds(x, y, width, height);
                cancelButton.addActionListener(e -> {
                    deleteFrame.setVisible(false);
                    deleteFrame = null;
                });
                add(cancelButton);
            }
        }
    }
}