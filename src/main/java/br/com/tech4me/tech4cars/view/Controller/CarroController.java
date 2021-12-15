package br.com.tech4me.tech4cars.view.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.tech4cars.service.CarroService;
import br.com.tech4me.tech4cars.view.model.CarroCadastroRequest;
import br.com.tech4me.tech4cars.view.model.CarroResponse;
import br.com.tech4me.tech4cars.view.model.CarroResponsePorId;
import br.com.tech4me.tech4cars.view.shared.CarroDTO;

@RestController
@RequestMapping("/api/tech4cars")
public class CarroController {
    @Autowired
    private CarroService servico;
   
    @GetMapping
    public ResponseEntity<List<CarroResponse>> obterCarros() {
        List<CarroDTO> carrosDto = servico.obterCarros();
        List<CarroResponse> carrosResponse = carrosDto.stream()
        .map(c -> new ModelMapper().map(c, CarroResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(carrosResponse, HttpStatus.FOUND);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CarroResponsePorId> obterCarroPorId(@PathVariable String id) {
        Optional<CarroDTO> carro = servico.obterCarroPorId(id);

        if (carro.isPresent()){
            CarroResponsePorId carroResposta = new ModelMapper().map(carro.get(), CarroResponsePorId.class);
          return new ResponseEntity<>(carroResposta, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @PostMapping()
    public ResponseEntity<CarroResponse> cadastrarCarro(@RequestBody CarroCadastroRequest carro) {
        CarroDTO carroCadastro = new ModelMapper().map(carro, CarroDTO.class);
        carroCadastro = servico.cadastrarCarro(carroCadastro);
        CarroResponse carroResponse = new ModelMapper().map(carroCadastro, CarroResponse.class);
        return new ResponseEntity<>(carroResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirCarro(@PathVariable String id) {
        servico.excluirCarro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> atualizarCarro(@PathVariable String id, @RequestBody CarroDTO novoCarro){
        Optional<CarroDTO> carro = servico.obterCarroPorId(id);

        if (carro.isPresent()){
        return new ResponseEntity<>(servico.atualizarAutomovel(id, novoCarro), HttpStatus.ACCEPTED);
        }

        return new  ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }




    
}