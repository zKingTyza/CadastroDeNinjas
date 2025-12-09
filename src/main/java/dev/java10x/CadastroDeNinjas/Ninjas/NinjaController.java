package dev.java10x.CadastroDeNinjas.Ninjas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vidas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem na minha rota";
    }


    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }


    //MOSTRAR NINJAS POR ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por ID", description = "Rota lista um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){

        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " nao existe no nossos registros");
        }

    }

    //MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "altera um ninja por ID", description = "Rota altera um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){
            NinjaDTO ninja = ninjaService.autalizarNinja(id, ninjaAtualizado);
            if(ninja != null){
                return ResponseEntity.ok(ninja);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ninja com o id: " + id + " nao existe no nossos registros");
            }
    }


    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não encontrado");
        }

    }
}
