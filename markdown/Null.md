# Null 처리 방법

- ?. : 옵셔널 체이닝

```kotlin
var temp: String? = null
val size = temp?.length
```

- ?: : 엘비스 연산자, null 일 경우 초기값 대입

```kotlin
val temp: String? = null
// null 일경우 "" 대입
textView.text = temp ?: ""

// null 일 경우 NPE 발생시키기

textView.text = temp ?: throws NullPoniterException("null 발생")
```

- as? : 안전한 타입 캐스팅 지원

```kotlin
var a : Any?
var b : Int?

var temp = a as? b // 불가능 할 경우 null 반환
```

- when 을 이용한 처리

```kotlin
val a: Any? = "String"

when(a){
    is Int -> println(a)
    is String -> println(a)
    else -> println("can't")
}
```

- 컬렉션 프레임워크에서 null 제외하기

```kotlin
val listWithNulls: List<String?> = listOf("A", null, "B")

listWithNulls.filterNotNull() // null 원소를 제거함

```

- let 블록을 이용한 예외처리

```kotlin
fun test() {
  val sample: Sample? = Sample("User name", 20, "userId")
  sample?.let {
    tvName.text = it.name
    tvAge.text = it.age
    tvId.text = it.id
    } ?: let{
        println("sample is null")
        tvName.text = View.GONE
        tvAge.text = View.GONE
        tvId.text = View.GONE
    } 
}

listWithNulls.forEach { it?.let {println(it)}}

```

- safeLet : 최대 5개 까지 동시에 null 체크 가능

```kotlin

fun test() {
  val a: String? = "ABC"
  val b: String? = "BBB"
  safeLet(a, b) { a, b ->
      println("$a $b")
} }

```