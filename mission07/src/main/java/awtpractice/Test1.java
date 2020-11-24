package awtpractice;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;

/* Frame은 주로 extends로 확장해서 사용한다. */
/* implement 하는 방식 : 원하는 코드를 작성하는 방법이다. */
class Test1 extends Frame {
    public Test1() {
        initUI();
        addEvent();
    }

    private void initUI() {
        setTitle("Week4 App");
        setSize(640, 480); /* 1. dimension 객체 사용   2. 좌표 사용 */
    }

    private void addEvent() {
        System.out.println("Add Event Listener");
        //별도의 클래스를 선언하지 않고 위와 같은 방법을 사용하는 이유?
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            // callback method : 내가 호출하지 않고 남이 실행하는 메서드.
            // (개발자가 직접 호출하지 않고 JVM이나 OS에서 호출하는 메서드)
            // 또한, 비동신 메서드 콜(async method call)이라고 한다.
            @Override
            public void windowClosing(WindowEvent e) { /* windowEvent 객체 형태로 입력 받아서 명령을 처리한다 */
                System.out.println("닫힘버튼 눌렸니?");
                dispose();
                /* e.getWindow().dispose() 형태로 사용이 필요없는 이유 :
                 *       프레임의 내부 함수와 멤버변수를 받았기 때문에(Closable)
                 */
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        /* invokeAndWait : 모든 이벤트 실행하고 시간이 남을 때 실행하는 역할 */
        try {
            EventQueue.invokeAndWait(() -> {
                Frame f = new Test1();
                f.setVisible(true);
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
