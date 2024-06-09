import entities.AddChildParam;
import entities.Node;
import usecases.AddChildUseCase;
import usecases.ReadWordsUseCase;
import usecases.SaveWordUseCase;
import usecases.SearchUseCase;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

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
        ReadWordsUseCase readWordsUC = new ReadWordsUseCase();
        List<String> words = readWordsUC.call();
        AddChildUseCase addChildUseCase = new AddChildUseCase();
        SearchUseCase searchUseCase = new SearchUseCase();
        SaveWordUseCase saveWordUseCase = new SaveWordUseCase();
        String input = "";

        Node root = new Node();
        for (String word : words) {
            root = addChildUseCase.call(new AddChildParam(root, word));
        }

        JFrame frame = new JFrame("Simple Swing Example");

        var p = new JPanel();
        var label = new JLabel();
        label.setFocusable(true);
        p.add(label);

        Node finalRoot = root;
        label.addKeyListener(new KeyListener() {
            int i = 0;
            List<String> words = new ArrayList<>(List.of());
            String word = "";
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (i + 1 >= words.size()) i = 0;
                    else i++;

                    String prediction = (i >= 0 && i < words.size()) ? words.get(i) : "";
                    prediction = prediction.substring(word.length());
                    label.setText("<html> <font color='red'>" + word + "</font><font color='blue'>" + prediction  + "</font></html>");
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    word = word.substring(0, word.length() - 1);
                    words = searchUseCase.call(new AddChildParam(finalRoot, word));
                    String prediction = (i >= 0 && i < words.size()) ? words.get(i) : "";
                    prediction = prediction.substring(word.length());
                    label.setText("<html> <font color='red'>" + word + "</font><font color='blue'>" + prediction  + "</font></html>");
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!words.contains(word)) {
                        word = "";
                        words = new ArrayList<>(List.of());
                        label.setText("");
                    } else {
                        word = "";
                        words = new ArrayList<>(List.of());
                        label.setText("");
                    }
                }
                else {
                    String text = label.getText();
                    if (text.isEmpty()) {
                        word += e.getKeyChar();
                    } else {
                        String[] q = text.split("</font>");
                        word = q[0].split("'red'>")[1] + e.getKeyChar();
                    }
                    words = searchUseCase.call(new AddChildParam(finalRoot, word));
                    String prediction = (i >= 0 && i < words.size()) ? words.get(i) : "";
                    if (prediction.length() < word.length()) {
                        i = 0;
                    } else {
                        prediction = prediction.substring(word.length());
                    }
                    label.setText("<html> <font color='red'>" + word + "</font><font color='blue'>" + prediction  + "</font></html>");
                    System.out.println("Key pressed: " + e.getKeyChar());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        frame.add(p);

        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
