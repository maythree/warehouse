About Process and Threads
----------------------
* Process는 프로그램을 실행하기 위한 자원을 제공한다.
* Process는 Single Thread로 실행되며 이를 primary thread라 부른다.
* Process는 primary thread 이외에 thread로부터 추가적으로 thread를 생성할 수 있다.

* Thread는 process안에서 scheduling 되어 실행되는 entity이다.
* 동일한 Process 내의 모든 Thread는 virtual address space 와 system resource 를 공유한다.
* 동일한 Process 내의 모든 Thread는 exception handler, scheduling priority, thread local storage,
unique thread id 를 가지며, schedule 되기 전까지의 thread context 를 저장하고 있다.

* Job Object은 Process의 하나의 group으로 묶어 이를 단일 unit으로 관리한다..
* Job Object는 하나의 process 일수도 있다.
* Job Object내의 프로세스는 분리될 수 없으며, process 에 의해 생성되는 process 역시 동일 Job Object에 속한다.


![Alt text](./resource/reference_01.png)