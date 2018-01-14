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