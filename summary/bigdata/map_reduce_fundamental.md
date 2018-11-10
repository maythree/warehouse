MapReduce Fundamental
----------------------
1. What is MapReduce
* __Apache Hadoop의 관점에서__ MapReduce는 HDFS(Hadoop Distributed File System)에 저장된 data를 프로세싱하기 위해 고안된
Framework이다.
* __Distributed Processing 관점에서__ MapReduce는 수 백에서 수천 대 이상의 클러스터 환경에서 data를 프로세싱하기 위한 Programming
Paradigm 또는 Distributed Algorithm의 구현체이다.
* __Functional Programming 관점에서__ MapReduce는 list 또는 기타 collection을 프로세싱하기 위한 고차함수(high-order-function)이다.


MapReduce 개념은 기술 영역에 따라 목적과 동작이 상이하다. 이 글에서 정리하고자 하는 내용은 Hadoop의 관점에서 deep-dive 해보고자 한다.

2. What is Map?
* Map은 key, value 쌍의 데이터를 동일한 타입의 key, value 쌍으로 변환(transformation)하는 테스크(task)이다.
변환된 데이터는 초기 데이터와 동일한 타입이 아닐 수 있다.

Map(k1, v1) -> list(k2, v2)
- size of list can be zero or many.
- Map transformation is not guaranteed that input type and result type are the same.

2-1. How Mappers work in Hadoop?
* Hadoop System은 task를 수 많은 node에 분산하여 처리한다. 이때 Hadoop은 기본적으로 128MB를 기준으로 data를 쪼개어 하나의 블록으로 저장한다.
이때 고가용성을 제공하기 위해 동일한 3개의 블록을 분산하여 저장한다.
따라서 Map task를 수행하는 Mapper의 갯수는 block의 갯수에 따라 다르다. 일반적인 병렬처리의 관점에서
하나의 노드당 약 10-100개의 mapper가 적정하다.
예로 데이터의 사이즈가 10TB이며, 하나의 블럭사이즈가 128MB라 가정할 때 약 81,920 mapper 가 생성된다.
(10 x 1024 / 128 = 81920)