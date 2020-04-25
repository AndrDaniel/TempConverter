package SDA.tempConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterFrame extends JFrame implements ActionListener {
    private JFrame frame; // pola globalne
    private JTextField inputField;
    private JLabel fahrenheitLabel;
    private JButton converterButton;


    public void showGuiWindow() {
        frame = new JFrame("Celsius Converter"); //ctr + q w nawiasach
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // klikniecie znaku x na naszym okienku rzeczywiscie zatrzymuje aplikacje, a nie tylko zamyka okno
        //ctr + spacja podpowiedzi w nawiasach
        addComponents();
        addActionToConverterBtn();

        frame.pack();
        //  frame.setSize(600, 200); // rozmiar
        frame.setVisible(true); // w sposob jawny chcemy zobaczyc okienko
        frame.setLocationRelativeTo(null); // centrowanie na ekranie


    //final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // pobieraniu rozmiaru okna
    //        frame.setLocation((int)screenSize.getWidth()/2,(int)screenSize.getHeight()/2);
    }

    private void addActionToConverterBtn() {
        converterButton.addActionListener(this); // klasa ktora ustawia nasluchiwacz jest rowniez nasluchiwaczem

    }

    private void addComponents() {
        inputField = new JTextField();
        fahrenheitLabel = new JLabel("Fahrenheit");
        converterButton = new JButton("Converter");// potrzebujemy dodac obsluge zdarzen

        JLabel celsiusLabel = new JLabel("Celsius");
        Insets style = new Insets(5, 10, 5, 10);

        //panel na kontrolki
        JPanel panel = new JPanel();
        // uklad - layout
        //zeby inaczej zorganizowac wyglad
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints(); // ograniczenia gdzie sie maja znalezc
        panel.setLayout(layout);
        c.insets = style;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        panel.add(inputField, c); // wszystko dodajemy do layout

        c.gridx = 1;
        c.gridy = 0;
        panel.add(celsiusLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(converterButton, c);


        c.gridx = 1;
        c.gridy = 1;
        panel.add(fahrenheitLabel, c);

//dodawanie bezposrednio do panelu domyslnym organizatorem jest flowlayout zajmuja tyle miejsca ile jest szerokosci okna
        // jak dodatkowe to przerzucane do dodatkowej lini
//        panel.add(inputField);
//        panel.add(celsiusLabel);
//        panel.add(converterButton);
//        panel.add(fahrenheitLabel);
        // do panelu dodajemy layout
        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //tu sie cos wydarzy po nacisniecu przycisku
        //wzór to C *1.8 +32 -> F
        double cels = Double.parseDouble(inputField.getText());
        double fahr = cels * 1.8 + 32;
        String farhVal = String.format("%.1f Fahrenheit", fahr);
        fahrenheitLabel.setText(farhVal);
        frame.pack();

    }
}
