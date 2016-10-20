
package pojo;

import java.util.Date;


public class Processo {
    private int id;
    private String nome;
    private Date dataInicio;
    private Date dataTermino;
    private String advogado;
    private String cliente;
    private String descricao;
    
    public int getId () {
        return id;
    }
    public String getNome() {
        
        return nome;
    }
    public Date getDataInicio() {
        
        return dataInicio;
    }
    public Date getDataTermino() {
        
        return dataTermino;
    }
    public String getAdvogado() {
        
        return advogado;
    }
    public String getCliente() {
        
        return cliente;
    }
    public String getDescricao() {
        
        return descricao;
    }
}
