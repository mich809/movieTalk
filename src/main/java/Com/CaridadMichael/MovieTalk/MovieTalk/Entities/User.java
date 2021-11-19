package Com.CaridadMichael.MovieTalk.MovieTalk.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Component
public class User {

    @Id
    @NotBlank
    @Size(min = 4)
    private String username;  
    @NotBlank
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Set<Role> role ;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_MOVIES",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "movie_id")
            }
    )
    private Set<Movie> movies = new HashSet<Movie>();
    
    


}