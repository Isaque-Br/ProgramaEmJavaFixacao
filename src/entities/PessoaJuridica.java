package entities;

public class PessoaJuridica extends Contribuinte {

    private int numeroDeFuncionarios;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, Double rendaAnual, int numeroDeFuncionarios) {
        super(nome, rendaAnual);
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public int getNumeroDeFuncionarios() {
        return numeroDeFuncionarios;
    }

    public void setNumeroDeFuncionarios(int numeroDeFuncionarios) {
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    @Override
    public double imposto() {
        double taxaDeImposto = (getNumeroDeFuncionarios() > 10.0) ? getRendaAnual() * 14.0 / 100.0 : getRendaAnual() * 16.0 / 100.0;

        return taxaDeImposto;
    }
}
