import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawFrame extends JFrame {
    private Drawable[] shapes;

    public DrawFrame(Drawable[] shapes) {
        this.shapes = shapes;
        setTitle("Final OOP Project - Shapes Viewer");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawPanel());
        setVisible(true);
    }

    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setFont(new Font("Arial", Font.BOLD, 36)); // تحديد نوع الخط وحجمه (36)
            g2.setColor(Color.DARK_GRAY);
            g2.drawString("Shapes Visualization", 350, 60); // رسم الكلمة في نص الشاشة من فوق

            g2.setStroke(new BasicStroke(3));
            g2.drawLine(350, 70, 700, 70);

            int xOffset = 80;
            int scale = 5;
            Random rand = new Random();

            if (shapes == null) return;

            for (Drawable s : shapes) {
                if (s == null) continue;

                g2.setFont(new Font("Arial", Font.PLAIN, 14));
                g2.setColor(new Color(rand.nextInt(200), rand.nextInt(200), rand.nextInt(200)));
                g2.setStroke(new BasicStroke(2.0f));

                if (s instanceof Circle) {
                    Circle c = (Circle) s;
                    int r = (int) (c.getRaduis() * scale);

                    g2.drawOval(xOffset, 250, r * 2, r * 2);

                    g2.setColor(Color.BLACK);
                    g2.drawString(c.howToDrwa(), xOffset, 250 + (r * 2) + 25);
                    g2.drawString(String.format("Area: %.2f", c.getArea()), xOffset, 250 + (r * 2) + 45);

                    xOffset += (r * 2) + 120;
                }
                else if (s instanceof Cube) {
                    Cube cb = (Cube) s;
                    int side = (int) (cb.getSide() * scale);
                    int d = side / 3;

                    g2.drawRect(xOffset + d, 250 - d, side, side);
                    g2.drawRect(xOffset, 250, side, side);
                    g2.drawLine(xOffset, 250, xOffset + d, 250 - d);
                    g2.drawLine(xOffset + side, 250, xOffset + side + d, 250 - d);
                    g2.drawLine(xOffset, 250 + side, xOffset + d, 250 + side - d);
                    g2.drawLine(xOffset + side, 250 + side, xOffset + side + d, 250 + side - d);

                    g2.setColor(Color.BLACK);
                    g2.drawString(cb.howToDrwa(), xOffset, 250 + side + 30);
                    g2.drawString(String.format("Area: %.2f", cb.getArea()), xOffset, 250 + side + 50);

                    xOffset += side + d + 120;
                }
            }
        }
    }
}