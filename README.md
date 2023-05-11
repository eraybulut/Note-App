# Note-App

A note-taking app using the Room library.


 ## Tech stack & Open-source libraries
- Minimum SDK level 24
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines and LiveData](https://github.com/Kotlin/kotlinx.coroutines)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  -  A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [DataBinding](https://developer.android.com/topic/libraries/data-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library. 
  - [Coroutine](https://developer.android.com/kotlin/coroutines):On Android, coroutines help to manage long-running tasks that might otherwise block the main thread and cause your app to become unresponsive. Over 50% of professional developers who use coroutines have reported seeing increased productivity. This topic describes how you can use Kotlin coroutines to address these problems, enabling you to write cleaner and more concise app code.


  </br>
  
### Package Structure

| Package | 
| ----- | 
|<img src="media/package.png" width="250" height="600"/>|
 
  </br>
  
 ### Screenshots

| Home | Home | Share |
| ----- | ------------ | ------------ |
|<img src="media/home_empty.jpg" width="250" height="500"/>|<img src="media/home.jpg" width="250" height="500"/>|<img src="media/share_post.jpg" width="250" height="500"/>|

 </br>
 
| Edit | Swipe To Delete | Swipe To Share |
| ----- | ------------ | ------------ |
|<img src="media/edit.jpg" width="250" height="500"/>|<img src="media/swipe_to_delete.jpg" width="250" height="500"/>|<img src="media/swipe_to_share.jpg" width="250" height="500"/>|



