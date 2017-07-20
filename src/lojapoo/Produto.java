/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MrFELIS
 */
abstract class Produto implements Serializable {
    protected String codigo;
    protected String descricao;
    protected float valor;

    public Produto(String codigo, String descricao, float valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }
    public Produto(){
    
    }
  
    abstract float getValor();
    abstract String getCodigo();
    abstract String getDescricao();
    abstract float valorTotal();
     abstract String dadosProdutos();
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @Override
   public Object clone(){
      Produto produto = null;
      produto.codigo=this.codigo;
      produto.descricao=this.descricao;
      produto.valor=this.valor;
      return produto;
 }

   
    public static Produto procurarProduto(ArrayList<Produto> produtos, String msg ){
        for(Produto produto : produtos){
            if(produto.getCodigo().equals(msg)) return produto;
        }
        return null;
    }
}