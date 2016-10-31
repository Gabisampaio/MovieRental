/**
 * Created by Gabriela on 14/10/16.
 */
class Movie {

    private String _title;
    static final int CHILDRENS = 2
    static final int REGULAR = 0
    static final int NEW_RELEASE = 1
    Price _price


    Movie(String title, int priceCode) {
        _title = title
        setType(_type)
    }

    def getTitle(){
        _title
    }

    def getType(){
        _price.getPriceCode()
    }

    def setType(int code){
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
