# ObsererAndroid

## Описание архитектуры приложения

В приложении используется `MVP` архитектура. Разберём взаимодействи слоёв на примере логина.  
Точка входа - `LoginFragment`. В него инжектится  `LoginPresenter`, который отвечает за бинес логику этого экрана.
`LoginPresenter` принимает в конструкторе `LoginModel`, отвечающую за работу с данным. Также `LoginPresenter` принимает в себя
`Config`, в котором находятся различные вспомогательные вещи, такие как объекты класса `Rx.Scheduler`.
Основная цель их передачи в конфиге - удобная замена на другие при тестировании. В случае других экранов в конфиге презентера
также должны находиться его параметры, например `id` участка голосвания итд.  
При каждом запросе на сервер в параметры должен поставляться `app_id`. Для этого каждая модель принимает в себя объект `AppIdGenerator`, который при первом запросе сгенерирует уникальный `app_id`.
Для запросов на сервер используется интефейс `SpbObserversApi`, за реализацию которого отвечает `Retrofit` (см. ниже)

Остальные _UseCase_ надо реализовывать в такой же структуре, для поддержания расширяемости, тестируемости и однообразности
кода приложения.

## Используемые билиотеки

* [RxJava](https://github.com/ReactiveX/RxJava) - асинхронность, Reactive Api
* [Dagger2](http://google.github.io/dagger/) - Dependency Injection
* [Retrofit2](http://square.github.io/retrofit/) - REST API
* [AutoValue](https://github.com/google/auto/tree/master/value) - immutability, генерация кода для дата-классов
* [ButterKnife](http://jakewharton.github.io/butterknife/) - view binding 
* [Timber](https://github.com/JakeWharton/timber) - логгирование
