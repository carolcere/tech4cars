package br.com.tech4me.tech4cars.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CarroCadastroRequest {

   
    private String id;
    @NotBlank(message = "O modelo não pode estar vazio")
    private String modelo;
    @NotEmpty(message = "A marca do carro deve ser informada")
    private String marca;
    @Size(message = "a placa deve te no mínimo 8 caracteres")
    private String placa;

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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    

    
    
}
