package entities;

public abstract class Contribuinte {     // CLASSE ABSTRATA GENERALISTA OU SUPERCLASSE
    private String nome;
    private Double rendaAnual;

    public Contribuinte() {     // BOA PRATICA INSTANCIAR O CONSTRUTOR COM OU SEM ARGUMENTO PARA INSTANCIAR OBJETO COM OU SEM ARGUMENTO E TAMBEM VARIOS FRAMEWORK USA CONSTRUTOR VAZIO

    }

    public Contribuinte(String nome, Double rendaAnual) {
        super();
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public abstract double imposto();      // METODO ABSTRATO / REGRA DE IMPOSTO SEM IMPLEMENTAÇÃO

}
