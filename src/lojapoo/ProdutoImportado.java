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
public class ProdutoImportado extends Produto {
    private float taxaImposto;
    private float taxaImportacao;
    private String tipo;

    public ProdutoImportado(float taxaImposto, float taxaImportacao, String codigo, String descricao, float valor) {
        super(codigo, descricao, valor);
        this.taxaImposto = taxaImposto;
        this.taxaImportacao = taxaImportacao;
        tipo = "importado";
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
        return super.valor + (taxaImposto/100 * super.valor) + (taxaImportacao/100 * super.valor);
        }
    @Override
    public String dadosProdutos(){
    String msg ="\nCodigo do Produto:  "+getCodigo()+
            "\nDescricao do Produto:  "+getDescricao()+
            "\nValor R$:  "+getValor()+
            "\nProduto Importado"+
            "\nTaxa de Imposto (%):  "+taxaImposto+
            "\nTaxa de Importacao (%):  "+taxaImportacao+
            "\nValor Total R$:  "+valorTotal();
        return msg;  
    }
}
