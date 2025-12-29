package br.edu.utfpr.cp.espjava.crudcidades;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // habilita o uso de recursos WebSecurity do Spring
@Configuration // indica que a classe carrega configurações que devem ser usadas pelo Spring
public class SecurityConfig extends WebSecurityConfiguration {

    /* 
    // criando usuários programaticamente (sem acesso a banco)::
    @Bean
    public InMemoryUserDetailsManager configure() throws Exception {
        UserDetails john = User.withUsername("john")
                                    .password(cifrador().encode("test123"))
                                    .roles("listar")
                                    .build();
        UserDetails anna = User.withUsername("anna")
                                     .password(cifrador().encode("test123"))
                                     .roles("admin")
                                     .build();
        
        return new InMemoryUserDetailsManager(john, anna);

    }
    */

    /* 
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/").hasAnyAuthority("listar", "admin")
            .antMatchers("/criar").hasAuthority("criar", "admin")
            .antMatchers("/criar").hasAuthority("admin")
            .antMatchers("/excluir").hasAuthority("admin")
            .antMatchers("/preparaAlterar").hasAuthority("admin")
            .antMatchers("/alterar").hasAuthority("admin")
            .anyRequest("/mostrar").authenticated()
            .anyRequest().denyAll()
                .and()
            .formLogin()
            .loginPage("/login.html").permiteAll()
            .defaultSucessUrl("/", false)
                .and()
            .logout().permiteAll();
    }
     */
   
    // Configurando autorização 
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(
                    auth -> {
                        // matcher mapeia uma ou mais URLs para os papéis que definem sua autorização
                        auth.requestMatchers("/").hasAnyRole("listar", "admin");
                        auth.requestMatchers("/criar", "excluir", "/alterar", "preparaAlterar").hasRole("admin");
                        auth.requestMatchers("/mostrar").authenticated();
                        auth.anyRequest().denyAll(); // bloqueia qualquer URL não definida anteriormente
                    }
                ).csrf(AbstractHttpConfigurer::disable)
                .formLogin(
                    form -> form.loginPage("/login.html").permitAll()
                )
                .logout(logout -> logout.permitAll()) // Qualquer pode ter acesso a página de login
                .build();       
    }
    
    @Bean // @Bean: o spring boot irá gerenciar automaticamente a configuração definida para o metodo
    public PasswordEncoder cifrador() {
        return new BCryptPasswordEncoder(); // Algoritmo para cifragem
    }

    /*
        A classe org.springframework.security.authentication.event.
        InteractiveAuthenticationSuccessEvent.class representa um evento que é disparado 
        pelo Spring Boot quando o usuário loga na aplicação (por isso AuthenticationSucess
        no nome da classe). A anotação serve como um inscrito, que ouve esse tipo de evento.
        O próprio framework cuida de tudo e, quando o evento é disparado, 
        o método que definimos entra em ação, imprimindo o nome do usuário na
        console do sistema.
    */
    @EventListener(InteractiveAuthenticationSuccessEvent.class)
    public void printUsuarioAtual(InteractiveAuthenticationSuccessEvent event) {

        var usuario = event.getAuthentication().getName();

        System.out.println(usuario);
    }

    
    @EventListener(ApplicationReadyEvent.class)
    public void printSenhas() {
        System.out.println("* * * * * * " + this.cifrador().encode("test123"));
    }
    
    
}
