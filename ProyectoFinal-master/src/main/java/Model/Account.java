package Model;

public class Account {
    private String numAccount;
    private Client client;
    private double balance;

    public Account(String numAccount, Client client) {
        this.numAccount = numAccount;
        this.client = client;
        this.balance = 0;
    }

    public double checkBalance() { return this.balance;}

    public void deposited (double valor) { this.balance += valor; }

    public void withdraw (double valor) {
        if (this.balance >= valor) {
            this.balance -= valor;
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    public void transfer(Account destino, double valor) {

        if (this.balance >= valor) {
            destino.deposited(valor);
            this.withdraw(valor);
        } else {
            System.out.println("Fondos insuficientes para esta transferecia");
        }

    }

    public String getnumAccount() { return numAccount; }
    public void setnumAccount(String numAccount) { this.numAccount=numAccount;}

    public Client getClient() { return client; }
    public void setclient(Client client) { this.client=client; }

    public double getsalary() { return balance; }
    public void setsalary(double balance) { this.balance= this.balance; }

    @Override
    public String toString() {
        return "Número de Cuenta='" + numAccount + '\'' + ", Cliente='" + client.toString() + '\'' +
                ", Saldo='" +balance + '\'' + '}';
    }
}
