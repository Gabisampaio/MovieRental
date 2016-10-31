/**
 * Created by Gabriela on 14/10/16.
 */
class Movie {

    private String _title;
    static final int CHILDRENS = 2
    static final int REGULAR = 0
    static final int NEW_RELEASE = 1
    int _type


    Movie(String title, int priceCode) {
        _title = title
        setType(_type)
    }

    def getTitle(){
        _title
    }

    def getType(){
        _type
    }

    def setType(int type){
        _type = type
    }

}
