
# 코틀린 인터페이스와 클래스

- 클래스는 기본적으로 final 이며, 상속을 허용하려면 open 키워드를 붙어야함
- open 클래스 중 오버라이드를 금지시키는 메소드가 필요할 경우, final을 붙여야함.

- 인터페이스

```kotlin
interface Clickable{
    fun click()
    fun showOff() = println("clickable") // 디폴트 메소드
}

class Button : Clickable{
    // 오버라이드는 반드시 오버라이드 키워드 사용
    override fun click() = println("I was clicked");
}

class Button : Clickable, Focusable{
    /**
    * 같은 이름과 시그니처를 가진 인터페이스의 경우 명시적으로 지정해서 구현함
*/
    override fun showOff(){
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}
```

- 가시성 변경자 (접근 제한자)
    - public 모든 곳에서 볼 수 있다
    - internal 같은 모듈안에서만 볼 수 있다. > 바이트코드에서 public으로 바뀜
    - protected 하위 클래스 안에서만 볼 수 있다.
    - private 같은 클래스 안에서만 볼 수 있다.

- 내부 클래스와 중첩 클래스
    - 중첩 클래스는 명시적으로 요청하지 않는 한 바깥쪽 클래스 인스턴스에 대한 접근 권한이 없다.
    - inner 키워드 : 내부 클래스를 만듬
    - @Outer : 바깥 쪽 클래스의 참조에 접근하기 위해서 필요
    
- 봉인된 클래스
    - sealed 변경자 : 그 상위클래스를 상속한 하위 클래스 정의를 제한함.
    - 자동으로 open 임


- 클래스 초기화 
    - 주 생성자 : 소괄호로 매개변수만 받는 생성자
    - _ : _변수는 프로퍼티와 생성자 파라미터를 구분함
    - 생성 : new 키워드 없이 생성자를 직접 호출하면됌.
    - 생성자 파라미터에 디폴트 값을 지정하면 컴파일러가 자동으로 파라미터가 없는 생성자를 만들어준다.
    - 부 생성자 : constructor 키워드를 이용함
    - init : 초기화 블록
    
