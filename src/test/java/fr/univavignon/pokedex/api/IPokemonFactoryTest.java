package fr.univavignon.pokedex.api;

/**
 * @author toufik
 */

public class IPokemonFactoryTest {
	//bulbuzzare
	private Pokemon b = new Pokemon(0,"Bulbizarre", 126,126, 90,613, 64, 4000, 4,  56 );
	private static final Pokemon aquali = new Pokemon(134, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 0);
	@Mock private IPokemonFactory pokemonFactoryMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

	/**
	 * Getter IPokemonFactory
	 * @return
	 */
	protected IPokemonFactory getIPokemonFactory() {
		Mockito.when(pokemonFactoryMock.createPokemon(1, 613, 64, 4000, 4)).thenReturn(b);
		Mockito.when(pokemonFactoryMock.createPokemon(134, 2729, 202, 5000, 4)).thenReturn(aquali);
		return pokemonFactoryMock;
	}
	
	/**
	 * TEST
	 */
	@Test
	public void testCreatePokemonMetaData() {
		assertEquals(b, getIPokemonFactory().createPokemon(1, 613, 64, 4000, 4));
		assertEquals(aquali, getIPokemonFactory().createPokemon(134, 2729, 202, 5000, 4));
		
		assertEquals(0,b.getIndex());
		assertEquals(134,aquali.getIndex());
		assertEquals("Bulbizarre",b.getName());
		assertEquals("Aquali",aquali.getName());
		
		assertEquals(613, b.getCp());
		assertEquals(64, b.getHp());
		assertEquals(4000, b.getDust());
		assertEquals(4, b.getCandy());
		assertEquals(126,b.getAttack());
		assertEquals(126,b.getDefense());
		assertEquals(90,b.getStamina());
		assertEquals(56, b.getIv(),0);
	}

}
