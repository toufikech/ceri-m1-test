package fr.univavignon.pokedex.api;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Toufik ECH CHALYOUAT
 *
 */

public class IPokemonMetadataProviderTest {
	
	@Mock private IPokedex pokedex;
	@Mock private IPokedexFactory pokdexFactory;
	@Mock private IPokemonTrainerFactory IPokemonTrainerFactory1;
	@Rule  public MockitoRule mockitoRule = MockitoJUnit.rule();

	private Pokemon pokemon = new Pokemon(0, "bulbizarre", 118, 118, 90, 613, 64, 4000, 4, 56);
	
}