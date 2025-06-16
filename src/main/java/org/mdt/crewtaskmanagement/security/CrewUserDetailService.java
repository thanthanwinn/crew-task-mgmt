package org.mdt.crewtaskmanagement.security;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.model.Crew;
import org.mdt.crewtaskmanagement.model.User;
import org.mdt.crewtaskmanagement.repository.CrewRepository;
import org.mdt.crewtaskmanagement.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrewUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User crew =  userRepository.findByEmail(username);
      if(crew == null) {
          throw new UsernameNotFoundException(username);
      }
        return new org.springframework.security.core.userdetails.User(
                crew.getEmail(),
                crew.getPassword(), // must be encoded!
                crew.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
                        .collect(Collectors.toList())
        );
    }
}
