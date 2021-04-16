// start: 2021.04.16(Fri)

class Main {  
    public static void main(String args[]) { 
      Thread thread1 = new DigitThread();
      Thread thread2 = new DigitThread();
      Thread thread3 = new AlphabetThread();
  
      thread1.start();
      thread2.start();
      thread3.start();
    } 
  }
  
  class DigitThread extends Thread {
    public void run(){
      for(int cnt=0; cnt<10; cnt++){
        System.out.print(cnt);
  
        try{
          Thread.sleep(1000);
        }catch(InterruptedException e){
          System.out.println(e.getMessage());
        }
      }
    }
  }
  
  class AlphabetThread extends Thread{
    public void run(){
      for(char ch = 'A'; ch<='Z'; ch++){
        System.out.println(ch);
  
        try{
          Thread.sleep(500);
        }catch(InterruptedException e){
          System.out.println(e.getMessage());
        }
      }
    }
  }