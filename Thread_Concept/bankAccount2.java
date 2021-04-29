// 프로그램에서 말하는 동기화? - > 공유 데이터 사용 중에 그 공유 데이터를 다른 스레드가 사용하지 못하도록 만들기.
// Critical Section 부분을 동기화 하기 위해 - > syncrhonized() 라는 키워드를 이용한다.
// End : 20210429
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
        //  동기화 블록(키워드 : Synchronized)
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