package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem na minha rota";
    }


    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinjas(){
        return "Ninja criado";
    }


    //MOSTRAR NINJAS POR ID (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "mostrar ninja por id";
    }



    //MOSTRAR TODOS OS NINJAS (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar ninja por Id";
    }


    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarPorId(){
        return "Deletar ninja por id";
    }
}
