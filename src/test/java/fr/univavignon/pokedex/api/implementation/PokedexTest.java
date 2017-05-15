package fr.univavignon.pokedex.api;
import fr.univavignon.pokedex.api.IPokedexTest;

/**
 * 
 * @author toufik
 *
 */
public class PokedexTest extends IPokedexTest {

	@Before
	public void setUp() {
		pokedexMock = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
	}
}
