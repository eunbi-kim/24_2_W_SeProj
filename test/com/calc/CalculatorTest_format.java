package com.calc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CalculatorTest_format {

	Calculator calculator = new Calculator();
	
	// assertEquals : 개별 요소 검증
	@Test
	void testParseInput_individualCheck() throws Exception {
		String[] result = calculator.parseInput("2 + 3");
		
		assertEquals("2", result[0]);
		assertEquals("+", result[1]);
		assertEquals("3", result[2]);
	}
	
	// assertEquals : list로 검증
	@Test
	void testParseInput_listCheck() throws Exception {
		String[] result = calculator.parseInput("2 + 3");
		
		assertEquals(Arrays.asList("2", "+", "3"), 
				Arrays.asList(result));
	}

	// assertEquals: 개별 요소 검증 (반복문 사용)
	@Test
	public void testParseInput_positive_LoopCheck() throws Exception {
		String[] expected = { "2", "+", "3" };
		String[] result = calculator.parseInput("2 + 3");

		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], result[i], "배열 요소가 예상 값과 다릅니다.");
		}
	}
	
	// assertArrayEquals : 두 배열이 동일한지 확인
	// 예상 배열 {"2", "+", "3"}과 메서드 결과 배열 비교
	@Test
	void testParseInput_array() throws Exception {
		String[] result = calculator.parseInput("2 + 3");
		
		assertArrayEquals(new String[] { "2", "+", "3" }, 
				result,
				"배열이 예상 값과 다릅니다");
	}
	
	// null 입력 시 예외 처리 확인
	// 현재, null 예외 처리를 하지 않았으므로 "테스트 실패패"
	@Test
	void testParseInput_nullAndEmpty() throws Exception {
		Exception nullException = 
				assertThrows(Exception.class, () ->
				calculator.parseInput(null));
		assertEquals("null은 입력 불가", 
				nullException.getMessage());
	}
	
}
