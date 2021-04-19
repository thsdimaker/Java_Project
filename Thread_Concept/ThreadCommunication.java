class Main {  
  public static void main(String args[]) { 
    CalcThread thread1 = new CalcThread();
    PrintThread thread2 = new PrintThread();

    SharedArea obj = new SharedArea();

    thread1.sharedArea = obj;
    thread2.sharedArea = obj;

    thread1.start();
    thread2.start();
  } 
}


// 공유 영역 클래스
class SharedArea {
  double result;
  boolean isReady;
}

class CalcThread extends Thread {
  SharedArea sharedArea;

  public void run() {
    double total = 0.0;

    // 로직? 무한급수 파이 = 1- (1/3) + (1/5) + (1/7)
    for(int cnt=01; cnt<100000000; cnt+=2){
      if(cnt / 2 % 2 == 0){
        total += 1.0 / cnt;
      }else{
        total -= 1.0 / cnt;
      }
      sharedArea.result = total * 4;
      sharedArea.isReady = true;
    }
  }
}

class PrintThread extends Thread {
  SharedArea sharedArea;
  public void run(){
    
    while(sharedArea.isReady != true)
      continue;
    System.out.println(sharedArea.result);
    

  }
  
}

