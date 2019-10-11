package br.com.seguirapp.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico", nullable = false)
    private int idServico;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo", nullable = false)
    private Grupo grupo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private Dispositivo dispositivo;

    @Basic
    @Column(name = "preco", nullable = false)
    private float preco;

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return idServico == servico.idServico &&
                Float.compare(servico.preco, preco) == 0 &&
                Objects.equals(grupo, servico.grupo) &&
                Objects.equals(pessoa, servico.pessoa) &&
                Objects.equals(dispositivo, servico.dispositivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, grupo, pessoa, dispositivo, preco);
    }

    @Override
    public String toString() {
        return "Servico{" +
                "grupo=" + grupo +
                ", pessoa=" + pessoa +
                ", dispositivo=" + dispositivo +
                ", preco=" + preco +
                '}';
    }
}
