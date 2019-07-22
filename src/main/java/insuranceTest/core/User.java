package insuranceTest.core;

import java.util.Random;


public class User {
    private String lastName;
    private String lastNameLat;
    private String firstName;
    private String firstNameLat;
    private String patronymic;
    private String telephoneNumber;
    private String birthDate;
    private String passportSeries;
    private String passportNumber;
    private String passportIssuePlace;
    private String passportIssueDate;
    private String email;
    private boolean sex;

    private static String[] lastNames = {"Иванов", "Петров", "Сидоров", "Пупкин"};
    private static String[] lastNamesLat = {"Ivanov", "Petrov", "Sidorov", "Pupkin"};
    private static String[] firstNames = {"Иван", "Петр", "Василий", "Александр"};
    private static String[] firstNamesLat = {"Ivan", "Petr", "Vasiliy", "Alexander"};
    private static String[] patronymics = {"Иванович", "Петрович", "Евгеньевич", "Андреевич"};
    private static String numbers = "0123456789";
    private static Random random;

    /**
     * Конструктор для пользователя на rgs.ru
     *
     * @param lastName
     * @param firstName
     * @param patronymic
     * @param telephoneNumber
     * @param email
     */
    public User(String lastName, String firstName, String patronymic, String telephoneNumber, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    /**
     * Генерирует рандомного юзера для rgs.ru
     *
     * @return
     */
    public static User getRandomUserForRgs() {
        random = new Random();
        return new User(lastNames[random.nextInt(4)],
                firstNames[random.nextInt(4)],
                patronymics[random.nextInt(4)],
                getRandomTelephoneNumber(random), "qwertyqwerty");
    }

    /**
     * конструктор для застрахованного в сбер
     *
     * @param lastNameLat
     * @param firstNameLat
     * @param birthDate
     */
    public User(String lastNameLat, String firstNameLat, String birthDate) {
        this.lastNameLat = lastNameLat;
        this.firstNameLat = firstNameLat;
        this.birthDate = birthDate;
    }

    /**
     * конструктор страхователя для сбера
     *
     * @param lastName
     * @param firstName
     * @param patronymic
     * @param birthDate
     * @param passportSeries
     * @param passportNumber
     * @param passportIssuePlace
     * @param passportIssueDate
     * @param sex
     */
    public User(String lastName, String firstName, String patronymic, String birthDate, String passportSeries, String passportNumber, String passportIssuePlace, String passportIssueDate, boolean sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.passportIssuePlace = passportIssuePlace;
        this.passportIssueDate = passportIssueDate;
        this.sex = sex;
    }

    /**
     * Генерирует рандомного застрахованного
     *
     * @return
     */
    public static User getRandomInsuredUserForSber() {
        random = new Random();
        return new User(lastNamesLat[random.nextInt(4)],
                firstNamesLat[random.nextInt(4)], getBirthRandomDate());
    }

    /**
     * генерирует рандомного страхователя
     *
     * @return
     */
    public static User getRandomInsurantUserForSber() {
        random = new Random();
        return new User(lastNames[random.nextInt(4)],
                firstNames[random.nextInt(4)],
                patronymics[random.nextInt(4)], getBirthRandomDate(), randomCellsGenerate(4), randomCellsGenerate(6), "ОУФМС МСК", getPassportRandomIssueDate(), true);
    }

    /**
     * Метод генерации рандомного номера телефона
     *
     * @param random
     * @return
     */
    public static String getRandomTelephoneNumber(Random random) {
        StringBuilder telephoneNumberBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                telephoneNumberBuilder.append("9");
            } else {
                char ch = numbers.charAt(random.nextInt(numbers.length()));
                telephoneNumberBuilder.append(ch);
            }
        }
        telephoneNumberBuilder.insert(0, "(");
        telephoneNumberBuilder.insert(4, ")");
        telephoneNumberBuilder.insert(5, " ");
        telephoneNumberBuilder.insert(9, "-");
        telephoneNumberBuilder.insert(12, "-");
        return telephoneNumberBuilder.toString();
    }

    /**
     * метод генерации рандомного дня рождения
     *
     * @return
     */
    public static String getBirthRandomDate() {
        String date = "";
        int yearBegin = 1960;
        int yearEnd = 2010 - yearBegin;
        int month = 1 + (int) (Math.random() * 12);
        String monthS = (month < 10) ? "0" + month : String.valueOf(month);
        int day = 1 + (int) (Math.random() * 31);
        String dayS = (day < 10) ? "0" + day : String.valueOf(day);
        date = "" + dayS + "." + monthS + "." + (yearBegin + (int) (Math.random() * yearEnd));
        return date;
    }

    /**
     * метод генерации рандомной даты выдачи паспорта
     *
     * @return
     */
    public static String getPassportRandomIssueDate() {
        String date = "";
        int yearBegin = 2010;
        int yearEnd = 2019 - yearBegin;
        int month = 1 + (int) (Math.random() * 12);
        String monthS = (month < 10) ? "0" + month : String.valueOf(month);
        int day = 1 + (int) (Math.random() * 31);
        String dayS = (day < 10) ? "0" + day : String.valueOf(day);
        date = "" + dayS + "." + monthS + "." + (yearBegin + (int) (Math.random() * yearEnd));
        return date;
    }

    /**
     * метод генерации ранодомных цифр, указанной длинны
     *
     * @param count
     * @return
     */
    public static String randomCellsGenerate(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char ch = numbers.charAt(random.nextInt(numbers.length()));
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public String getSex() {
        String sexS = (sex) ? "м" : "ж";
        return sexS;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPassportIssuePlace() {
        return passportIssuePlace;
    }

    public String getPassportIssueDate() {
        return passportIssueDate;
    }

    public String getLastNameLat() {
        return lastNameLat;
    }

    public String getFirstNameLat() {
        return firstNameLat;
    }

}
