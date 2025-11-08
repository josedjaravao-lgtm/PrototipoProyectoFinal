package Model;

public class Loan {
    private String numLoan;
    private Account account;
    private double loan;

    public Loan(String numLoan, Account account, double loan) {
        this.numLoan = numLoan;
        this.account = account;
        this.loan = loan;
    }

    public void toPay(double abono){
        if(abono > this.loan){
            this.account.deposited(abono- loan);
            this.loan = 0;

        }else{
            this.loan -= abono;
        }
    }

    public double getLoan(){
        return  this.loan;
    }

    @Override
    public String toString() {
        return this.numLoan + " " + account.getClient().getName() + " " + this.loan;
    }

}
