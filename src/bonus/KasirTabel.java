package bonus;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class KasirTabel extends JFrame {

    JTextField tBarang, tHarga, tJumlah;
    JTable tabel;
    DefaultTableModel model;
    JLabel lTotal;

    int totalSemua = 0;

    public KasirTabel(){

        setTitle("Kasir Minimarket");
        setSize(500,400);
        setLayout(null);

        JLabel l1 = new JLabel("Barang");
        l1.setBounds(20,20,100,20);
        add(l1);

        tBarang = new JTextField();
        tBarang.setBounds(100,20,120,20);
        add(tBarang);

        JLabel l2 = new JLabel("Harga");
        l2.setBounds(20,50,100,20);
        add(l2);

        tHarga = new JTextField();
        tHarga.setBounds(100,50,120,20);
        add(tHarga);

        JLabel l3 = new JLabel("Jumlah");
        l3.setBounds(20,80,100,20);
        add(l3);

        tJumlah = new JTextField();
        tJumlah.setBounds(100,80,120,20);
        add(tJumlah);

        JButton btnTambah = new JButton("Tambah");
        btnTambah.setBounds(250,50,100,30);
        add(btnTambah);

        model = new DefaultTableModel();
        model.addColumn("Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total");

        tabel = new JTable(model);
        JScrollPane sp = new JScrollPane(tabel);
        sp.setBounds(20,120,440,150);
        add(sp);

        lTotal = new JLabel("Total Bayar : 0");
        lTotal.setBounds(20,300,200,30);
        add(lTotal);

        btnTambah.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                String barang = tBarang.getText();
                int harga = Integer.parseInt(tHarga.getText());
                int jumlah = Integer.parseInt(tJumlah.getText());

                int total = harga * jumlah;

                model.addRow(new Object[]{
                        barang,
                        harga,
                        jumlah,
                        total
                });

                totalSemua += total;

                lTotal.setText("Total Bayar : " + totalSemua);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new KasirTabel();
    }
}
