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
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class IPokedexFactoryTest {
    @Mock private IPokemonMetadataProvider iPokemonMetadataProvider;
    @Mock private IPokemonFactory iPokemonFactory;
    @Mock private IPokedexFactory iPokedexFactory;
    @Mock private IPokedex iPokedex;
    
    /**
     * get iPokemonMetadataProvider
     * @return
     */
    public IPokemonMetadataProvider getIPokemonMetadataProvider() {
        return this.iPokemonMetadataProvider;
    }
    /**
     * set iPokemonMetadataProvider
     * @param iPokemonMetadataProvider
     */
    public void setIPokemonMetadataProvider(IPokemonMetadataProvider iPokemonMetadataProvider) {
        this.iPokemonMetadataProvider = iPokemonMetadataProvider;
    }
    
    /**
     * get iPokemonFactory
     * @return
     */
    public IPokemonFactory getIPokemonFactory() {
        return this.iPokemonFactory;
    }
    /**
     * set iPokemonFactory
     * @param iPokemonFactory
     */
    public void setPokemonFactory(IPokemonFactory iPokemonFactory) {
        this.iPokemonFactory = iPokemonFactory;
    }
    
    /**
     * get iPokedex
     * @return
     */
    public IPokedex getIPokedex() {
        return this.iPokedex;
    }
    /**
     * set iPokedex
     * @param iPokedex
     */
    public void setUnPokedex(IPokedex iPokedex) {
        this.iPokedex = iPokedex;
    }
    
    /**
     * get iPokedexFactory
     * @return
     */
    public IPokedexFactory getIPokedexFactory() {
        return this.iPokedexFactory;
    }
    /**
     * 
     * @param iPokedexFactory
     */
    public void setIPokedexFactory1(IPokedexFactory iPokedexFactory) {
        this.iPokedexFactory = iPokedexFactory;
    }
    
    /**
     * 
     * @throws PokedexException
     * @throws IOException
     */
    @Before
    public void setUp() throws PokedexException, IOException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(iPokemonFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory)).thenReturn(iPokedex);
    }
    
    @Test
	public void testCreatePokedex() {
		assertEquals(getIPokedex(),getIPokedexFactory().createPokedex(getIPokemonMetadataProvider(), getIPokemonFactory()));
		
	}
}
