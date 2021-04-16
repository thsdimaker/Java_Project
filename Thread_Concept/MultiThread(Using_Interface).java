class Main {  
    public static void main(String args[]) {
  
      Thread thread = new Thread(new SmallLetters());
      thread.start();
      char arr[] = {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ',
                    'ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
  
      for(char ch : arr){
        System.out.println(ch);
      }
    } 
  }
  
  // (java.lang.Runnable Interface)
  class SmallLetters implements Runnable{
    public void run(){
      
      for(char ch = 'a'; ch<='z'; ch++){
        System.out.println(ch);
      }
    }
  }