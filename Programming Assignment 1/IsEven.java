/**
 * A simple class implementing the IntegerRelation interface.
 * 
 * @author Gregory Gelfond
 * @version 1.0
 */
class IsEven implements IntegerRelation {

    public IsEven() {}

    public boolean satisfies(int x) {
        return x % 2 == 0;
    }
    
}
