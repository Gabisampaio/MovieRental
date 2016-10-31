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

    def double getCharge() {
        double thisAmount = 0
        //determine amounts for aRental line
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2
                if (this.getDaysRented() > 2)
                    thisAmount += (this.getDaysRented() - 2) * 1.5
                break
            case Movie.NEW_RELEASE:
                thisAmount += this.getDaysRented() * 3
                break
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (this.getDaysRented() > 3)
                    thisAmount += (this.getDaysRented() - 3) * 1.5
                break
        }
        thisAmount
    }

    def getPoints() {
        int frequentRenterPoints
        // add frequent renter points
        frequentRenterPoints++
        // add bonus for a two day new release rental
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1)
            frequentRenterPoints++
        frequentRenterPoints
    }
}
