package ru.compscicenter.java2012.collections;

import java.util.Collection;
import java.util.Iterator;

/**
 * MultiSet is an unordered collection that may contain duplicate elements.
 * It refines some of the operations inherited from {@link Collection}
 * and adds several new operations aware of MultiSet's ability to contain multiple
 * occurrences of an element.
 *
 * Implementations must provide default constructor (without arguments)
 * and constructor with single parameter of type <code>Collection&lt;? extends E&gt;</code>.
 *
 * @param <E> the type of elements in this multiset
 */
public interface MultiSet<E> extends Collection<E> {

    /**
     * Returns the number of elements in this multiset, including all duplicates
     *
     * @return the number of elements in this multiset, including all duplicates
     */
    @Override
    int size();


    /**
     * Returns an iterator over the elements in this multiset.
     * Elements that occur multiple times in the multiset will be returned multiple times
     * by this iterator, but the order is not defined.
     *
     * @return an <tt>Iterator</tt> over the elements in this multiset
     */
    @Override
    Iterator<E> iterator();


    /**
     * Adds a single occurrence of the specified element to this multiset.
     *
     * Always returns <code>true</code>, because multiset always allows adding
     * both new elements and new occurrences of known elements.
     *
     * @param e  element to add
     * @return <code>true</code>
     */
    @Override
    boolean add(E e);


    /**
     * Adds multiple occurrences of the specified element to this multiset.
     *
     * @param e  element to add
     * @param occurrences  number of element occurrences to add; can't be negative
     *
     * @return the count of element occurrences before the operation; possibly zero
     *
     * @throws IllegalArgumentException  if <code>occurrences</code> is negative
     */
    int add(E e, int occurrences);


    /**
     * Removes a single occurrence of the specified element from this multiset, if present.
     *
     * @param e  element to remove
     * @return <code>true</code> if the element was found and removed
     */
    @Override
    boolean remove(Object e);


    /**
     * Removes multiple occurrences of the specified element from this multiset, if present.
     * If multiset contains fewer copies of the element than given by <code>occurrences</code>
     * parameter, all occurrences are removed.
     *
     * @param e  element to remove
     * @param occurrences  number of element occurrences to remove; can't be negative
     *
     * @return the count of element occurrences before the operation; possibly zero
     *
     * @throws IllegalArgumentException  if <code>occurrences</code> is negative
     */
    int remove(Object e, int occurrences);


    /**
     * Returns the number of occurrences of an element in this multiset.
     *
     * @param e  the element to whose occurrences are to be returned
     * @return the number of occurrences of an element in this multiset
     */
    int count(Object e);


    /**
     * Returns <code>true</code> if this multiset contains at least one occurrence of each element
     * in the specified collection.
     *
     * This method ignores the occurrence count of an element in the two collections; it may still
     * return <code>true</code> even if other collections contains several occurrences of an element
     * and this multiset contains only one.
     *
     * @param c  the collection of elements to be looked up in this multiset
     * @return <code>true</code> if this multiset contains at least one occurrence of each element in <code>c</code>
     *
     */
    @Override
    boolean containsAll(Collection<?> c);


    /**
     * For each element in given collection removes <em>all</em> occurrences of the element from this multiset, if present.
     *
     * @param c  collection with elements to remove from this multiset
     * @return <code>true</code> if at least one element was found and removed
     */
    @Override
    boolean removeAll(Collection<?> c);


    /**
     * For each element in given collection retains <em>all</em> occurrences of the element from this multiset, if present.
     *
     * @param c  collection with elements to retain in this multiset
     * @return <code>true</code> if at least one element was removed
     */
    @Override
    boolean retainAll(Collection<?> c);


    /**
     * Compares the specified object with this multiset for equality.
     * Returns true if the given object is also a multiset
     * and contains equal elements with equal counts.
     *
     * @param o  object to compare with
     * @return <code>true</code> if this multiset is equal to given object as defined above
     */
    @Override
    boolean equals(Object o);
}