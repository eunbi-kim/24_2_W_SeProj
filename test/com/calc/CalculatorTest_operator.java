package com.calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest_operator {

	Calculator calculator = new Calculator();
	
	@Test
	void testAdd() {
		assertEquals(9, calculator.add(4, 5));
	}

	@Test
	void testMinus() {
		assertEquals(-1, calculator.minus(4, 5));
	}

	
	@Test
	void testMulti() {
		assertEquals(20, calculator.multi(4, 5));
	}

	@Test
	void testDivide() throws Exception {
		assertEquals(2, calculator.divide(4, 2));
		assertThrows(Exception.class, () 
				-> calculator.divide(4, 0), 
				"0 예외 처리 발생");
		// calculator.divide(4, 0) 실행 시, Exception 여부만 확인
		// 세 번째 인자인 "0 예외 처리 발생"은은 테스트 실패 시 출력할 사용자 메시지
		// 모든 assert문에 사용자 메시지 추가 가능능
	}

	// Divide Error
	// exception 발생 여부 및 기대 결과(Divide Error 메시지) 동일 여부 확인 
	@Test
	public void testDeivide_exception() throws Exception {
		Exception exception = assertThrows(Exception.class, () 
				-> calculator.divide(4, 0));
		assertEquals("Divide Error", 
				exception.getMessage());
	}

	@Test
	void testCalculate_Positive() throws Exception {
		assertEquals(5, calculator.calculate("+", 2, 3));
		assertEquals(-1, calculator.calculate("-", 2, 3));
		assertEquals(6, calculator.calculate("*", 2, 3));
	}
	
	// calculate Error
	// assertThows : 예외 발생 여부만 확인할 경우 (사용자 정의 메시지 포함)
	@Test
	void testCalculate_errorOperator_checkException() throws Exception {
		assertThrows(Exception.class, () 
				-> calculator.calculate("&", 4, 2), 
				"Unsupported Operator");
	}

	// calculate Error
	// assertThrows & assertEquals
	// exception 발생 여부 및 기대 결과(Unsupported Operator) 동일 여부 확인
	@Test
	void testCalculate_errorOperator_checkFailMesseage() throws Exception {
		Exception exception = assertThrows(Exception.class, () 
				-> calculator.calculate("&", 4, 2));

		// 반한된 예외 객체의 메시지를 assertEquals로 비교
		assertEquals("Unsupported Operator", 
				exception.getMessage());
	}
	
	// 경계값 테스트 (int의 최대값) 
	@Test
	public void testCaculate_Max() throws Exception {
		assertEquals(Integer.MAX_VALUE, 
				calculator.add(Integer.MAX_VALUE, 0));
	}
}
