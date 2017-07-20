/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author MrFELIS
 */
public class LojaPOO{

    private static int menu(){
        int opcao;
        Boolean continua;
        do{
        continua=true;  
        String menu="Loja IMPLACAVEL";
        menu+=  "\n1 - Cadastrar"+
                "\n2 - Registrar Compra"+
                "\n3 - Relatorios"+
                "\n4 - Salvar Dados"+
                "\n5 - Carregar Dados"+
                "\n6 - Sair";
        String opc=JOptionPane.showInputDialog(menu);
        if( opc == null) return 6;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<7) continua=false;
        }while(continua);
        return opcao;
    }
    
    private static int menuCadastrar(){
        int opcao;
        Boolean continua;
        do{
        continua=true; 
        String menu="Menu Cadastrar";
        menu+=  "\n1 - Cliente"+
                "\n2 - Produto"+
                "\n3 - Voltar";
        String opc=JOptionPane.showInputDialog(menu);
        if(opc == null) return 4;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<7) continua=false;
        }while(continua);
        return opcao;
    }
    
    private static int menuCadastrarProduto()  {
        int opcao;
        Boolean continua;
        do{
        continua=true; 
        String menu="Menu Cadastrar";
        menu+=  "\n1 - Produto Nacional"+
                "\n2 - Produto Internacional"+
                "\n3 - Voltar";
                String opc=JOptionPane.showInputDialog(menu);
        if(opc == null) return 4;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<4) continua=false;
        }while(continua);
        return opcao;
    }

    private static int menuRelatorios(){
    int opcao;
    Boolean continua;
    do{
        continua=true;
        String menu="Menu Cadastrar";
        menu+=  "\n1 - Listar Clientes"+
                "\n2 - Listar Cliente Especifico"+
                "\n3 - Listar Gastos de um Cliente"+
                "\n4 - Listar Produtos"+
                "\n5 - Listar Produto Especifico"+
                "\n6 - Listar Vendas"+
                "\n7 - Listar Venda Especifica"+
                "\n8 - Listar Venda por tipo de pagamento"+
                "\n9 - Listar Venda por tipo de pagamento detalhado"+
                "\n10 - Voltar";
        String opc=JOptionPane.showInputDialog(menu);
        if(opc == null) return 11;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<11) continua=false;
    }while(continua);
    return opcao;
}
    private static int menuCartao(){
        int opcao;
        Boolean continua;
        do{
            continua=true;
            String menu="Relatorio"+
                    "\n1 - Dinheiro"+
                    "\n2 - Cartao "+
                    "\n3 - Cheque";
            String opc= JOptionPane.showInputDialog(menu);
            if(opc == null) return 4;
            opcao=Integer.parseInt(opc);
            if(opcao>=1 && opcao<=3) continua=false;
        }while(continua);
        return opcao;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
        //===VARIAVEIS DE CONTROLE====//
        Boolean continua;
        Boolean continua2;
        int opcao;
        int opcao2;
        //====ARRAY==================//
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();
        //======
        String nome;
        String cpf;
        
        String codigo;
        String desc;
        float valor;
        float taxaImposto;
        float taxaImportacao;


        String msg = null;
        Cliente cli;
        Produto pro;
        Venda vendas;
        Item it;
        Calendar d;
        TipoPagamento pg = null;
        JanelaRelatorio rel;
        

        do{       
            continua=true;
            opcao=menu();
            switch(opcao){
               case 1:
                  do{
                       opcao2=menuCadastrar();
                       continua2=true;
                       switch(opcao2){
                           case 1:
                               nome = JOptionPane.showInputDialog("Insira o nome do Cliente");
                               cpf =(JOptionPane.showInputDialog("Insira CPF"));
                               Cliente cl = new Cliente(nome, cpf);
                               clientes.add(cl);  
                               break;
                           case 2:
                               do{
                                   continua2=true;
                                   opcao2=menuCadastrarProduto(); 
                                   switch(opcao2){
                                       case 1:
                                            codigo = JOptionPane.showInputDialog("Codigo do Produto Nacional");
                                            desc =(JOptionPane.showInputDialog("Descricao do Produto Nacional"));
                                            valor =Float.parseFloat(JOptionPane.showInputDialog("Valor Produto Nacional"));
                                            taxaImposto =Float.parseFloat(JOptionPane.showInputDialog("Taxa Imposto Produto Nacional"));
                                            Produto prod = new ProdutoNacional(taxaImposto, codigo,desc, valor);
                                            produtos.add(prod);
                                            break;
                                       case 2:
                                            codigo = JOptionPane.showInputDialog("Codigo do Produto Importado");
                                            desc =(JOptionPane.showInputDialog("Descricao do Produto Importado"));
                                            valor =Float.parseFloat(JOptionPane.showInputDialog("Valor Produto Importado"));
                                            taxaImposto =Float.parseFloat(JOptionPane.showInputDialog("Taxa Imposto Produto Importado"));
                                            taxaImportacao = Float.parseFloat(JOptionPane.showInputDialog("Taxa Importacao"));
                                            prod = new ProdutoImportado(taxaImposto, taxaImportacao, codigo,desc, valor);
                                            produtos.add(prod);
                                           break;   
                                       case 3:
                                           continua2=false;
                                           break;
                                       case 4:
                                           continua2=false;     //FECHAR PROGRAMA, BOTAO X E CANCELAR
                                           continua=false;
                                           break;
                                    }
                                }while(continua2);
                               continua2=true;
                               break;
                              
                            case 3:
                               continua2=false;
                               break;
                       
                            case 4:
                                continua2=false;    //FECHAR PROGRAMA, BOTAO X E CANCELAR
                                continua=false;
                                break;                    
                   }  
                   }while(continua2);
                    break;
              //==================CASE 2=========================================================================
               case 2:
                   if(clientes.isEmpty()){ JOptionPane.showMessageDialog(null, "Não há Clientes Cadastrados"); break;}
                   if(produtos.isEmpty()){ JOptionPane.showMessageDialog(null, "Não há Produtos Cadastrados"); break;}
                   msg=JOptionPane.showInputDialog("Registrar Comprar\nInsira nome do Cliente:");      
                   cli = Cliente.procurarCliente(clientes, msg);
                   if(cli != null){
                       pg=TipoPagamento.tipoCartao();
                       msg = JOptionPane.showInputDialog("Coloque o número da venda");
                       d = Calendar.getInstance();
                       vendas = new Venda(msg,pg,cli,d);
                       do{
                       msg=JOptionPane.showInputDialog("Insira o codigo do Produto");
                       pro = Produto.procurarProduto(produtos, msg);
                       if(pro != null){
                           int n = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do item:"));
                           it = new Item(pro,n);
                           vendas.addItem(it);
                           cli.addVenda(vendas);
                       }
                       else JOptionPane.showMessageDialog(null, "Produto Não Encontrado");
                   }while(JOptionPane.showConfirmDialog(null, "Deseja Continuar as Comprar?")==0);
                   }
                   else JOptionPane.showMessageDialog(null, "Cliente Não Encontrado");
                   break;
             //===================CASE 3===============================================================================
               case 3:
                   do{
                       opcao2=menuRelatorios();
                       continua2=true;
                       switch(opcao2){
                           case 1:
                               msg="";
                               if(clientes.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Clientes Cadastrados");
                               else{ for (Cliente cliente : clientes) {
                                        msg+="\n";
                                        msg+= cliente.dadosCliente();
                                    }
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               }
                               break;
                           case 2:
                               if(clientes.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Clientes Cadastrados");
                               else{
                                   Boolean aux=true;
                                   msg=JOptionPane.showInputDialog("Insira Nome Cliente");
                                   for(Cliente cliente: clientes){
                                       if(cliente.getNome().equals(msg)){
                                           JOptionPane.showMessageDialog(null, cliente.dadosCliente());
                                           aux=false;
                                       } 
                                   }
                                   if(aux) JOptionPane.showMessageDialog(null, "Cliente Nao Encontrado");
                               }
                               break;
                           case 3:
                               msg=JOptionPane.showInputDialog("Insira Nome Cliente");
                               cli=Cliente.procurarCliente(clientes, msg);
                               if(cli!=null){
                                    msg=cli.gastosCliente();
                                    rel = new JanelaRelatorio(msg);
                                    rel.exibir();
                               }
                               else JOptionPane.showMessageDialog(null, "Cliente Nao Encontrado");
                                break;
                           case 4:
                               msg="";
                               if(produtos.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Produtos Cadastrados");
                               else{ for (Produto produto : produtos) {
                                        msg+="\n";
                                        msg += produto.dadosProdutos();
                                    }
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               }
                               break;
                           case 5:
                               if(produtos.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Produto Cadastrados");
                               else{
                                   Boolean aux=true;
                                   msg=JOptionPane.showInputDialog("Insira Codigo Produto");
                                   for(Produto produto: produtos){
                                       if(produto.getCodigo().equals(msg)){
                                           JOptionPane.showMessageDialog(null, produto.dadosProdutos());
                                           aux=false;
                                       } 
                                   }
                                   if(aux) JOptionPane.showMessageDialog(null, "Produto Não Encontrado");
                               }
                               break;
                           case 6:
                               msg="";
                               float total=0;
                               for(Cliente cliente : clientes){
                                   msg+=cliente.exibirVendasGeral();
                                   total+=cliente.totalAcumulado();
                               }
                               msg+="\n\nPreço Total R$ "+total;
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               break;
                           case 7:                               
                               msg=JOptionPane.showInputDialog("\nInsira o Codigo da Venda");
                               String msg2=null;
                               for(Cliente cliente: clientes){
                                   msg2+="\n";
                                   msg2+=cliente.procurarVenda(cliente, msg);
                               }
                               if(msg2==null){   JOptionPane.showMessageDialog(null,"Não há vendas Cadastrada com esse numero"); break;}
                               rel = new JanelaRelatorio(msg2);
                               rel.exibir();
                               break;
                           case 8:
                               opcao2 = menuCartao();
                               msg="";
                               for(Cliente cliente: clientes){
                                   msg+=cliente.buscaTipoPagamentoSimp(opcao2);
                               }
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               break;
                           case 9:
                               break;
                           case 10:
                               continua2=false;
                               break;
                           case 11:
                               continua=false;
                               continua2=false;
                               break;
                       }
                   }while(continua2);
                   break;
               //===========================CASE 4=====================================================
               case 4:
                   
                   if(clientes.isEmpty() && produtos.isEmpty()){
                       JOptionPane.showMessageDialog(null, "NÂO HÁ CLIENTES E PRODUTOS CADASTRADOS!\n CADASTRE ANTES PARA SALVAR");
                   }
                   
                   if(clientes.isEmpty() == false){
                        FileOutputStream fos = new FileOutputStream("clientes.dat");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
         
                        oos.writeInt(clientes.size());
                        for(int i = 0; i<clientes.size();i++){
                            oos.writeObject(clientes.get(i));
                        }
                        fos.close();
                   }
                   if(produtos.isEmpty() == false){
                       
                      FileOutputStream fos = new FileOutputStream("produtos.dat");
                       ObjectOutputStream oos = new ObjectOutputStream(fos);
   
                        oos.writeInt(produtos.size());
                        for(int i = 0; i<produtos.size();i++){
                            oos.writeObject(produtos.get(i));
                        }
                        fos.close();
                   };
                   
                  
                   JOptionPane.showMessageDialog(null, "DADOS SALVOS COM SUCESSO!");
                   
                   break;
                   
              //===========================CASE 5=====================================================
               case 5:
      
                   FileInputStream fis = new FileInputStream("clientes.dat");
                   ObjectInputStream ois = new ObjectInputStream(fis);
                   
                   int numClientes = ois.readInt();
                   for(int i=0;i<numClientes;i++){
                       cli = (Cliente)ois.readObject();
                       clientes.add(i, cli);
                   }
                   fis.close();
                   
                   fis = new FileInputStream("produtos.dat");
                   ois = new ObjectInputStream(fis);
                   
                   int numProdutos = ois.readInt();
                   for(int i=0;i<numProdutos;i++){
                       pro = (Produto)ois.readObject();
                       produtos.add(i, pro);
                   }
                   fis.close();
                   
                   JOptionPane.showMessageDialog(null, "DADOS CARREGADOS COM SUCESSO!");
                   break;
               case 6:
                   continua=false;
                   break;
           }
        }while(continua);
    
        //testando
}
}
