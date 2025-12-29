package br.edu.utfpr.cp.espjava.crudcidades.cidade;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class CidadeController {

    private final CidadeRepository repository;

    private Set<Cidade> cidades;

    public CidadeController(final CidadeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")    
    public String listar(
        Model memoria, 
        Principal usuario, 
        HttpSession sessao, 
        HttpServletResponse response) {

        // Adicionando cookies
        response.addCookie(new Cookie("listar", LocalDateTime.now().toString()));

        // armazena valores que precisa enviar ao navegador (ui.Model)
        // funciona com uma memóeria compartilhada entre a View (pagina) e Controller
        // permitindo que os dados armazenados transitem entre as duas camadas

        // Converte cidade em cidadeentidade
        // utiliza o atributo repository para acessar as cidades armazenadas no banco 
        // converte cidadeEntidade em cidade fazendo DTO (que será exibida em tela)
        memoria.addAttribute("listaCidades", this.converteCidade(repository.findAll()));

        sessao.setAttribute("usuarioAtual", usuario.getName());
        
        return "/crud";
    }

    private List<Cidade> converteCidade(List<CidadeEntidade> cidades) {
        return cidades.stream()
               .map(cidade -> new Cidade(
                    cidade.getNome(), 
                    cidade.getEstado()))
                .collect(Collectors.toList());
    }

    @PostMapping("/criar")
    public String criar(
        @Valid Cidade cidade, 
        BindingResult validacao,  // ao validar este objeto recebe os erros gerados 
        Model memoria,
        HttpServletResponse response
    ) {

        response.addCookie(new Cookie("criar", LocalDateTime.now().toString()));

        if(validacao.hasErrors()) {

            // verifica a existências de erros de validação
            validacao
                .getFieldErrors()  // se houver erros, retorna lista de erros
                .forEach(
                    error -> memoria.addAttribute(
                        error.getField(), 
                        error.getDefaultMessage()) // retorna mensagem de erro definida para o erro ocorreido (definidas no arquivo properties)
                );

            // persistência só ocorre após passar pela validação

            memoria.addAttribute("nomeInformado", cidade.getNome()); // armazena valores informados para serem recuperados
            memoria.addAttribute("estadoInformado", cidade.getEstado());
            memoria.addAttribute("listaCidades", this.converteCidade(repository.findAll()));

            return "/crud";
        
        } else {
            repository.save(cidade.clonar()); // atribuito repositpry para persistir dados no banco (cidade convertida em cidadeEntidade)
        }

        return "redirect:/"; // redirecionamento para o metodo listar() por sua vez carrega a lista de cidades e a pagina crud.ftl
    }

    @GetMapping("/excluir")
    public String excluir(
        @RequestParam String nome,
        @RequestParam String estado,
        HttpServletResponse response
    ) {

        response.addCookie(new Cookie("Excluir", LocalDateTime.now().toString()));

        var cidadeEstadoEncontrada = repository.findByNomeAndEstado(nome, estado);
        
        cidadeEstadoEncontrada.ifPresent(repository::delete);

        return "redirect:/";
    }

    @GetMapping("/preparaAlterar")
    public String preparaAlterar(
        @RequestParam String nome,
        @RequestParam String estado,
        Model memoria
    ) {

        // Se existir uma cidade com os valores buscados, ela será armazenada em um objeto do tipo Optional
        var cidadeAtual = repository.findByNomeAndEstado(nome, estado);

        cidadeAtual.ifPresent(ciddadeEncontrada -> {
            memoria.addAttribute("cidadeAtual", ciddadeEncontrada); 
            memoria.addAttribute("listaCidades", this.converteCidade(repository.findAll()));  // busca no banco ao invés da lista
        });

        return "/crud";
    }

    @PostMapping("/alterar")
    public String alterar(
        @RequestParam String nomeAtual,
        @RequestParam String estadoAtual,
        Cidade cidade, 
        BindingResult validacao,  // ao validar este objeto recebe os erros gerados
        Model memoria,
        HttpServletResponse response) 
        {

            response.addCookie(new Cookie("Alterar", LocalDateTime.now().toString()));

            var cidadeAtual = repository.findByNomeAndEstado(nomeAtual, estadoAtual);

            if (cidadeAtual.isPresent()) {
                var ciddadeEncontrada = cidadeAtual.get();
                ciddadeEncontrada.setNome(cidade.getNome());
                ciddadeEncontrada.setEstado(cidade.getEstado());

                repository.saveAndFlush(ciddadeEncontrada);
            }

        return "redirect:/";
    }

    @GetMapping("/mostrar")
    @ResponseBody
    public String mostraCookie(@CookieValue String listar) {
        return "Ultimo acesso a método listar(): " + listar;
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
