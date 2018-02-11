# 람다식

- 자바 코드

```java
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        view.setAlpha(0.5f);
    }
});
```

- 코틀린 코드

```kotlin
button.setOnClickListener {
    view -> view.alpha = 0.5f
}

/* 매개변수가 하나인 경우, it으로 대체*/

button.setOnClickListener {
    it.alpha = 0.5f
}

```

- 리턴이 존재하는 경우

```java
button.setOnTouchListener { view, motionEvent ->
    /* 코드 */
    true // 마지막 줄이 리턴에 해당
}
```

- 컬랙션 함수형 API
    - map
    - filter
    - all : 모든 원소가 만족하는지
    - any : 만족하는 원소가 하나라도 있는지
    - find : 조건을 만족하는 첫 번쨰 원소를 반환
    - count : 조건을 만족하는 원소의 수 반환 
    - groupBy : 조건에 부합하게 그룹화
    
- lazy 컬렉션 연산 
    - 즉시계산과 지연계산 
        - 즉시계산 : 모든 컬렉션의 컬렉션을 하나둘씩 연산함
        - 지연계산 : 컬렉션의 첫번쨰 원소부터 연산함
    - asSequence : 원본 컬렉션을 시퀸스로 변환함. 
    - 중간 연산 : 시퀸스를 받아 시퀸스로 반환
    - 최종 연산 : 컬렉션으로 반환 
    
- SAM 생성자

```kotlin
val listener = OnClickListener {
    view -> val text = when(view.id){
        R.id.button1 -> "First Button"
        R.id.button2 -> "Second Button"
        else -> "Unknown button"
    }
    toast(text)
}
```

- 유용한 함수
    - let : 블록의 결과값을 반환
    - apply : 블록의 리시버로 전달후 객체 자체를 반환
    - run : 객체 없이 인자가 없는 익명 함수처럼 사용가능하고
    - with : 객체를 리시버로 전달후 블록의 결과값 반환
    
    