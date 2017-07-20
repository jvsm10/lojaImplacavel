/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.Serializable;
import java.util.ArrayList;
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
        String msg ="\nNome "+nome+
                    "\nCPF "+ cpf;
        return msg;  
    }
    public static Cliente procurarCliente(ArrayList<Cliente> clientes, String msg ){
        for(Cliente cliente : clientes){
            if(cliente.getNome().equals(msg)) return cliente;
        }
        return null;
    }
    public String procurarVenda(Cliente cli, String msg ){
        String msg2="Venda Especifica";
        msg2+="\n";
        Boolean aux=false;
        for(Venda venda : vendas){
                if(venda.getNumero().equals(msg)){
                msg2+=venda.exibirEspecifico(cli);
                msg2+="\n";
                aux=true;
            }
        }
        if(aux == false) msg2=""; 
             return msg2;
        }
       
    public String gastosCliente(){ //EXIBE GASTO DE UM CLIENTE CASE 3
        String msg="Todos as comprar com o Cliente";
        if(vendas.isEmpty()){ 
            JOptionPane.showMessageDialog(null, "Nenhuma Compra Efetuada");
        }
        else{
        for(Venda venda: vendas){
            msg+="\n";
            msg+=venda.exibirDados();
        }
       }
      return msg;
    }
    public float totalAcumulado(){  //EXIBIR O TOTAL DO DAS VENDAS
        float total=0;
        for(Venda venda: vendas){
            total+=venda.calcularTotal();
        }
        return total;
    }
        public String exibirVendasGeral(){ //CASSE 6 RELATORIO
        String msg="";
        
        for(Venda venda: vendas){
            msg+="\n";
            msg+="\nNome "+nome;
            msg+="\nCPF "+cpf;
            msg+=venda.exibirDados();
            venda.calcularTotal();
        }
        return msg;
    }
        
    public String buscaTipoPagamentoSimp(int tipo){
        String msg="";
        for(Venda venda: vendas){
            msg+=dadosCliente();
            msg+=venda.buscaTipoPagamentoSimp(tipo);
        }
        return msg;
    } 
  
}
