package fr.univavignon.pokedex.api;

/**
 * @author toufik
 */

public class IPokemonFactoryTest {
	//bulbuzzare
	private Pokemon b = new Pokemon(0,"Bulbasaur", 126,126, 90,613, 64, 4000, 4,  56 );
	private static final Pokemon vaporeon = new Pokemon(134, "Vaporeon", 186, 168, 260, 2729, 202, 5000, 4, 0);
	@Mock private IPokemonFactory pokemonFactoryMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

	/**
	 * Getter IPokemonFactory
	 * @return
	 */
	protected IPokemonFactory getIPokemonFactory() {
		Mockito.when(pokemonFactoryMock.createPokemon(1, 613, 64, 4000, 4)).thenReturn(b);
		Mockito.when(pokemonFactoryMock.createPokemon(134, 2729, 202, 5000, 4)).thenReturn(vaporeon);
		return pokemonFactoryMock;
	}
	
	/**
	 * TEST
	 */
	@Test
	public void testCreatePokemon() {
		assertEquals(b, getIPokemonFactory().createPokemon(1, 613, 64, 4000, 4));
		assertEquals(vaporeon, getIPokemonFactory().createPokemon(134, 2729, 202, 5000, 4));
	}

}
