import adapters.node.implementations.NodeService;
import entities.AddChildParam;
import entities.Node;
import org.jline.reader.impl.DefaultParser;
import usecases.AddChildUseCase;
import usecases.ReadWordsUC;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Main {
    public static final String[] ANSI_COLORS = {
            "\u001B[31m", // Red
            "\u001B[32m", // Green
            "\u001B[33m", // Yellow
            "\u001B[34m", // Blue
            "\u001B[35m", // Purple
            "\u001B[36m", // Cyan
            "\u001B[37m"  // White
    };

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        ReadWordsUC readWordsUC = new ReadWordsUC();
        List<String> words = readWordsUC.call();
        AddChildUseCase addChildUseCase = new AddChildUseCase();
        String input = "";

        Node root = new Node();
        for (String word : words) {
            root = addChildUseCase.call(new AddChildParam(root, word));
        }


        JFrame frame = new JFrame("Simple Swing Example");

        var p = new JPanel();
        var html = "";
        var label = new JLabel(html);
        label.setFocusable(true);
        p.add(label);

        label.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                label.setText("<html> <font color='red'>" + e.getKeyChar() + "</font><font color='blue'>Petar</font></html>");
                System.out.println("Key pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Called when a key is released
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Called when a key is typed (after being pressed and released)
            }
        });

        // Add the text field to the frame
        frame.add(p);

        // Set frame properties
        frame.setSize(600, 200); // Set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
