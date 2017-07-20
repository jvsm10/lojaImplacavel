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
            opcao =Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de pagamento: \n1 - Dinheiro\n2 - Cartão\n3 - Cheque"));
            switch(opcao){
                    case 2:  
                        msg = JOptionPane.showInputDialog("Coloque o número do cartão");
                        msg2 = JOptionPane.showInputDialog("Coloque o nome do titular do cartão");
                        pg = new Cartao(msg,msg2);
                        break;
                    case 1:
                        do{
                            dinheiro=Float.parseFloat(JOptionPane.showInputDialog("Informe a quantia recebida"));
                        }while(dinheiro<total);
                        pg = new Dinheiro(dinheiro);
                        break;
                    case 3:  
                        msg = JOptionPane.showInputDialog("Coloque o nome do emissor");
                        msg2 = JOptionPane.showInputDialog("Coloque o número do cheque");
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
