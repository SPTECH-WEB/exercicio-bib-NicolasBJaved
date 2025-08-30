package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public String getNome() {
        return nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;

    }

    public void registrarLivro(Integer quantidade){
        if(quantidade != null && ativa && quantidade >0){
            qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade){
        if(quantidade != null && ativa && quantidade > 0 && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            return quantidade;
        }
        return null;
    }

    public Integer devolver(Integer quantidade){
        if(quantidade != null && ativa && quantidade >0){
            qtdLivros += quantidade;
            return quantidade;
        }
        return null;
    }

    public Integer desativar(){
        if(!ativa){
            return null;
        }

        Integer quantidadeAnterior = qtdLivros;
        ativa = false;
        qtdLivros = 0;
        return quantidadeAnterior;
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if(quantidade != null && ativa && destino.ativa && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual == null){
            return false;
        }
        if(percentual > 0){
            multaDiaria += multaDiaria * percentual;
            return true;
        }

        return false;
    }


}
