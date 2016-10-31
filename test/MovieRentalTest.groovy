import spock.lang.Specification

/**
 * Created by Gabriela on 23/10/16.
 */
class MovieRentalTest extends Specification {

    String CUSTOMER_NAME = "Maria"

    String REGULAR_MOVIE = "Titanic"
    String CHILDRENS_MOVIE = "Frozen"
    String NEW_RELEASE_MOVIE = "Inferno"

    def "Regular movie report test"(){
        given:
        Rental rental = new Rental(new Movie(REGULAR_MOVIE,Movie.REGULAR),4)
        Customer customer = new Customer(CUSTOMER_NAME)
        when:
        customer.addRental(rental)
        String report = customer.report()
        then:
        report.equals(generateReport([(REGULAR_MOVIE):'5'],5,1))
    }

    def "Childrens movie report test"(){
        given:
        Rental rental = new Rental(new Movie(CHILDRENS_MOVIE,Movie.CHILDRENS),5)
        Customer customer = new Customer(CUSTOMER_NAME)
        when:
        customer.addRental(rental)
        String report = customer.report()
        then:
        report.equals(generateReport([(CHILDRENS_MOVIE):'4.5'],4.5,1))
    }

    def "New release movie report test"(){
        given:
        Rental rental = new Rental(new Movie(NEW_RELEASE_MOVIE,Movie.NEW_RELEASE),0)
        Customer customer = new Customer(CUSTOMER_NAME)
        when:
        customer.addRental(rental)
        String report = customer.report()
        then:
        report.equals(generateReport([(NEW_RELEASE_MOVIE):'0'],0,1))
    }

    def "Three movies report test"(){
        given:
        Customer customer = new Customer(CUSTOMER_NAME)
        Movie m1 = new Movie(NEW_RELEASE_MOVIE,Movie.NEW_RELEASE)
        Movie m2 = new Movie(REGULAR_MOVIE,Movie.REGULAR)
        Movie m3 = new Movie(CHILDRENS_MOVIE,Movie.CHILDRENS)
        when:
        customer.addRental(new Rental(m1,2))
        customer.addRental(new Rental(m2,4))
        customer.addRental(new Rental(m3,5))
        String report = customer.report()
        then:
        report.equals(generateReport([(NEW_RELEASE_MOVIE):'6.0', (REGULAR_MOVIE):'5.0', (CHILDRENS_MOVIE):'4.5'],15.5,4))
    }

    //This method generates the expected result (for report method)
    def generateReport(LinkedHashMap<String,String> pairs, double totalAmount, int frequentRenterPoints){
        String result = "Rental Record for " + CUSTOMER_NAME +"\n"
        pairs.each{pair -> result += "\t" + pair.key + "\t" + Double.parseDouble(pair.value) + "\n" }
        result += "Amount owed is " + totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points"
    }
}
