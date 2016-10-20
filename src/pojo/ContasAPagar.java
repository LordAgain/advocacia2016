
package pojo;

import java.util.Date;

public class ContasAPagar {
    private String descricaoConta;
    private Date dataVencimento;
    private int quantidadeParcelas;
    private double valorParcelas;
    
    
    public void setDescricaoConta(String descricaoConta) {
        
        this.descricaoConta=descricaoConta;
    }
    public void setDataVencimento(Date dataVencimento) {
        
        this.dataVencimento=dataVencimento;
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
    public Date getDataVencimento(){
        
        return dataVencimento;
    }
    public int getQuantidadeParcelas(){
        
        return quantidadeParcelas;
    }
    public double getValorParcelas(){
        
        return valorParcelas;
    }
    
}
