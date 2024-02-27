import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class RelojAnalogico extends JFrame {

    public RelojAnalogico() {
        setTitle("Reloj Analógico");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Timer timer = new Timer(1000, e -> {
            repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g.setColor(Color.BLACK);
        g.fillOval(centerX - 150, centerY - 150, 300, 300);
        g.setColor(Color.WHITE);
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(i * 30 - 90);
            int x = (int) (centerX + 120 * Math.cos(angle));
            int y = (int) (centerY + 120 * Math.sin(angle));
            g.drawString(Integer.toString(i), x, y);
        }
        LocalTime now = LocalTime.now();
        int hour = now.getHour() % 12;
        int minute = now.getMinute();
        int second = now.getSecond();
        double hourAngle = (hour * 30) + (0.5 * minute);
        double minuteAngle = (minute * 6) + (0.1 * second);
        double secondAngle = second * 6;
        g.drawLine(centerX, centerY, centerX + (int) (100 * Math.cos(Math.toRadians(hourAngle))), centerY + (int) (100 * Math.sin(Math.toRadians(hourAngle))));
        g.drawLine(centerX, centerY, centerX + (int) (130 * Math.cos(Math.toRadians(minuteAngle))), centerY + (int) (130 * Math.sin(Math.toRadians(minuteAngle))));
        g.setColor(Color.RED);
        g.drawLine(centerX, centerY, centerX + (int) (130 * Math.cos(Math.toRadians(secondAngle))), centerY + (int) (130 * Math.sin(Math.toRadians(secondAngle))));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RelojAnalogico reloj = new RelojAnalogico();
            reloj.setVisible(true);
        });
    }
}