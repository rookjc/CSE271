/**
 * A simple class implementing the IntegerTransformation interface.
 *
 * @author Gregory Gelfond
 * @version 1.0
 */
class Cube implements IntegerTransformation {

    public Cube() {}

    public int transform(int x) {
        return x * x * x;
    }
    
}
