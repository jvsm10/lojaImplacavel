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
public class Cheque extends TipoPagamento{
    private String nomeEmissor;
    private String numeroCheque;
    public Cheque(String nomeEmissor, String numeroCheque) {
        this.tipoPagamento="Cheque";
        this.nomeEmissor=nomeEmissor;
        this.numeroCheque=numeroCheque;   
    }

        
    @Override
    public String exibirDados() {
        String msg;
        msg="\nNome Emissor "+nomeEmissor+"\nNumero do Cheque "+numeroCheque;
        return msg;
    }
    
}
