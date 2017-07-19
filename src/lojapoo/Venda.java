/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author MrFELIS
 */
public class Venda {
    private String numero;
    private ArrayList<Item> itens;
    private TipoPagamento tipoPago;
    private Cliente cliente;
    private Calendar data;
    
    public Venda(String numero, TipoPagamento tipoPago, Cliente cliente, Calendar data) {
        this.numero = numero;
        this.tipoPago = tipoPago;
        this.cliente = cliente;
        this.data = data;
        itens = new ArrayList<>();
    
    }
    public Venda(){
        
    }

    public String getNumero() {
        return numero;
    }

    public TipoPagamento getTipoPago() {
        return tipoPago;
    }
    
    public void addItem(Item itens){
        this.itens.add(itens);
    }

    public float calcularTotal(){
        float total=0;
        for(Item item:itens){
           total+=item.calcularTotal();
    }
        return total;
}
    public String getData(){
        String msg;
        msg =data.get(Calendar.DAY_OF_MONTH)+ "/" +data.get(Calendar.MONTH) +"/"+ data.get(Calendar.YEAR);
        return msg;
    }
    
    public String exibirEspecifico(Cliente cli){
        String msg="";
        for(Item item : itens){
            msg+=cli.dadosCliente();
            msg+=exibirDados();
            msg+=item.dadosItem();
        }
        
        return msg;
    }
    public String exibirDados(){
        String msg="\nNumero da Compra "+numero+
                "\nTipo de Pagamento "+tipoPago.getTipoPagamento()+
                "\nData "+getData()+
                "\nValor Total "+calcularTotal();
        return msg;
    }
    
    public String buscaTipoPagamentoSimp(int tipo){
        String msg2="";
        Dinheiro auxdinheiro;
        Cheque auxcheque;
        Cartao auxcartao;
        msg2+="\nData "+getData();
        switch(tipo){
            case 1:
                if(tipoPago.getTipoPagamento().equals("dinheiro")){
                    auxdinheiro=(Dinheiro) tipoPago; 
                    msg2+="\nQuantia Recebida R$ "+auxdinheiro.getQuantia();
                    msg2+="\nTroco R$ ";
                }
                break;
            case 2:
                if(tipoPago.getTipoPagamento().equals("cartao")){
                    auxcartao= (Cartao) tipoPago;
                    msg2+=auxcartao.exibirDados();
                }
                break;
            case 3:
                if(tipoPago.getTipoPagamento().equals("cheque")){
                auxcheque=(Cheque) tipoPago;
                msg2+=auxcheque.exibirDados();
                }
                break;
        }
        return msg2;
    }
       
}

