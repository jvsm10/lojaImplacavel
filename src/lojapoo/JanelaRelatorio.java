/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;


import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Danilo
 */
public class JanelaRelatorio extends JDialog{
    private JTextArea texto;
    private JScrollPane barraRolagem;
    
    public JanelaRelatorio(String msg){
        texto = new JTextArea();
        texto.setText(msg);
        texto.setEditable(false);
        barraRolagem = new JScrollPane(texto);
        add(barraRolagem); 
    }
    
    public void exibir(){
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setSize(480, 560);
        setVisible(true);
        
    }
}
