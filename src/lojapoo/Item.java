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
    
    public float calcularTotal(){
        return quantidade * produto.getValor();
    }
    
    public String dadosItem(){
        String msg="\nCodigo do produto "+produto.getCodigo();
        msg+="\nDescricao "+produto.getDescricao();
        msg+="\nQuantidade do produto "+quantidade;
        return msg;
    }
}
