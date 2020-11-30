package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginImagePannel extends JPanel{
    private BufferedImage loginImage;

    public LoginImagePannel() {
        setupLoginImage();
        setupLoginImagePannel();
    }

    private void setupLoginImagePannel() {
        setLayout(null);
        setBounds(0, 0, 250, 250);
    }

    private void setupLoginImage() {
        try {
            loginImage = ImageIO.read(new File("D:\\codes\\codesquad_cocoa_java\\AccountBook\\src\\main\\resources\\loginImage.jpeg"));
        } catch(IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "loginImage Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(loginImage, 25, 15, null);
    }
}
