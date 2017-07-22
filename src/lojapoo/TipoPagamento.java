/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author MrFELIS
 */
abstract class TipoPagamento implements Serializable {
    protected String tipoPagamento;
    
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    } 
    abstract String exibirDados();
    
    public static TipoPagamento tipo(float total){
        Boolean continua;
        int opcao;
        String msg, msg2;
        float dinheiro;
        TipoPagamento pg = null;
        do{
            continua=false;
            do{
            msg= JOptionPane.showInputDialog("Escolha o tipo de pagamento: \n1 - Dinheiro\n2 - Cartão\n3 - Cheque");
            if(msg == null)
                msg = "";
            }while(msg.isEmpty());
            opcao =Integer.parseInt(msg);
            switch(opcao){
                    case 2:  
                        do{
                        msg = JOptionPane.showInputDialog("Coloque o número do cartão");
                        if(msg==null)
                        msg="";
                        }while(msg.isEmpty());
                        do{
                        msg2 = JOptionPane.showInputDialog("Coloque o nome do titular do cartão");
                        if(msg2==null)
                        msg2="";
                        }while(msg2.isEmpty());
                        pg = new Cartao(msg,msg2);
                        break;
                    case 1:
                        do{    
                        do{
                            msg = JOptionPane.showInputDialog("Informe a quantia recebida");
                            if(msg==null){
                            msg="";
                            } 
                        }while(msg.isEmpty());                           
                        dinheiro=Float.parseFloat(msg);
                         }while(dinheiro<total);
                        pg = new Dinheiro(dinheiro);
                        break;
                    case 3:  
                        do{
                        msg = JOptionPane.showInputDialog("Coloque o nome do emissor");
                        if(msg==null)
                        msg="";
                        }while(msg.isEmpty());
                        do{
                        msg2 = JOptionPane.showInputDialog("Coloque o número do cheque");
                        if(msg2==null)
                        msg2="";
                        }while(msg2.isEmpty());
                        pg = new Cheque(msg,msg2);
                        break;
                    default:
                        continua=true;
                        break;
                       }
        }while(continua);
        return pg;
    }
}
