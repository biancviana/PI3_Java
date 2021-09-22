package com.project.lebiton.model.impl;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.factory.FactoryLoginDAO;
import com.project.lebiton.model.UsuarioInterface;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medico extends Usuario implements UsuarioInterface {

    private StringProperty especialidade;
    private StringProperty crm;

    public Medico(final String email, final String senha) {
        super(email, senha);
    }

    public Medico() {}

    public Medico(final StringProperty nome, final String email, final String telefone, final String senha, final StringProperty especialidade, final StringProperty crm) {
        super(nome, email, telefone, senha);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public void setEspecialidade(final String especialidade) {
        this.especialidade = new SimpleStringProperty("");
        this.especialidade.set(especialidade);
    }

    public StringProperty getEspecialidade() {
        return especialidade;
    }

    public StringProperty getCrm() {
        return crm;
    }

    @Override
    public boolean logar() {
        final LoginDaoInterface dao = FactoryLoginDAO.criarLogindao();
        return dao.login(this.email, this.senha);
    }

    public static class Builder {
        protected StringProperty nome;
        protected StringProperty especialidade;
        protected StringProperty crm;
        protected String email;
        protected String telefone;
        protected String senha;

        public Builder nome(final String nome) {
            this.nome = new SimpleStringProperty("");
            this.nome.set(nome);
            return this;
        }

        public Builder especialidade(final String especialidade) {
            this.especialidade = new SimpleStringProperty("");
            this.especialidade.set(especialidade);
            return this;
        }

        public Builder crm(final String crm) {
            this.crm = new SimpleStringProperty("");
            this.crm.set(crm);
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder telefone(final String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder senha(final String senha) {
            this.senha = senha;
            return this;
        }

        public Medico build() { return new Medico(nome, email, telefone, senha, especialidade, crm);}
    }
}
