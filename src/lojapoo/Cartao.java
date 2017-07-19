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
public class Cartao extends TipoPagamento{
    private String nome;
    private String numero;

    public Cartao(String nome, String numero) {
        this.tipoPagamento="Cartao";
        this.nome = nome;
        this.numero = numero;
    }

    
    @Override
    public String exibirDados(){
        String msg="\nTipo de Pagamento "+tipoPagamento+"\nNome "+nome+"\nNumero "+numero;
        return msg;
    }
}
