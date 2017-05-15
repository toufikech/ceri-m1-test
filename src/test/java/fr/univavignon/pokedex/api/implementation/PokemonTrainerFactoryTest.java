package fr.univavignon.pokedex.api;
import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;
/**
 * 
 * @author toufik
 *
 */

public class PokemonTrainerFactoryTest extends IPokemonTrainerFactoryTest {
	
	
	@Test
	public void test() throws PokedexException, MalformedURLException, IOException, InterruptedException {

		PokemonTrainerFactory poketrainerfactoryImp = new PokemonTrainerFactory();
		Team team=Team.INSTINCT;
		this.setUp();
		assertEquals("Ondine",poketrainerfactoryImp.createTrainer("Ondine",team,pokedexFactory).getName());
		assertEquals(team,poketrainerfactoryImp.createTrainer("Ondine",team,pokedexFactory).getTeam());

	
	}
}