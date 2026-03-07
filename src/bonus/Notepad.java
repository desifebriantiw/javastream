package bonus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {

    JTextArea textArea;
    JMenuItem newFile, openFile, saveFile, deleteFile, renameFile;
    File currentFile;

    public Notepad() {

        setTitle("Notepad Eci Coba");
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        newFile = new JMenuItem("New File");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");
        renameFile = new JMenuItem("Rename File");
        deleteFile = new JMenuItem("Delete File");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        renameFile.addActionListener(this);
        deleteFile.addActionListener(this);

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(renameFile);
        fileMenu.add(deleteFile);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if(e.getSource()==newFile){

                textArea.setText("");
                currentFile = null;

            }

            else if(e.getSource()==openFile){

                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(this);

                currentFile = chooser.getSelectedFile();

                BufferedReader br = new BufferedReader(new FileReader(currentFile));
                textArea.read(br,null);
                br.close();
            }

            else if(e.getSource()==saveFile){

                JFileChooser chooser = new JFileChooser();
                chooser.showSaveDialog(this);

                currentFile = chooser.getSelectedFile();

                BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile));
                textArea.write(bw);
                bw.close();

                JOptionPane.showMessageDialog(this,"File berhasil disimpan");

            }

            else if(e.getSource()==renameFile){

                if(currentFile!=null){

                    String newName = JOptionPane.showInputDialog("Masukkan nama baru");

                    File newFileName = new File(currentFile.getParent()+"\\"+newName);

                    currentFile.renameTo(newFileName);

                    JOptionPane.showMessageDialog(this,"File berhasil direname");
                }

            }

            else if(e.getSource()==deleteFile){

                if(currentFile!=null){

                    int confirm = JOptionPane.showConfirmDialog(this,"Hapus file?");

                    if(confirm==0){

                        currentFile.delete();
                        textArea.setText("");
                        JOptionPane.showMessageDialog(this,"File dihapus");
                    }
                }

            }

        } catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error : "+ex.getMessage());
        }

    }

    public static void main(String[] args) {

        new Notepad();

    }
}
