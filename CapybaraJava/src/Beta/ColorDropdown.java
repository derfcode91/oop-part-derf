import javax.swing.*;
import java.awt.*;

public class ColorDropdown {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorDropdown::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Color Dropdown Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Sample items with names and colors
        ColoredItem[] items = {
                new ColoredItem("Red Item", Color.RED),
                new ColoredItem("Green Item", Color.GREEN),
                new ColoredItem("Blue Item", Color.BLUE)
        };

        // Create the JComboBox with the items
        JComboBox<ColoredItem> comboBox = new JComboBox<>(items);
        comboBox.setRenderer(new ColorfulRenderer());

        frame.add(comboBox);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class ColoredItem {
        private final String name;
        private final Color color;

        public ColoredItem(String name, Color color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class ColorfulRenderer extends JLabel implements ListCellRenderer<ColoredItem> {

        public ColorfulRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends ColoredItem> list, ColoredItem value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setText(value.getName());
            setIcon(createColoredDotIcon(value.getColor()));

            return this;
        }

        private Icon createColoredDotIcon(Color color) {
            return new Icon() {
                private static final int SIZE = 10;

                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    g.setColor(color);
                    g.fillOval(x, y, SIZE, SIZE);
                }

                @Override
                public int getIconWidth() {
                    return SIZE;
                }

                @Override
                public int getIconHeight() {
                    return SIZE;
                }
            };
        }
    }
}
