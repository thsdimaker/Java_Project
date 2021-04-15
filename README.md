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

