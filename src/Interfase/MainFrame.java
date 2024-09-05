package Interfase;

import Control.Dictionary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JPanel implements ActionListener {
    private JFrame main;
    private JFrame modify;
    private JPanel rigth,up,down;
    private JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8;
    private JTextField field1;
    private DefaultListModel model;
    private JList list;
    Dictionary dic;
    private JFrame add;
    private JPanel panel5;
    private JPanel panel6;
    private JTextField field5,field6,field7,fieldx,fieldy;
    private JLabel label5,label6,label7,labelx,labely;

    private JButton botone,botonf,botonx,botony;

    public MainFrame(){
        main = new JFrame("Diccionario");
        modify = new JFrame("Diccionario");
        rigth = new JPanel();
        up = new JPanel();
        down = new JPanel();
        boton1 = new JButton("buscar");
        boton1.addActionListener(this);
        boton2 = new JButton("mostrar por letra");
        boton2.addActionListener(this);
        boton3 = new JButton("modificar palabra");
        boton3.addActionListener(this);
        boton4 = new JButton("eliminar palabra");
        boton4.addActionListener(this);
        boton5 = new JButton("salir");
        boton5.addActionListener(this);
        boton6 = new JButton("agregar palabra");
        boton6.addActionListener(this);
        boton7 = new JButton("todas las palabras");
        boton7.addActionListener(this);
        botonx = new JButton("modificar");
        botonx.addActionListener(this);
        botony = new JButton("cancelar");
        botony.addActionListener(this);
        field1 = new JTextField();
        model = new DefaultListModel();
        list = new JList();
        dic = new Dictionary();
        add = new JFrame("Diccionario");
        panel5 = new JPanel();
        panel6 = new JPanel();
        botone = new JButton("agregar");
        botone.addActionListener(this);
        botonf = new JButton("cancelar");
        botonf.addActionListener(this);
        field5 = new JTextField();
        field6 = new JTextField();
        field7 = new JTextField();
        label5 = new JLabel("palabra  >");
        label6 = new JLabel("traducción  >");
        label7 = new JLabel("significado  >");
        labelx = new JLabel("nueva traducción  >");
        labely = new JLabel("nuevo significado  >");
        fieldx = new JTextField();
        fieldy = new JTextField();
    }

    public void main(){
        dic.loadData();
        buttons();
        fields();
        main.setSize(1000,550);
        main.setLayout((LayoutManager) null);
        main.add(rigth());
        main.add(up());
        main.add(down());
        main.setResizable(false);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    public void add(){
        labels();
        fields();
        add.setSize(600,240);
        add.setLayout((LayoutManager) null);
        add.add(panel());
        add.setResizable(false);
        add.setLocationRelativeTo(null);
        add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add.setVisible(true);
    }

    public void modify(){
        labels();
        fields();
        modify.setSize(600,240);
        modify.setLayout((LayoutManager) null);
        modify.add(panel6());
        modify.setResizable(false);
        modify.setLocationRelativeTo(null);
        modify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        modify.setVisible(true);
    }

    public void labels(){
        label5.setBounds(15,25,70,15);
        label5.setBackground(Color.black);
        label6.setBounds(286,25,90,15);
        label6.setBackground(Color.black);
        label7.setBounds(15,90,90,15);
        label7.setBackground(Color.black);
        labelx.setBounds(15,25,130,15);
        labelx.setBackground(Color.black);
        labely.setBounds(15,90,130,15);
        labely.setBackground(Color.black);
    }

    public JPanel rigth(){
        rigth.setBounds(752,4,228,503);
        rigth.setLayout((LayoutManager) null);
        rigth.add(boton2);
        rigth.add(boton3);
        rigth.add(boton4);
        rigth.add(boton5);
        rigth.add(boton6);
        rigth.add(boton7);
        rigth.setBackground(Color.WHITE);
        return rigth;
    }

    public JPanel panel(){
        panel5.setBounds(4,4,576,194);
        panel5.setLayout((LayoutManager) null);
        panel5.setBackground(Color.WHITE);
        panel5.add(label5);
        panel5.add(label7);
        panel5.add(label6);
        panel5.add(field5);
        panel5.add(field6);
        panel5.add(field7);
        panel5.add(botone);
        panel5.add(botonf);
        return panel5;
    }

    public JPanel panel6(){
        panel6.setBounds(4,4,576,194);
        panel6.setLayout((LayoutManager) null);
        panel6.add(botony);
        panel6.add(botonx);
        panel6.add(fieldx);
        panel6.add(fieldy);
        panel6.add(labelx);
        panel6.add(labely);
        panel6.setBackground(Color.WHITE);
        return panel6;
    }

    public JPanel up(){
        up.setBounds(4,4,744,64);
        up.setLayout((LayoutManager) null);
        up.add(boton1);
        up.add(field1);
        up.setBackground(Color.WHITE);
        return up;
    }

    public JPanel down(){
        down.setBounds(4,72,744,435);
        down.setLayout((LayoutManager) null);
        down.add(pane());
        down.setBackground(Color.WHITE);
        return down;
    }

    public void buttons(){
        boton1.setBounds(532,13,200,38);
        boton2.setBounds(15,210,200,38);
        boton3.setBounds(15,254,200,38);
        boton4.setBounds(15,298,200,38);
        boton5.setBounds(15,445,200,38);
        boton6.setBounds(15,166,200,38);
        boton7.setBounds(15,342,200,38);
        botone.setBounds(310,140,250,40);
        botonf.setBounds(15,140,250,40);
        botonx.setBounds(310,140,250,40);
        botony.setBounds(15,140,250,40);
    }

    public JScrollPane pane(){
        list.setModel(model);
        list.setBackground(Color.WHITE);
        all();
        JScrollPane pane = new JScrollPane(list);
        pane.setBounds(10, 10,724,415);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        return pane;
    }

    public void all(){
        model.removeAllElements();
        for (int i= 0; i < dic.getList().size(); i++){
            for (int j = 0; j < dic.getList().get(i).listInsort().size(); j++){
                model.addElement(dic.getList().get(i).listInsort().get(j).getWord() + "  >>>>  " +
                        dic.getList().get(i).listInsort().get(j).getMeaning() + "  >>>>  " +
                        dic.getList().get(i).listInsort().get(j).getTranslation() + "   ");
            }
        }
    }

    public void fields(){
        field1.setBounds(13,13,510,39);
        field5.setBounds(78,20,200,30);
        field6.setBounds(368,20,200,30);
        field7.setBounds(95,80,473,30);
        fieldx.setBounds(142,20,419,30);
        fieldy.setBounds(142,80,419,30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1){
            if (field1.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hay campos vacios");
            }else{
                String letter4 = field1.getText().toLowerCase().replace(" ","");
                char first4 = letter4.toUpperCase().charAt(0);
                int assci4 = (int) first4 == 209 ? (int) first4 - 118 : (int) first4;
                if(dic.findWord(letter4,assci4-65) != null){
                   model.removeAllElements();
                   model.addElement(dic.findWord(letter4,assci4-65).getInfo().getWord() + "  >>>>  " +
                           dic.findWord(letter4,assci4-65).getInfo().getMeaning() + "  >>>>  " +
                           dic.findWord(letter4,assci4-65).getInfo().getTranslation() + "   ");
                }else{
                    JOptionPane.showMessageDialog(null, "La palabra no existe");
                }
            }

        }

        if(e.getSource() == boton2){
            if (field1.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hay campos vacios");
            }else{
                String letter3 = field1.getText().toLowerCase().replace(" ","");
                char first3 = letter3.toUpperCase().charAt(0);
                int assci3 = (int) first3 == 209 ? (int) first3 - 118 : (int) first3 ;
                try {
                    model.removeAllElements();
                    for (int i = 0; i < dic.getList().get(assci3 - 65).listInsort().size(); i++){
                        model.addElement(dic.getList().get(assci3 - 65).listInsort().get(i).getWord() + "  >>>>  " +
                                dic.getList().get(assci3 - 65).listInsort().get(i).getMeaning() + "  >>>>  " +
                                dic.getList().get(assci3 - 65).listInsort().get(i).getTranslation() + "   ");
                    }
                    if(dic.getList().get(assci3 - 65).listInsort().size() == 0){
                        JOptionPane.showMessageDialog(null, "No hay palabras por esa letra");
                    }
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "No hay palabras por esa letra");
                }
            }

        }

        if(e.getSource() == boton4){
            try {
                String[] selected = list.getSelectedValue().toString().split(">");
                String selected2 = selected[0].toLowerCase().replace(" ","");
                char first3 = selected2.toUpperCase().charAt(0);
                int assci3 = (int) first3 == 209 ? (int) first3 - 118 : (int) first3 ;
                dic.deleteWord(selected2,assci3-65);
                model.remove(list.getSelectedIndex());
            }catch (Exception e1){
                JOptionPane.showMessageDialog(null, "No hay ninguna palabra seleccionada, para eliminar una palabra primero hay que seleccionarla");
            }
        }

        if(e.getSource() == boton5){
            main.dispose();

        }

        if(e.getSource() == boton6){
            add();
            main.setVisible(false);
        }

        if(e.getSource() == botone){
            if(field5.getText().equals("") || field6.getText().equals("") || field7.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hay campos vacios");
            }else{
                String word2 = field5.getText().toLowerCase().replace(" ","");
                String meaning2 = field7.getText();
                String translate2 = field6.getText();
                char first2 = word2.toUpperCase().charAt(0);
                int assci2 = (int) first2 == 209 ? (int) first2 - 118 : (int) first2;
                if(dic.add(word2, meaning2, translate2, assci2 - 65) == true){
                    dic.addListData(word2,meaning2,translate2);
                    all();
                    field5.setText(null);
                    field6.setText(null);
                    field7.setText(null);
                }
            }
        }

        if (e.getSource() == botonf){
            add.dispose();
            main.setVisible(true);
        }

        if(e.getSource() == boton3){
            if(list.getSelectedValue() == null){
                JOptionPane.showMessageDialog(null, "No hay ninguna palabra seleccionada, para modificar una plabra primero hay que seleccionarla");
            }else {
                modify();
                String[] selected = list.getSelectedValue().toString().split(">");
                String selected2 = selected[0].toLowerCase().replace(" ","");
                char first3 = selected2.toUpperCase().charAt(0);
                int assci3 = (int) first3 == 209 ? (int) first3 - 118 : (int) first3 ;
                fieldy.setText(dic.findWord(selected2,assci3-65).getInfo().getMeaning());
                fieldx.setText(dic.findWord(selected2,assci3-65).getInfo().getTranslation());
                main.setVisible(false);
            }
        }

        if(e.getSource() == boton7){
            all();
        }

        if(e.getSource() == botony){
            modify.dispose();
            main.setVisible(true);
        }

        if(e.getSource() == botonx){
            if(fieldx.getText().equals("") || fieldy.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hay campos vacios");
            }else{
                String[] selected = list.getSelectedValue().toString().split(">");
                String selected2 = selected[0].toLowerCase().replace(" ","");
                char first3 = selected2.toUpperCase().charAt(0);
                int assci3 = (int) first3 == 209 ? (int) first3 - 118 : (int) first3 ;
                dic.modifyWord(selected2,fieldy.getText(),fieldx.getText(),assci3-65);
                model.removeAllElements();
                fieldx.setText(null);
                fieldy.setText(null);
                model.addElement(dic.findWord(selected2,assci3-65).getInfo().getWord() + "  >>>>  " +
                        dic.findWord(selected2,assci3-65).getInfo().getMeaning() + "  >>>>  " +
                        dic.findWord(selected2,assci3-65).getInfo().getTranslation() + "   ");
                modify.dispose();
                main.setVisible(true);
            }
        }
    }
}
