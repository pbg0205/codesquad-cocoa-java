package notepad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class NoteView extends Frame implements ActionListener {
    private String fileName;

    private TextArea textArea;
    private MenuBar menuBar;

    private Menu menu;
    private MenuItem menuNew;
    private MenuItem menuOpen;
    private MenuItem menuSaveAs;
    private MenuItem menuExit;

    public NoteView() {
        addExitEvent();
        initMenu();
        initMenuItems();
        addMenuAction();
        initMenuBar();
        initUI();
    }

    private void initUI() {
        textArea = new TextArea();

        setTitle("notepad");
        setSize(640, 480);
        add(textArea);
        setMenuBar(menuBar);
    }

    private void initMenu() {
        this.menu = new Menu("file");
    }

    private void initMenuItems() {
        this.menuNew = new MenuItem("New");
        this.menuOpen = new MenuItem("Open");
        this.menuSaveAs = new MenuItem("Save As");
        this.menuExit = new MenuItem("Exit");

        menu.add(menuNew);
        menu.add(menuOpen);
        menu.add(menuSaveAs);
        menu.add(menuExit);
    }

    private void addMenuAction() {
        menuNew.addActionListener(this);
        menuOpen.addActionListener(this);
        menuSaveAs.addActionListener(this);
        menuExit.addActionListener(this);
    }

    private void initMenuBar() {
        this.menuBar = new MenuBar();
        this.menuBar.add(menu);
        setMenuBar(menuBar);
    }

    private void addExitEvent() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("New")) {
            executeNew();
        }

        if (command.equals("Open")) {
            executeOpen();

        }

        if (command.equals("Save As")) {
            executeSaveAs();
        }

        if (command.equals("Exit")) {
            executeExit();
        }
    }

    private void executeNew() {
        textArea.setText("");
    }

    private void executeOpen() {
        FileDialog fileDialog = new FileDialog(this, "파일 열기", FileDialog.LOAD);
        fileDialog.setVisible(true);
        fileName = fileDialog.getDirectory() + fileDialog.getFile();
        System.out.println("open :" + fileName);
        fileOpen(fileName);
    }

    private void executeSaveAs() {
        FileDialog fileDialog = new FileDialog(this, "파일 저장", FileDialog.SAVE);
        fileDialog.setVisible(true);
        fileName = setFileName(fileDialog);
        System.out.println("save as :" + fileName);
        saveAs(fileName);
    }

    private String setFileName(FileDialog fileDialog) {
        if(isNullInFile(fileDialog)) {
            return "새로운 문서.txt";
        }

        return fileDialog.getFile() + ".txt";
    }

    private boolean isNullInFile(FileDialog fileDialog) {
        return fileDialog.getFile() == null;
    }

    private void fileOpen(String fileName) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        StringWriter stringWriter;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            stringWriter = new StringWriter();

            int number;
            while((number = bufferedReader.read()) != -1){
                stringWriter.write(number);
            }

            bufferedReader.close();
            textArea.setText(stringWriter.toString());
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void saveAs(String fileName) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        try{
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textArea.getText());
            bufferedWriter.close();
        }catch(IOException ie){
            ie.printStackTrace();
        }
    }

    private void executeExit() {
        System.exit(0);
    }
}
