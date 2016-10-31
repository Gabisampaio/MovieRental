/**
 * Created by Gabriela on 14/10/16.
 */
class Movie {

    private String _title;
    static final int CHILDRENS = 2
    static final int REGULAR = 0
    static final int NEW_RELEASE = 1
    int _priceCode


    Movie(String title, int priceCode) {
        _title = title
        _priceCode = priceCode
    }

    def getTitle(){
        _title
    }

    def getPriceCode(){
        _priceCode
    }

    def setPriceCode(int priceCode){
        _priceCode = priceCode
    }

}
