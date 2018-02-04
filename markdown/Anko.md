# Anko

> 젯브레인에서 직접 제작하여 배포하는 코틀린 라이브러리로, 안드로이드 어플리케이션 개발에 유용한 유틸리티 함수를 제공함.

- Anko Commons : 유틸 클래스를 모아놓음 
- Anko Layouts : 레이아웃관련 유틸리티
- Anko SQLite : ORM 관련
- Anko Coroutines : 코루틴 라이브러리를 기본으로 한 유틸리티

# Anko Commons 

> 안드로이드 애플리케이션을 작성할 때 일반적으로 자주 구현하는 기능을 간편하게 추가할 수 있는 유틸리티 함수 제공

```groovy
compile "org.jetbrains.anko:anko-commons:$anko_version" 
```

```kotlin
toast("내용") // 토스트 표시


/*다이얼로그 관련*/

alert(title = "Message", message = 'isn\'t it?'){ // 다이얼로그
} 
val citites = listOf("Seoul","Tokyo","New York","Singapore")

selector(title= "Select City", items = cities ){    //리스트 다이얼로그
 dlg, selction -> toast("You selected ${cities[selection]}")
}

// 진행률을 표시하는 다이얼로그를 생성
val pd = progressDialog(title ="File Download", message = "Downloading")

// 다이얼로그를 표시
pd.show()

// 진행률을 50으로 조정
pd.progress = 50

// 진행률을 표시하지 않는 다이얼로그를 생성하고 표시
ideterminateProgressDialog(message = "Please wait").show()


/* 인텐트 관련 */

val intent = Intent(this, DetailActivity::class.this)
intent.putExtra("id",150L)
startActivity(intent)


var intent = intentFor<DetailActivity>(
    "id" to 150L, "title" to "mTitle"
    .noHistory //인텐트 플래그 설정
)
startActivity<DetailActivity>("id" to 150L, "title" to "Awesome item")

makeCall(number = "01012345678")

```

