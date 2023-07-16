package entities;

// SUBCLASSE HERDANDO A CLASSE ABSTRATA CONTRIBUINTE
// E SENDO OBRIGADA A INSTANCIAR O METODO ABSTRATO A NAO SER QUE A TORNE ABSTRATA TBM
public class PessoaFisica extends Contribuinte {
    private Double gastosComSaude;

    public PessoaFisica() {
    }

    // INSTANCIANDO NOME, RENDA E GASTOSCOMSAUDE
    public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
        super(nome, rendaAnual);    // ATRIBUINDO REAPROVEITANDO A IMPLEMENTAÇÃO DO CONSTRUTOR DA SUPERCLASSE
        this.gastosComSaude = gastosComSaude; // E O QUE TIVER A MAIS, FAZMOS A ATRIBUIÇÃO
    }   // O THIS REFERE AO ATRIBUTO DA CLASSE E NÃO O ARGUMENTO DO CONSTRUTOR/METODO

    public Double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(Double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    // IMPLEMENTANDO PELA PRIMEIRA VEZ O METODO ABSTRATO IMPOSTO
    @Override
    public double imposto() {
        // FORMA ALTERNATIVA (IF TERNARIO)
        // double  taxaDeImposto = (getRendaAnual() < 20000.0) ? getRendaAnual() * 15.0 / 100.0 : getRendaAnual() * 25.0 / 100.0;
        double taxaDeImposto;
        if (getRendaAnual() < 20000.0) {
            taxaDeImposto = getRendaAnual() * 15.0 / 100.0;
        } else {
            taxaDeImposto = getRendaAnual() * 25.0 / 100.0;
        }
        taxaDeImposto -= getGastosComSaude() * 50.0 / 100.0;
        if (taxaDeImposto < 0.0) {
            taxaDeImposto = 0.0;
        }
        return taxaDeImposto;
    }
}