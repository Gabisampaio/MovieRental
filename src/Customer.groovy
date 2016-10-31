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
            double thisAmount = rental.getCharge()
            frequentRenterPoints += rental.getPoints()
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n"

            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n"
        result += "You earned " + frequentRenterPoints + " frequent renter points"
    }

    /*
        Rental Record for Maria
	        Titanic	5.0
	        Harry Potter	3.5
        Amount owed is 8.5
        You earned 2 frequent renter points
     */

}

