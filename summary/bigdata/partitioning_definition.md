Partitioning definition
----------------------
#### The Magic Recipe For Distributed Systems.
* Distributed System은 하나의 시스템이 서로 다른 Network Computer들로 구성된 것을 의미한다.(이때의 각각의 Computer를 보통 Node라고 한다.)<br/>
* Distributed System의 목적은 단일 서버로 해결할 수 없는 대용량의 computing 자원이 필요한 공통의 문제를 해결하는 것이다. 
* 이를 위해 Distributed System은 Paritioning을 활용한다.

#### Partitioning 이란?
* Partitioning은 하나의 데이터를 여러 개의 chunk로 분리하고 이를 각 Node에 분산하여 저장한다. 
* chunk는 경우에 따라 shard, partition, vnode 등으로 부른다. 
* Partitioning을 통해 데이터에 대한 read/write에 대한 부하를 분산시킬 수 있으며, 서비스의 확장에 scale-out한 구조를 가능하게 한다.


#### Partitioning 전략
* Partitioning을 하는 전략에 따라 특정 Node에 partition이 편향되어 병목을 발생시킬 수 있다. 따라서 partitioning 방법이 매우 중요하다.
* 일반적으로 데이터를 read/write시 id 또는 key를 부여한다. 이는 데이터를 저장해야 할지를 판단하고 추후에 저장된 데이터를 빠르게 조회하기 위함이다.
* 그러나 모든 데이터가 고유한 id 또는 key를 갖고 있지 않으므로, 모든 경우에 처리할 수 있는 Partitioning 전략이 필요하다.

* 1) Key Range Partitioning
전체 key를 특정 range로 나누어 partitioning하는 방법이다.
예를 들어 사람을 저장하는 경우 이름을 기준으로 ㄱ-ㄹ, ㅁ-ㅇ, ㅈ-ㅎ 의 3개의 parition으로 데이터를 분리할 수 있다.
이때의 장점은 range에 따라 parition이 정렬되어 있으므로, 시계열 조회 같은 연속적인 데이터를 조회하는 데 매우 유리하다.
그러나 경우에 따라 range의 boundary를 잘못 정한 경우 hotspot이 발생한다.(김씨가 많은 한국에서는 첫 번째 partition이 비대해지며 많은 부하가 발생한다.)
따라서 key range를 정함에 있어 data의 분포와 특성을 고려해야하며 때로는 다양한 key의 조합을 고려하여 설계해야 한다.


* 2) Key Hash Partitioning
각 데이터 key에 hash function을 적용하고, 이를 partition의 갯수로 나눈 나머지에 해당하는 node에 저장하는 것이다.  
key가 변경되지 않는 한 항상 같은 hash code를 보장받기 때문에 모든 Node에 균등하게 분산 저장할 수 있는 장점이 있다.
그러나 Key Range Partitioning이 갖는 series data query에 대한 장점을 잃는다. 하지만 제일 큰 문제는 
partition의 갯수가 변경되는 경우로 동일한 데이터가 다른 node에 저장되는 문제가 발생한다. 
distributed system에서 partition의 갯수가 변경되는 일은 흔한 일이다. 이를 해결하기 위한 것이 Consistent Hashing이다.

* 3) Consistent Hashing


참조
https://medium.com/@Pranaykc/understanding-partitioning-in-distributed-systems-4ac3c8010fae
