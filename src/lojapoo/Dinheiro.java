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
public class Dinheiro extends TipoPagamento{
    private float quantia;
    public Dinheiro( float quantia) {
        this.tipoPagamento="Dinheiro";
        this.quantia=quantia;
    }

    public float getQuantia() {
        return quantia;
    }
    
    @Override
    String exibirDados(){
        return "\nTipo de Pagamento "+tipoPagamento+"\nQuantia "+quantia;
    }
    
}
