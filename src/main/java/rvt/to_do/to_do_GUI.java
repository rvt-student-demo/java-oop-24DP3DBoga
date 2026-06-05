package rvt.ToDoUzdevumi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TodoGUI extends JFrame {
    private ArrayList<String> tasks;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;

    public TodoGUI() {
        this.tasks = new ArrayList<>();

        setTitle("To do list");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.listModel = new DefaultListModel<>();
        this.taskList = new JList<>(listModel);
        this.taskField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove selected");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(removeButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(event -> addTask());
        removeButton.addActionListener(event -> removeTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();

        if (task.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Task cannot be empty.");
            return;
        }

        tasks.add(task);
        listModel.addElement(task);
        taskField.setText("");
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a task first.");
            return;
        }

        tasks.remove(selectedIndex);
        listModel.remove(selectedIndex);
    }
}