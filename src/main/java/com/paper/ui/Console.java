package com.paper.ui;

import com.paper.CommandHandler;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Console extends JFrame {
    private static JTextArea textArea;
    private JTextField inputField;

    public Console() {
        Font Jetbrains = new Font("Jetbrains Mono", Font.PLAIN, 14);
        setTitle("Terminal Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(Jetbrains);
        textArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBackground(Color.DARK_GRAY);
        add(scrollPane, BorderLayout.CENTER);
        textArea.setBackground(Color.DARK_GRAY);
        inputField = new JTextField();
        inputField.setFont(Jetbrains);
        inputField.setBackground(Color.DARK_GRAY);
        inputField.setForeground(Color.WHITE);
        textArea.append("""
                YOU ARE NOW RUNNING PaperOS in Graphical-Terminal MODE.
                Return to normal mode by edit startup args: -normal-mode
                """);
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                textArea.append("> " + input + "\n");
                try {
                    processCommand(input);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                inputField.setText("");
            }
        });
        add(inputField, BorderLayout.SOUTH);
    }


    private void processCommand(String command) throws Exception {
        textArea.append(command + "\n");
        CommandHandler.CMD(command);
    }
    public static void displayText(@NotNull String text){
        textArea.append(text);
    }
}
