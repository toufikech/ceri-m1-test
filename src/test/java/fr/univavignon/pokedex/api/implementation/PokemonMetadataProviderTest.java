package fr.univavignon.pokedex.api;
import org.junit.Before;

import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.implementation.PokemonMetadataProvider;
/**
 * 
 * @author Toufik
 *
 */

public class PokemonMetadataProviderTest {
	@Before
	public void setUp(){
		this.iPokemonMetadataProvider = new PokemonMetadataProvider();
	}
}