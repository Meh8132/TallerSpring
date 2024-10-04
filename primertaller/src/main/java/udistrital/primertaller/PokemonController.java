package udistrital.primertaller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/view/{name}")
    public String mostrarPokemon(@PathVariable String name, Model model) {
        PokemonDTO pokemon = pokemonService.obtenerPokemon(name);
        model.addAttribute("pokemon", pokemon);
        return "pokemon"; // El nombre de la plantilla HTML a usar
    }
}

