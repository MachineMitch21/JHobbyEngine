package JHobbyEngine.math;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix4fTest {

  @Test
  public void testAdd() {
    Matrix4f first = new Matrix4f(1.0f);
    Matrix4f second = new Matrix4f(1.0f);

    Matrix4f expected = new Matrix4f(2.0f);
    Matrix4f result = Matrix4f.add(first, second);
    assertEquals(result.equals(expected), true);
  }
}