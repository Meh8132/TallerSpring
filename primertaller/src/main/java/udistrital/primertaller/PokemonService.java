package udistrital.primertaller;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;
    private final Gson gson;

    public PokemonService(RestTemplate restTemplate, Gson gson) {
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    public PokemonDTO obtenerPokemon(String name){
        String response = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name, String.class);
        return gson.fromJson(response, PokemonDTO.class);
    }
}
