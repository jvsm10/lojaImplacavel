/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

/**
 *
 * @author MrFELIS
 */
public class ProdutoNacional extends Produto{
    private float taxaImposto;
    private String tipo;

    public ProdutoNacional(float taxaImposto, String codigo, String descricao, float valor) {
        super(codigo, descricao, valor);
        this.taxaImposto = taxaImposto;
        tipo="nacional";
    }
    
    @Override
    public float getValor() {
        return valor;
    }
    @Override
    public String getDescricao() {
        return descricao;
    }
    @Override
    public String getCodigo(){
        return codigo;
    }

    
    @Override
    float valorTotal(){
        return(super.valor + (taxaImposto/100 * super.valor) );
    }
    
    @Override
    public String dadosProdutos(){
      String msg ="\nProduto "+getCodigo()+
            "\nDescricao "+getDescricao()+
            "\nValor R$ "+getValor()+
            "\nTaxa de Imposto (%) "+taxaImposto+
            "\nValor Total R$ "+valorTotal();
        return msg;  
    }
}
