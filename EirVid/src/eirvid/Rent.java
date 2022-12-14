package eirvid;

/**
 *
 * @author Willian Lopes do Amaral 2020487
 */
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Rent implements List<Rent> {
    // Overdue fee per day

    public static final BigDecimal OVERDUE_FEE = new BigDecimal("1.00");

    private String clientName;
    private MovieMenu movie;
    private LocalDate checkoutDate;
    private LocalDate returnDate;
    private BigDecimal overdueFee;

    public Rent(String clientName, MovieMenu movie, String returnDateString) throws IOException, NullPointerException {
        setClientName(clientName);
        setMovie(movie);
        setCheckoutDate(LocalDate.now());

        try {
            setReturnDate(returnDateString);
        } catch (DateTimeParseException ex) {
            System.out.println("Error converting returnDate from String to LocalDate: %s. Using current date instead!");
            setReturnDate(this.checkoutDate);

        }
        updateOverdueFee();

    }

    /**
     * Updates overdueFee if currentDate > returnDate per formula: (currentDate -
     * returnDate) * OVERDUE_FEE
     * Or sets overdueFee to 0, if it is not initialized yet
     */
    public void updateOverdueFee() {
        if (LocalDate.now().isAfter(returnDate)) {
            overdueFee = BigDecimal.valueOf(Period.between((LocalDate) returnDate, LocalDate.now()).getDays());
            overdueFee = overdueFee.multiply(OVERDUE_FEE);
        } else if (overdueFee == null)
            overdueFee = new BigDecimal(0);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) throws IOException {
        if ("".equals(clientName))
            throw new IOException("Name can't be empty or null!");
        this.clientName = clientName;
    }

    // public Movie getMovie() { return movie; }
    private void setMovie(MovieMenu movie) throws NullPointerException {
        if (movie == null)
            throw new NullPointerException("Movie can't be null!");
        this.movie = movie;
    }

    // public LocalDate getCheckoutDate() { return checkoutDate; }
    private void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    // public LocalDate getReturnDate() { return returnDate; }
    private void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Converts returnDateString to returnDate LocalDate object
     * 
     * @param checkoutDate2 - returnDate represented as String
     * @throws IOException            if returnDateString is empty or null
     * @throws DateTimeParseException if returnDateString is not using formula
     *                                yyyy-MM-dd
     */

    private void setReturnDate(String returnDateString) throws IOException, DateTimeParseException {
        // Checks for string's emptiness. If fails -> throws IOException
        // if(returnDateString == null || returnDateString.isEmpty()) throw new
        // IOException("The return date is empty or null");
        if ("".equals(returnDateString))
            throw new IOException("The return date is empty or null");

        // Tries to parse the string. If fails -> throws DateTimeParseException
        this.returnDate = LocalDate.parse(returnDateString);
    }

    public BigDecimal getOverdueFee() {
        return overdueFee.add(BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        /*
         * Output example:
         * Name: Jack
         * Movie title: Harry Potter
         * Rent price: $20.99
         * Checkout date: 2017-07-28
         * Return date: 2017-08-05
         * Overdue fee: $0.00
         */
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        // noinspection StringBufferReplaceableByString
        StringBuilder strBld = new StringBuilder();
        strBld.append("Name: ").append(clientName).append("\n");
        strBld.append("Movie title: ").append(movie.getMovieTitle()).append("\n");
        strBld.append("Rent price: ").append(currencyFormat.format(movie.getRentPrice())).append("\n");
        strBld.append("Checkout date: ").append(checkoutDate).append("\n");
        strBld.append("Return date: ").append(returnDate).append("\n");
        strBld.append("Overdue fee: ").append(currencyFormat.format(overdueFee));

        return strBld.toString();
    }

    @Override
    public boolean add(Rent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void add(int index, Rent element) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean addAll(Collection<? extends Rent> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Rent> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Rent get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<Rent> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<Rent> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<Rent> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Rent remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Rent set(int index, Rent element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Rent> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

}
