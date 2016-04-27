package com.spaceprobe.controllers.parsers;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class SpaceProbeParserTest extends TestCase {

	@Test
	public void testParserRequestBodyStringWithSuccess() {
		
		SpaceProbeParser parser = new SpaceProbeParser();
		
		List<List<String>> list = parser.parse("5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");
		
		assertEquals(list.size(), 5);
		assertEquals(list.toString(), "[[5, 5], [1, 2, N], [L, M, L, M, L, M, L, M, M], [3, 3, E], [M, M, R, M, M, R, M, R, R, M]]");
		
	}

}
