# 산술자 오버로딩 

> 산술자를 직접 오버로딩해 사용 가능 
-  이항 산술 연산자
    - times: a*b
    - div : a/b
    - rem : a%b
    - plus : a+b
    - minus : a-b

- 복합 대입 연산자
    - timesAssign: a*=b
    - divAssign : a/=b
    - remAssign : a%=b
    - plusAssign : a+=b
    - minusAssign : a-=b
    
- 단항 연산자 
    - unaryPlus : +a
    - unaryMinus : -a
    - not : !a
    - inc : ++a , a++
    - dec : --a , a--
    
        
```kotlin
data class Point(val x : Int, val y : Int){
    operator fun plus(other: Point) : Point{
        return Point(x + otehr.x, y + other.y)
    }
}

/*피연산자가 다른 타입인 경우*/
operator fun Point.times(scale: Douber) : Point{
    return Point((x*scale).toInt(), (y*scale).toInt())
}


```

- 인덱스로 원소의 접근(get, set)

```kotlin
operator fun Point.get(index:Int) : Int{
    /*구현부*/
}

operator fun Point.set(index:Int, value: Int) : Int{
    /*구현부*/
}
```

- in 관례 (contains)

- 비구조화 할당 : 자바스크립트와 비슷함

# 위임 프로퍼티 

> 
