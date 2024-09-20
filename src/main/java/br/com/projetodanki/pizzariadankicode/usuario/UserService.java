package br.com.projetodanki.pizzariadankicode.usuario;

import br.com.projetodanki.pizzariadankicode.config.CriptografiaSenha;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByLogin(login);
    }

    public DadosUsuarioCadastro criarUsuario(DadosUsuarioCadastro dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);

        //Criptografando a senha
        String senhaCriptografada = CriptografiaSenha.criptografia(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);

        repository.save(usuario);
        return modelMapper.map(usuario, DadosUsuarioCadastro.class);
    }
}
