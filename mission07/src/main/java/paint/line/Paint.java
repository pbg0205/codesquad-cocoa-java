package paint.line;

import java.awt.*;
import java.awt.event.*;

class Paint extends Frame implements MouseMotionListener {
    private int x;
    private int y;

    private Image image;
    private Graphics gImage;

    public Paint(String title) {
        initUI(title);
        initImageAndGraphics();
        initEvent();
    }

    private void initUI(String title) {
        setTitle(title);
        setBounds(100, 100, 500, 500);
        setVisible(true);
    }

    private void initImageAndGraphics() {
        image = createImage(500, 500);
        gImage = image.getGraphics();
        gImage.drawString("왼쪽버튼을 누른 채로 마우스를 움직여보세요.", 10, 50);
        repaint();
    }

    private void initEvent() {
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        if((image != null)) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {}

    @Override
    public void mouseDragged(MouseEvent me) {
        if(me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK){
            return ;
        }

        x = me.getX();
        y = me.getY();

        gImage.drawString("*", x, y);
        repaint();
    }
}
