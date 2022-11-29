package salsabila.aurel.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class KartuATM {
    private JTextField textNumberCard;
    private JTextField textMine;
    private JButton saveButton;
    private JComboBox comboAtm;
    private JComboBox comboBank;
    private JPanel cardPanel;
    private JTextArea textAreaHasil;
    private JButton browseFileButton;
    private JTextField textImage;
    private JLabel JImage;
    public String fileName;

    public void interestingDataToFile(String hasil) throws IOException{
        try{
            FileWriter myWriter = new FileWriter("FileDatabase.txt", true);
            myWriter.write(hasil);
            myWriter.close();
            System.out.println("Successfully wrote to the file");
        }catch (IOException ex){
            System.out.println("An error occurred");
            ex.printStackTrace();
        }
    }

    public KartuATM() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noKartu = textNumberCard.getText();
                String jenisATM = (String) comboAtm.getSelectedItem();
                String Bank = (String) comboBank.getSelectedItem();
                String namaPemilik = textMine.getText();
                String file = textImage.getText();

                String hasil = "\n\nNomor Kartu : " +noKartu +"\nJenis ATM : " +jenisATM +"\nBank : " +Bank +"\nNama Pemilik : " +namaPemilik +"\nFile Image : " +file;

                //menampilkan hasil di TextArea
                JOptionPane.showMessageDialog(null, "Save Data");
                textAreaHasil.append(hasil);

                try {
                    interestingDataToFile(hasil + "\n\n");
                    file = null;
                }catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
            browseFileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser browseImage = new JFileChooser();
                    JFileChooser jfc = new JFileChooser();
                    if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        JImage.setText("");
                        ImageIcon gambarBaru = new ImageIcon(new ImageIcon(jfc.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(150,120, Image.SCALE_SMOOTH));
                        JImage.setIcon(gambarBaru);
                        String getNamaFile = jfc.getSelectedFile().getName();
                    }

                }

            });
    }
    public JPanel getCardPanel() {
        return cardPanel;
    }
}
