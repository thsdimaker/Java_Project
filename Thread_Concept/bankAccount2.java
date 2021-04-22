class Main {  
    public static void main(String args[]) { 
      SharedArea area = new SharedArea();
  
      area.account1 = new Account("111-111-1111", "김김김", 20000000);
      area.account2 = new Account("222-222-2222", "님님님", 10000000);
  
      TransferThread thread1 = new TransferThread(area);
      PrintThread thread2 = new PrintThread(area);
  
      thread1.start();
      thread2.start();
      
    } 
  }

  class Account{
    String accountNo;
    String ownerName;
    int balance;
  
    Account(String accountNo, String ownerName, int balance){
      this.accountNo = accountNo;
      this.ownerName = ownerName;
      this.balance = balance;
    }
  
    void deposit(int amount){
      balance += amount;
    }
  
    int withdraw(int amount){
      if(balance<amount)
        return 0;
      balance -= amount;
      return amount;
    }
  }

  class SharedArea {
    Account account1;
    Account account2;
  }
  
  class TransferThread extends Thread {
    SharedArea sharedArea;
    
    TransferThread(SharedArea area){
      sharedArea = area;
    }
  
    public void run(){
      for(int cnt=0; cnt<12; cnt++){
        sharedArea.account1.withdraw(1000000);
        System.out.println("김김김 계좌: 100만원 인출");
  
        sharedArea.account2.deposit(1000000);
        System.out.println("님님님 계좌: 100만원 입금");
      }
    }
  }

  class PrintThread extends Thread{
    SharedArea sharedArea;
    
    PrintThread(SharedArea area){
      sharedArea = area;
    }
  
    public void run(){
      for(int cnt=0; cnt<3; cnt++){
        synchronized(sharedArea){
            int sum = sharedArea.account1.balance + 
            sharedArea.account2.balance;

            System.out.println("계좌 잔액 합계: " + sum);
        }
        
        try{
          Thread.sleep(1);
        }catch(InterruptedException e){
          System.out.println(e.getMessage());
        }
          
      }
    }
  }