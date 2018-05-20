package org.bienestar.cocina.autocorrect;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class SpellFixerTest {

	private ResourceReader reader;
	private SpellFixer spelling;

	public SpellFixerTest() throws IOException {
		super();
		String filePath = new File("").getAbsolutePath();
		reader = new ResourceReader(filePath.concat(File.separator + "big.txt"));
		spelling = new SpellFixer(reader.getWords());
	}

	@Test
	public void inputa() {
		List<String> result = spelling.getBestFit("a");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.contains("Agua"));
	}

	@Test
	public void inputA() {
		List<String> result = spelling.getBestFit("A");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.contains("Agua"));
	}

	@Test
	public void inputZ() {
		List<String> result = spelling.getBestFit("Z");
		assertTrue(result.contains("Azúcar"));
	}

	@Test
	public void inputAzu() {
		List<String> result = spelling.getBestFit("Azu");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.size() == 1);
	}
	
	//input inteligente 2.0
	@Test
	public void inputa20() {//te con leche
		List<String> result = spelling.getBestFit("a");
		assertTrue(result.indexOf("Azúcar")==0);
		assertTrue(result.indexOf("Agua")==1);
		assertTrue(result.indexOf("Arroz")==2);
		assertTrue(result.indexOf("Carne Picada")==3);
	}

	@Test
	public void inputz20Te() {//te con leche
		List<String> result = spelling.getBestFit("z");
		assertTrue(result.indexOf("Azúcar")==0);
		assertTrue(result.indexOf("Arroz")==1);
	}
	
	@Test
	public void inputz20Albondiga() {//Albondiga
		List<String> result = spelling.getBestFit("z");
		assertTrue(result.indexOf("Azúcar")==1);
		assertTrue(result.indexOf("Arroz")==0);
	}
	@Test
	public void input20Clbondiga() {//Albondiga
		List<String> result = spelling.getBestFit("c");
		assertTrue(result.indexOf("Carne Picada")==0);
		assertTrue(result.indexOf("Azúcar")==1);
	}
	@Test
	public void input20CTe() {//Te con leche
		List<String> result = spelling.getBestFit("c");
		assertTrue(result.indexOf("Azúcar")==0);
		assertTrue(result.indexOf("Carne Picada")==1);
	}
	
	@Test
	public void input20rTe() {//Te con leche
		List<String> result = spelling.getBestFit("r");
		assertTrue(result.indexOf("Azúcar")==0);
		assertTrue(result.indexOf("Carne Picada")==1);
	}
	
	@Test
	public void input20rAlbondiga() {//Albondiga
		List<String> result = spelling.getBestFit("r");
		assertTrue(result.indexOf("Carne Picada")==0);
		assertTrue(result.indexOf("Azúcar")==1);
	}
	@Test
	public void input20pAlbondiga() {//Albondiga
		List<String> result = spelling.getBestFit("p");
		assertTrue(result.indexOf("Carne Picada")==0);
		assertTrue(result.indexOf("Leche en Polvo")==1);
	}
	
	@Test
	public void input20pTe() {//Te con leche
		List<String> result = spelling.getBestFit("p");
		assertTrue(result.indexOf("Leche en Polvo")==0);
		assertTrue(result.indexOf("Carne Picada")==1);
	}
	
	@Test
	public void input20AzuTe() {//te con leche
		List<String> result = spelling.getBestFit("Azu");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.size() == 1);
	}
	
	@Test
	public void input20AzuAlbondiga() {//Albondiga
		List<String> result = spelling.getBestFit("Azu");
		assertTrue(result.contains("Azúcar"));
		assertTrue(result.size() == 1);
	}
}
