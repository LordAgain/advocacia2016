
package pojo;

import java.util.Date;


public class ContasAReceber {
    private String nomeCliente;
    private String descricaoConta;
    private Date dataPagamento;
    private int quantidadeParcelas;
    private double valorParcelas;
    
    public void setNomeCliente(String nomeCliente) {
        
        this.nomeCliente=nomeCliente;
        
    }
    
    public void setDescricaoConta(String descricaoConta) {
        
        this.descricaoConta=descricaoConta;
    }
    public void setDataVencimento(Date dataPagamento) {
        
        this.dataPagamento=dataPagamento;
    }
    public void setQuantidadeParcelas(int quantidadeParcelas) {
        
        this.quantidadeParcelas=quantidadeParcelas;
    }
    public void setValorParcelas(double valorParcelas) {
        
        this.valorParcelas=valorParcelas;
    }
   
           
    public String getDescricaoConta(){
        
        return descricaoConta;
    }

    /**
     *
     * @return
     */
    public Date getDataPagamento(){
        
        return dataPagamento;
    }
    public int getQuantidadeParcelas(){
        
        return quantidadeParcelas;
    }
    public double getValorParcelas(){
        
        return valorParcelas;
    }
    
    public String getNomeCliente(){
        
        return nomeCliente;
    }
    
    
}
