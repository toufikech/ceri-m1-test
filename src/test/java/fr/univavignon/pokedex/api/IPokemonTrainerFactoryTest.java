package fr.univavignon.pokedex.api;
/**
 * 
 * @author toufik
 *
 */

import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
/**
 * 
 * @author toufik
 *
 */
public class IPokemonTrainerFactoryTest {

	@Mock private IPokemonMetadataProvider iPokemonMetadataProvider;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	/**
	 * setup
	 * @throws PokedexException
	 */
	@Before
	public void setUp() throws PokedexException {
		Mockito.when(IPokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException(""));
		Mockito.when(IPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"bulbizarre",126,126,90));
		Mockito.when(IPokemonMetadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException(""));
	}
	/**
	 * TEST
	 * @throws PokedexException
	 */
	@Test 
	public void testPokemonMetadata() throws PokedexException{
		PokemonMetadata pokemonMetadata = pokemonMetadataProviderMock.getPokemonMetadata(0); 
		assertEquals(126,pokemonMetadata.getAttack());
		assertEquals(126,pokemonMetadata.getDefense());
		assertEquals(0,pokemonMetadata.getIndex());
		assertEquals("bulbizarre",pokemonMetadata.getName());
		assertEquals(90,pokemonMetadata.getStamina());
	}
}
