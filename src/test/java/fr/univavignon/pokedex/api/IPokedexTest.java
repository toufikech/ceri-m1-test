package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author toufik
 *
 */
public class IPokedexTest {
	@Mock private IPokedex iPokedex;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

	private Pokemon bulbizarre = new Pokemon(0, "bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
	private Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
	private PokemonMetadata bulbizarreData = new PokemonMetadata(0,"bulbizarre",126,126,90);
	
	private List<Pokemon> listPokemon = new ArrayList<Pokemon>();
	
	@Before
	public void setUp() throws PokedexException {
		listPokemon.add(bulbizarre);
		Mockito.when(iPokedex.size()).thenReturn(0);
		Mockito.when(iPokedex.addPokemon(bulbizarre)).thenReturn(0);
		Mockito.when(iPokedex.addPokemon(aquali)).thenReturn(1);
		Mockito.when(iPokedex.getPokemon(0)).thenReturn(bulbizarre);
		Mockito.when(iPokedex.getPokemons()).thenReturn(listPokemon);
		Mockito.when(iPokedex.getPokemon(-1)).thenThrow(new PokedexException(""));
		
		List<Pokemon> pokemonsSortedByName = new ArrayList<Pokemon>();
		pokemonsSortedByName.add(aquali);
		pokemonsSortedByName.add(bulbizarre);
		List<Pokemon> pokemonsSortedByCP = new ArrayList<Pokemon>();
		pokemonsSortedByCP.add(bulbizarre);
		pokemonsSortedByCP.add(aquali);
		List<Pokemon> pokemonsSortedByIndex = new ArrayList<Pokemon>();
		pokemonsSortedByIndex.add(bulbizarre);
		pokemonsSortedByIndex.add(aquali);
		Mockito.when(iPokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemonsSortedByName);
		Mockito.when(iPokedex.getPokemons(PokemonComparators.CP)).thenReturn(pokemonsSortedByCP);
		Mockito.when(iPokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemonsSortedByIndex);
		
		Mockito.when(iPokedex.getPokemonMetadata(0)).thenReturn(bulbizarreData);
		Mockito.when(iPokedex.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
		
	}
	
	@Test(expected=PokedexException.class)
	public void testPokemonException() throws PokedexException{
		iPokedex.getPokemon(-1);
	}
	
	@Test 
	public void testPokedex() throws PokedexException{
		
		assertEquals(0, iPokedex.size());
		assertEquals(0, iPokedex.addPokemon(bulbizarre));
		assertEquals(bulbizarre, iPokedex.getPokemon(0));
		assertEquals(1, iPokedex.getPokemons().size());
		
	}
	
	@Test 
	public void testCPComparatorPokedex() {
		
		assertEquals(0, iPokedex.size());
		assertEquals(0, iPokedex.addPokemon(bulbizarre));
		assertEquals(1, iPokedex.addPokemon(aquali));
		
		List<Pokemon> pokemonsSortedByCP = iPokedex.getPokemons(PokemonComparators.CP);
		assertEquals(0, pokemonsSortedByCP.get(0).getIndex());
		assertEquals(133, pokemonsSortedByCP.get(1).getIndex());
		
	}
	
	
	@Test 
	public void testIndexComparatorPokedex() {
		
		assertEquals(0, iPokedex.size());
		assertEquals(0, iPokedex.addPokemon(bulbizarre));
		assertEquals(1, iPokedex.addPokemon(aquali));
		
		List<Pokemon> pokemonsSortedByIndex = iPokedex.getPokemons(PokemonComparators.INDEX);
		assertEquals(0, pokemonsSortedByIndex.get(0).getIndex());
		assertEquals(133, pokemonsSortedByIndex.get(1).getIndex());
		
	}
	
	/**
	 * TEST 
	 * @throws PokedexException
	 */
	@Test 
	//public void testGetPokemonMetadataWithPokedex() throws PokedexException {
	public void testGetPokemonDataPokedex() throws PokedexException {
		PokemonMetadata pokemonDataCreate = iPokedex.getPokemonMetadata(0);
		assertEquals(bulbizarreData.getAttack(), pokemonDataCreate.getAttack());
		assertEquals(bulbizarreData.getDefense(), pokemonDataCreate.getDefense());
		assertEquals(bulbizarreData.getIndex(), pokemonDataCreate.getIndex());
		assertEquals(bulbizarreData.getName(), pokemonDataCreate.getName());
	}
	
	/**
	 * TEST creation pokemon pokedex
	 */
	@Test 
	public void testCreatePokemonPokedex() {
		Pokemon pokemon = iPokedex.createPokemon(0, 613, 64, 4000, 4);
		assertEquals(bulbizarre.getAttack(), pokemon.getAttack());
		assertEquals(bulbizarre.getDefense(), pokemon.getDefense());
		assertEquals(bulbizarre.getIndex(), pokemon.getIndex());
		assertEquals(bulbizarre.getName(), pokemon.getName());
		assertEquals(bulbizarre.getCandy(), pokemon.getCandy());
		assertEquals(bulbizarre.getCp(), pokemon.getCp());
		assertEquals(bulbizarre.getName(), pokemon.getName());
		assertEquals(bulbizarre.getIv(), pokemon.getIv());
		assertEquals(bulbizarre.getHp(), pokemon.getHp());
		assertEquals(bulbizarre.getStamina(), pokemon.getStamina());
	}
}
