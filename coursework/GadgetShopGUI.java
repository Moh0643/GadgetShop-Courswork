import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShopGUI extends JFrame {
    private ArrayList<Gadget> gadgets;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField;
    private JTextField displayNumberField, phoneNumberField, callDurationField, downloadSizeField;
    private JTextArea displayArea;

    public GadgetShopGUI() {
        gadgets = new ArrayList<>();

        setTitle("Gadget Shop");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        JPanel inputPanel = new JPanel(new GridLayout(10, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        creditField = new JTextField();
        memoryField = new JTextField();
        displayNumberField = new JTextField();
        phoneNumberField = new JTextField();
        callDurationField = new JTextField();
        downloadSizeField = new JTextField();

        inputPanel.add(new JLabel("Model:"));
        inputPanel.add(modelField);
        inputPanel.add(new JLabel("Price (£):"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Weight (grams):"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Size:"));
        inputPanel.add(sizeField);
        inputPanel.add(new JLabel("Credit (minutes):"));
        inputPanel.add(creditField);
        inputPanel.add(new JLabel("Memory (MB):"));
        inputPanel.add(memoryField);
        inputPanel.add(new JLabel("Display Number:"));
        inputPanel.add(displayNumberField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("Call Duration (minutes):"));
        inputPanel.add(callDurationField);
        inputPanel.add(new JLabel("Download Size (MB):"));
        inputPanel.add(downloadSizeField);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        JButton addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMobile();
            }
        });

        JButton addMp3Button = new JButton("Add MP3");
        addMp3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMp3();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });

        JButton makeCallButton = new JButton("Make A Call");
        makeCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeCall();
            }
        });

        JButton downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
            }
        });

        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMp3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadMusicButton);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        add(inputPanel);
        add(buttonPanel);
        add(outputPanel);
    }

    private void addMobile() {
        String model = modelField.getText();
        double price = Double.parseDouble(priceField.getText());
        float weight = Float.parseFloat(weightField.getText());
        String size = sizeField.getText();
        int credit = Integer.parseInt(creditField.getText());
        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);
        displayArea.append("Mobile added: " + mobile.toString() + "\n");
    }

    private void addMp3() {
        String model = modelField.getText();
        double price = Double.parseDouble(priceField.getText());
        float weight = Float.parseFloat(weightField.getText());
        String size = sizeField.getText();
        double memory = Double.parseDouble(memoryField.getText());
        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3);
        displayArea.append("MP3 added: " + mp3.toString() + "\n");
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        displayNumberField.setText("");
        phoneNumberField.setText("");
        callDurationField.setText("");
        downloadSizeField.setText("");
    }

    private void displayAll() {
        for (Gadget gadget : gadgets) {
            displayArea.append(gadget.toString() + "\n");
        }
    }

    private void makeCall() {
        int displayNumber = Integer.parseInt(displayNumberField.getText());
        if (displayNumber < gadgets.size() && displayNumber >= 0) {
            Mobile mobile = (Mobile) gadgets.get(displayNumber);
            String phoneNumber = phoneNumberField.getText();
            int duration = Integer.parseInt(callDurationField.getText());
            mobile.makeCall(phoneNumber, duration);
            displayArea.append("Call made from mobile: " + mobile.getModel() + "\n");
        } else {
            displayArea.append("Invalid display number\n");
        }
    }

    private void downloadMusic () {
        int displayNumber = Integer.parseInt(displayNumberField.getText());
        if (displayNumber < gadgets.size() && displayNumber >= 0) {
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            double downloadSize = Double.parseDouble(downloadSizeField.getText());
            if (mp3.getmemory() >= downloadSize) {
                displayArea.append("Music downloaded on MP3: " + mp3.getModel() + "\n");
            } else {
                displayArea.append("Not enough memory on MP3\n");
            }
        } else {
            displayArea.append("Invalid display number\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GadgetShopGUI().setVisible(true);
            }
        });
    }
}
