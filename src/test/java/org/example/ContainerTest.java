package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ContainerTest extends TestCase
{
    private Container container;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        container = new Container();
    }

    public void testInitialSize()
    {
        assertEquals(0, container.getSize());
        assertTrue(container.isEmpty());
    }

    public void testAddElement()
    {
        container.add("Element 1");
        assertEquals(1, container.getSize());
        assertFalse(container.isEmpty());
        assertEquals("Element 1", container.get(0));
    }

    public void testAddMultipleElements()
    {
        container.add("Element 1");
        container.add("Element 2");
        container.add("Element 3");

        assertEquals(3, container.getSize());
        assertEquals("Element 1", container.get(0));
        assertEquals("Element 2", container.get(1));
        assertEquals("Element 3", container.get(2));
    }

    public void testGetInvalidIndex()
    {
        container.add("Element 1");

        try
        {
            container.get(1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e)
        {
            assertEquals("Index: 1 Size: 1", e.getMessage());
        }
    }

    public void testRemoveElement()
    {
        container.add("Element 1");
        container.add("Element 2");
        container.add("Element 3");

        container.remove(1);

        assertEquals(2, container.getSize());
        assertEquals("Element 1", container.get(0));
        assertEquals("Element 3", container.get(1));
    }

    public void testRemoveInvalidIndex()
    {
        try
        {
            container.remove(0);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e)
        {
            assertEquals("Index: 0 Size: 0", e.getMessage());
        }

        container.add("Element 1");

        try
        {
            container.remove(1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e)
        {
            assertEquals("Index: 1 Size: 1", e.getMessage());
        }
    }

    public void testResize()
    {
        for (int i = 0; i < 10; i++)
        {
            container.add("Element " + i);
        }

        assertEquals(10, container.getSize());
        container.add("Element 10");

        assertEquals(11, container.getSize());
        assertEquals("Element 10", container.get(10));
    }

    public void testConstructorWithNegativeCapacity()
    {
        try
        {
            new Container(-5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e)
        {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    public void testConstructorWithZeroCapacity()
    {
        try
        {
            new Container(0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e)
        {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    public static Test suite()
    {
        return new TestSuite(ContainerTest.class);
    }
}