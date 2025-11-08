package com.example.proyectofinal;

import Model.Account;
import Model.Client;
import Model.Loan;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client("Ana Perez", 21, "1032988652","ana.perez@mail.com","3204387063");
        Client client2 = new Client("Juan Lopez",  22, "1032688787","juan.lopez@mail.com","3218917298");

        Account cuenta1 = new Account("C-1001", client1);
        Account cuenta2 = new Account("C-1002", client2);

        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());

        cuenta1.deposited(1000);
        cuenta2.deposited(5000);

        cuenta1.withdraw(500);
        cuenta2. deposited(2000);

        cuenta2.transfer(cuenta1, 3000);

        cuenta1.transfer(cuenta2, 5000);

        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());

        System.out.println("*******************");

        Loan prestamo1 = new Loan("P001", cuenta1, 10000);

        System.out.println(prestamo1.toString());
        prestamo1.toPay(8000);
        prestamo1.toPay(3000);
        System.out.println(prestamo1.toString());
        System.out.println(cuenta1.toString());
    }
}
