package dev.java10x.CadastroDeNinjas.Missoes;

//LocalHOST:8080


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //REQUISIÇÃO
    // GET -- MANDAR UMA REQUISIÇAO
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas com sucesso";
    }

    // POST -- CRIAR AS MISSOES
    @PostMapping("criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    // PUT -- ALTERAR MISSOES
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }

    // DELETE -- DELETAR MISSOES
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }
}
