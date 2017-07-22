/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.File;
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
        int opcao=0;
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
        if(opc==null) return 6;
        else if( opc.isEmpty()) return 0;
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
        if(opc == null) return 3;
        else if(opc.isEmpty()) return 0;
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
        if(opc == null) return 3;
        else if(opc.isEmpty()) return 0;
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
        if(opc == null) return 10;
        else if(opc.isEmpty()) return 0;
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
            if(opc == null) return 0;
        else if(opc.isEmpty()) return 0;
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
        int numvenda= 0;
        float taxaImposto;
        float taxaImportacao;


        String msg = null;
        String msg2;
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
                               do{
                               nome = JOptionPane.showInputDialog("Insira o nome do Cliente");
                               if(nome == null)
                                   nome = "";
                               }while(nome.isEmpty());
                               cli=Cliente.procurarCliente(clientes,nome);
                               if(cli!= null){ JOptionPane.showMessageDialog(null, "Cliente Ja Cadastrado");break;}
                               do{
                               cpf =(JOptionPane.showInputDialog("Insira CPF"));
                               if(nome == null)
                                   cpf = "";
                               }while(cpf.isEmpty());
                               Cliente cl = new Cliente(nome, cpf);
                               clientes.add(cl);  
                               break;
                           case 2:
                               do{
                                   continua2=true;
                                   opcao2=menuCadastrarProduto(); 
                                   switch(opcao2){
                                       case 1:
                                           do{
                                            codigo = JOptionPane.showInputDialog("Codigo do Produto Nacional");
                                            if(codigo == null)
                                                codigo = "";
                                            }while(codigo.isEmpty());
                                            pro=Produto.procurarProduto(produtos, codigo);
                                            if(pro!= null){ JOptionPane.showMessageDialog(null, "Produto Ja Cadastrado");break;}
                                            do{
                                            desc =(JOptionPane.showInputDialog("Descricao do Produto Nacional"));
                                            if(desc == null)
                                                desc = "";
                                            }while(desc.isEmpty());
                                            do{
                                            msg2 = (JOptionPane.showInputDialog("Valor Produto Nacional"));
                                            if(msg2 == null)
                                                msg2 = "";
                                            }while(msg2.isEmpty());
                                            valor =Float.parseFloat(msg2);
                                            do{
                                            msg2=(JOptionPane.showInputDialog("Taxa Imposto Produto Nacional"));
                                            if(msg2 == null)
                                                msg2 = "";
                                            }while(msg2.isEmpty());
                                            taxaImposto =Float.parseFloat(msg2);
                                            Produto prod = new ProdutoNacional(taxaImposto, codigo,desc, valor);
                                            produtos.add(prod);
                                            break;
                                       case 2:
                                           do{ 
                                           codigo = JOptionPane.showInputDialog("Codigo do Produto Importado");
                                            if(codigo == null)
                                                codigo = "";
                                            }while(codigo.isEmpty());
                                            pro=Produto.procurarProduto(produtos, codigo);
                                            if(pro!= null){ JOptionPane.showMessageDialog(null, "Produto Ja Cadastrado");break;}
                                            do{
                                            desc =(JOptionPane.showInputDialog("Descricao do Produto Importado"));
                                            if(desc == null)
                                                desc = "";
                                            }while(desc.isEmpty());
                                            do{
                                            msg2 = (JOptionPane.showInputDialog("Valor Produto Importado"));
                                            if(msg2 == null)
                                                msg2 = "";
                                            }while(msg2.isEmpty());
                                            valor =Float.parseFloat(msg2);
                                            do{
                                            msg2 =(JOptionPane.showInputDialog("Taxa Imposto Produto Importado"));
                                            if(msg2 == null)
                                                msg2 = "";
                                            }while(msg2.isEmpty());
                                            taxaImposto =Float.parseFloat(msg2);
                                            do{
                                            msg2 = (JOptionPane.showInputDialog("Taxa Importacao"));
                                            if(msg2 == null)
                                                msg2 = "";
                                            }while(msg2.isEmpty());
                                            taxaImportacao = Float.parseFloat(msg2);
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
                   numvenda++;
                   if(clientes.isEmpty()){ JOptionPane.showMessageDialog(null, "Não há Clientes Cadastrados"); break;}
                   if(produtos.isEmpty()){ JOptionPane.showMessageDialog(null, "Não há Produtos Cadastrados"); break;}
                   msg=JOptionPane.showInputDialog("Registrar Comprar\nInsira nome do Cliente:");      
                   cli = Cliente.procurarCliente(clientes, msg);
                   if(cli != null){
                       vendas = new Venda();
                       vendas.setCliente(cli);
                       do{
                       msg=JOptionPane.showInputDialog("Insira o codigo do Produto");
                       pro = Produto.procurarProduto(produtos, msg);
                       if(pro != null){
                           do{
                           msg =  JOptionPane.showInputDialog("Quantidade do item:");
                           if(msg==null)
                               msg="";
                           }while(msg.isEmpty());
                           int n = Integer.parseInt(msg);
                           it = new Item(pro,n);
                           vendas.addItem(it);
                       }
                       else JOptionPane.showMessageDialog(null, "Produto Não Encontrado");
                   }while(JOptionPane.showConfirmDialog(null, "Deseja adicionar mais itens?")==0);
                       pg=TipoPagamento.tipo(vendas.calcularTotalVendas());
                       d = Calendar.getInstance();
                       vendas.setNumero(String.valueOf(numvenda));
                       vendas.setTipoPago(pg);
                       vendas.setData(d);
                       cli.addVenda(vendas);
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
                                   do{
                                   msg=JOptionPane.showInputDialog("Insira Nome Cliente");
                                   if(msg == null)
                                       msg = "-1";
                                    }while(msg.isEmpty());
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
                               do{
                               msg=JOptionPane.showInputDialog("Insira Nome Cliente");
                               if(msg == null)
                                                msg = "-1";
                                            }while(msg.isEmpty());
                               cli=Cliente.procurarCliente(clientes, msg);
                               if(cli!=null){
                                    msg=cli.gastosCliente();
                                    msg+="\n\nTotal Gasto pelo Cliente:  "+cli.totalAcumulado();
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
                                   do{
                                   msg=JOptionPane.showInputDialog("Insira Codigo Produto");
                                   if(msg == null)
                                                msg = "-1";
                                            }while(msg.isEmpty() || msg =="-1");
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
                                   msg+="\n";
                                   msg+=cliente.exibirVendasGeral();
                                   total+=cliente.totalAcumulado();
                               }
                               if(msg.isEmpty()){ JOptionPane.showMessageDialog(null, "Nao há vendas cadastradas"); break;}
                               msg+="\n\nPreço Total R$:  "+total;
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               break;
                           case 7:                               
                               do{
                               msg=JOptionPane.showInputDialog("\nInsira o Codigo da Venda");
                               if(msg == null)
                                    msg = "-1";
                               }while(msg.isEmpty() || msg =="-1");
                               msg2="";
                               for(Cliente cliente: clientes){
                                   msg2+="\n";
                                   msg2+=cliente.buscaEspecifica(msg);
                               }
                               if(msg2.isEmpty()){   JOptionPane.showMessageDialog(null,"Não há vendas Cadastrada com esse numero"); break;}
                               rel = new JanelaRelatorio(msg2);
                               rel.exibir();
                               break;
                           case 8:
                               opcao2 = menuCartao();
                               msg="";
                               for(Cliente cliente: clientes){
                                   
                                   msg+=cliente.buscaTipoPagamentoSimp(opcao2);
                                   msg+="\n";
                               }
                               if(msg.isEmpty()){JOptionPane.showMessageDialog(null, "Nenhuma Compra Efetuado por esse Pagamento"); break;}
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               break;
                           case 9:
                               opcao2 = menuCartao();
                               msg="";
                               for(Cliente cliente: clientes){
                                   msg+="\n";
                                   msg+=cliente.buscaTipoPagamentoDetalhado(opcao2);
                               }
                               if(msg.isEmpty()){JOptionPane.showMessageDialog(null, "Nenhuma Compra Efetuado por esse Pagamento"); break;}
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
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
                   
                   else{ if(clientes.isEmpty() == false){
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
                   }
                   break;
                   
              //===========================CASE 5=====================================================
               case 5:
                   File f = new File("clientes.dat");
                   if(f.exists()){
                   FileInputStream fis = new FileInputStream("clientes.dat");
                   ObjectInputStream ois = new ObjectInputStream(fis);
                   int numClientes = ois.readInt();
                   for(int i=0;i<numClientes;i++){
                       cli = (Cliente)ois.readObject();
                       clientes.add(i, cli);
                   }
                   fis.close();
                   f = new File("produtos.dat");
                   if(f.exists()){
                   fis = new FileInputStream("produtos.dat");
                   ois = new ObjectInputStream(fis);
                   
                   int numProdutos = ois.readInt();
                   for(int i=0;i<numProdutos;i++){
                       pro = (Produto)ois.readObject();
                       produtos.add(i, pro);
                   }
                   fis.close();
                   }
                   JOptionPane.showMessageDialog(null, "DADOS CARREGADOS COM SUCESSO!");
                   }
                   else JOptionPane.showMessageDialog(null, "NÃO HÁ DADOS PARA CARREGAR!");
                   
                   break;
               case 6:
                   continua=false;
                   break;
           }
        }while(continua);
}
}
