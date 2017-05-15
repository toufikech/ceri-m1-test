package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import java.io.IOException;

import fr.univavignon.pokedex.implementation.PokemonFactoryTest;
/**
 * @author toufik
 */

public class PokemonFactoryTest extends IPokemonFactoryTest {
	@Override
	public IPokemonFactory getProvider() throws IOException {
		return pokemonFactory();
	}
}
