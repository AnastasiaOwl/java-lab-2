package pack;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Logic {
    public List<Customer> fillList() {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("Volkov", "Nikita", "Viktorovich", LocalDate.of(2001, 05, 14), "vyl. Sadova 34", 878976657, 3456.50));
        list.add(new Customer("Sova", "Maria", "Sergievna", LocalDate.of(1998, 03, 11), "vyl. Faleevskay", 789989776, 55678.00));
        list.add(new Customer("Devikova", "Anna", "Andriivna", LocalDate.of(1973, 06, 21), "vyl. Soborna", 987678967,2344556.25 ));
        list.add(new Customer("Stepach", "Sergiy", "Aleksandrovich", LocalDate.of(2001, 10, 10), "vyl. Soborna", 878976687, -3224.40));
        list.add(new Customer("Filinov", "Nikita", "Oleksiyvich", LocalDate.of(1997, 05, 22), "vyl. Mira", 456757892,55678.00 ));
        list.add(new Customer("Vinkova", "Svetlana", "Aleksandrovna", LocalDate.of(1975, 01, 14), "vyl. Bila", 987654353,-345.78 ));
        list.add(new Customer("Sokolov", "Igor", "Andrievich", LocalDate.of(2000, 02, 15), "vyl. Stadion", 234569764,-1234.70 ));
        list.add(new Customer("Rydik", "Anna", "Viktorovna", LocalDate.of(2003, 05, 01), "vyl. Mira", 456776432, 324165.00));
        list.add(new Customer("Petrov", "Ivan", "Antonovich", LocalDate.of(1997, 07, 24), "vyl. Nadeshda", 678787543, 3456.50));
        return list;
    }
    public List<Customer> AddToList( List<Customer> list, String addSurname, String addName, String addPatronymic, LocalDate addBirthDate, String addAddress, long addCardNumber, double addCardBalance) {
        list.add(new Customer(addSurname, addName, addPatronymic, addBirthDate, addAddress,  addCardNumber,addCardBalance));
        return list;
    }

    public List<Customer> remove(List<Customer> list, int index) {
        list.remove(index);
        return list;
    }
    public List<Customer> sortName(List<Customer> list, String nameSearch) {
        List<Customer> result = list.stream().filter(x -> nameSearch.equals(x.getName()))
                .collect(Collectors.toList());
        return result;
    }
    public List<Customer> sortCardNumber(List<Customer> list, long cardNumberF, long cardNumberT) {
        List<Customer> result = list.stream().filter((x) ->cardNumberF<(x.getCardNumber()) && cardNumberT>(x.getCardNumber()))
        .collect(Collectors.toList());
        return result;
    }

    public List<Customer> sortCardBalance(List<Customer> list, long qCardBalance) {
       List<Customer> r = list.stream().filter((x) -> 0>(x.getCardBalance()))
               .sorted(Comparator.comparing(Customer::getCardBalance))
              .collect(Collectors.toList());
            Collections.reverse(r);
       return r;
    }
    public long qCardBalance(List<Customer> list, List<Customer> r, long qCardBalance) {
        sortCardBalance( list, qCardBalance);
        qCardBalance =r.size();
        return qCardBalance;
    }

    public List<Customer> sortByCardBalanceCardNumber(List<Customer> list) {
        List<Customer> result = list.stream().sorted(Comparator.comparing(Customer::getCardBalance)
              .thenComparing(Customer::getCardNumber))
               .collect(Collectors.toList());
            return result;
        }

        public List<Integer> sortByBirthYear(List<Customer> list) {
            List<Integer> h= list.stream().map(customer -> customer.birthDate.getYear()).distinct().collect(Collectors.toList());
            return h;
        }
        public Map<Integer,Customer> sortYearCardBalance(List<Customer> list) {
            Map<Integer, Customer> map;
            list.sort(Comparator.comparing(Customer::getCardBalance));
            map = list.stream().collect(Collectors.toMap(customer -> customer.birthDate.getYear(), customer -> customer, (a, b) -> b));
            return map;
        }
}