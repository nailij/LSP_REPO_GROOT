
package org.howard.edu.lsp.assignment5;

import java.util.TreeSet;
import java.util.Collections;

/**
 * Represents a mathematical set of integers without duplicates.
 * Stores integers in ascending numerical order.
 */
public class IntegerSet {

    private TreeSet<Integer> integers;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        integers = new TreeSet<>();
    }

    /**
     * Removes all elements from this set.
     */
    public void clear() {
        integers.clear();
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of unique integers
     */
    public int length() {
        return integers.size();
    }

    /**
     * Checks whether this set contains the specified integer.
     *
     * @param value the integer to search for
     * @return true if the integer exists, otherwise false
     */
    public boolean contains(int value) {
        return integers.contains(value);
    }

    /**
     * Adds an integer to this set.
     * Duplicate values are automatically ignored.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        integers.add(item);
    }

    /**
     * Removes an integer from this set if it exists.
     * Does nothing if the integer is not present.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        integers.remove(item);
    }

    /**
     * Checks whether this set contains no elements.
     *
     * @return true if the set is empty, otherwise false
     */
    public boolean isEmpty() {
        return integers.isEmpty();
    }

    /**
     * Returns the largest integer in this set.
     *
     * @return the largest integer
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (integers.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }

        return integers.last();
    }

    /**
     * Returns the smallest integer in this set.
     *
     * @return the smallest integer
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (integers.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }

        return integers.first();
    }

    /**
     * Returns a string representation of this set
     * with integers in ascending numerical order.
     *
     * @return the formatted set
     */
    @Override
    public String toString() {
        return integers.toString();
    }

    /**
     * Checks whether this set and another set contain
     * exactly the same integers.
     *
     * @param b the set to compare
     * @return true if both sets contain the same integers,
     *         otherwise false
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }

        return integers.equals(b.integers);
    }

    /**
     * Returns a new set containing all integers
     * from this set and another set.
     *
     * @param b the set to combine with this set
     * @return a new set containing the union
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        result.integers.addAll(this.integers);
        result.integers.addAll(b.integers);

        return result;
    }

    /**
     * Returns a new set containing integers
     * shared by this set and another set.
     *
     * @param b the set to compare
     * @return a new set containing the intersection
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        result.integers.addAll(this.integers);
        result.integers.retainAll(b.integers);

        return result;
    }

    /**
     * Returns a new set containing integers in this set
     * that are not present in another set.
     *
     * @param b the set containing integers to exclude
     * @return a new set containing the difference
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        result.integers.addAll(this.integers);
        result.integers.removeAll(b.integers);

        return result;
    }

    /**
     * Returns a new set containing integers in another
     * set that are not present in this set.
     *
     * @param b the set containing integers to compare
     * @return a new set containing the complement
     */
    public IntegerSet complement(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        result.integers.addAll(b.integers);
        result.integers.removeAll(this.integers);

        return result;
    }

    /**
     * Checks whether every integer in this set
     * is also contained in another set.
     *
     * @param b the set to compare
     * @return true if this set is a subset of b,
     *         otherwise false
     */
    public boolean isSubsetOf(IntegerSet b) {
        return b.integers.containsAll(this.integers);
    }

    /**
     * Checks whether this set and another set
     * have no integers in common.
     *
     * @param b the set to compare
     * @return true if the sets share no integers,
     *         otherwise false
     */
    public boolean isDisjoint(IntegerSet b) {
        return Collections.disjoint(this.integers, b.integers);
    }

    /**
     * Returns a new set containing integers that appear
     * in exactly one of the two sets.
     *
     * @param b the set to compare
     * @return a new set containing the symmetric difference
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        result.integers.addAll(this.integers);

        for (int value : b.integers) {
            if (!result.integers.add(value)) {
                result.integers.remove(value);
            }
        }

        return result;
    }
}