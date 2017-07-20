/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.Serializable;

/**
 *
 * @author MrFELIS
 */
public class Item implements Serializable{
    private int num;
    private Produto produto;
    private float quantidade;

    public Item(Produto produto,float quantidade) {
        this.num = 0;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public int getNum() {
        return num;
    }

    public float getValorProduto() {
        return produto.getValor();
    }

    public String getCodigoProduto() {
        return produto.getCodigo();
    }
    
    public float calcularTotal(){
        return quantidade * produto.valorTotal();
    }
    
    public String dadosItem(){
        String msg; 
        msg=produto.dadosProdutos();
        return msg;
    }
}
