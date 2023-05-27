package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaLibro extends JFrame {
    private JLabel lblId;
    private JLabel lblTitulo;
    private JLabel lblAutor;
    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JButton btnAgregar;
    private JTable tblLibro;
    private JScrollPane scroll;
    private GridLayout layout;
    private JPanel panel1; //formulario para capturar libros
    private JPanel panel2; //tabla para mostrar los libros
    private JPanel panel3;
    private JPanel panel4;
    private JButton btnBoton;

    public VentanaLibro(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(234, 133, 221, 255));
        lblId = new JLabel("Id: ");
        lblTitulo = new JLabel("Titulo: ");
        lblAutor = new JLabel("Autor: ");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtTitulo = new JTextField(10);
        txtAutor = new JTextField(15);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblTitulo);
        panel1.add(txtTitulo);
        panel1.add(lblAutor);
        panel1.add(txtAutor);
        panel1.add(btnAgregar);

        //panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(92, 220, 84, 255));
        tblLibro = new JTable();
        scroll = new JScrollPane(tblLibro);
        panel2.add(scroll);
        btnBoton = new JButton("cargar");
        panel2.add(btnBoton);


        //panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(236, 230, 108, 255));



        //panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(121, 171, 250, 255));



        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JLabel getLblAutor() {
        return lblAutor;
    }

    public void setLblAutor(JLabel lblAutor) {
        this.lblAutor = lblAutor;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JTextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public JTextField getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(JTextField txtAutor) {
        this.txtAutor = txtAutor;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblLibro() {
        return tblLibro;
    }

    public void setTblLibro(JTable tblLibro) {
        this.tblLibro = tblLibro;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnBoton() {
        return btnBoton;
    }

    public void setBtnBoton(JButton btnBoton) {
        this.btnBoton = btnBoton;
    }
    public void limpiar(){
        txtTitulo.setText("");
        txtAutor.setText("");
    }
}
