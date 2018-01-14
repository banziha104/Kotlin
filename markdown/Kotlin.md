### 원시타입

- byte
- short
- int
- long
- char
- float
- double
- boolean

### 배열

> 배열 타입이 별도로 존재하는 자바와 달리 타입인자를 가지는 Array 클래스로 표현
    
```kotlin
var word : Array<String> = arrayOf("Lorem","ipsum","dolor","sit")

var intArr : IntArray = intArrayOf(1,2,3,4,5)
```

### 컬렉션

> JVM을 기반으로 하는 코틀린에서 컬렉션은 그대로 사용함, type alias 를 사용하여 다른 클래스와의 일관성을 유지함
> <br> 단, Iterable 을 상속한 컬렉션은 수정이 불가능하며, MutableIterable 을 상속받을 경우 가능함

```kotlin

// 자료를 수정할 수 없는 리스트 생성
val immutableList : List<String> = listOf("Lorem", "ipsum","dolor","sit")

// 컴파일 에러 : 자료 수정을 위한 함수를 지원하지 않음
immutableList.add("amet")

val mutableList : MutableList<String> = arrayListOf("Lorem","ipsum","dolor","sit")

```

### 클래스 인터페이스

클래스와 인터페이스의 선언 및 인스턴스 생성

```kotlin
public class Baz{

}

class Baz{ //접근 제한자를 두지 않는 경우 public으로 간주

}

interface Foo{

}

interface Foo // 본체없이 생성도 가능

val foo: Foo = Foo() // new 키워드 생략

val bar : Bar = Bar(1) // 인자 하나를 받는 생성자로 인스턴스 생성

// 추상클래스 선언
abstract class Foo{
    //추상 메소드 선언
     abstract fun bar()
}
// object : [생성자] 형태로 선언
var foo = object : Foo(){
    override fun bar(){
        //함수 구현
    }
}

```


### 프로퍼티

> 코틀린에서는 게터 세터 메소드를 그대로 제공함, val 로 선언시 getter만 제공
```kotlin

class Person {
    /*명시적으로 값은 선언해주어야함 */
    var name : Stirng? = null
    
    var address : String? = null
    
    lateinit var address : String? //초기화시 할당하며, var 키워드 사용 생성자 호출 시점에 할당 가능한 경우 사용
}

```

### 생성자


```kotlin
class Foo{
    init{
        //생성자에서 수행할 작업들
        Log.d("Foo","Number: $a") // a의 값을 사용
    }
}

class Foo(val a: Int, var b: Int){
    constructor(a:Int) : this(a,0) //추가 생성자, 주 생성자를 반드시 호출해야함
}
```

### 함수

```kotlin
class Foo{

    // 아무 것도 반환 하지 않는 함수
    fun foo() : Unit { // Unit 키워드는 반환값 생략가능
    
    }
    
    // 정수 값을 반환하는 함수
    fun bar() : Int {
        return 0
    }
}
```


### 상속과 인터페이스

> 콜론뒤에 상속한 클래스나 인터페이스 표시 반드시 부모 클래스의 생성자를 호출해야함.
> <br> open 키워드를 붙인 클래스나 함수가 아니라면 클래스를 상속하거나 함수를 재정의할 수 없음
```kotlin
class MainActivity: AppCompatActivity(),View.OnClickListener{

}

class MyView : View{
    constructor(context : context) : super(context){
        //뷰 초기화
    }
    constructor(context : Context, attrs : AttributeSet?) : super(context,attrs){
        
    }
}

```

# this 

> 해당 키워드를 사용한 클래스 자신을 지칭할 때 사용하며 가장 가까운 범위의 클래스를 의미함,
> <br> 따라서 클래스 내에서 다른 클래스나 인터페이스의 인스턴스를 동적으로 생성하여 사용하는 경우 
> <br> this를 바인딩 해주어야함, 코틀린에서는 this@{클래스 이름} 으로 함

```kotlin
class MainActivity : AppCompatActivity(){
    fun a(){
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
    }
}
```

### 정적 필드 및 메서드

> 코틀린에서는 정적 필드와 메서드를 지원하지 않음. 

```kotlin
const val FOO = 123

// 함수 foo를 패키지 foo.bar에 선언
fun foo(){

}
class Foo{
    //함수 bar 는 Foo의 인스턴스를 생성해야 사용가능
    fun bar(){}
}

import foo.bar.FOO
import foo.bar.foo

class Bar{
    fun bar(){
        val foo = FOO
    }
    // foo.bar 패키지 내의 함수 foo를 호출함
    foo()
}

/*동반 객체를 사용하는 것이 가장 비슷함, private 생성자에도 접근가능*/


class User private constructor(val name : String, val registerTime : Long){
    // companion object는 클래스 내부에 존재함으로 private로 선언된 생성자에 접근할 수 이씀
    companion object{
        fun create(name: String) : User{
            return User(name, System.currentTimeMillis())
        }
    }
}
```

### 싱글톤

> object 키워드를 사용하여 이를 간편하게 선언 할 수 있음

```kotlin
object Singleton{
    var FOO = "foo"
    
    fun foo() {}
}

val fooValue = foo.FOO

Foo.foo() // Foo의 함수 호출
```

### 옵셔널 관련

- ?: 널값에 디폴트를 넣음

```kotlin
var a = foo ?: bar // 널일경우 bar 를 넣고 널이 아닐경우 foo 반환

var b = foo ?: throws IllegalStateException() //널일경우 에러를 발생시킴
```

- ?. : 가능할 경우에만 값을 넣고, 아닌 경우 null을 대입

```kotlin
var foo = bar?.baz // 널이 아닐 경우에만 값을 대입, 그렇지 않을 경우 null을 대입

foo?.bar() // foo가 null이 아닐경우에만 bar() 호출
```

- as? : 안전한 캐스팅

```kotlin
var foo: String = "foo"

// 실패할 수도 있음으로 Int? 로선언
var bar : Int? = foo as? Int 
```

- !! : 널이 아님을 보증

```kotlin
val foo : Foo? = "..."

val nonNullFoo : Foo = foo!! // 널 값이 아님을 보증

foo!!.bar() // 값 foo가 널 값을 포함하지 않음을 보증
```


