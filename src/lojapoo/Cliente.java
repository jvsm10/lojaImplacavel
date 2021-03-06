/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MrFELIS
 */
public class Cliente implements Serializable {
    private String cpf;
    private String nome;
    private ArrayList<Venda> vendas;

    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        vendas = new ArrayList<>();
    }
    public Cliente(){
    }

    public String getNome() {
        return nome;
    }
    public void addVenda(Venda venda){
        this.vendas.add(venda);
    }
    public String dadosCliente(){
        String msg ="\nNome:  "+nome+
                    "\nCPF:  "+ cpf;
        return msg;  
    }
    public static Cliente procurarCliente(ArrayList<Cliente> clientes, String msg ){
        for(Cliente cliente : clientes){
            if(cliente.getNome().equals(msg)) return cliente;
        }
        return null;
    }

    public String gastosCliente(){ //EXIBE GASTO DE UM CLIENTE CASE 3
        String msg="Todos as comprar com o Cliente";
        if(vendas.isEmpty()){ 
            JOptionPane.showMessageDialog(null, "Nenhuma Compra Efetuada");
        }
        else{
        for(Venda venda: vendas){
            msg+="\n";
            msg+=venda.exibirDadosItem();
       }
       }
      return msg;
    }
    public float totalAcumulado(){  //EXIBIR O TOTAL DO DAS VENDAS
        float total=0;
        for(Venda venda: vendas){
            total+=venda.calcularTotalVendas();
        }
        return total;
    }
        public String exibirVendasGeral(){ //CASSE 6 RELATORIO
        String msg="";
        
        for(Venda venda: vendas){
            msg+="\n";
            msg+="\nNome:  "+nome;
            msg+="\nCPF:  "+cpf;
            msg+=venda.exibirDadosItem();
        }
        return msg;
    }
    
    public String buscaEspecifica(String msg){
        String msg2="";
        for(Venda venda:vendas){
            if(venda.getNumero().equals(msg)){
            msg2+="\n";
            msg2+=dadosCliente();
            msg2+=venda.exibirEspecifico();
            }
        }
       return msg2;
    }
    
        public String buscaTipoPagamentoSimp(int tipo){
        String msg="";
        ArrayList<Venda> listaVenda = new ArrayList<>();
        if(tipo==1) listaVenda=tipoPago("Dinheiro");
        else if(tipo==2) listaVenda=tipoPago("Cartao");
        else if(tipo==3) listaVenda=tipoPago("Cheque");
        if(listaVenda.isEmpty()) return "";
        for(Venda venda: vendas){
            msg+=dadosCliente();
            msg+="\n";
            msg+=venda.buscaTipoPagamentoSimp(tipo);
        }
        return msg;
    } 
        
    public String buscaTipoPagamentoDetalhado(int tipo){
        String msg="";
        ArrayList<Venda> listaVenda = new ArrayList<>();
        if(tipo==1) listaVenda=tipoPago("Dinheiro");
        else if(tipo==2) listaVenda=tipoPago("Cartao");
        else if(tipo==3) listaVenda=tipoPago("Cheque");
        if(listaVenda.isEmpty()) return "";
        for(Venda venda: vendas){
            msg+=dadosCliente();
            msg+="\n";
            msg+=venda.buscaTipoPagamentoDetalhado(tipo);
            
        }
        return msg;
    }   
    

    public ArrayList tipoPago(String pago){
        ArrayList<Venda> listaVenda = new ArrayList<>();
        for(Venda venda: vendas){
            if(venda.getTipoPago().getTipoPagamento().equals(pago))
                listaVenda.add(venda);
        }
        return listaVenda;
    }
            
}
