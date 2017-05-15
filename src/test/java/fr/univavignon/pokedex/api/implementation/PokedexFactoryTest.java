package fr.univavignon.pokedex.api;
import fr.univavignon.pokedex.api.IPokedexFactoryTest;
/**
 * 
 * @author toufik
 *
 */
public class PokedexFactoryTest extends IPokedexFactoryTest {
	@Before
	public void setUp() throws Exception {
		pokedexFactoryTest = new PokedexFactory();
		pokemonMetadataProvider = new PokemonMetadataProvider();
		pokemonFactory = new PokemonFactory();
		pokedex = null;
	}
}
