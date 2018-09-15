package testsort;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import radixsort.RadixSort;

public class TestRadixSort {

	/**
	 * Test sorting array with 1 element, 1 digit.
	 */
	@Test
	public final void testOneElement() {
		int[] a = { 1 };
		RadixSort.radixSort(a, 1);
		assertTrue("Error sorting one element", a[0] == 1);
	}

	/**
	 * Test sorting array with 2 elements, max 2 digits.
	 */
	@Test
	public final void testTwoElements() {
		int[] a = { 13, 1 };
		RadixSort.radixSort(a, 2);
		assertTrue("Wrong order, two elements", a[0] == 1);
		assertTrue("Wrong order, two elements", a[1] == 13);
	}

	/**
	 * Test sorting array with 10 elements, max 2 digits.
	 */
	@Test
	public final void testTenSmallElements() {
		int[] a = { 10, 2, 5, 7, 4, 9, 8, 6, 1, 3 };
		RadixSort.radixSort(a, 2);
		for (int i = 0; i < 10; i++) {
			assertTrue("Wrong order, ten elements", a[i] == i + 1);
		}
	}

	/**
	 * Test sorting array with 13 elements, max 3 digits.
	 */
	@Test
	public final void test13Elements() {
		int[] correct = { 1, 10, 44, 51, 96, 109, 122, 178, 236, 567, 674, 674,
				721 };
		int[] a = new int[13];
		a[0] = correct[12];
		a[1] = correct[1];
		a[2] = correct[3];
		a[3] = correct[6];
		a[4] = correct[11];
		a[5] = correct[4];
		a[6] = correct[5];
		a[7] = correct[2];
		a[8] = correct[8];
		a[9] = correct[7];
		a[10] = correct[0];
		a[11] = correct[9];
		a[12] = correct[10];

		RadixSort.radixSort(a, 3);
		for (int i = 0; i <= 12; i++) {
			assertTrue("Wrong order, 13 elements", a[i] == correct[i]);
		}
	}

	/**
	 * Test sorting 100 000 integers with maximum 7 figures.
	 */
	@Test
	public final void testRandom() {
		int[] a = new int[100000];
		Random r = new Random();
		for (int i = 0; i <= 99999; i++) {
			a[i] = r.nextInt(9999999);
		}
		RadixSort.radixSort(a, 7);
		for (int i = 0; i <= 99998; i++) {
			assertTrue("Wrong order", a[i] <= a[i + 1]);
		}
	}

}
