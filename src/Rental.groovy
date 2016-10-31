/**
 * Created by Gabriela on 14/10/16.
 */
class Rental {

    private Movie _movie;
    private int _daysRented;

    Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    def getDaysRented(){
        _daysRented
    }

    def getMovie(){
        _movie
    }

    double getCharge() {
        this.getMovie().getCharge(daysRented)
    }

    def getPoints() {
        // add bonus for a two day new release rental
        def extraPoint = (this.getMovie().getType() == Movie.NEW_RELEASE) && this.getDaysRented() > 1
        extraPoint ? 2 : 1
    }
}
