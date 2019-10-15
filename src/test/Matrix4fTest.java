package test;

import JHobbyEngine.math.Matrix4f;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Matrix4fTest {

  @Test
  public void testEquals() {
    Matrix4f first = new Matrix4f(
            2.3f, 2.1f, 1.0f, 1.0f,
            5.4f, 3.2f, 1.2f, 5.4f,
            6.5f, 7.4f, 1.2f, 4.3f,
            1.0f, 1.0f, 34.5f, 12.25f
    );

    Matrix4f second = new Matrix4f(
            new float[] {
                    2.3f, 2.1f, 1.0f, 1.0f,
                    5.4f, 3.2f, 1.2f, 5.4f,
                    6.5f, 7.4f, 1.2f, 4.3f,
                    1.0f, 1.0f, 34.5f, 12.25f
            }
    );

    assertEquals(first.equals(second), true);

    Matrix4f identity = new Matrix4f(1.0f);

    assertEquals(first.equals(identity), false);
  }

  @Test
  public void testAdd() {
    Matrix4f first = new Matrix4f(1.0f);
    Matrix4f second = new Matrix4f(1.0f);

    Matrix4f expected = new Matrix4f(2.0f);
    Matrix4f result = Matrix4f.add(first, second);
    assertEquals(result.equals(expected), true);
  }

  @Test
  public void testSubtract() {
    Matrix4f first = new Matrix4f(3.4f);
    Matrix4f second = new Matrix4f(1.2f);

    Matrix4f expected = new Matrix4f(2.2f);
    Matrix4f result = Matrix4f.subtract(first, second);
    assertEquals(result.equals(expected), true);
  }
}