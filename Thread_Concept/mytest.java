// Start Date : 2021-04-15
// 2개의 스레드로 작동하는 멀티스레드 프로그램(기초)
// A부터 Z까지 출력 클래스(메인 스레드)
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
  
//   0부터 9까지 출력()
// extends Thread(java.lang.Thread 클래스 상속)
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
  