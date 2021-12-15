package br.com.tech4me.tech4cars.view.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CarroDTO {

    private String id;
    @NotBlank(message= "O modelo não pode estar vazio")
    private String modelo;
    @NotBlank(message= "A marca de não pode estar vazio")
    private String marca;
    @Size(message = "a placa deve te no mínimo 8 caracteres")
    private String placa;
    @Positive(message = "O valor não pode estar zerado!")
    private Double valor;
    @Positive(message = "O preço custo deve ser falado!")
    private Double precoDeCusto;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Double getPrecoDeCusto() {
        return precoDeCusto;
    }
    public void setPrecoDeCusto(Double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    
}
