# 변수

- var : 변경 가능한 참조
- val : 변경 불가능한 참

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



<br>

---

# 문자열 템플릿

```kotlin
var name = if(args.size > 0) args[0] else "kotlin"
println("Hello, $name")
```

<br>

---

# 함수

- 기본형

```kotlin
fun 이름(변수 : 타입) : 반환값 {
        //본문
}
```

- 식이 본문인 함수

```kotlin
fun max( a : Int, b: Int) = if( a > b ) a else b 
```


# 클래스와 인스턴스

```kotlin
class Person{
    var foo: String = "foo"
    
    fun fool(){
    
    }
}

interface Bar{
    fun bar()
}
```

# 조건문

- if - else 문

```kotlin
fun max(a:Int, b:Int) : Int {
    if(a>b){
        return a
    }else{
        return b
    }
}
```

# 