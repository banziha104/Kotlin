# 클래스

- 데이터 클래스

> 자료를 구성하는 프로퍼티만 선언하면 컴파일러 equals(), hashcode(),toString() 함수를 자동으로 생성

```kotlin
data class Person(
val name:String,
val address : String
)
```

- 한정 클래스

> enum 클래스를 확장한 개념의 클래스로 하나의 인스턴스만 생성되어 있는 enum 클래스와 달리 인스턴스를 여러 개 생성할 수 있음

```kotlin
sealed class MobileApp(val os: String){
    class Android(os: String, val packageName: String) : MobileApp(os)
    
    class IOS(os: String, val bundleID: String) : MobileApp(os)
}
```

- 프로퍼티의 사용자 지정

```kotlin
val adult : Boolean 
    get() = age >= 19
    
val address: String = ""
    set(value){
        field = value.substring(0..9)
    }
```
---

<br>

# 함수 

- 명명된 인자 : 명명된 인자를 사용함으로 함수를 호출할 때, 매개변수의 순서와 상관없이 인자를 전달할 수 있음.

```kotlin
fun drawCircle(x : Int, y: Int, radius : Int){

}

drawCircle(10,5,radius = 25) // 일부만도 사용 가능
```

- 기본 매개변수 : 매개변수에 기본 값을 지정할 수 있음

```kotlin
fun drawCircle(x : Int, y: Int, radius : Int =25){

}

drawCircle(10,5)
```

- 단일 표현식 : Unit 타입을 제외한 타입을 반환하는 함수라면 단일 표현식 사용 가능

```kotlin
fun basic() : Int {
    return 21 *2
}

fun basic() : Int = 21 * 2  // 단일표현식

fun basic() = 21 * 2 // 반환값 생략 가능
```

- 확장함수: 기존에 만들어져 있는 클래스에 새로운 메서드를 추가할 수 있음

```kotlin
// 선언부에서는 클래스 .함수 를 적어준다
private fun String.withPostfix(postFix: String) = "$this$postFix"

// 구현부에서는 this를 사용하여 클래스의 인스턴스에 접근할수 있으며 이를 리시버 객체라고함
fun String.withBar() = this.withPostfix("Bar")
```

- 연산자 오버로딩 : 각 연산자별로 사전 정의된 함수를 재정의하는 방식으로 연산자 오버로딩을 사용할 수 있음

```kotlin
class Volume(var left : Int, var right : Int){
    //단항 연산자 -
    operator fun unaryMinus() : Volume {
        this.left = -this.left
        this.right = -this.right
        return this
    }
}
```

# 람다식 및 메소드 프로퍼티 참조

```kotlin
val button : Button

button.setOnClickListener({ v: View -> doSomething()}) // 람다식

button.setOnClickListener({ v -> doSomething()}) // 인자 타입 생략

button.setOnClickListener{ v -> doSomething()}// 다른인자가 없는 경우 소괄호 생략

button.setOnClickListener{ doSomething(it)}// 인자가 한개인 경우 it 사용

/*와일드 카드 패턴*/

setSomething { _ , dialog -> something()} // _ 는 필요하지 않는 것을 생략함

/*레퍼런스 사용*/
button.setOnClickListener({ v -> doSomething(v)}) // 람다식

button.setOnClickListener({ ::doSomething}) // 메소드레퍼런스

val adult = age > 19

val people : List<Person> 

people.filter({Person::adult}) // 프로퍼티 참조

people
```

- 인라인 함수 : 인라인 함수를 사용하면 매개변수로 받는 함수형 인자의 본체를 해당 인자가 사용되는 부분에 그대로 대입함으로 성능 하락을 방지

```kotlin
inline fun doSomething(body : () -> Unit){
    println("pre")
    body()
    println("post")
}
```

- 분해선언 : 일부만 사용하거나 각 항목을 별도의 변수로 뽑아 사용하는 경우, 지원하는 클래스는 아래와 같음
    - 데이터 클래스로 선언된 클래스
    - kotlin.Pair
    - kotlin.Triple
    - kotlin.collections.Map.Entry

```kotlin
data class Person(val age: Int, val name: String)

val person : Person = ...

val (ageOfPerson, nameOfPerson) = person

// 분해선언 기능을 사용하고 싶다면 해당 클래스 내에 별도로 componentN 함수를 프로퍼티 선언 순서 및
// 타입에 맞춰서 추가해주어야함

class Person(val age : Int, val name : String){
    operator fun component1() = this.age
    operator fun component2() = this.name
}

val person : Person = ...
val (age,name) = person
```
