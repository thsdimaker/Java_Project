# Java_Project-For_Learning-
This Repository is for java_project learning concept like thread, multithread, etc...


# 스레드 개념

스레드 : 순서대로 하나씩 처리 되는 것이 기본, 한 가닥 실과 같은 흐름이 존재

이런 실행 흐름을 스레드(Thread, 한가닥 실)라고 부름.

Ex)

class Sum {

... main ..(String args[])

    int sum =0;

    for(int i=0; i<100; i++){

        sum += i;
        
    }
    
    System.out.println(sum);
}

# 싱글 스레드 프로그램

main 메소드의 첫 번째 명령문부터 시작되고, main 메소드의 마지막에 도달하거나

return 문을 만나면 종료


# 멀티 스레드 프로그램(n>=2)

때로는 동시에 두 가지 하는 일을 하는 프로그램이 필요

Ex) Discord 같은 음성 프로그램 (사용자가 말 - 상대방이 들을 수)

있어야 한다.

이런 프로그램을 위해서는 멀티 스레드 프로그램이 기반.

# 멀티 스레드 프로그램의 작동 원리?

스레드의 시작 - > 스레드의 끝
 ㄴ > 스레드의 시작 - > 스레드의 끝

 ㄴ > 스레드의 시작  - > 스레드의 끝

 멀티 스레드는 프로그램에서 메인 스레드가 끝났다고 프로그램이 끝나는 것이 아니다.

 모든 스레드가 끝이 나야만 끝이 난다.

# 멀티 스레드 작성하기 위한 3가지 방법?

-1) 스레드 만들 줄 알아야하고

-2) 스레드 시작 할 줄 알아야하고

-3) 스레드가 할 일을 기술 할줄 알아야 한다.

그래서 어떻게 하면 될까?

JDk 라이브러리 활용 

- java.lang.Thread 클래스

- java.lang.Runnable 인터페이스 활용

