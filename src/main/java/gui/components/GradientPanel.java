package gui.components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import logic.Config;

public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(0, height);

        float[] fractions = {0.0f, 0.5f, 1.0f};
        Color firstColor = Config.LIGHT_GREEN;
        Color secondColor = new Color(
                (firstColor.getRed() + Config.DARK_GREEN.getRed()) / 2,
                (firstColor.getGreen() + Config.DARK_GREEN.getGreen()) / 2,
                (firstColor.getBlue() + Config.DARK_GREEN.getBlue()) / 2
        );

        Color[] colors = {firstColor, secondColor, Config.DARK_GREEN};

        LinearGradientPaint gradient = new LinearGradientPaint(start, end, fractions, colors);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();
    }

}
