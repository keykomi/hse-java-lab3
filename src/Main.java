import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String surname = null;
        String firstName = null;
        String middleName = null;
        LocalDate birthday = null;
        do {
            try {
                System.out.println("Введите фамилию, имя, отчество по-русски и дату рождения в формате \"ДД.ММ.ГГГГ\":");

                String fullName = scanner.nextLine();
                String[] nameParts = fullName.split(" ");
                surname = nameParts[0];
                firstName = nameParts[1];
                middleName = nameParts[2];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                birthday = LocalDate.parse(nameParts[3], formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Вы ввели дату рождения в неверном формате");
            }
        } while (birthday == null);
        
        String initials = firstName.charAt(0) + "." + middleName.charAt(0) + ".";

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthday, currentDate);

        String gender = "М";
        if (middleName.charAt(middleName.length() - 1) == 'а') {
            gender = "Ж";
        }
        int year = age.getYears();
        String yearsWord = "";
        if (year % 10 == 1 && year != 11) {
            yearsWord = "год";
        } else if (year % 10 >= 2 && year % 10 <= 4 && (year < 12 || year > 14)) {
            yearsWord = "года";
        } else {
            yearsWord = "лет";
        }

        System.out.println(surname + " " + initials + " " + gender + " " + age.getYears() + " " + yearsWord);

        scanner.close();
    }
}