package game2048;

import java.awt.*;
import java.awt.event.*;

public class GameView extends Frame {
    private static final int ARRAY_RANGE_MAX = 4;
    private Label[][] labels;
    private Font font;
    private Board board;

    public GameView() {
        initFrame();
        initFont();
        initBoard();
        setLabels();
        initEvent();
    }

    private void initFrame() {
        setTitle("2048");
        setSize(640, 480);
        setLayout(new GridLayout(ARRAY_RANGE_MAX, ARRAY_RANGE_MAX, 30, 30));
        setLocation(getWidth() / 2, getHeight() / 2);
        setVisible(true);
    }

    private void initFont() {
        this.font = new Font("맑은 고딕", Font.BOLD, 40);
    }

    private void initBoard() {
        this.board = new Board();
    }

    private void setLabels() {
        this.labels = new Label[ARRAY_RANGE_MAX][ARRAY_RANGE_MAX];

        for (int row = 0; row < ARRAY_RANGE_MAX; row++) {
            initLabel(row);
        }
    }

    private void initLabel(int row) {
        for (int col = 0; col < ARRAY_RANGE_MAX; col++) {
            String value = String.valueOf(board.getNumber(row, col));
            labels[row][col] = new Label(value);
            setLabelDetail(row, col);
        }
        pack();
    }

    private void setLabelDetail(int row, int col) {
        labels[row][col].setSize(50, 50);
        labels[row][col].setAlignment(Label.CENTER);
        labels[row][col].setFont(font);

        add(labels[row][col]);
    }

    private void initEvent() {
        addCommand();
        addExitEvent();
    }

    private void addExitEvent() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void addCommand() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'w') {
                    board.moveToUp();
                }

                if (ke.getKeyChar() == 's') {
                    board.moveToUnder();
                }

                if (ke.getKeyChar() == 'a') {
                    board.moveToLeft();
                }

                if (ke.getKeyChar() == 'd') {
                    board.moveToRight();
                }

                checkWinner();
                checkFinish();

                removeAll();
                setLabels();
            }
        });
    }

    private void checkWinner() {
        if (board.checkHaving2048()) {
            String message = "you win!";
            System.out.println(message);
            sendExitMessage(message);
        }
    }

    private void checkFinish() {
        if (!board.haveLocation()) {
            String message = "you lose";
            System.out.println(message);
            sendExitMessage(message);
        }
        board.generateNumber(2);
        board.printMapStatus();
    }

    private void sendExitMessage(String message) {
        Dialog dialog= new Dialog(this);
        Label label = new Label(message);
        Button button = new Button("OK");

        label.setAlignment(Label.CENTER);
        dialog.add("Center", label);
        dialog.setSize(300,200);
        dialog.add("South", button);

        button.addActionListener(e -> System.exit(0));
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        dialog.setLocation(getWidth() / 2, getHeight() / 2);
        dialog.setVisible(true);
    }
}
