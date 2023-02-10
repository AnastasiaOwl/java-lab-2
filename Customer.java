package pack;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Comparator;

public class Customer implements Comparator <Customer>{
    protected String surname;
    protected String name;
    protected String patronymic;
    protected LocalDate birthDate;
    protected String address;
    protected long cardNumber;
    protected double cardBalance;

    public Customer(String surname, String name, String patronymic, LocalDate birthDate, String address,long cardNumber,  double cardBalance) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.cardNumber = cardNumber;
        this.cardBalance = cardBalance;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        patronymic = patronymic;
    }

    public LocalDate  getBirthDate() {return birthDate; }

    public void setBirthDate(LocalDate birthDate) {
        birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        cardNumber = cardNumber;
    }

    public double getCardBalance() {
        return this.cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String toString() {
        return "Student:surname=" + this.surname + ", name=" + this.name + ", patronymic=" + this.patronymic + ", birthDate=" + this.birthDate + ", address=" + this.address + ", cardNumber=" + this.cardNumber + ", cardBalance=" + this.cardBalance ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Double.compare(customer.cardNumber, cardNumber) == 0 && Double.compare(customer.cardBalance, cardBalance) == 0 && Objects.equals(surname, customer.surname) && Objects.equals(name, customer.name) && Objects.equals(patronymic, customer.patronymic) && Objects.equals(birthDate, customer.birthDate) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, birthDate, address, cardNumber, cardBalance);
    }

    @Override
    public int compare(Customer o1,Customer o2) {
        return (int) (Double.compare(o1.getCardBalance(),o2.getCardBalance()));
    }
}