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

