# Label

- 특정 구문에 이름을 붙여주어, break나 continue를 명시적으로 가능 하게한다
- name@ : 정의할때는 골뱅이가 뒤로
- @name : 사용할때는 골뱅이가 앞으로

```kotlin
for (i in 1..100) {
    loop@ for (j in 1..100) {
        if (j > 10) break@loop
print(j) }
println() }
```

- return 구문

```kotlin

val ints = mutableListOf(1, 2, 0, 4, 5)
fun foo() {
    ints.forEach lit@ {
        if (it == 0) return@lit
        print(it)
    } 
}

/*람다식인 경우 해당 함수를 직접 호출*/

val ints = mutableListOf(1, 2, 0, 4, 5)
fun foo() {
    ints.forEach {
        if (it == 0) return@forEach
        print(it)
} }


/* 클래스 내부 직접 리턴 */

private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
        R.id.navigation_home -> {
            message.setText(R.string.title_home)
            return@OnNavigationItemSelectedListener true
        }
        R.id.navigation_dashboard -> {
            message.setText(R.string.title_dashboard)
            return@OnNavigationItemSelectedListener true
        }
        R.id.navigation_notifications -> {
            message.setText(R.string.title_notifications)
            return@OnNavigationItemSelectedListener true
} }
false
}

```

- this 바인딩

```kotlin
class Sample {
    fun Int.foo() {
        val a = this@Sample
        val b = this
        val c = this@foo
        println("b === c ${b === c}")
    }
    fun test(a: Int) {
        a.foo()
} }
```