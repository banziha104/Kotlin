# 코틀린에서 자바 코드 사용하기

- 게터 세터 프로퍼티화
    - 자바에서 게터세터가 있다면 코틀린에서는 var로 볼수 있음
    - Person 클래스의 getName()을 person.name으로 사용

- 가변 인자를 받는 메서드

```java
public class ArrayTest{
    public int doSomething(int... args){
        
    }
}

```

```kotlin
val intArgs = intArrayOf(1,2,3,4,5)
s.dosomething(*intArgs) // 스프레드 연산자를 사용하여 인자를 전달
```

- Object 클래스 내의 메소드
    - 자바 Object클래스는 코틀린에서 Any로 처리
    - toString() , hashCode(), equals() 지원
    - wait(), notify() 함수는 자바의 Object 클래스의 확장함수로 지원
    
```kotlin

val str = "Lorem ipsum"

val kotlinClass : KClass<out String> = str::class
val javaClass : Class<out String> = str::class.java //자바클래스반환
    
```

# 자바에서 코틀린 코드 사용하기

- 프로퍼티의 게터 세터
    - var 는 getter, setter 모두지원
    - val 는 getter 만 지원
    
- 기본 매개변수가 있는 함수

> @JvmOverLoads 어노테이션을 추가하면 자바에서도 기본 매개변수의 이점을 이용하가능

```kotlin
class Person @JvmOverLoads construtor();
```

- 패키지 단위 함수

> Foo.kt 파일을 FooKt 클래스의 형태로 사용가능

```kotlin

// Foo.kt

const val Bar = "bar"

```

```kotlin

// @file:JvmName("이름") 을 사용하면 해당 이름으로 사용가능
@file:JvmName("FooUtils")

package com.foo.bar

const val BAR = "bar"
```

```java
// [클래스]Kt의 형태로 사용
FooKt.Bar 
FooUtils.BAR
```

- 동반 객체 및 싱글톤

    - 동반 객체
    > 클래스이름.Companion.이름 로 접근
    > <br> @JvmField와 @JvmStatic 사용시 자바의 정적 멤버 및 메소드 처럼 사용가능

```kotlin
class Foo
    companion object{
        @JvmField
        val BAR = "bar"
        
        @JvmStatic
        fun baz(){
        
        }
    }
}
```

- 싱글톤

> 동반 객체와 유사함, 클래스이름.INSTANCE를 통해 접근 @JvmStatic 어노테이션을 사용하면 기존 처럼 사용가능

```kotlin
object FOO{
    const val BAR = "bar"
    
    @JvmStatic
    fun baz(){
        
    }
}
```

```java
String bar = Foo.BAR;
Foo.baz
```