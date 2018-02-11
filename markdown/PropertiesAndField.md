# 변수 선언 방법

- val : 상수
- var : 변수
- ? : 옵셔널 밸류
- Any : jave의 Object
- getter/ setter

```kotlin
var list: List<T> = mutableListOf()
 set(value) {
 if (value.isNotEmpty()) {
 field = value
 }
 }
 get() = field
 val isEmpty: Boolean
 get() = this.list.isEmpty()
```

- lazy : 호출하는 시점에서 초기화가 일어남, null은 불가능
- lateinit : var 변수만 사용 가능함.
