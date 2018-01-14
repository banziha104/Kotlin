### 조건 확인 라이브러리

- check() : 조건이 맞지않으면, IllegalStateException 발생
- required() : 조건이 맞지 않으면 IllegalArgumentException 발생
- error() : 강제로 에러발생

### 컬렉션 생성함수

- 배열
    - arrayOf : 함수 인자로 받은 값으로 구성된 배열을 반환
    - emptyArray() : 빈 배열을 반환함
    - xxxArrayof() : xxx의 원시타입을 가지는 배열을 생성
    
- 리스트
    - listOf() : 읽기 전용 리스트를 반환
    - listOfNotNull() : 널 값은 무시하고 널이 아닌 값으로만 리스트를 구성함
    - mutableListOf() : 인자로 받은 elemenets를 요소로 가지며 수정 가능한 리스트를 반환
    
- 맵
    - mapOf() : Pair 형태로 받은 인자들을 포함하는 읽기 전용 맵을 반환
    - mutableMapOf() : 수정 가능한 맵 반환
    
- 집합
    - setOf() : 읽기전용
    - mutableSetOf : 수정 가능한 맵
    

# 스트림 함수 
- 변환
    - map() : 컬렉션 내 인자를 다른값 혹은 다른 타입으로 변환
    - mapNotNull() : null 인 경우 이를 무시
- 필터
    - filter() : 컬렉션 내 인자들 중 주어진 조건과 일치하는 인자만 걸러주는 역할
    - take() : 컬렉션 내 인자들 중 앞에서 인자로 받은 개수만큼만을 갖는 리스트를 만듬
- 조합 및 합계
    - zip() : 두 컬렉션 내의 자료들을 조합하여 새로운 자료를 만들때 사용
    - joinToString() : 컬렉션 내 자료를 문자열 형태로 반환함과 동시에, 이를 조합하여 하나의 문자열로 생성
    - reduce() : 컬렉션 내의 자료를 조합함, 첫 번째 인자로 결과가 두번째 인자로는 조합할 자료가 들어감
    
- 기타
    - any() : 컬렉션 내 단 하나의 자료라도 존재하면 true를 반환, 아닌 경우 false를 반환
    - none() : 컬렉션이 비었는지 확인
    - max, min : 숫자 타입 컬렉션 내에서 각각 최댓값 최소값을 찾아 반환
    

# 범위 지정함수

- let() : 
    