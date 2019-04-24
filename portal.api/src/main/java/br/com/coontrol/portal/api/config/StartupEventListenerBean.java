package br.com.coontrol.portal.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.coontrol.portal.model.Usuario;
import br.com.coontrol.portal.api.repository.UsuarioRepository;

@Component
public class StartupEventListenerBean {
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(usuarioRepository.findByUsuario("coontrol") == null) {
            Usuario user = new Usuario();
            user.setUsuario("coontrol");
            user.setSenha("12345");
            user.setRole("ROLE_USER");
            usuarioRepository.save(user);
            
            Usuario user1 = new Usuario();
            user1.setUsuario("kaue");
            user1.setSenha("12345");
            user1.setRole("ROLE_ADMIN");
            usuarioRepository.save(user1);
        }
    }

}
