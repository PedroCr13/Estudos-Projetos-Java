package br.edu.utfpr.cp.espjava.crudcidades.visao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
public class CidadeController {

    private Set<Cidade> cidades;

    public CidadeController() {
        cidades = new HashSet<>();
    }

    @GetMapping("/")    
    public String listar(Model memoria) {

        // armazena valores que precisa enviar ao navegador (ui.Model)
        // funciona com uma memóeria compartilhada entre a View (pagina) e Controller
        // permitindo que os dados armazenados transitem entre as duas camadas
        memoria.addAttribute("listaCidades", cidades);

        return "/crud";
    }

    @PostMapping("/criar")
    public String criar(@Valid Cidade cidade, 
        BindingResult validacao,  // ao validar este objeto recebe os erros gerados 
        Model memoria) {

        if(validacao.hasErrors()) {

            /* exibe dados de erro no console
             System.out.println( 
                    String.format(
                        "O atributo %s emitiu a seguinte mensagem: %s", 
                         error.getField(), 
                         error.getDefaultMessage())
                    )
             */

            // verifica a existências de erros de validação
            validacao
                .getFieldErrors()  // se houver erros, retorna lista de erros
                .forEach(
                    error -> memoria.addAttribute(
                        error.getField(), 
                        error.getDefaultMessage()) // retorna mensagem de erro definida para o erro ocorreido (definidas no arquivo properties)
                );

            memoria.addAttribute("nomeInformado", cidade.getNome()); // armazena valores informados para serem recuperados
            memoria.addAttribute("estadoInformado", cidade.getEstado());
            memoria.addAttribute("listaCidades", cidades);

            return "/crud";
        
        } else {
            cidades.add(cidade);
        }

        return "redirect:/"; // redirecionamento para o metodo listar() por sua vez carrega a lista de cidades e a pagina crud.ftl
    }

    @GetMapping("/excluir")
    public String excluir(
        @RequestParam String nome,
        @RequestParam String estado) {

        // iterando pela lista para localizar a cidade e estado passados por parametro
        cidades.removeIf(cidadeAtual -> 
                  cidadeAtual.getNome().equals(nome) && 
                  cidadeAtual.getEstado().equals(estado)
        );

        return "redirect:/";
    }

    @GetMapping("/preparaAlterar")
    public String preparaAlterar(
        @RequestParam String nome,
        @RequestParam String estado,
        Model memoria
    ) {

        // Se existir uma cidade com os valores buscados, ela será armazenada em um objeto do tipo Optional
        var cidadeAtual = cidades
                            .stream()
                            .filter(cidade -> 
                                        cidade.getNome().equals(nome) && 
                                        cidade.getEstado().equals(estado)).findAny();

        if (cidadeAtual.isPresent()) {
            memoria.addAttribute("cidadeAtual", cidadeAtual.get());
            memoria.addAttribute("listaCidades", cidades);
        }

        return "/crud";
    }

    @PostMapping("/alterar")
    public String alterar(
        @RequestParam String nomeAtual,
        @RequestParam String estadoAtual,
        Cidade cidade, 
        BindingResult validacao,  // ao validar este objeto recebe os erros gerados
        Model memoria) {
        cidades.removeIf(cidadeAtual -> 
                            cidadeAtual.getNome().equals(nomeAtual) && 
                            cidadeAtual.getEstado().equals(estadoAtual)
        );

        criar(cidade, validacao, memoria);

        return "redirect:/";
    }

    /* 
    @GetMapping("/")    
    public String listar(Model memoria) {
        // Set - collections não permite elementos repetidos (lista imutável)
        // of - cria lista com valores predefinidos
        var cidades = Set.of(
            new Cidade("Cornélio Procópio", "PR"),
            new Cidade("Assis", "SP"),
            new Cidade("Itajaí","SC")
        );

        // armazena valores que precisa enviar ao navegador (ui.Model)
        // funciona com uma memóeria compartilhada entre a View (pagina) e Controller
        // permitindo que os dados armazenados transitem entre as duas camadas
        memoria.addAttribute("listaCidades", cidades);

        return "/crud";
    }
     */
}
