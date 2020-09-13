package usantatecla.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import usantatecla.utils.Console;
import usantatecla.utils.Direction;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateTest {

    private ConcreteCoordinate coordinate00;
    private ConcreteCoordinate coordinate01;
    private ConcreteCoordinate coordinate11;
    private ConcreteCoordinate coordinate02;
    private ConcreteCoordinate coordinate12;

    @Mock
    private Console console;

    @InjectMocks
    private ConcreteCoordinate coordinate = new ConcreteCoordinate();

    public CoordinateTest() {
        this.coordinate00 = new ConcreteCoordinate(0, 0);
        this.coordinate01 = new ConcreteCoordinate(0, 1);
        this.coordinate11 = new ConcreteCoordinate(1, 1);
        this.coordinate02 = new ConcreteCoordinate(0, 2);
        this.coordinate12 = new ConcreteCoordinate(1, 2);
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates00And01ThenIsHorizontal() {
        assertEquals(Direction.HORIZONTAL, this.coordinate00.getDirection(this.coordinate01));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates01And11ThenIsVertical() {
        assertEquals(Direction.VERTICAL, this.coordinate01.getDirection(this.coordinate11));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates00And11ThenIsMainDiagonal() {
        assertEquals(Direction.MAIN_DIAGONAL, this.coordinate00.getDirection(this.coordinate11));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates02And11ThenIsInverseDiagonal() {
        assertEquals(Direction.INVERSE_DIAGONAL, this.coordinate02.getDirection(this.coordinate11));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates00And12ThenDirectionIsNull() {
        assertEquals(Direction.NULL_DIRECTION, this.coordinate00.getDirection(this.coordinate12));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewCoordinatesWhenRow4AndColumn4ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(4).thenReturn(2);
        when(this.console.readInt("Column: ")).thenReturn(4).thenReturn(2);
        this.coordinate.read("Title");
        assertTrue(new ConcreteCoordinate(2,2).equals(this.coordinate));
    }

    @Test
    public void testGivenNewCoordinatesWhenRow0AndColumn0ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(0).thenReturn(2);
        when(this.console.readInt("Column: ")).thenReturn(0).thenReturn(2);
        this.coordinate.read("Title");
        assertFalse(new ConcreteCoordinate(2,2).equals(this.coordinate));
    }

    @Test
    public void testGivenNewCoordinatesWhenRow1AndColumn1ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(1);
        when(this.console.readInt("Column: ")).thenReturn(1);
        this.coordinate.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow3AndColumn3ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(3);
        when(this.console.readInt("Column: ")).thenReturn(3);
        this.coordinate.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareTwoCoordinateEqualsThenIsTrue() {
        ConcreteCoordinate coordinate00Copy = new ConcreteCoordinate(0, 0);
        assertTrue(this.coordinate00.equals(coordinate00Copy));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareTwoCoordinateNotEqualsRowThenIsTrue() {
        ConcreteCoordinate coordinate01Copy = new ConcreteCoordinate(1, 0);
        assertTrue(!this.coordinate00.equals(coordinate01Copy));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareTwoCoordinateNotEqualsColumnThenIsFalse() {
        ConcreteCoordinate coordinate01Copy = new ConcreteCoordinate(0, 1);
        assertFalse(this.coordinate00.equals(coordinate01Copy));
    }
    
    @Test
    public void testGivenNewCoordinatesWhenCompareNullCoordinatehenIsFalse() {
        assertFalse(this.coordinate00.equals(NullCoordinate.NULL_COORDINATE));
    }
    
    @Test
    public void testGivenNullCoordinatesWhenCompareNullCoordinatehenIsTrue() {
        assertTrue(NullCoordinate.instance().equals(NullCoordinate.instance()));
    }
    
    @Test
    public void testGivenNullCoordinatesWhenCompareConcreteCoordinatehenIsFalse() {
        assertFalse(NullCoordinate.instance().equals(this.coordinate00));
    }
    
    @Test
    public void testGivenNewCoordinatesWhenCompareOneCoordinateWithAnObjectThenIsFalse() {
        assertFalse(this.coordinate00.equals(new Object()));
    }
    
}
