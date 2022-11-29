package salsabila.aurel.gui;

import javax.swing.*;

public class RunFormATMCard {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Kartu ATM");
        jFrame.setContentPane(new KartuATM().getCardPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(500, 400);
        jFrame.setVisible(true);
    }
}
