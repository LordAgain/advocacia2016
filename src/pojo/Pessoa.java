
package pojo;

import java.util.Date;


public class Pessoa {
    private int id;
    private String nome;
    private Date dataNacimento;
    private String cpf;
    private String rg;
    private String telefone;
    private String celular;
    private String email;
    private char eCliente;
    private char eAdvogado;
    private String estado;
    private String cidade;
    private String rua;
    private int numeroCasa;
    private String complemento;
    private String cep;
    
    private void setCliente (char eCliente) {
        
        this.eCliente = eCliente;
    }
    private void setId (int id) {
        this.id = id;
    }
    private void setDataNacimento(Date dataNacimento){
        this.dataNacimento = dataNacimento;
    }
    private void setAdvogado (char eAdvogado) {
        this.eAdvogado = eAdvogado;
    }
    private void setNumeroCasa (int numeroCasa) {
        
        this.numeroCasa = numeroCasa;
    }
    public void setNome (String nome ) {
 
        this.nome=nome;
        
    }
    public void setCpf (String cpf ) {
        
        this.cpf=cpf;
        
    }
    public void setRg (String rg) {
        
        this.rg=rg;  
    }
    public void setTelefone (String telefone ) {
        
        this.telefone=telefone;
        
    }
    public void setCelular (String celular) {
        
        this.celular=celular;
        
    }
    public void setEmail (String email ) {
        
        this.email=email;
        
    }
    public void setEstado (String estado ) {
        
        this.estado=estado;
        
    }
    public void setCidade (String cidade ) {
        
        this.cidade=cidade;
        
    }
    public void setRua (String rua ) {
        
        this.rua=rua;
        
    }
    public void setComplemento (String complemento) {
        
        this.complemento=complemento;
        
    }
    public void setCep (String cep ) {
        
        this.cep=cep;
        
    }
    public int getId  () {
        
        return id;
    }
    public int getNumeroCasa  () {
        
        return numeroCasa;
    }
    public String getNome () {
        
        return nome;
    }
    public String getCpf() {
        
        return cpf;
    }
    public String getRg () {
        
        return rg;
    }
    public String getTelefone() {
        
        return telefone;
    }
    public String getCelular () {
        
        return celular;
    }
    public String getEmail () {
        
        return email;
    }
    public String getEstado () {
        
        return estado;
    }
    public String getCidade () {
        
        return cidade;
    }
    public String getRua () {
        
        return rua;
    }
    public String getComplemento () {
        
        return complemento;
    }
    public String getCep () {
        
        return cep;
    }
    public char getCliente () {
        
        return eCliente;
    }
    public char getAdvogado () {
        
        return eAdvogado;
    }
    public Date getDataNacimento () {
        
        return dataNacimento;
    }
}
