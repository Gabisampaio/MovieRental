/**
 * Created by Gabriela on 31/10/16.
 */
abstract class Price {

    static final int CHILDRENS = 2
    static final int REGULAR = 0
    static final int NEW_RELEASE = 1

    abstract int getPriceCode()

    static void newType(int code){
        switch (code) {
            case REGULAR:
                new RegularPrice()
                break
            case NEW_RELEASE:
                new NewReleasePrice()
                break
            case CHILDRENS:
                new ChildrensPrice()
                break
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
}
