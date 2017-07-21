/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author MrFELIS
 */
public class Venda implements Serializable {
    private String numero;
    private ArrayList<Item> itens;
    private TipoPagamento tipoPago;
    private Cliente cliente;
    private Calendar data;
    
    public Venda(){
        itens = new ArrayList<>();
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipoPago(TipoPagamento tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData(Calendar data) {
        this.data = data;
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

    public float calcularTotalVendas(){
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
    
    public String exibirEspecifico(){111
        String msg="";
        for(Item item : itens){
            msg+="\n\n";
            msg+=exibirDados();
            msg+=item.dadosItem();
            msg+="\nQuantidade deste Produto:  "+item.getQuantidade();
            msg+="\nValor total do(s) Produto(s) R$:  "+item.calcularTotal();
        } 
        return msg;
    }
    
    public String exibirDadosItem(){
        String msg="";
        for(Item item : itens){
            msg+="\n";
            msg+=exibirDados();
            msg+="\nQuantidade deste Produto:  "+item.getQuantidade();
            msg+="\nValor total do(s) Produto(s) R$:  "+item.calcularTotal();
        }
        return msg;
    }
    public String exibirDados(){
        String msg="\nNumero da Venda:  "+numero+
                "\nTipo de Pagamento:  "+tipoPago.getTipoPagamento()+
                "\nData "+getData();    
        return msg;
    }
    public String buscaTipoPagamentoSimp(int tipo){
        String msg="";
        for(Item item : itens){
            msg+="\nNumero da Venda:  "+numero;
            msg+="\nCodigo do Produto:  "+item.getCodigoProduto();
            msg+="\nValor Total:  "+item.calcularTotal();
            msg+="\nData:  "+getData();
            msg+=buscaTipoPagamento(tipo);
            msg+="\n\n";
            
        }
        return msg;
    }
    
    public String buscaTipoPagamentoDetalhado(int tipo){
        String msg="";
        for(Item item : itens){
            msg+="\nNumero da Venda:  "+numero;
            msg+=item.dadosItem();
            msg+="\nData "+getData();
            msg+=buscaTipoPagamento(tipo);
            msg+="\n\n";
            
        }
        return msg;
    }
    public String buscaTipoPagamento(int tipo){
        String msg2="";
        Dinheiro auxdinheiro;
        Cheque auxcheque;
        Cartao auxcartao;
        switch(tipo){
            case 1:
                if(tipoPago.getTipoPagamento().equals("Dinheiro")){
                    auxdinheiro=(Dinheiro) tipoPago; 
                    msg2+="\nQuantia Recebida R$ "+auxdinheiro.getQuantia();
                    msg2+="\nTroco R$ "+(auxdinheiro.getQuantia()-calcularTotalVendas());
                }
                break;
            case 2:
                if(tipoPago.getTipoPagamento().equals("Cartao")){
                    auxcartao= (Cartao) tipoPago;
                    msg2+=auxcartao.exibirDados();
                }
                break;
            case 3:
                if(tipoPago.getTipoPagamento().equals("Cheque")){
                auxcheque=(Cheque) tipoPago;
                msg2+=auxcheque.exibirDados();
                }
                break;
        }
        return msg2;
    }
    

    public String buscaTipoPagamentoArray(int tipo){
        String msg2="";
        Dinheiro auxdinheiro;
        Cheque auxcheque;
        Cartao auxcartao;
        switch(tipo){
            case 1:
                if(tipoPago.getTipoPagamento().equals("Dinheiro")){
                    auxdinheiro=(Dinheiro) tipoPago; 
                    msg2+="\nQuantia Recebida R$ "+auxdinheiro.getQuantia();
                    msg2+="\nTroco R$ "+(auxdinheiro.getQuantia()-calcularTotalVendas());
                }
                break;
            case 2:
                if(tipoPago.getTipoPagamento().equals("Cartao")){
                    auxcartao= (Cartao) tipoPago;
                    msg2+=auxcartao.exibirDados();
                }
                break;
            case 3:
                if(tipoPago.getTipoPagamento().equals("Cheque")){
                auxcheque=(Cheque) tipoPago;
                msg2+=auxcheque.exibirDados();
                }
                break;
        }
        return msg2;
    }
       
}


