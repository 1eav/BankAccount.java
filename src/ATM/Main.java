package ATM;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double putIn = 600;
        double takeOut = 1000;
        String cash;
        String cashIn;
        String cashOut;
        boolean finish;
        char bankOperation;

        DecimalFormat myFormat;
        myFormat = new DecimalFormat("#.00");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Scanner input = new Scanner(System.in);
        System.out.println("БАНКОВСКИЕ ОПЕРАЦИИ");
        System.out.println("Выбор операции\n--------------");
        do {
            System.out.println("1. <Банковская карта>");
            System.out.println("2. <Депозит>");
            System.out.println("0. <Завершить>");
            System.out.print("\nВыбор категории: ");
            switch (bankOperation = input.next().charAt(0)) {
                case '1':
                    CardAccount myCardAccount = new CardAccount("Александр", 1000);
                    System.out.println("Номер карты: " + myCardAccount.getAccountNumber() + "\nВладелец карты: " + myCardAccount.getOwner());
                    cash = myFormat.format(myCardAccount.getAmount());
                    System.out.println("Сумма: " + cash + " руб");
                    myCardAccount.put(putIn);
                    cashIn = myFormat.format(putIn);
                    cash = myFormat.format(myCardAccount.getAmount());
                    System.out.println("Сумма пополнения: " + cashIn + "\nОстаток: " + cash + " руб");
                    finish = myCardAccount.take(takeOut);
                    cashOut = myFormat.format(takeOut);
                    cash = myFormat.format(myCardAccount.getAmount());
                    if (finish) {
                        System.out.println("Сумма снятия: " + cashOut + "\nКомиссия: <100> руб" + "\nОстаток: " + cash + " руб");
                    } else {
                        System.out.println("Недостаточно средств для снятия " + cashOut + " руб" + "\nОстаток: " + cash + " руб");
                    }
                    System.out.println("\nВремя операции: " + '"' + time.format(now) + '"');
                    System.out.println("-------------------------------------");
                    break;
                case '2':
                    DepositAccount anotherAccount = new DepositAccount ("Александр", 500);
                    System.out.println("Номер депозита : " + anotherAccount.getAccountNumber() + "\nВладелец депозита: " + anotherAccount.getOwner());
                    cash  = myFormat.format(anotherAccount.getAmount());
                    System.out.println("Сумма депозита: " + cash + " руб");
                    finish = anotherAccount.take(takeOut);
                    cashOut = myFormat.format(takeOut);
                    cash = myFormat.format(anotherAccount.getAmount());
                    if (finish) {
                        System.out.println("Сумма снятия: " + cashOut + "\nКомиссия: 15 руб" + "\nОстаток: " + cash + " руб");
                    } else {
                        System.out.println("Недостаточно средств для снятия " + cashOut + " руб" + "\nОстаток: " + cash + " руб");
                    }
                    anotherAccount.postInterest();
                    cash = myFormat.format(anotherAccount.getAmount());
                    System.out.println("Процентная ставка: 1%");
                    System.out.println("После доли с ежемесячной процентной ставкой: " + "\nОстаток: " + cash + " руб");
                    System.out.println("\nВремя операции: " + '"' + time.format(now) + '"');
                    System.out.println("-------------------------------------");
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Ошибка! Некорректный ввод");
                    System.out.println(" ");
            }
        } while (bankOperation != '0');
    }
}