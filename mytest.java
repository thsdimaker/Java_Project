class Main {  
    public static void main(String args[]) {
      Thread thread = new DigitThread();
      thread.start();
      for(char ch = 'A'; ch<='Z'; ch++){
        System.out.println(ch);
        try{
          Thread.sleep(1000);
        }catch(InterruptedException e){
          System.out.println(e.getMessage());
        }
      }
    } 
  }
  
  class DigitThread extends Thread{
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
  