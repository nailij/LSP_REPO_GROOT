package org.howard.edu.lsp.assignment6;
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
 
/**
 * Assignment 6: JUnit 5 tests for IntegerSet.
 *
 * Complete every TODO. Do not remove, rename, or disable test methods.
 * Each test must contain meaningful assertions and run independently.
 */
public class IntegerSetTest {
 
    // ===== clear() =====
 
    /**
     * Create a populated set; call clear(); assert that it is empty and its length is zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsPopulatedSet() {
        // Arrange
        IntegerSet set = setOf(10, 20, 30);

        // Act
        set.clear();

        // Assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }
 
    /**
     * Clear an already empty set; verify it remains empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsEmptySet() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        set.clear();

        // Assert
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }
 
    // ===== length() =====
 
    /**
     * Add repeated and unique integers; assert the number of distinct elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthCountsUniqueElements() {
        // Arrange
        IntegerSet set = setOf(7, 7, -2, 5, -2, 5, 10);

        // Act
        int length = set.length();

        // Assert
        assertEquals(4, length);
    }
 
    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        int length = set.length();

        // Assert
        assertEquals(0, length);
    }
 
    // ===== equals() =====
 
    /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsIgnoresInsertionOrder() {
        // Arrange
        IntegerSet first = setOf(1, 5, 3);
        IntegerSet second = setOf(3, 1, 5);

        // Act and Assert
        assertTrue(first.equals(second));
        assertTrue(second.equals(first));
    }
 
    /**
     * Construct sets of equal length with different elements; assert inequality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsDetectsDifferentContents() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(1, 2, 4);

        // Act and Assert
        assertFalse(first.equals(second));
        assertFalse(second.equals(first));
    }
 
    /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsEmptySetsEqual() {
        // Arrange
        IntegerSet first = new IntegerSet();
        IntegerSet second = new IntegerSet();

        // Act and Assert
        assertTrue(first.equals(second));
        assertTrue(second.equals(first));
    }
 
    /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsSameObjectAndDifferentSizes() {
        // Arrange
        IntegerSet first = setOf(2, 4);
        IntegerSet second = setOf(2, 4, 6);

        // Act and Assert
        assertTrue(first.equals(first));
        assertFalse(first.equals(second));
        assertFalse(second.equals(first));
    }
 
    // ===== contains() =====
 
    /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsPresentAndAbsent() {
        // Arrange
        IntegerSet set = setOf(-4, 0, 8);

        // Act and Assert
        assertTrue(set.contains(8));
        assertTrue(set.contains(-4));
        assertFalse(set.contains(9));
    }
 
    /**
     * Verify an empty set does not contain an arbitrary integer.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsEmptySetContainsNothing() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act and Assert
        assertFalse(set.contains(0));
        assertFalse(set.contains(-10));
    }
 
    // ===== largest() =====
 
    /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet set = setOf(-50, 0, 17, -3, 9);

        // Act
        int largest = set.largest();

        // Assert
        assertEquals(17, largest);
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> set.largest());
    }
 
    // ===== smallest() =====
 
    /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        // Arrange
        IntegerSet set = setOf(10, -15, 0, 7, -2);

        // Act
        int smallest = set.smallest();

        // Assert
        assertEquals(-15, smallest);
    }
 
    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act and Assert
        assertThrows(IllegalStateException.class, () -> set.smallest());
    }
 
    // ===== add() =====
 
    /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        set.add(12);
        set.add(12);
        set.add(12);

        // Assert
        assertEquals(1, set.length());
        assertTrue(set.contains(12));
    }
 
    /**
     * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        set.add(Integer.MIN_VALUE);
        set.add(Integer.MAX_VALUE);
        set.add(0);

        // Assert
        assertEquals(3, set.length());
        assertTrue(set.contains(Integer.MIN_VALUE));
        assertTrue(set.contains(Integer.MAX_VALUE));
        assertTrue(set.contains(0));
    }
 
    // ===== remove() =====
 
    /**
     * Remove a present element; verify it is absent and others remain.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveRemovesExistingElement() {
        // Arrange
        IntegerSet set = setOf(3, 6, 9);

        // Act
        set.remove(6);

        // Assert
        assertFalse(set.contains(6));
        assertTrue(set.contains(3));
        assertTrue(set.contains(9));
        assertEquals(2, set.length());
    }
 
    /**
     * Remove an absent element; verify the set is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveIgnoresAbsentElement() {
        // Arrange
        IntegerSet set = setOf(3, 6, 9);

        // Act
        set.remove(42);

        // Assert
        assertEquals(3, set.length());
        assertTrue(set.contains(3));
        assertTrue(set.contains(6));
        assertTrue(set.contains(9));
    }
 
    // ===== union() =====
 
    /**
     * Verify union() contains all distinct elements from two overlapping sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionOverlappingSets() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 4, 5);

        // Act
        IntegerSet result = first.union(second);

        // Assert
        assertEquals("[1, 2, 3, 4, 5]", result.toString());
        assertEquals(5, result.length());
    }
 
    /**
     * Verify union with an empty set and with the same object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionEmptyAndSameOperand() {
        // Arrange
        IntegerSet set = setOf(3, 1, 2);
        IntegerSet empty = new IntegerSet();

        // Act
        IntegerSet withEmpty = set.union(empty);
        IntegerSet emptyFirst = empty.union(set);
        IntegerSet withSelf = set.union(set);

        // Assert
        assertEquals("[1, 2, 3]", withEmpty.toString());
        assertEquals("[1, 2, 3]", emptyFirst.toString());
        assertEquals("[1, 2, 3]", withSelf.toString());
    }
 
    /**
     * Verify both inputs remain unchanged; modify the result and verify the inputs are still unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testUnionDoesNotMutateInputs() {
        // Arrange
        IntegerSet first = setOf(1, 2);
        IntegerSet second = setOf(2, 3);

        // Act
        IntegerSet result = first.union(second);

        // Assert: neither operand changes, even after modifying the result
        assertNotSame(first, result);
        assertNotSame(second, result);
        assertEquals("[1, 2]", first.toString());
        assertEquals("[2, 3]", second.toString());
        result.add(99);
        result.remove(2);
        assertEquals("[1, 2]", first.toString());
        assertEquals("[2, 3]", second.toString());
    }
 
    // ===== intersect() =====
 
    /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3, 4);
        IntegerSet second = setOf(2, 4, 6);

        // Act
        IntegerSet result = first.intersect(second);

        // Assert
        assertEquals("[2, 4]", result.toString());
        assertEquals(2, result.length());
    }
 
    /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectDisjointAndSameOperand() {
        // Arrange
        IntegerSet first = setOf(1, 2);
        IntegerSet disjoint = setOf(3, 4);

        // Act
        IntegerSet noOverlap = first.intersect(disjoint);
        IntegerSet selfOverlap = first.intersect(first);

        // Assert
        assertTrue(noOverlap.isEmpty());
        assertEquals("[1, 2]", selfOverlap.toString());
    }
 
    /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(2, 3, 4);

        // Act
        IntegerSet result = first.intersect(second);

        // Assert
        assertEquals("[2, 3]", result.toString());
        assertNotSame(first, result);
        assertNotSame(second, result);
        result.remove(2);
        result.add(99);
        assertEquals("[1, 2, 3]", first.toString());
        assertEquals("[2, 3, 4]", second.toString());
    }
 
    // ===== diff() =====
 
    /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 4);

        // Act
        IntegerSet firstMinusSecond = first.diff(second);
        IntegerSet secondMinusFirst = second.diff(first);

        // Assert
        assertEquals("[1, 2]", firstMinusSecond.toString());
        assertEquals("[4]", secondMinusFirst.toString());
    }
 
    /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        // Arrange
        IntegerSet set = setOf(1, 2);
        IntegerSet empty = new IntegerSet();

        // Act
        IntegerSet minusEmpty = set.diff(empty);
        IntegerSet emptyMinusSet = empty.diff(set);
        IntegerSet minusSelf = set.diff(set);

        // Assert
        assertEquals("[1, 2]", minusEmpty.toString());
        assertTrue(emptyMinusSet.isEmpty());
        assertTrue(minusSelf.isEmpty());
    }
 
    /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 4);

        // Act
        IntegerSet result = first.diff(second);

        // Assert
        assertEquals("[1, 2]", result.toString());
        assertNotSame(first, result);
        assertNotSame(second, result);
        result.remove(1);
        result.add(99);
        assertEquals("[1, 2, 3]", first.toString());
        assertEquals("[3, 4]", second.toString());
    }
 
    // ===== complement() =====
 
    /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 4, 5);

        // Act
        IntegerSet result = first.complement(second);

        // Assert: complement is second minus first, not first minus second
        assertEquals("[4, 5]", result.toString());
        assertEquals(2, result.length());
    }
 
    /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        // Arrange
        IntegerSet set = setOf(1, 2);
        IntegerSet empty = new IntegerSet();

        // Act
        IntegerSet emptyReceiver = empty.complement(set);
        IntegerSet emptyArgument = set.complement(empty);

        // Assert
        assertEquals("[1, 2]", emptyReceiver.toString());
        assertTrue(emptyArgument.isEmpty());
    }
 
    /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        // Arrange
        IntegerSet first = setOf(1, 2);
        IntegerSet second = setOf(2, 3, 4);

        // Act
        IntegerSet result = first.complement(second);

        // Assert
        assertEquals("[3, 4]", result.toString());
        assertNotSame(first, result);
        assertNotSame(second, result);
        result.remove(3);
        result.add(99);
        assertEquals("[1, 2]", first.toString());
        assertEquals("[2, 3, 4]", second.toString());
    }
 
    // ===== isSubsetOf() =====
 
    /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        // Arrange
        IntegerSet subset = setOf(1, 2);
        IntegerSet superset = setOf(1, 2, 3);

        // Act and Assert
        assertTrue(subset.isSubsetOf(superset));
        assertFalse(superset.isSubsetOf(subset));
    }
 
    /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        // Arrange
        IntegerSet first = setOf(1, 4);
        IntegerSet second = setOf(1, 2, 3);

        // Act and Assert
        assertFalse(first.isSubsetOf(second));
    }
 
    /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        // Arrange
        IntegerSet first = setOf(5, 1, 3);
        IntegerSet second = setOf(3, 5, 1);

        // Act and Assert
        assertTrue(first.isSubsetOf(second));
        assertTrue(second.isSubsetOf(first));
    }
 
    /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        // Arrange
        IntegerSet empty = new IntegerSet();
        IntegerSet populated = setOf(1, 2);

        // Act and Assert
        assertTrue(empty.isSubsetOf(populated));
        assertFalse(populated.isSubsetOf(empty));
        assertTrue(empty.isSubsetOf(empty));
    }
 
    // ===== isDisjoint() =====
 
    /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        // Arrange
        IntegerSet first = setOf(1, 3);
        IntegerSet second = setOf(2, 4);

        // Act and Assert
        assertTrue(first.isDisjoint(second));
        assertTrue(second.isDisjoint(first));
    }
 
    /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 4);

        // Act and Assert
        assertFalse(first.isDisjoint(second));
        assertFalse(second.isDisjoint(first));
    }
 
    /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        // Arrange
        IntegerSet empty = new IntegerSet();
        IntegerSet populated = setOf(1, 2);

        // Act and Assert
        assertTrue(empty.isDisjoint(populated));
        assertTrue(populated.isDisjoint(empty));
        assertFalse(populated.isDisjoint(populated));
        assertTrue(empty.isDisjoint(empty));
    }
 
    // ===== symmetricDiff() =====
 
    /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 4, 5);

        // Act
        IntegerSet result = first.symmetricDiff(second);

        // Assert
        assertEquals("[1, 2, 4, 5]", result.toString());
        assertEquals(4, result.length());
    }
 
    /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIdenticalSets() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 2, 1);

        // Act
        IntegerSet result = first.symmetricDiff(second);

        // Assert
        assertTrue(result.isEmpty());
        assertEquals(0, result.length());
    }
 
    /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        // Arrange
        IntegerSet first = setOf(1, 2);
        IntegerSet empty = new IntegerSet();
        IntegerSet disjoint = setOf(3, 4);

        // Act
        IntegerSet withEmpty = first.symmetricDiff(empty);
        IntegerSet emptyFirst = empty.symmetricDiff(first);
        IntegerSet withDisjoint = first.symmetricDiff(disjoint);

        // Assert
        assertEquals("[1, 2]", withEmpty.toString());
        assertEquals("[1, 2]", emptyFirst.toString());
        assertEquals("[1, 2, 3, 4]", withDisjoint.toString());
    }
 
    /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        // Arrange
        IntegerSet first = setOf(1, 2, 3);
        IntegerSet second = setOf(3, 4);

        // Act
        IntegerSet result = first.symmetricDiff(second);

        // Assert
        assertEquals("[1, 2, 4]", result.toString());
        assertNotSame(first, result);
        assertNotSame(second, result);
        result.remove(1);
        result.add(99);
        assertEquals("[1, 2, 3]", first.toString());
        assertEquals("[3, 4]", second.toString());
    }
 
    // ===== isEmpty() =====
 
    /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act and Assert
        assertTrue(set.isEmpty());
    }
 
    /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        // Arrange
        IntegerSet set = setOf(10);

        // Act and Assert
        assertFalse(set.isEmpty());
    }
 
    /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        // Arrange
        IntegerSet set = setOf(10, 20);

        // Act
        set.clear();

        // Assert
        assertTrue(set.isEmpty());
    }
 
    // ===== toString() =====
 
    /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        // Arrange
        IntegerSet set = setOf(10, -3, 5, 0, -20);

        // Act
        String formatted = set.toString();

        // Assert
        assertEquals("[-20, -3, 0, 5, 10]", formatted);
    }
 
    /**
     * Verify an empty set formats as [].
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testToStringEmptyFormatting() {
        // Arrange
        IntegerSet set = new IntegerSet();

        // Act
        String formatted = set.toString();

        // Assert
        assertEquals("[]", formatted);
    }
 
    /**
     * Verify comma-space formatting, brackets, and duplicate suppression.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        // Arrange
        IntegerSet set = setOf(2, 1, 3, 2, 1);

        // Act
        String formatted = set.toString();

        // Assert
        assertEquals("[1, 2, 3]", formatted);
        assertEquals(3, set.length());
    }
 
    /** Creates a fresh set for a single test, keeping tests independent. */
    private static IntegerSet setOf(int... values) {
        IntegerSet set = new IntegerSet();
        for (int value : values) {
            set.add(value);
        }
        return set;
    }
}