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

