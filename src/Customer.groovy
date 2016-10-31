/**
 * Created by Gabriela on 14/10/16.
 */
class Customer {

    private String _name
    private List<Rental> _rentals

    Customer (String name){
        _name = name
        _rentals = new LinkedList<Rental>()
    }

    void addRental(Rental arg) {
        _rentals.add(arg)
    }

    String getName(){
        _name
    }

    def report() {
        double totalAmount = 0
        int frequentRenterPoints = 0
        String result = "Rental Record for " + getName() + "\n"
        _rentals.each{ rental ->
            double thisAmount = getCharge(rental)
            // add frequent renter points
            frequentRenterPoints++
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n"

            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n"
        result += "You earned " + frequentRenterPoints + " frequent renter points"
    }

    def double getCharge(List<Rental> rental) {
        double thisAmount = 0
        //determine amounts for aRental line
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5
                break
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3
                break
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5
                break
        }
        thisAmount
    }

    /*
        Rental Record for Maria
	        Titanic	5.0
	        Harry Potter	3.5
        Amount owed is 8.5
        You earned 2 frequent renter points
     */

}

