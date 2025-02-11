package org.hutsdev.elements;

import javax.swing.*;
import java.awt.*;

public class ShadowLabel extends JLabel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Малюємо фон перед текстом

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();

        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2 - 5;

        g2d.setColor(Color.BLACK);
        g2d.drawString(getText(), x + 2, y + 2);

        g2d.setColor(getForeground());
        g2d.drawString(getText(), x, y);
    }
}
